package lab1;

import java.util.Iterator;
import java.util.Stack;

//This is a recursive iterator class.  It is pulled from the "Head First Design Patterns" book.

public class PortfolioIterator implements Iterator {
	
	Stack stack = new Stack();
	
	public PortfolioIterator(Iterator iterator) {
		stack.push(iterator);
	}

	
	//To see if there is a next element, we check to see if the stack is empty.  If not, we get the
	//iterator off the top of the stack and see if it has a next element. If it doesn't, we pop it off
	//the stack and call the method again, recursively.
	@Override
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator iterator = (Iterator) stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	//First, we see if there is a next element by calling hasNext(). If there is a next element, we get the
	//current iterator off the stack and get its next element.  If that element is a composite, so we
	//put than on the stack.  Then we return the component.
	@Override
	public Object next() {
		if (hasNext()) {
			Iterator iterator = (Iterator) stack.peek();
			Component component = (Component) iterator.next();
			if (component instanceof Composite) {
				stack.push(component.createIterator());
			}
			return component;
		} else {
			return null;
		}
	}

	//We're only supporting traversal.
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
