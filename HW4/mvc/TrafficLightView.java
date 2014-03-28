package mvc;

//Check comments for PedestrianLightView.
//This class works in an analogous manner as the PedestrianLightView.
//it keeps an instance of its subject and is updated by it's subject just as
//the pedestrian light view is.

public class TrafficLightView extends Observer {

private String trafficSignal;
	
	private static int observerIDTracker = 0;
	private int observerID;
	
	private Subject trafficModel;
	
	public TrafficLightView(Subject trafficModel){
		this.trafficModel = trafficModel;
		
		this.observerID = ++observerIDTracker;
		
		System.out.println("New Traffic Observer " + this.observerID);
		
		trafficModel.register(this);
	}
	
	@Override
	public void update(String trafficStatus) {
		trafficSignal = trafficStatus;
		
		System.out.println("Status:\nTraffic Light: "+trafficSignal);
		
	}

	

}
