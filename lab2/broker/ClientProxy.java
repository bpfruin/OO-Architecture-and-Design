package broker;

//This class creates a CallMessage given the arguments supplied by the client.
//There is a method that creates a CallMessage for the add method and one that
//creates one for the length method.  This class also has methods to send the call message
//to the ClientBroker as well as a method to send the result to the client.

public class ClientProxy {
	
	String operation;
	String word;
	int num1;
	int num2;
	
	private CallMessage message = new CallMessage();
	private ClientBroker cb = new ClientBroker();
	
	
	public void createCallMessage(String operation, String word){
		if(!operation.equalsIgnoreCase("length")){
			System.out.println("ERROR: only valid operations are Add and Length");
		}
		
		message.setMethod(operation);
		message.setMessage(word);
		message.setNum1(0);
		message.setNum2(0);
		message.setResult(0);
		
		
		sendMessage(message);
		
	}
	
	public void createCallMessage(String operation, int num1, int num2){
		if(!operation.equalsIgnoreCase("add")){
			System.out.println("ERROR: only valid operations are Add and Length");
		}
		
		message.setMethod(operation);
		message.setMessage(null);
		message.setNum1(num1);
		message.setNum2(num2);
		message.setResult(0);
		
		sendMessage(message);
		
	}
	
	public void sendMessage(CallMessage message){
		cb.getMessage(message);
	}
	
	public void sendResultToClient(CallMessage cMessage){
		MyMain client = new MyMain();
		client.getResult(cMessage);
	}

}
