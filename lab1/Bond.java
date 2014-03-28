package lab1;

import java.util.Iterator;

//Simple leaf class to represent a bond.  Bonds have a price, a name, and a discount rate(although the
//discount rate is not used for calculations.

public class Bond extends Leaf implements Visitable {
	
	String name;
	double price;
	double rate;
	
	public Bond(String bondName, double bondPrice, double bondRate){
		name = bondName;
		price = bondPrice;
		rate = bondRate;
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
		System.out.println("The bond "+getName()+" is currently valued at "+getPrice()+" with a discount rate of "+getRate());
	}

	@Override
	public double accept(PricingVisitor visitor) {
		return visitor.visit(this);
	}
	
	public Iterator createIterator() {
		return new NullIterator();
	}

}
