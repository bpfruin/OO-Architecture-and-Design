package phfmm;

//the strategy method is implemented here.  The interface is a public instance variable of the control
//layer which can be dynamically changed at run time.
public interface Strategy {
	
   String execute(int time, int part);
   
   int time();
   
} 
//this is the constantpressure strategy.  the exact details are given in the homework.  There is also
//some values checking in here as well.
class ConstantPressure implements Strategy{

    public String execute(int time, int part) {
        
    	int pressure = part + 100;
        
        int power = time * 2;
        
        if(pressure < 0){
    		pressure = 0;
    	}
    	if(power < 0){
    		power = 0;
    	}
        if(power > 200){
        	power = 200;
        }
        if(pressure > 200){
        	pressure = 200;
        }
    	
    	return time + "," + pressure + "," + power + "\n";
    }
    
    public int time(){
    	return 10;
    }
}
//class for the constantcurrent strategy.  implemented in an similar manner as above.
class ConstantCurrent implements Strategy{

    public String execute(int time, int part) {
    	    	
    	int pressure = 50 - (time * 2);
    			
    	int power = part + 50;
    	
    	if(pressure < 10){
    		pressure = 10;
    	}
    	if(power < 0){
    		power = 0;
    	}
    	if(power > 200){
        	power = 200;
        }
        if(pressure > 200){
        	pressure = 200;
        }
    	return time + "," + pressure + "," + power + "\n";
    }
    
    public int time(){
    	return 20;
    }
}

//class for the ramp strategy.  implemented in an similar manner as above.
class Ramp implements Strategy{
	
    public String execute(int time, int part) {
    	    	
    	if(part < 50){ 
    		String error = "ERROR: Only part sizes 50 and greater can be used from RAMP mode";
    		System.out.println(error);
    		return error;
    	}
    	
    	int pressure = time * 10;
    			
    	int power = part + (time * 20);
    	
    	if(pressure < 0){
    		pressure = 0;
    	}
    	if(power < 0){
    		power = 0;
    	}
    	
    	if(power > 200){
        	power = 200;
        }
        if(pressure > 100){
        	pressure = 100;
        }
    	    	
    	return time + "," + pressure + "," + power + "\n";
    }
    
    public int time(){
    	return 30;
    }
}



