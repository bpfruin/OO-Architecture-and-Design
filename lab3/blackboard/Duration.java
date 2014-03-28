package blackboard;

//This is the duration knowledge source.  It gets songs from similar artists that the user asked for and
//makes a recommendation based on which songs have similar durations as the original.

import java.util.ArrayList;

import de.umass.lastfm.Artist;
import de.umass.lastfm.Track;


public class Duration implements KnowledgeSource {
	
	private int targetDuration;
	private Track targetSong;

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
	
	public void getSimilarArtist(Blackboard bb, String artist, String song){
		ArrayList<Artist> artists = (ArrayList<Artist>) Artist.getSimilar(artist, "5f376ba66130fc50ab78ff155b7430a7");
		//Artist band = artists.get(0);
		//String name = band.getName();
		//System.out.println("THE SIMILAR ARTIST IS: "+name);
		
		targetSong = Track.getInfo(artist, song, "5f376ba66130fc50ab78ff155b7430a7");
		targetDuration = targetSong.getDuration();
		//System.out.println("THE DURATION OF TARGET SONG: "+targetSong.getName()+" IS "+targetSong.getDuration());
		
		for(int i = 0; i < 3; i++){
			
			int rand = (int) (Math.random()*artists.size());
			Artist band = artists.get(rand);
			String name = band.getName();
			//System.out.println("THE SIMILAR ARTIST IS: "+name);
			
			Track track = getTopTrack(band);
			
			bb.addTrackToControl(track);
			
			artists.remove(rand);
			
			
		}
		
		makeRecommendation(bb);
		
	
		
	}
	
	public Track getTopTrack(Artist artist){
		
		ArrayList<Track> track = (ArrayList<Track>) artist.getTopTracks(artist.getName(), "5f376ba66130fc50ab78ff155b7430a7");
		
		return track.get(0);
		
	}
	
	public void makeRecommendation(Blackboard bb){
		
		ArrayList<Track> list = bb.getControlData();
		
		int min = 1000000;
		Track rec = null;
		
		//System.out.println("IN GET RECOMMENDATION");
		for(int i = 0; i < list.size(); i++){
			int difference = Math.abs(list.get(i).getDuration() - targetSong.getDuration());
			if(difference < min){
				min = difference;
				rec = list.get(i);
			}
			bb.setCurrentRecommendation(rec);
			//System.out.println(list.get(i).getName());
			//System.out.println("The new recommendation is: "+rec.getName());
		}
		
	}

}
