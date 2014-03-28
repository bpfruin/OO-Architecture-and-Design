package phfmm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControlLayer {
	
	public Strategy strategyType;
	

	private HardwareLayer hl = new HardwareLayer();
	
	//this method executes a mode and passes the result to the hardware layer.
	public String tryStrategy(int time, int part){
		String result = strategyType.execute(time, part);
				
		hl.writeFile(result);
		return result;
	}
	
	//this method supports a manual run for user supplied inputs
	public String manualRun(int time, int psi, int amps, int part){
		String result = time + "," + psi + "," + amps + "\n";;
				
		hl.writeFile(result);
		return result;
	}
	
	//this method sets the strategy type
	public void setStrategy(Strategy newStrategy){
		strategyType = newStrategy;
	}
	
	public Strategy getStrategyType() {
		return strategyType;
	}
	
	//this method send the first line of the recipe file to the harware layer, so that it's the first
	//line of the output file
	public void fileTitle(String title){
		hl.writeFile(title);
	}
	
	//this method gets the amount of time that a given strategy should run
	public int strategyTime(){
		return strategyType.time();
	}
	
	//this method gets the control values from the hardware layer.  It is simply the last string passes
	//to it by the control layer
	public String getControlVals(){
		String vals = hl.getHWControl();
		return vals;
	}
	
	//this method compares the output file and the check file provided to us.  It compares the two files, line
	//by line.  If it compares 2 lines that don't match, the method returns false and an error is printed.
	//If it does not find a mismatch, once it gets to the end of one file, it check to see if both files have
	//been fully consumed.  If they have, all the previous lines match and there is not file left, hence a complete
	//match and a good part.
	public boolean compareFiles(String path) throws IOException{
		
		String DAS = path;
		String output = "/Users/bpfruin/Documents/CSPP51036/hw3-bpfruin/src/phfmm/output.txt";
		BufferedReader dasFile = new BufferedReader(new FileReader(DAS));
		BufferedReader outFile = new BufferedReader(new FileReader(output));

		while (true) {
		    String partOne = dasFile.readLine();
		    String partTwo = outFile.readLine();
		    
		    if (partOne == null || partTwo == null){
		    	System.out.println("Reached End of File");
		    	break;	    	
		    } else if (!partOne.equals(partTwo)) {
		    	System.out.println("DEFECTIVE PART");
		    	return false;
		    }		   

		    }
		String partOne = dasFile.readLine();
	    String partTwo = outFile.readLine();
		
		if (partOne == null && partTwo == null){
		System.out.println("GOOD PART");
		return true;
		}
		System.out.println("One file is longer than the other, DEFECTIVE PART");
		return false;
		}

}
