package message;

//This is the base class for Messages.  The methods throw exceptions because I thought it did not make
//sense for both the QueryMessage and ReplyMessage to implement both methods.

public abstract class Message {
	
	public String getMessage(){
		throw new UnsupportedOperationException();
	}
	
	public void addMessage(){
		throw new UnsupportedOperationException();
	}

}
