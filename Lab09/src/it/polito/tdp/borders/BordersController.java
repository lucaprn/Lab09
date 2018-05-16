/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.borders.db.BordersDAO;
import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;
	BordersDAO dao;
	

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader
	
	 @FXML
	 private ComboBox<Country> cmbCountry;


	@FXML
	void doCalcolaConfini(ActionEvent event) {
		try {
			int anno = Integer.parseInt(this.txtAnno.getText());
			if(anno > 2016 || anno < 1816) {
				this.txtAnno.appendText("\nInserisci anno da 1816 a 2016 !\n");
				return;
			}
			model.creaGrafo(anno);
			
			this.txtResult.appendText("\nLista stati e numero stati confinanti : \n");
			this.txtResult.appendText(model.getListaConnessi());
			this.txtResult.appendText("\nNumero grafi Connessi : \n");
			this.txtResult.appendText(""+model.numeroGrafi());
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
			this.txtResult.appendText("\ninserisci anno valido!!!\n");
		}

	
	}
	  @FXML
	void doVicini(ActionEvent event) {
		 Country c = this.cmbCountry.getValue();
		 List<Country> s = model.getVicini(c);
		 this.txtResult.appendText(String.format("\n\nCountry %s , connection : \n", c.getStateName()));
		 for(Country country : s) {
			 if(!country.equals(c))
			 this.txtResult.appendText("\n-"+country);
		 }

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert cmbCountry != null : "fx:id=\"cmbCountry\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
	}

	public void setModel(Model model) {
		this.model=model;
		this.dao=new BordersDAO();
		List<Country> tmp = new ArrayList<>(dao.loadAllCountries());
		this.cmbCountry.getItems().addAll(tmp);
		
		
	}
}
