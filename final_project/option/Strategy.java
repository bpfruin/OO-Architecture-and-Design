package option;

//This file contains the Strategy interface and the three Strategy classes.
//I know the is a good argument for this to be 4 files but I left it as one
//because they're all so short and closely related.  When I started the project,
//I had plans for much more ambitious and complicated strategies so at the time
//I thought it would be nice to be able to look at all three strategies side by
//side.

//The strategies are very simple, the first is delta neutral, where the user is instructed
//to buy or sell the appropriate number of shares in order to get portolio delta to 0,
//the second strategy, PositiveDelta, instructs the user to buy or sell the appropriate number
//of shares to get a delta of 10, and NegativeDelta sells the user to buy/sell the number of shares
//to get their delta to -10.
//They all call the Portfolio that was passed into it's getDelta() method and returns the appropriate
//number of shares to conform to the strategy.
//The math is very simple because a share of stock always has a delta of 1.

public interface Strategy {
		
	   int execute(Portfolio port);
	   	   
	} 
	

	class DeltaNeutral implements Strategy{

	    public int execute(Portfolio port) {
	        
	    	int target = (int)port.getDelta();
	    	
	    	System.out.println("Currently, your portfolio delta is: "+target);
	    	
	    	return -(target);
	    }

	    
	}

	class PositiveDelta implements Strategy{

	    public int execute(Portfolio port) {
	    	    	
	    	int target = (int)port.getDelta();
	    	
	    	System.out.println("Currently, your portfolio delta is: "+target);

	    	
	    	return -(target) + 10;
	    }
	    
	}


	class NegativeDelta implements Strategy{
		
	    public int execute(Portfolio port) {
	    	
	    	int target = (int)port.getDelta();
	    	
	    	System.out.println("Currently, your portfolio delta is: "+target);
	    	
	    	return -(target) - 10;
	    }
	    
	}