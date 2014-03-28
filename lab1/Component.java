package lab1;

import java.util.Iterator;

//Parent class for components.  All methods throw UnsupportedOperationException in case a subclass
//does not implement every method.

public abstract class Component {
	
	public void add(Component component){
		throw new UnsupportedOperationException();
	}
	
	public void remove(Component component){
		throw new UnsupportedOperationException();
	}
	
	public double getPrice(){
		throw new UnsupportedOperationException();
	}
	
	public Iterator createIterator(){
		throw new UnsupportedOperationException();
	}
	
	public void print(){
		throw new UnsupportedOperationException();
	}

	public double accept(PricingVisitor visitor) {
		throw new UnsupportedOperationException();
	}
}
