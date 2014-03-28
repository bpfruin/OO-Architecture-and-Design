package option;

//This class very closely mirrors the CallOption and PutOption class.  It has fields for all its input variables as well as for its
//price and Greeks.  The class has a constructor that takes in it's input variables and getters and setters
//for all its fields.  It also has an accept method so the Visitor can assign price and Greek values. 


public class Stock extends Security implements Visitable {
	
	private double stockLastTraded;
	private double riskFreeRate;
	private double volatility;

	private double price;
	private double delta;
	private double gamma;
	private double vega;
	private double theta;
	private double rho;
	
	private boolean buy;
	
	//constructor
	public Stock(boolean b, double lastTraded){
		buy = b;
		stockLastTraded = lastTraded;
	}	
	
	//getters and setters
	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}

	public double getStockLastTraded() {
		return stockLastTraded;
	}

	public void setStockLastTraded(double stockLastTraded) {
		this.stockLastTraded = stockLastTraded;
	}

	public double getRiskFreeRate() {
		return riskFreeRate;
	}

	public void setRiskFreeRate(double riskFreeRate) {
		this.riskFreeRate = riskFreeRate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public double getVega() {
		return vega;
	}

	public void setVega(double vega) {
		this.vega = vega;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getRho() {
		return rho;
	}

	public void setRho(double rho) {
		this.rho = rho;
	}
	
	public double getVolatility() {
		return volatility;
	}

	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}	

	//accept method for "valuation"
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
