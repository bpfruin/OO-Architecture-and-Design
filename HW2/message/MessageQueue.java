package message;

//Very simple implementation of a queue using a vector.  Lots of other data structures could have been used
//it just need to be an ordered data structure for this implementation.  It contains all the standard
//methods for a queue, ie push, pop, and isEmpty

import java.util.Vector;

public class MessageQueue {
		
	private Vector<String> queue;

	public MessageQueue(){
		this.queue = new Vector<String>();
	}

	public void addMsg(String message){
		queue.add(message);
	}

	public boolean isEmpty(){
		return queue.size() == 0;
	}

	public String popMsg(){
		if(isEmpty()){
			System.out.println("Error: Message queue is empty");
			return null;
		}
		System.out.println(queue.get(0));
		return queue.remove(0);
	}

}
