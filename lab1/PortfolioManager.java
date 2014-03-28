package lab1;

public class PortfolioManager {
	
	//Simple driver class.  It's a singleton, like in HW1.
	
protected PortfolioManager(){}
	
	public static PortfolioManager getInstance(){
		if (instance == null){
			//took out synchronized part
			instance = new PortfolioManager();
		}
		return instance;
	}
	
	
	private static PortfolioManager instance = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PortfolioManager p1;
		
		
		p1 = PortfolioManager.getInstance();
		p1.aMethod();
		
	}
	
	public void aMethod(){
		
		//Instantiate some composites...
		Component masterPortfolio = new Portfolio("All assets: ", "This portfolio includes all assets");
		Component stockAccount = new Account("Stocks: ", "This is an account of Stocks");
		Component bondAccount = new Account("Bonds: ", "This is an account of Bonds");
		Component moneyMarketAccount = new Account("Money Market: ", "This is an account of money market accounts");
		
		//Instantiate some leaves
		MoneyMarket mm = new MoneyMarket("test", 20.00, 5.00);
		MoneyMarket mm1 = new MoneyMarket("test", 130.00, 5.00);
		MoneyMarket mm2 = new MoneyMarket("test", 540.00, 5.00);

		//put the leaves in an account
		moneyMarketAccount.add(mm);
		moneyMarketAccount.add(mm1);
		moneyMarketAccount.add(mm2);
		
		//Instantiate some leaves
		Stock s = new Stock("test", 4320.00);
		Stock s1 = new Stock("test", 56730.00);
		Stock s2 = new Stock("test", 2340.00);

		//put the leaves in an account
		stockAccount.add(s);
		stockAccount.add(s1);
		stockAccount.add(s2);
		
		//Instantiate some leaves
		Bond b = new Bond("test", 420.00, 3.0);
		Bond b1 = new Bond("test", 6730.00, 2.0);
		Bond b2 = new Bond("test", 340.00, 6.0);

		//put the leaves in an account
		bondAccount.add(b);
		bondAccount.add(b1);
		bondAccount.add(b2);
		
		//put the accounts in a portfolio
		masterPortfolio.add(stockAccount);
		masterPortfolio.add(bondAccount);
		masterPortfolio.add(moneyMarketAccount);
		
		PricingVisitor pricer = new PricingVisitor();
		
		//call the visitor method on the portfolio
		masterPortfolio.accept(pricer);
		
	}

}
