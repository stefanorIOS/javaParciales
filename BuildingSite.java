package UTN_UltimoParcial;

import java.util.LinkedList;

public class BuildingSite {
	int id;
	String address;
	LinkedList<Job> jobs = new LinkedList<Job>();

	public static void main(String[] args) {
	}
	
	public double getOverAllBudget(){
		double suma = 0;
		for (Job j : jobs) {
			suma= suma + j.finalAmount();
		}
		return suma;
	}
	
}

abstract class Job{
	int id;
	String descripcion;
	double estimatedHours;
	double insuranceCost; 
	WorkType worktype;
	abstract public double finalAmount();
	
	public WorkType getWorkType(){
		return (this.worktype);
	}
}


class FixedPriceJob extends Job{
	double agreedBuedged;

	@Override
	
	public double finalAmount() {
		return (this.agreedBuedged);
	}
}

class QuantityRatedJob extends Job{
	double quantity;
	
	@Override	
	public double finalAmount() {
		
		return ( (this.quantity) *(this.worktype.getQualityRate() ) );
		}
	}
abstract class HourlyRatedJob extends Job{
	
}

class Contratist extends Job{
	int ssn;
	String firstName;
	String lastName;
	double hourlyRate;


public double getHourlyRate() {
	return (this.hourlyRate);
	}


@Override
public double finalAmount() {

	return (this.hourlyRate * this.estimatedHours);
}


}

class WorkType{
	String name;
	String descripcion;
	String workUnit;
	double quialityRate;
	LinkedList<Job> jobs = new LinkedList<Job>();
	
	public double getQualityRate() {
		return (this.quialityRate);
	}
	
	
}


	

