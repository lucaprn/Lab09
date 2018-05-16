package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	private Graph<Country,DefaultEdge> grafo;
	private BordersDAO dao;
	private List<Country> countriesList;

	public Model() {
		this.dao = new BordersDAO();
		this.grafo=new SimpleGraph<>(DefaultEdge.class);
		this.countriesList = new ArrayList<>(dao.loadAllCountries());
	}
	
	public void creaGrafo(int anno) {
		Graphs.addAllVertices(grafo, countriesList);
		this.addEdge(anno);
	}

	private void addEdge(int anno) {
		List<Border> borders = new ArrayList<Border>(dao.getCountryPairs(anno));
		for(Border b : borders) {
			grafo.addEdge(this.getCountryFromID(b.getCcode1()), this.getCountryFromID(b.getCcode2()));
		}
		
	}
	
	public Country getCountryFromID(int id) {
		for(Country c : this.countriesList) {
			if(c.getcCode()==id) {
				return c;
			}
		}
		return null;
	}


	public Graph<Country, DefaultEdge> getGrafo() {
		return grafo;
	}

	public int getDegree(Country c) {
		// TODO Auto-generated method stub
		return grafo.degreeOf(c);
	}
	
	public String getListaConnessi(){
		StringBuilder sb = new StringBuilder();
		for(Country c : grafo.vertexSet()) {
			sb.append(c.getStateName()+" : "+this.getDegree(c)+"\n");
		}
		return sb.toString();
		
	}
 	

	public int numeroGrafi() {
		ConnectivityInspector ci = new ConnectivityInspector(grafo);
		return ci.connectedSets().size();
	}
	
	
	

}
