package option;

import java.util.ArrayList;
import java.util.Iterator;

//This class represents the heart of the data layer of my application.  This class manages the
//contents of positions, which reflects the trades the user has entered.  This class adds Securities
//to the portfolio ArrayList and has fields for the value and Greeks for the Portfolio as a whole.

//I'm not sure if I should have named the ArrayList portfolio, since it is the name of the class as well.
//It's not confusing for me but I can see how it could be confusing to someone else.  I ended up using
//"portfolio" because I felt it was the best representation of what it is in real life.

//This class has methods to create stocks and options and has getters and setters for the value and
//Greeks fields.

public class Portfolio implements SecuritiesIterator {
	
	private ArrayList<Security> portfolio;
	private double value;
	private double delta;
	private double gamma;
	private double theta;
	private double vega;
	private double rho;
	
	
	//This method takes in the parameters from the controller class that were origianlly supplied by the user in the UI
	//layer of the application.  It creates the CallOption, creates the portfolio ArrayList if it has not been created
	//yet and finally adds the CallOption object to the ArrayList
	public void addCallOptionToPortfolio(boolean b, double lastTraded, double strike, double vol, double time, double rate){
		
		CallOption option = new CallOption(b, lastTraded, strike, vol, time, rate);
		
		if(portfolio == null){
			portfolio = new ArrayList<Security>();
		}
		portfolio.add(option);
		
	}
	
	//This method works in the same way the the method above works.  I perhaps should have made them one method.
	public void addPutOptionToPortfolio(boolean b, double lastTraded, double strike, double vol, double time, double rate){
		
		PutOption option = new PutOption(b, lastTraded, strike, vol, time, rate);
		
		if(portfolio == null){
			portfolio = new ArrayList<Security>();
		}
		portfolio.add(option);
		
	}
	
	//This method works in the same way that the above 2 methods work.  I should have considered combining all three
	//methods.  If I rewrote this application, I would combine all three.
	public void addStockToPortfolio(boolean b, double lastTraded){
		
		Stock stock = new Stock(b, lastTraded);
		
		if(portfolio == null){
			portfolio = new ArrayList<Security>();
		}
		portfolio.add(stock);
		
	}
	
	//This method return an iterator object of type Security, used by the application for
	//valuing and updating the position.
	@Override
	public Iterator<Security> createIterator() {

		return portfolio.iterator();
		
	}

	//The remaining methods are setters and getters for the fields of the class.
	public ArrayList<Security> getPortfolio() {
		return portfolio;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public double getGamma() {
		return gamma;
	}

	public void setGamma(double gamma) {
		this.gamma = gamma;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getVega() {
		return vega;
	}

	public void setVega(double vega) {
		this.vega = vega;
	}

	public double getRho() {
		return rho;
	}

	public void setRho(double rho) {
		this.rho = rho;
	}

}
