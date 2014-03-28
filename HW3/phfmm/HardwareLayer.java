package phfmm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HardwareLayer {
	
	private String currentLine;

	//this method writes the line of output, produced by the given strategy to the text file.
	public void writeFile(String data){
		
		currentLine = data;
		
			try{ 
				File file = new File("/Users/bpfruin/Documents/CSPP51036/hw3-bpfruin/src/phfmm/output.txt");
 
				//if file doesnt exists, then create it
				if(!file.exists()){
					file.createNewFile();
				}
 
				//true = append file
				FileWriter fileWriter = new FileWriter(file,true);
    	        	BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
    	        	bufferWriter.write(data);
    	        	bufferWriter.close();
 
 
			}catch(IOException e){
				e.printStackTrace();
			}
		
		
	}

	//public String getString(String output){
		//return output;
	//}
	//this method gets the last line produced by the control layer and sends it back to the control layer
	public String getHWControl(){
		return currentLine;
	}
	
	
	

}
