package lab1;

//interface for classes using an accept method.  This forces classes that want to be visitable to implement the method.

public interface Visitable {

	public double accept(PricingVisitor visitor);
	
}
