package lab1;

import java.util.Iterator;

//Simple class representing a stock.  Stocks have a name and price.  Otherwise, this class is the same
//as the bond and money market class.

public class Stock extends Leaf implements Visitable {
	
	String name;
	double price;
	
	public Stock(String stockName, double stockPrice){
		name = stockName;
		price = stockPrice;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void print(){
		System.out.println("The stock "+getName()+" is currently valued at "+getPrice());
	}

	@Override
	public double accept(PricingVisitor visitor) {
		return visitor.visit(this);
	}
	
	public Iterator createIterator() {
		return new NullIterator();
	}
}
