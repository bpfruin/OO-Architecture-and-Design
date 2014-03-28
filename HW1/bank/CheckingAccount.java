package bank;

public class CheckingAccount extends Account {
	
	//interest rate
	final double RATE = 0.00;

	//Constructor allows user to pass in the last date interest was calcualted as well as the starting balance
	public CheckingAccount(int lastCalc, double bal){
		lastCalcYear = lastCalc;
		balance = bal;
	}
	
	//Method to calculate interest on the checking account.  This method mirrors the one in the savings account
	//class with the exception of this one having a 0% interest rate and thus doesn't really do anything
	
	public void calcInterest(){
		System.out.println("In CheckingAccount.calcInterest");
		System.out.println("RATE = "+RATE);
				
		int years = this.currentYear - this.lastCalcYear;
				
		System.out.println("number of years to accrue: "+years);
		
		System.out.println("old balance: "+balance);
		
		double startBalance = balance;
		
		for (int i=0; i<years; i++){
			balance *= (1+RATE);
		}
			
		this.interest =  balance - startBalance;
		
	}

}
