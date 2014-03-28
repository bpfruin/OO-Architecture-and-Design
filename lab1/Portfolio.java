package lab1;

import java.util.ArrayList;
import java.util.Iterator;

//This class is essentially the same as the account class with the exception of the add method.  Portfolios
//can contain other portfolios and accounts but cannot contain leaf elements.  This behavior is captured
//in the add method.  Otherwise, this class has the same behavior as account.

public class Portfolio extends Composite implements Visitable {
	
	ArrayList<Component> portfolioComponents = new ArrayList<Component>();
	String name;
	String description;
	
	Iterator iterator = null;
	
	public Portfolio(String portfolioName, String portfolioDescription){
		name = portfolioName;
		description = portfolioDescription;
	}
	
	public void add(Component component){
		if (component instanceof Composite){
		portfolioComponents.add(component);
		} else {
			System.out.println("ERROR: Only Accounts and Portfolios can be added to Portfolios");
		}
	}
	
	public void remove(Component component){
		portfolioComponents.remove(component);
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	//see Account class for explaination of getPrice() and print()
	
	public double getPrice(){
		double total = 0;
		
		System.out.println(getName() +" "+ getDescription());
		System.out.println("Value: ");
		
		Iterator iterator = portfolioComponents.iterator();
		while (iterator.hasNext()) {
			Component component = (Component)iterator.next();
			total += component.getPrice();
		}
		System.out.println(total);
		return total;
	}
	
	public void print(){
		System.out.println(getName() +" "+ getDescription());
		System.out.println("--------------------");
		
		Iterator iterator = portfolioComponents.iterator();
		while (iterator.hasNext()) {
			Component component = (Component)iterator.next();
			component.print();
		}
	}

	@Override
	public double accept(PricingVisitor visitor) {
		return visitor.visit(this);
	}
	
	public Iterator createIterator(){
		if (iterator == null) {
			iterator = new PortfolioIterator(portfolioComponents.iterator());
		}
		return iterator;
	}

}
