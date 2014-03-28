package broker;

//The server broker boxes the stringified CallMessages back into CallMessages
//and sends them to the ServerProxy. This class also performs ServerIdentification
//as well.  The identifying string is hardcoded in the boxUp method

public class ServerBroker {
	
	private String stringMessage;
	private CallMessage cMessage = new CallMessage();
	private ServerProxy serv = new ServerProxy();
	
	
	public void getFromTransport(String message){	
		stringMessage = message;
		boxUp(stringMessage);		
	}
	
	//This method turns the String messages back into CallMessages.  It also sends the CallMessage
	//to the ServerProxy
	public void boxUp(String message){
						
		String[] messageArray = message.split(",");
		
		cMessage.setMethod(messageArray[0]);
		cMessage.setMessage(messageArray[1]);
		cMessage.setNum1(Integer.parseInt(messageArray[2]));
		cMessage.setNum2(Integer.parseInt(messageArray[3]));
		
		serv.sendToServer(cMessage, "Lab 2 Server Broker");
	}
	
	//This method takes the result from the returned call message and sends it back as a String
	//the other arguments are done away with.  Only the result is sent back.
	public void unboxAndSend(CallMessage message){
		Transport trans = new Transport();
		String result = Integer.toString(message.getResult());
		trans.sendResultBack(result);
		
	}

}
