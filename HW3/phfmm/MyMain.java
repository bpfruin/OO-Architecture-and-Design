package phfmm;

import java.io.IOException;

public class MyMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//this is a simple test class.  The file paths are absolute and hard-coded so they will need to be
		//corrected when running on another computer. It calls methods from the UI class.  Everything should
		//work as expected without errors.
		
		UserInterface ui = new UserInterface();
		
		//String path = "/Users/bpfruin/Documents/CSPP51036/hw3-bpfruin/src/phfmm/HW3_ConstantCurrent.csv";
		//String testPath = "/Users/bpfruin/Documents/CSPP51036/hw3-bpfruin/src/phfmm/HW3_ConstantCurrent.csv.reference.csv";
		
		String path = "/Users/bpfruin/Documents/CSPP51036/hw3-bpfruin/src/phfmm/HW3_Ramp.csv";
		String testPath = "/Users/bpfruin/Documents/CSPP51036/hw3-bpfruin/src/phfmm/HW3_Ramp.csv.reference.csv";
		
		//String path = "/Users/bpfruin/Documents/CSPP51036/hw3-bpfruin/src/phfmm/hw3_recipe1.csv";
		//String testPath = "/Users/bpfruin/Documents/CSPP51036/hw3-bpfruin/src/phfmm/hw3_recipe1.csv.reference.csv";
		
		ui.initFile();
		
		ui.getTitle(path);
		
		int part = ui.readRecipe(path);
		
		int time = ui.getTime();		
		
		ui.executeRecipe(time, part);
		
		ui.sendFileForCompare(testPath);
		
		//ui.manualRun(30, 1000, -10, 50);
		
		ui.getControlValue();
		
	}

}
