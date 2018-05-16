package it.polito.tdp.borders.db;

import java.util.List;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Border;

public class TestDAO {

	public static void main(String[] args) {

		BordersDAO dao = new BordersDAO();

		System.out.println("Lista di tutte le nazioni:");
		List<Country> countries = dao.loadAllCountries();
		
		for(Country c : countries) {
			System.out.println(c);
		}
		
		System.out.println("\nLista di tutti i confini :\n");
		
		List<Border> confini = dao.getCountryPairs(2000);
		
		for(Border b : confini) {
			System.out.println(b);
		}
		
	}
}
