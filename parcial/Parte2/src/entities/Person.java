package entities;

import java.util.ArrayList;

public class Person {

	private ArrayList<Activity> actividades;
	
	double getBiling (double socialCorcernDiscountPercentage){
		
		double total = 0;
		
		// asumo que el porcentaje es 75% -> 75/100 -> 0.75
		
		for(Activity a : actividades) {
			
			if(a.isOfSocialCorcen()) {
				total += a.getCost()*socialCorcernDiscountPercentage/100;
			}else {
				total += a.getCost();
			}
		}
		
		return total;
	}
	
	
}
