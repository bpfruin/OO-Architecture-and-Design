package bank;

public class SavingsAccount extends Account {
	//interest rate
	final double RATE = 0.02;
	
	//Constructor take in last year interest was calculated as well as the balance.  This seemed sufficient
	//for my simple implementation of the problem solution.
	public SavingsAccount(int lastCalc, double bal){
		lastCalcYear = lastCalc;
		balance = bal;
	}
	
	//This method calculates the interest in a simple fashion.
	//First, the year we are currently in is subtracted from the last year interest was calculated.
	//this is either a user specified value or it is part of the instance in the case where updateBalance()
	//has already been run on the instance.
	//Interest is then compounded on the original balance using a for loop
	//interest is computed with simple arithmetic and balance is reassigned to its original value.
	public void calcInterest(){
		System.out.println("in SavingsAccount.calcInterest");
		System.out.println("RATE = "+RATE);
		
		int years = this.currentYear - this.lastCalcYear;
		
		System.out.println("number of years to accrue: "+years);	
		System.out.println("old balance: "+balance);
	
		double startBalance = balance;
		
		for (int i=0; i<years; i++){
			balance *= (1+RATE);	
		}
		
		double interestAcc = balance - startBalance;
		balance = startBalance;
				
		setInterest(interestAcc);				
	}
	
}
