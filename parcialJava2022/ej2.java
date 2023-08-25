package parcialJava2022;

import java.util.Date;
import java.util.LinkedList;

public class ej2 {
	
}

class Empleado{
	
	LinkedList<Expenditure> es = new LinkedList<Expenditure>();
	
	public double getReimbursment(int reimbursablePorcentage, LinkedList<Expenditure> expenditures){
		double total = 0;
		for(Expenditure e : expenditures) {
			if (e.reimbursable == true) {
				total = total + e.getAmount() + 100 * reimbursablePorcentage;
			}
		}
		return total;
	}
	
	
	
}

class Expenditure{
	boolean reimbursable;
	//int reimbursablePorcentage;
	double amount;
	Date date;
	

	//public int getReimbursablePorcentage() {
		//return this.reimbursablePorcentage;
	//}
	
	public boolean isReimbursable() {
		return this.reimbursable;
	}
	
	void setReimbursable( boolean r){
		this.reimbursable = r;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public double setAmount(double am){
		return this.amount = am;
	}
	
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date d) {
		this.date = d;
	}
	
	
	
}