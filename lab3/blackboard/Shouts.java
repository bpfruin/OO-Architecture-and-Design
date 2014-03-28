package blackboard;

//This knowlege source makes recomendations based on the "position" of tracks by similar
//artists to the one the user provided.  It selects the song with the highest position.
//It's called shouts because my original idea did not pan out.

import java.util.ArrayList;

import de.umass.lastfm.Artist;
import de.umass.lastfm.Track;

public class Shouts implements KnowledgeSource {

	private int targetPosition;
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
		targetPosition = targetSong.getPosition();
		//System.out.println("THE POSITION OF TARGET SONG: "+targetSong.getName()+" IS "+targetSong.getPosition());
		
		for(int i = 0; i < 3; i++){
			
			int rand = (int) (Math.random()*artists.size());
			Artist band = artists.get(rand);
			String name = band.getName();
			//System.out.println("THE SIMILAR ARTIST IS: "+name);
			
			Track track = getTopTrack(band);
			
			//System.out.println("The position of "+track.getName()+" is "+track.getPosition());
			
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
		
		int max = -100;
		Track rec = null;
		
		//System.out.println("IN GET RECOMMENDATION");
		for(int i = 0; i < list.size(); i++){
			//int difference = Math.abs(list.get(i).getPosition() - targetSong.getDuration());
			if(list.get(i).getPosition() > max){
				max = list.get(i).getPosition();
				rec = list.get(i);
			}
			bb.setCurrentRecommendation(rec);
			//System.out.println(list.get(i).getName());
			//System.out.println("The new recommendation is: "+rec.getName());
		}
		
	}

}
