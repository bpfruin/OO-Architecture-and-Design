package broker;

//The client broker performs 2 primary functions.  It sends a string to the transport layer of the original
//CallMessage and it also gets the result String from the transport layer and puts the result into
//a CallMessage object to go back to the ClientProxy.

public class ClientBroker {
	
	
	private CallMessage brokerMessage = new CallMessage();
	private String stringMessage;
	private Transport tp = new Transport();
	
	//This method gets the CallMessage from the proxy, turns it into a String and then sends that
	//string to the transport layer
	public void getMessage(CallMessage message){
		brokerMessage = message;
		stringify(brokerMessage);
		sendToTransport(stringMessage);
	}
	
	//This method turns the CallMessage into a standard String format
	public void stringify(CallMessage message){
		String result = brokerMessage.getMethod() +","+ brokerMessage.getMessage() +","+ brokerMessage.getNum1() +","+ brokerMessage.getNum2();
		stringMessage = result;
	}
	
	//This sends the stringified message to the transport layer
	public void sendToTransport(String stringMessage){
		tp.getAndSend(stringMessage);
	}
	
	//This method gets the result string from the transports layer, boxes it into a CallMessage
	//and sends it to the client proxy
	public void sendResultToProxy(String result){
		ClientProxy cProxy = new ClientProxy();
		String[] messageArray = result.split(",");
		
		brokerMessage.setResult(Integer.parseInt(messageArray[0]));
		
		cProxy.sendResultToClient(brokerMessage);
	}

}
