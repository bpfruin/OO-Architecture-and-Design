package option;

import java.util.Scanner;

//This is the most complicated and involved console UI I've ever written so I'm sure there's
//some duplicate code and tons of room for improvement.  The general procedure goes as follows:
//The user is asked if they want to update/buy/sell.  If they chose update, they are asked to
//enter new parameters and if the user has a position, the new portfolio value and greeks are
//reported to the user.  If the user chooses buy or sell, the user is asked for the security type,
//then for the parameters for the security.  portfolio value and Greeks are returned and the user
//is then asked for their trading strategy, and finally a trading/hedge recommendation
//is reported to the user.  The program runs in a loop until the user enters "12" when asked
//to enter a menu option(i.e. "12" CAN be entered as a parameter without the program quitting).

//I'm not sure if I did input validation correctly.  I don't use any try/catch blocks, I just wrote
//methods that repeatly ask for new input until what is expected is received.

public class Main {

	private static int option;
	
	public static void main(String[] args){
		startUI();
	}
	
	//This method tests for the Controller class being a singleton and then asks the user for input.
	//if the user chose update, it calls the update method of the controller as well getStrategy
	//method so the user can get a trade recommendation after an update.  If buy or sell is selected
	// it calls  the getParams method.
	public static void startUI(){	
		
		Controller c = Controller.getInstance();
		
		boolean buy = false;
		
		Controller r1, r2;
		
		
		r1 = Controller.getInstance();
		r2 = Controller.getInstance();
		
		if(r1.equals(r2)){
			
		} else {
			System.err.println("Uh oh. r1 and r2 are not equal.  Not a Singleton!");
		}				
		
		while (option != 12) {
		    Scanner scn = new Scanner(System.in); 
		
		    System.out.println("Would you like to buy, sell, or update parameters?");
	        System.out.println("--------------------------");
	        System.out.println("0) Update");
	        System.out.println("1) Buy");
	        System.out.println("2) Sell");
	        System.out.println("12) Exit");
			
	        option = (int) getUserInput(scn);
			
	        if(option == 1){
				buy = true;
				getParams(buy, c);
			} else if(option == 2){
				buy = false;
				getParams(buy, c);
			} else if(option == 0){
				double last = 0;
				double vol = 0;
				double rate = 0;
				
				System.out.println("Current stock price: ");
				last = getPositiveNumber(scn);
				
				System.out.println("Current volatility: ");
				vol = getPositiveNumber(scn);
				
				System.out.println("Current risk free rate: ");
				rate = getPositiveNumber(scn);
				
				c.updatePortfolio(last, rate, vol);
				
				if(c.getPortfolio() != null){
					getStrategy(c);
				}
			}		
		}			
				System.out.println("You chose to exit the program");
	}
	    
	//This class get the strategy selection from the user and then calls the tryStrategy method
	//of the controller which in turn calls the execute method of the strategy itself.
	public static void getStrategy(Controller c){
		
		while (option != 12){
		    Scanner scn = new Scanner(System.in); 
		
		    System.out.println("Pick a strategy:");
		    System.out.println("Delta Neutral recommends a strategy that gets your delta to 0");
		    System.out.println("Delta Positive recommends a strategy that gets your delta to 10");
		    System.out.println("Delta Negative recommends a strategy that gets your delta to -10");
		    System.out.println("--------------------------");
		    System.out.println("6) Delta Neutral");
		    System.out.println("7) Delta Positive");
		    System.out.println("8) Delta Negative");
	        System.out.println("12) Exit");
        		
			option = (int) getUserInput(scn);
				
			if(option == 6){
				c.setStrategyType(new DeltaNeutral());	
				c.tryStrategy(c.getPortfolio());
				break;
			}	
			if(option == 7){
				c.setStrategyType(new PositiveDelta());	
				c.tryStrategy(c.getPortfolio());
				break;
			}
			if(option == 8){
				c.setStrategyType(new NegativeDelta());	
				c.tryStrategy(c.getPortfolio());
				break;
			}
	}
}
	
