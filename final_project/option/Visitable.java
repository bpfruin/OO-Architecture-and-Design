package option;

//This is the Vistable interface that makes classes that implement in also implement the accept method.

public interface Visitable {
	
	public void accept(Visitor visitor);

}