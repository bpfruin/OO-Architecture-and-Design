package broker;

//This class instantiates its servant objects and calls methods on them and
//sends results back to the server proxy

public class Server {
	
	private ServerProxy sProxy = new ServerProxy();
	private String identity = "Lab 2 Server Broker";
	
	//This method calls the appropriate methods on the servant objects,
	//gets the result, and sends the CallMessage with the result added back
	//to the client proxy.
	public void serverGetMessage(CallMessage callMessage){
		
		if(callMessage.getMethod().equalsIgnoreCase("length")){
			Length lengthCalc = new Length();
			callMessage.setResult(lengthCalc.computeLength(callMessage.getMessage()));
			sProxy.serverProxyReturnResult(callMessage);
		}
		
		if(callMessage.getMethod().equalsIgnoreCase("add")){
			Add adder = new Add();
			callMessage.setResult(adder.addEmUp(callMessage.getNum1(), callMessage.getNum2()));
			sProxy.serverProxyReturnResult(callMessage);

		}
		
		
	}
	//This method just checks to see if the name passed into it
	//matches the hard-coded identifying parameter.
	public boolean identifyServer(String name){
		if(name.equalsIgnoreCase(identity)){
			return true;
		} else {
			return false;
		}
	}

}
