package parcialJava2022;
import java.util.LinkedList;

public class parcialJava2022 {

}

class biuldingSite{
	int id;
	String addres;
	LinkedList<Job>jobs = new LinkedList<Job>();
	
	public double getOveralBudget() {
		double t = 0;
		for (Job j : jobs) {
			t = t + j.amountByJob();
		}
		return t;
	}
}

abstract class Job{
	int id;
	String name;
	String description;
	double estimatedHours;
	double insuranceCost;
	WorkType wk;
	
	abstract double amountByJob();
	
}

class WorkType{
	String name;
	String desription;
	String workUnit;
	double quantityRate;
	
	public double getQuantityRate() {
		return this.quantityRate;
	}
	
	
}

class FixedPriceJob extends Job{
	double agreedBudget;
	
	@Override
	double amountByJob() {
		return (agreedBudget);
	}
}

class QuantityRatedJob extends Job{
	double quantity;
	
	@Override
	double amountByJob() {
		
		return(this.quantity*wk.quantityRate);
	}
	
}

abstract class Contratist extends HourlyRatedJob{
	int ssn;
	String firsName;
	String lastName;
	double hourlyRate;
	
	@Override
	double amountByJob() {
		return (this.hourlyRate * this.estimatedHours);
	}
}

abstract class HourlyRatedJob extends Job{
	
}




