package broker;

//This class locates the server we are looking for and sends it the call message to it
//This class aslso sends the result CallMessage back to the ServerBroker

public class ServerProxy {
	
	//This method performs a check to indentify the server and sends the CallMessage
	//to it if it can find it.
	public void sendToServer(CallMessage message, String name){
		Server serv = new Server();
		if(locateServer(name)){
			serv.serverGetMessage(message);
		} else {
			System.out.println("Sorry, that server is offline");
		}
	}
	
	//This method sends the result CallMessage back to the ServerBroker
	public void serverProxyReturnResult(CallMessage message){
		ServerBroker sBroker = new ServerBroker();
		sBroker.unboxAndSend(message);
	}
	
	public boolean locateServer(String name){
		Server serv = new Server();
		if(serv.identifyServer(name)){
			return true;
		} else {
			return false;
		}
	}
	
}
