package it.polito.tdp.borders.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		System.out.println("TestModel -- TODO");
		
		model.creaGrafo(2000);
		
		System.out.println(model.getGrafo());
		
		Country c = new Country("CAN",20,"Canada");
		
		System.out.format("Numero stati confinanti con : %s ",c.getStateName());
		System.out.format("%n %d %n", model.getDegree(c));
		
		System.out.println(model.getListaConnessi());
		
		System.out.println("\n---------Numero Grafi connessi------\n");
		System.out.println(model.numeroGrafi());

		
//		System.out.println("Creo il grafo relativo al 2000");
//		model.createGraph(2000);
		
//		List<Country> countries = model.getCountries();
//		System.out.format("Trovate %d nazioni\n", countries.size());

//		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
	}

}
