package lab1;

import java.util.Iterator;

//This is the iterator for leafs.  next() returns null and hasNext() returns false.  This is because
//leafs have nothing to iterate over.

public class NullIterator implements Iterator {

	public Object next() {
		return null;
	}
	
	public boolean hasNext(){
		return false;
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
