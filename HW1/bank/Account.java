package bank;

import java.util.Calendar;

public abstract class Account {
	
	protected double balance;
	protected int accountNumber;
	protected int currentYear;
	protected int lastCalcYear;
	protected double interest;
	
	
	public int getLastCalcYear() {
		return lastCalcYear;
	}
	

	public int setLastCalcYear() {
		lastCalcYear = Calendar.getInstance().get(Calendar.YEAR);
		return lastCalcYear;
	}

	
	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear() {
		currentYear = Calendar.getInstance().get(Calendar.YEAR);
	}


	//I added a call to setCurrentYear here... not sure if that's bad or not.  I didn't know where else
	//I could put it where I would just have to call it once for an account.
	public void getAccountSummary(){
		setCurrentYear();
		calcInterest();
		updateBalance();
		printSummary();
	}
	
	
	public abstract void calcInterest();
	
	//This method computes the new balance and updates the LastCalcYear field so the balance will be correct
	//the next time getAccountSummary is called on an instance of an account.
	public void updateBalance(){

		balance = balance + interest;
		//do this last
		this.setLastCalcYear();
	}
	
	
	public void printSummary(){
		System.out.println("In printSummary of base class Account");
		System.out.println("Interest accrued is: "+interest);
		System.out.println("New balance is: "+balance);
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}
	
}
