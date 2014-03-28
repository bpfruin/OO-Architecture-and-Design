package broker;

//This class acts as a transport layer. it sends messages to and from the brokers.
//it handles only Strings

public class Transport {
	
	private String transportMessage;
	private ServerBroker sb = new ServerBroker();
	
	public void getAndSend(String message){
		transportMessage = message;
		sb.getFromTransport(transportMessage);		
	}
	
	public void sendResultBack(String result){
		ClientBroker cBroker = new ClientBroker();
		cBroker.sendResultToProxy(result);
		
	}
	
}