	//This method get the input parameters for a Call, Put, or Stock.  Once all the parameters are received,
	//the appropriate create method is called on the Controller(which calls Portfolio) and then the getStrategy()
	//method is called so the user can get the trading strategy that results from his/her trade.
	public static void getParams(boolean buy, Controller c){
				
		double lastTraded = 0;
		double strike = 0;
		double volatility = 0;
		double timeToExpiry = 0;
		double riskFreeRate = 0;
		int lotSize = 0;
			
		while (option != 12){
		    Scanner scn = new Scanner(System.in); 
	
	    	System.out.println("Pick a type of security to trade");
	        System.out.println("--------------------------");
	    	System.out.println("3) Call");
	        System.out.println("4) Put");
	        System.out.println("5) Stock");
	        System.out.println("12) Exit");
	    	System.out.println("Parameters that are percentages should be entered as decimal fractions of 1.");
	    	System.out.println("i.e. '50%' should be entered as '0.5'");

	    
				option = (int) getUserInput(scn);
		
			if(option == 3){
				System.out.println();
				
				System.out.println("Current stock price: ");
				lastTraded = getPositiveNumber(scn);
								
				System.out.println("Strike price: ");
				strike = getPositiveNumber(scn);				
				
				System.out.println("Volatility: ");
				volatility = getPositiveNumber(scn);				
				
				System.out.println("Years til expiry: ");	
				timeToExpiry = getPositiveNumber(scn);
				
				System.out.println("Risk free rate: ");
				riskFreeRate = getPositiveNumber(scn);				
				
				System.out.println("Quantity: ");
				lotSize = (int) getPositiveInt(scn);
				
				c.createCallOption(buy, lastTraded, strike, volatility, timeToExpiry, riskFreeRate, lotSize);
				getStrategy(c);
				break;
				
			}
			
			if(option == 4){
				System.out.println();
				
				System.out.println("Current stock price: ");
				lastTraded = getPositiveNumber(scn);
				
				System.out.println("Strike price: ");
				strike = getPositiveNumber(scn);
				
				System.out.println("Volatility: ");
				volatility = getPositiveNumber(scn);
				
				System.out.println("Years til expiry: ");
				timeToExpiry = getPositiveNumber(scn);
				
				System.out.println("Risk free rate: ");
				riskFreeRate = getPositiveNumber(scn);
				
				System.out.println("Quantity: ");
				lotSize = (int) getPositiveInt(scn);
				
				c.createPutOption(buy, lastTraded, strike, volatility, timeToExpiry, riskFreeRate, lotSize);
				getStrategy(c);
				break;				
				
			}
			if(option == 5){
				System.out.println();
				
				System.out.println("Current stock price: ");
				lastTraded = getPositiveNumber(scn);
				
				System.out.println("Quantity: ");
				lotSize = (int) getPositiveInt(scn);
				
				c.createStock(buy, lastTraded, lotSize);
				getStrategy(c);
				break;			
			}
		}
	}

	
	//This method is for input validation of doubles.  It repeatly asks for new input until it gets
	//a positive nonzero number.  negative numbers can break the black schoales formulae and it also
	//doesn't make sense for inputs to be 0.
	public static double getPositiveNumber(Scanner scn){
		double input = 0;
			do {
			System.out.println("Enter a positive number");
			while (!scn.hasNextDouble()) {
	            System.out.println("That's not a number!");
	            scn.next(); // this is important!
	        }
	        input = scn.nextDouble();
	    } while (input <= 0);
		return input;
	}
	
	//The following methods are used for input validation
	
	//This is used to get the lot size from the user.  It works much like the above method
	//except this is for ints.  It also doesn't allow 0 input because people can't clear
	//negative or zero contracts.
	public static double getPositiveInt(Scanner scn){
		double input = 0;
			do {
			System.out.println("Enter a positive number");
			while (!scn.hasNextInt()) {
	            System.out.println("Input must be an integer");
	            scn.next(); // this is important!
	        }
	        input = scn.nextInt();
	    } while (input <= 0);
		return input;
	}
	
	//This works like the above method but it allows zero input.
	public static double getUserInput(Scanner scn){
		double input = 0;
			do {
				System.out.println("Pick an option");
			while (!scn.hasNextInt()) {
	            System.out.println("Input must be an integer");
	            scn.next(); // this is important!
	        }
	        input = scn.nextInt();
	    } while (input < 0);
		return input;
	}	
}