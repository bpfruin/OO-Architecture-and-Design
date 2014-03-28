package mvc;

//this class represents the pedestrian light view.  It maintains an observer id and registers
//itself with its subject.  The update method called by the model displays the signal passed in
//by the model.

public class PedestrianLightView extends Observer {
	
	private String pedSignal;
	
	private static int observerIDTracker = 0;
	private int observerID;
	
	private Subject pedModel;
	
	public PedestrianLightView(Subject pedModel){
		this.pedModel = pedModel;
		
		this.observerID = ++observerIDTracker;
		
		System.out.println("New Ped Observer " + this.observerID);
		
		pedModel.register(this);
	}
	
	@Override
	public void update(String pedestrianStatus) {
		pedSignal = pedestrianStatus;
		
		System.out.println("Pedestrian Light: "+pedSignal+"\n");
		
	}



}
