package option;

//This is the SecuritiesIterator interface.  It has the classes that implement it
//have a createIterator() method.  The Portfolio class implements the interface.

import java.util.Iterator;

public interface SecuritiesIterator {
	
	public Iterator<Security> createIterator();

}
