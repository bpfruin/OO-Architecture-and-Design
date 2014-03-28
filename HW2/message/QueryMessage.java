package message;

//This class simply gets messages from the queue

public class QueryMessage extends Message {
	
	public void getMessage(MessageQueue queue){
		queue.popMsg();
	}

}
