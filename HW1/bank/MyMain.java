package bank;

import java.util.Calendar;

public class MyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Account a1 = new CheckingAccount(1980, 5000.0);
		a1.getAccountSummary();
		a1.getAccountSummary();
		
		Account a2 = new SavingsAccount(1980, 5000.0);
		a2.getAccountSummary();
		a2.getAccountSummary();
		
		Account a3 = new SavingsAccount(1990, 30000.0);
		a3.getAccountSummary();
	}

}
