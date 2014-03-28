package lab1;

import java.util.Iterator;

//Class to represent MoneyMarkets.  Essentially the same as the bond class.

public class MoneyMarket extends Leaf implements Visitable {
	
	String name;
	double price;
	double rate;
	
	public MoneyMarket(String MMName, double MMPrice, double MMRate){
		name = MMName;
		price = MMPrice;
		rate = MMRate;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getRate(){
		return rate;
	}
	
	public void print(){
		System.out.println("The money market "+getName()+" is currently valued at "+getPrice()+" with an interest rate of "+getRate());
	}

	@Override
	public double accept(PricingVisitor visitor) {
		return visitor.visit(this);
	}
	
	public Iterator createIterator() {
		return new NullIterator();
	}

}
