package lab1;

import java.util.ArrayList;
import java.util.Iterator;

//This class represents an account.  An account can have leafs but no composites.  This behavior is
//captured in the add method.

public class Account extends Composite implements Visitable {

	ArrayList accountComponents = new ArrayList();
	String name;
	String description;
	
	Iterator iterator = null;
	
	public Account(String accountName, String accountDescription){
		name = accountName;
		description = accountDescription;
	}
	
	public void add(Component component){
		if (component instanceof Leaf){
		accountComponents.add(component);
		} else {
			System.out.println("ERROR: Only Stocks, Bonds, and Money Markets can be added to Accounts");
		}
	}
	
	public void remove(Component component){
		accountComponents.remove(component);
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	
	//The get price method uses an iterator to loop over the components of the account and calls the
	//getPrice method on each component.  These values are summed up and returned
	public double getPrice(){
		double total = 0;
		
		System.out.println(getName() +" "+ getDescription());
		System.out.println("Value: ");
		
		Iterator iterator = accountComponents.iterator();
		while (iterator.hasNext()) {
			Component component = (Component)iterator.next();
			total += component.getPrice();
		}
		System.out.println("$"+total);
		return total;
	}
	
	//This method loops over the components of an account and calls the print method on each component
	//the print method for leaves prints out the leaf's attributes.
	public void print(){
		System.out.println(getName() +" "+ getDescription());
		System.out.println("--------------------");
		
		Iterator iterator = accountComponents.iterator();
		while (iterator.hasNext()) {
			Component component = (Component)iterator.next();
			component.print();
		}
	}

	//This calls the visitor method
	@Override
	public double accept(PricingVisitor visitor) {
		return visitor.visit(this);
	}
	
	//This method instantiates a PortfolioIterator
	public Iterator createIterator(){
		if (iterator == null) {
			iterator = new PortfolioIterator(accountComponents.iterator());
		}
		return iterator;
	}
	
}
