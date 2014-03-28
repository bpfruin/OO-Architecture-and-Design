package option;

//This class mirrors the CallOption class.  It has fields for all its input variables as well as for its
//price and Greeks.  The class has a constructor that takes in it's input variables and getters and setters
//for all its fields.  It also has an accept method so the Visitor can price the option and calculate
//its greeks

public class PutOption extends Option implements Visitable {
	
	private double stockLastTraded;
	private double strikePrice;
	private double volatility;
	private double timeTilExpiry;
	private double riskFreeRate;
	
	private double price;
	private double delta;
	private double gamma;
	private double vega;
	private double theta;
	private double rho;
	
	private boolean buy;
	
	public PutOption(boolean b, double lastTraded, double strike, double vol, double time, double rate){
		
		buy = b;
		stockLastTraded = lastTraded;
		strikePrice = strike;
		volatility = vol;
		timeTilExpiry = time;
		riskFreeRate = rate;
		
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

	public double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public double getVolatility() {
		return volatility;
	}

	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}

	public double getTimeTilExpiry() {
		return timeTilExpiry;
	}

	public void setTimeTilExpiry(double timeTilExpiry) {
		this.timeTilExpiry = timeTilExpiry;
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

//accept method for the visitor.
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
