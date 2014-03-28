package blackboard;

//This knowledge source finds a track similar to the one that the user provided.

import java.util.ArrayList;

import de.umass.lastfm.Track;

public class SimilarTrack implements KnowledgeSource {

	
	
	
	//private Blackboard bb = new Blackboard();
	private ArrayList<Track> chart = new ArrayList<Track>();
	
	public void getFirstSong(String artist, String track){
	    chart = (ArrayList<Track>) Track.getSimilar(artist, track, "5f376ba66130fc50ab78ff155b7430a7");
	    
	    for(int i = 0; i < chart.size(); i++){
	    	//bb.addTrackToControl((Track)(chart.get(i)));
	    }    

	}
	
	@Override
	public void updateBlackboard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execCondition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execAction() {
		// TODO Auto-generated method stub
		
	}

	
	public Track getSimilar(Blackboard bb){
		if(chart.get(0) == null){
			System.out.println("Sorry, no more tracks to recommend");
			return null;
		}
		
		Track track1 = chart.get(0);
		chart.remove(0);
		
		bb.addTrackToControl(track1);
		//System.out.println(track1.getName());
		//System.out.println(track1.getUrl());
		
		makeRecommendation(bb, track1);
		
	    return track1;
	}
	
	public void makeRecommendation(Blackboard bb, Track track){
		
		bb.setCurrentRecommendation(track);
				
	}
	
	
	

}
