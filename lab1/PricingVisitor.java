package lab1;

import java.util.Iterator;

public class PricingVisitor {


	//The Account visit method uses an iterator to loop over the components of the account and calls the
	//getPrice method on each component.  These values are summed up and returned.
	public double visit(Account accountItem) {
		System.out.println("Value of account: ");
		
		double total = 0;
		
		System.out.println(accountItem.getName() +" "+ accountItem.getDescription());
		
		Iterator iterator = accountItem.createIterator();
		while (iterator.hasNext()) {
			Component component = (Component)iterator.next();
			total += component.getPrice();
		}
		System.out.println("Total account value: ");
		System.out.println(total);
		return total;
		
	}

	//The Portfolio visit method uses an iterator to loop over the components of the account and calls the
	//getPrice method on each component.  These values are summed up and returned.
	public double visit(Portfolio portfolioItem) {
		
		double total = 0;
		
		System.out.println(portfolioItem.getName() +" "+ portfolioItem.getDescription());
		
		Iterator iterator = portfolioItem.createIterator();
		while (iterator.hasNext()) {
			Component component = (Component)iterator.next();
			total += component.getPrice();
		}
		System.out.println("Total portfolio value: ");
		System.out.println("$"+total);
		return total;
		
	}

	//the leaf visitor methods print out a message with the price and return the price calling the
	//getPrice() method on the leaf
	public double visit(Bond bondItem) {
		System.out.println("Price of bond: "+bondItem.getPrice());
		return bondItem.getPrice();
	}

	
	public double visit(Stock stockItem) {
		System.out.println("Price of stock: "+stockItem.getPrice());
		return stockItem.getPrice();
	}


	public double visit(MoneyMarket moneyMarketItem) {
		System.out.println("Price of money market: "+moneyMarketItem.getPrice());
		return moneyMarketItem.getPrice();
	}

	
	
}
