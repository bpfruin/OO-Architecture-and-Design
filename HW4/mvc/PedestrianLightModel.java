package mvc;

import java.util.ArrayList;

//this class is for the pedestrian light model.  It registers and unregisters observers, it contains the status of
//the lights and and changes them by keeping a counter of changes and mods that counter by 3, and returns the
//"signal" in that ArrayList index.

public class PedestrianLightModel implements Subject {

	private ArrayList<Observer> observers;
	private String signal;
	private ArrayList<String> signals;
	private static int count = 0;
	
	public PedestrianLightModel(){
		observers = new ArrayList<Observer>();
		signals = new ArrayList<String>();
		signals.add("Walk: OFF. Don't Walk: ON");
		signals.add("Walk: ON. Don't Walk: OFF");
		signals.add("Walk: OFF. Don't Walk: Flashing");


	}
	
	//notifyObservers calls the update() method of all its observers, passing in the current
	//signal
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
	
	//this method sets the next signal to be displayed and calls notifyObserver()
	//so the view can display the new signal.
	public void setNewLightStatus(){
		int counter = count % 3;
		
		this.signal = signals.get(counter);
		count++;
		notifyObserver();
	}

}