package message;

//Simple driver class that adds a few messages and pops them from the queue.  The last call to getMessage
//calls it on an empty queue, generating an error message.

public class MyMain {

	public static void main(String[] args) {
		MessageQueue queue = new MessageQueue();
		ReplyMessage reply = new ReplyMessage();
		QueryMessage query = new QueryMessage();
		
		reply.addMessage(queue, "Hey, there!");
		query.getMessage(queue);
		reply.addMessage(queue, "How you doin?");
		query.getMessage(queue);
		reply.addMessage(queue, "U of C rocks");
		reply.addMessage(queue, "Ryerson");
		query.getMessage(queue);
		query.getMessage(queue);
		query.getMessage(queue);


	}

}
