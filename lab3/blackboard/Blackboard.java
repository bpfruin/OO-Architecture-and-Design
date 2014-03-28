package blackboard;

//This is the blackboard class.  It holds the pool of possible songs as well as the song to be recommended next.

import java.util.ArrayList;

import de.umass.lastfm.Track;

public class Blackboard {

	private ArrayList<Track> solutions = new ArrayList<Track>();
	private ArrayList<Track> controlData = new ArrayList<Track>();
	private Track currentTrack;
	private Track currentRecommendation;
	
	
	public void inspect(){
		
	}
	
	public void update(){
		
	}
	
	public void makeRecommendation(){
		System.out.println("Do you like "+currentRecommendation.getName()+" by "+currentRecommendation.getArtist());
		System.out.println("Check it out: "+currentRecommendation.getUrl());
	}

	
	public void printTheSongs(){
		System.out.println("PRINTING THE SONGS");
		System.out.println("THE CURRENT RECOMMENDATION IS: "+currentRecommendation.getName());
		for(int i = 0; i < controlData.size(); i++){
			System.out.println(controlData.get(i).getName());
			System.out.println("The Duration of "+controlData.get(i).getName()+" is: "+controlData.get(i).getDuration());

		}
	}
	

	
	public void addTrackToControl(Track track){
		controlData.add(track);
		currentTrack = track;
	}
	
	public void removeTheTrack(){
//		int index = controlData.indexOf(currentTrack);
		int index = controlData.indexOf(currentRecommendation);
		//System.out.println("INDEX IS "+index);
		controlData.remove(index);
	}

	public Track getCurrentRecommendation() {
		return currentRecommendation;
	}

	public void setCurrentRecommendation(Track currentRecommendation) {
		this.currentRecommendation = currentRecommendation;
	}

	public ArrayList<Track> getControlData() {
		return controlData;
	}

	public void setControlData(ArrayList<Track> controlData) {
		this.controlData = controlData;
	}
	
	
	
	
}
