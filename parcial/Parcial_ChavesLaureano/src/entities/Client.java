package entities;

import java.util.ArrayList;

public class Client {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	private ArrayList<Site> sitios;
	
	private double getBiling() {
		
		double total = 0;
		for(Site s : sitios) {
			
			total += s.getFacturacion();
		}
		return total;
	}

}
