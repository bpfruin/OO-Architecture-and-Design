package phfmm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	
	private ControlLayer cl = new ControlLayer();
	
	
	//This method gets the first line of the recipe file in order to append it to the DAS file
	public void getTitle(String filePath) throws FileNotFoundException{
		Scanner input1 = new Scanner(new File(filePath));
		
		while (input1.hasNextLine()) {
            String line = input1.nextLine() + "\n";
            cl.fileTitle(line);
        }
	}
	
	//this file reads the recipe we are using.  It parses the tokens from the file, uses the 2nd to
	//determine which mode to execute and gets the third token for the part size
	public int readRecipe(String filePath) throws FileNotFoundException{
		Scanner input1 = new Scanner(new File(filePath));
		
		input1.useDelimiter(",");
        ArrayList<String> words = new ArrayList<String>();
        
        while(input1.hasNext()){
            String next = input1.next().toUpperCase();
            String word = new String(next);
            words.add(word);
            
        }
        
        if(words.get(1).equals("RAMP")){
        	cl.setStrategy(new Ramp());
        	return Integer.parseInt(words.get(2));
        } else if(words.get(1).equals("CONSTANTPRESSURE")){
        	cl.setStrategy(new ConstantPressure());
        	return Integer.parseInt(words.get(2));
        } else if(words.get(1).equals("CONSTANTCURRENT")){
        	cl.setStrategy(new ConstantCurrent());
        	return Integer.parseInt(words.get(2));
        } else {
        	System.out.println("ERROR: Could not read recipe file");
        	return 0;
        }
	}
	
	//this method gets the number of seconds to run for a particular mode
	public int getTime(){
		return cl.strategyTime();
	}
	
	//this method makes sure the machine will not run longer than 100 seconds and then calls the strategy
	//for the recipe that was set in the readRecipe method
	public void executeRecipe(int t, int part){		
		int time = normalizeTime(t);
		
		for(int i = 0; i<=time; i++){
			cl.tryStrategy(i, part);
		}
	}
	
	//this method is for a manual run.  The user supplies all inputs and this method makes sure the
	//values are permissible.  It then calls the manual run method
	public void manualRun(int t, int psi, int amps, int size){
		int time = normalizeTime(t);
		int pressure = normalize(psi);
		int power = normalize(amps);
		
		for(int i = 0; i<=time; i++){
			cl.manualRun(i, pressure, power, size);
		}
	}
	
	//This method calls the getControlValues method of the Control Layer which in turn gets the values
	//from the hardware layer.
	public void getControlValue(){
		String control = cl.getControlVals();
		System.out.println("Control Values: "+control);
	}
	
	//this method makes a call to the control layer to compare the output file and the check file
	public void sendFileForCompare(String path) throws IOException{
		cl.compareFiles(path);
	}
	
	//This method makes sure psi and amps values are permissible
	public int normalize(int num){
		if (num > 200){
			num = 200;
		} else if (num < 0){
			num = 0;
		}
		return num;
	}
	
	//This method makes sure time values are permissible
	public int normalizeTime(int num){
		
		if (num > 100){
			num = 100;
		} else if (num < 0){
			num = 0;
		}
		return num;
		
	}
	
	//The method clears the output file so it does not need to be deleted for every run.
	public void initFile(){
		
		try{
		    // Create file 
		    FileWriter fstream = new FileWriter("/Users/bpfruin/Documents/CSPP51036/hw3-bpfruin/src/phfmm/output.txt",false);
		        BufferedWriter out = new BufferedWriter(fstream);
		    //Close the output stream
		    out.close();
		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
	   
	}
}