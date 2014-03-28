package mvc;

//check comments for PedestrianLightModel
//this class works in an analogous manner as the PedestrianLighModel.  The only real difference
//is the Strings in the signals array.  This model also registers and unregisters observers as
//well as notifies it's observers of changes.

import java.util.ArrayList;

public class TrafficLightModel implements Subject {

	private ArrayList<Observer> observers;
	private String signal;
	private ArrayList<String> signals;
	private static int count = 0;
	
	public TrafficLightModel(){
		observers = new ArrayList<Observer>();
		signals = new ArrayList<String>();
		signals.add("Red: ON, Yellow: OFF, Green: OFF");
		signals.add("Red: OFF, Yellow: OFF, Green: ON");
		signals.add("Red: OFF, Yellow: ON, Green: OFF");

	}
	
	@Override
	public void notifyObserver() {

		for(Observer observer : observers){
			observer.update(signal);
		}
		
	}

	@Override
	public void register(Observer o) {

		observers.add(o);
		
	}

	@Override
	public void unregister(Observer o) {

		int observerIndex = observers.indexOf(o);
		observers.remove(observerIndex);
		
	}
	
	public void setNewLightStatus(){
		int counter = count % 3;
		
		this.signal = signals.get(counter);
		count++;
		notifyObserver();
	}

}
