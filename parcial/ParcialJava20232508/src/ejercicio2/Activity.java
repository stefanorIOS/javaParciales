package ejercicio2;

import java.util.LinkedList;

public class Activity {
	String name;
	double cost;
	boolean ofSocialConcern;
	
	public double getCost(){
		return (this.cost);
	} 
	
	boolean isSocialConcern() {
		return this.ofSocialConcern;
	}
	
	class Persona{
		
		LinkedList <Activity> activities = new LinkedList<Activity>(); 
		
		public double getBilling(double socialConcernDiscountPercentage){
			double total = 0;
			
			for(Activity a : activities) {
				if(a.isSocialConcern()==true) {
					total = total + a.getCost() - socialConcernDiscountPercentage;
				}
				
				else {
					total = total + a.getCost();
				}			
		}
			return total;
	
		}
		
		//taba bien pero calcule mal el porcentaje :(
		
	}
	
	
	
	
	
	
	
	
}
