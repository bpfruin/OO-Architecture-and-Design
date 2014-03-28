//This is a client class that presents a simple UI.  users input whether they want to add
//two integers or get the length of a string.  The UI then asks for the arguments and calls the
//method in the client proxy class that creats a call message
//This class also has the getResult method which the client proxy calls once it receives the result.
package broker;

import java.util.Scanner;

public class MyMain {

	private static ClientProxy cp = new ClientProxy();
	
	public static void main(String[] args) {
		
		String operation;
		String word;
		int num1;
		int num2;
		Scanner scnScanner = new Scanner(System.in);
		System.out.println("What is your operation? Add or Length");
		operation = scnScanner.nextLine();
		operation = operation.trim();
		if(operation.equalsIgnoreCase("length")){
			System.out.println("Enter the string you would like to know the length of, excluding leading and trailing whitespace");
			word = scnScanner.nextLine();
			word = word.trim();
			cp.createCallMessage(operation, word);
		} else if(operation.equalsIgnoreCase("add")) {
			System.out.println("Enter the first integer you would like to sum");
			while(!scnScanner.hasNextInt()){
				System.out.println("That's not a number.  Try again.");
				scnScanner.next();
			}
			num1 = scnScanner.nextInt();
			System.out.println("Enter the second integer you would like to sum");
			while(!scnScanner.hasNextInt()){
				System.out.println("That's not a number.  Try again.");
				scnScanner.next();
			}
			num2 = scnScanner.nextInt();
			
			cp.createCallMessage(operation, num1, num2);
		} else {
			System.out.println("Sorry, only add and length operations are supported");
		}		
		//cp.createCallMessage("length", "heyblahvlajfjkhjsajkdshjkjsadjksda");
		
		//cp.createCallMessage("add",1,50);
		
		

	}
	
	//This method gets the final result from the ClientProxy class.  The client
	//proxy calls this method when it has the CallMessage containing the result
	//of the operation.
	public void getResult(CallMessage message){
		int result = message.getResult();
		System.out.println("The result of the operation is: "+result);
	}

}
