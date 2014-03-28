package mvc;

import java.util.Scanner;

//this is a simple main class that gets input from the user and informs the controller.
//the controller in turn informs the models.

public class Main {

	private static Controller c = new Controller();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		while(true){
			System.out.println("Press enter to change light....<enter>");
			Scanner keyboard = new Scanner(System.in);
			keyboard.nextLine();
			c.informModel();
		}

		
	}

}
