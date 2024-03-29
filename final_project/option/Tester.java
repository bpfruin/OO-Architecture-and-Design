package option;

import java.text.DecimalFormat;

public class Tester {

//THIS CLASS IS STRICTLY FOR TEST PURPOSES ONLY
//A CONSOLE BASED UI IS IN THE "MAIN" CLASS

	

//This class instantiates some objects, and tests the values generated to values
//set by me and known to be correct.  I truncate the numbers to 2 decimal places
//becuase the results of Black Schoales often tend to be infinitely repeating decimals
//and thus hard to check for equality.
	
//First I check the results of creating a call option and a put option on their own
//Then instantiate a small portfolio that buys a call, sells a put, and buys a share of stock.
//The value and Greeks generated by the program are checked against hard coded values known
//to be accurate.
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Visitor pricer = new Visitor();
		DecimalFormat df = new DecimalFormat("#.##");
		int successes = 0;
		int errors = 0;
		
		double callValue = 1.46;
		double callDelta = 0.95;
		double callGamma = 0.11;
		double callVega = 1.1;
		double callRho = 7.99;
		double callTheta = -0.45;
		
		CallOption callOption = new CallOption(true, 10, 9, 0.1, 1, 0.05);
		callOption.accept(pricer);
		
		double codeCallValue = Double.parseDouble(df.format(callOption.getPrice()));
		double codeCallDelta = Double.parseDouble(df.format(callOption.getDelta()));
		double codeCallGamma = Double.parseDouble(df.format(callOption.getGamma()));
		double codeCallVega = Double.parseDouble(df.format(callOption.getVega()));
		double codeCallRho = Double.parseDouble(df.format(callOption.getRho()));
		double codeCallTheta = Double.parseDouble(df.format(callOption.getTheta()));
		
		if ( callValue == codeCallValue ){
		 successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}
		
		if ( callDelta == codeCallDelta ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( callGamma == codeCallGamma ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( callVega == codeCallVega ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( callTheta == codeCallTheta ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( callRho == codeCallRho ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   

		
		double putValue = 0.02;
		double putDelta = -0.05;
		double putGamma = 0.11;
		double putVega = 1.10;
		double putRho = -0.57;
		double putTheta = -0.03;
		
		PutOption putOption = new PutOption(true, 10, 9, 0.1, 1, 0.05);
		putOption.accept(pricer);
		
		double codePutValue = Double.parseDouble(df.format(putOption.getPrice()));
		double codePutDelta = Double.parseDouble(df.format(putOption.getDelta()));
		double codePutGamma = Double.parseDouble(df.format(putOption.getGamma()));
		double codePutVega = Double.parseDouble(df.format(putOption.getVega()));
		double codePutRho = Double.parseDouble(df.format(putOption.getRho()));
		double codePutTheta = Double.parseDouble(df.format(putOption.getTheta()));
		
		if ( putValue == codePutValue ){
		 successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}
		
		if ( putDelta == codePutDelta ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( putGamma == codePutGamma ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( putVega == codePutVega ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( putTheta == codePutTheta ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( putRho == codePutRho ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		
		Controller c = Controller.getInstance();
		c.createCallOption(true, 10, 9, 0.1, 1, 0.05, 1);
		c.createPutOption(false, 10, 9, 0.1, 1, 0.05, 1);
		c.createStock(true, 10, 1);
						
		double portValue = 11.44;
		double portDelta = 2;
		double portGamma = 0;
		double portVega = 0.0;
		double portRho = 8.56;
		double portTheta = -0.43;
		
		
		double codePortValue = Double.parseDouble(df.format(c.getPortfolio().getValue()));
		double codePortDelta = Double.parseDouble(df.format(c.getPortfolio().getDelta()));
		double codePortGamma = Double.parseDouble(df.format(c.getPortfolio().getGamma()));
		double codePortVega = Double.parseDouble(df.format(c.getPortfolio().getVega()));
		double codePortRho = Double.parseDouble(df.format(c.getPortfolio().getRho()));
		double codePortTheta = Double.parseDouble(df.format(c.getPortfolio().getTheta()));
		
		if ( portValue == codePortValue ){
		 successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}
		
		if ( portDelta == codePortDelta ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( portGamma == codePortGamma ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( portVega == codePortVega ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( portTheta == codePortTheta ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}   
		
		if ( portRho == codePortRho ){
			successes++;
		} else {
			errors++;
			System.out.println("portfolio value does not match expected");
		}  	
		
		System.out.println("There were "+successes+" successes and there were "+errors+" errors.");
		
	}

}
