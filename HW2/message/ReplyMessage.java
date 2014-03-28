package message;

//This class replies to messages.  Very straightforward.

public class ReplyMessage extends Message {
	
	public void addMessage(MessageQueue queue, String message){
		queue.addMsg(message);
	}

}
