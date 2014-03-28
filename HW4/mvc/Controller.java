package mvc;

//this is the controller class that takes input from the user and informs the model of new input
//it is a subclass of Observer but i does not "care about" the updates it gets so the update()
//method is unimplemented.  This class also instantiates the model and view instances.

public class Controller extends Observer {

	PedestrianLightModel pedModel = new PedestrianLightModel();
	TrafficLightModel trafficModel = new TrafficLightModel();
	
	PedestrianLightView pedView = new PedestrianLightView(pedModel);
	TrafficLightView trafficView = new TrafficLightView(trafficModel);
	
	
	
	public void informModel(){
		trafficModel.setNewLightStatus();
		pedModel.setNewLightStatus();
	}


	@Override
	public void update(String signal) {
		// TODO Auto-generated method stub
		
	}

}
