package option;

//The controller class does a lot.  It coordinates much of what goes on in the application.
//This class is a singleton so that the client can be assured that there aren't more than one
//controllers, causing problems like trades not being reflected in the position.  It also makes
//calls on the portfolio class, adding securities to the position and requests for the actual
//portfolio arraylist for valuation and update purposes.  The methods are commented.

import java.text.DecimalFormat;
import java.util.Iterator;


public class Controller {
	
	Portfolio portfolio;	
	public Strategy strategyType;
	DecimalFormat df = new DecimalFormat("#.##");
	
	//from Mark Shacklette's in class example
		protected Controller(){}
		
		//Mark Shacklette's singleton getInstance() method.
		public static Controller getInstance(){
			if (instance == null){
				//took out synchronized part
				instance = new Controller();
			}
			return instance;
		}
	
		private static Controller instance = null;

	
	//this method makes calls on the Strategy class for execution of the hedging strategy.
	//the value returned is the number of shares the user should buy or sell depending
	//on the trading strategy selected by the user.
	public int tryStrategy(Portfolio portfolio){
		int result = strategyType.execute(portfolio);
		
		if (result > 0){
			System.out.println("You should buy "+result+" shares of stock.\n");
		} else if (result < 0) {
			result = Math.abs(result);
			System.out.println("You should sell "+result+" shares of stock.\n");
		} else {
			System.out.println("Your position already conforms to your strategy.\n");
		}		
		return result;
	}
	
	//getter for the Portfolio instance used by the controller
	public Portfolio getPortfolio() {
		return portfolio;
	}

	//getter and setter for the Strategy instance used by the controller and set dynamically by the user
	//at runtime
	public Strategy getStrategyType() {
		return strategyType;
	}

	public void setStrategyType(Strategy strategyType) {
		this.strategyType = strategyType;
	}

	
	//This method values the portfolio and sets all the greeks for all the securites in the
	//portfolio and for the portfolio itself as a whole.  It uses an iterator to iterate through
	//the ArrayList of Security used by the Portfolio class.  The iterator goes through the collection
	//and uses the Visitor to value all the Securities and then sets all the prices and greeks for the
	//Securities, summing the results to finally yield the value and Greeks for the portfolio itself.
	//It also reports the Portfolio value and Greeks to the user.
	public void valuePortfolio(){
		
		double value = 0;
		double delta = 0;
		double gamma = 0;
		double theta = 0;
		double vega = 0;
		double rho = 0;
		
		System.out.println("Your portfolio value and Greeks are:");
		
		Iterator<Security> iterator = portfolio.createIterator();
		Visitor pricer = new Visitor();
		
		while(iterator.hasNext()){
			
			Security security = (Security) iterator.next();
			security.accept(pricer);
			
			if(security.isBuy()){
				value += security.getPrice();
				delta += security.getDelta();
				gamma += security.getGamma();
				theta += security.getTheta();
				vega += security.getVega();
				rho += security.getRho();
			} else {
				value -= security.getPrice();
				delta -= security.getDelta();
				gamma -= security.getGamma();
				theta -= security.getTheta();
				vega -= security.getVega();
				rho -= security.getRho();
			}		
		}
		
		value = Double.parseDouble(df.format(value));
		delta = Double.parseDouble(df.format(delta));
		gamma = Double.parseDouble(df.format(gamma));
		theta = Double.parseDouble(df.format(theta));
		vega = Double.parseDouble(df.format(vega));
		rho = Double.parseDouble(df.format(rho));

		
		portfolio.setValue(value);
		System.out.println("The value of your portfolio is: $"+portfolio.getValue());
		portfolio.setDelta(delta);
		System.out.println("The delta of your portfolio is: "+portfolio.getDelta());
		portfolio.setGamma(gamma);
		System.out.println("The gamma of your portfolio is: "+portfolio.getGamma());
		portfolio.setTheta(theta);
		System.out.println("The theta of your portfolio is: "+portfolio.getTheta());
		portfolio.setVega(vega);
		System.out.println("The vega of your portfolio is: "+portfolio.getVega());
		portfolio.setRho(rho);
		System.out.println("The rho of your portfolio is: "+portfolio.getRho()+"\n");
	}
	
	//Update portfolio takes the price, rate and volatility params supplied by the user and uses an
	//iterator on the Portfolio instance of the class and sets these values in these fields
	//for all the securities.  Once this is complete, the method calls valuePortfolio()
	//so the new Greeks and value is reported to the user.
	public void updatePortfolio(double price, double rate, double volatility){
				
		if(portfolio == null){
			System.out.println("Nothing has been added to the portfolio yet.");
			return;
		}		
		
		Iterator<Security> iterator = portfolio.createIterator();
		
		while(iterator.hasNext()){
			
			Security security = (Security) iterator.next();
			
			security.setStockLastTraded(price);
			security.setRiskFreeRate(rate);
			security.setVolatility(volatility);			
		}
		valuePortfolio();
	}
	
	//This method sends the params supplied by the user to the portfolio class so that a new CallOption
	//object is added to the Portfolio.  It is run in a loop, with the limit of the for loop being the
	//quantity to trade supplied by the user. The method first checks if the Portfolio is null and creates
	//and instance if it is.  The method finally calls the valuePortfolio() method so the user knows the new
	//value and Greeks of his/her portfolio.
	public void createCallOption(boolean b, double lastTraded, double strike, double vol, double time, double rate, int size){
		
		if(portfolio == null){
			portfolio = new Portfolio();
		}
	
		for(int i = 0; i < size; i++){
			portfolio.addCallOptionToPortfolio(b, lastTraded, strike, vol, time, rate);
		}
		
		valuePortfolio();	
	}
	
	//This method works the same way as createCallOption except this one creates a PutOption.  They should probably be one
	//method.
	public void createPutOption(boolean b, double lastTraded, double strike, double vol, double time, double rate, int size){
		
		if(portfolio == null){
			portfolio = new Portfolio();
		}
		
		for(int i = 0; i < size; i++){
			portfolio.addPutOptionToPortfolio(b, lastTraded, strike, vol, time, rate);
		}
		
		valuePortfolio();		
	}
	
	//This method works much the same as the previous 2 except this one creates a Stock object.
	public void createStock(boolean b, double lastTraded, int size){
		
		if(portfolio == null){
			portfolio = new Portfolio();
		}
		
		for(int i = 0; i < size; i++){
			portfolio.addStockToPortfolio(b, lastTraded);
		}
		
		valuePortfolio();
	}
}
