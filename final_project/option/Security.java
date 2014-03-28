package option;

//This is an abstract base class for security.  It has method declarations for all getters and setters so that
//when the portfolio(which is an ArrayList<Security>) is being iterated over, these methods can be called
//regardless of whether the Security object is an stock or option.

public abstract class Security implements Visitable{
		
	public abstract boolean isBuy();

	public abstract void setBuy(boolean buy);

	public abstract double getStockLastTraded();
	
	public abstract void setStockLastTraded(double stockLastTraded);
	
	public abstract double getRiskFreeRate();

	public abstract void setRiskFreeRate(double riskFreeRate);
	
	public abstract double getPrice();
	
	public abstract void setPrice(double price);
	
	public abstract double getDelta();
	
	public abstract void setDelta(double delta);
	
	public abstract double getGamma();
	
	public abstract void setGamma(double gamma);
	
	public abstract double getVega();
	
	public abstract void setVega(double vega);
	
	public abstract double getTheta();
	
	public abstract void setTheta(double theta);
	
	public abstract double getRho();
	
	public abstract void setRho(double rho);
	
	public abstract double getVolatility();

	public abstract void setVolatility(double volatility);

	public abstract void accept(Visitor visitor);

}
