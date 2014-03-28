package option;
//CallOption is a subclass of Option and it represents a real world call option derivative
//It is a very simple class.  it has fields for its real world variables and analytics and it has setters
//and getters for all its fields.  it's constuctor takes in it's input variables as well as a buy/sell
//flag.  This class also has an accept method so the derivative can be valued by the visitor.
public class CallOption extends Option implements Visitable {
	
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
	
	//constructor
	public CallOption(boolean b, double lastTraded, double strike, double vol, double time, double rate){
		
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

	//accept method
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
