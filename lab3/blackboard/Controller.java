package blackboard;

//This is the simple controller class.  It runs in a loop and calls the knowledge sources sequentially. I know
//I should have done more tuning but I'm sick and out of time to work on this lab.

import de.umass.lastfm.Artist;
import de.umass.lastfm.Track;

public class Controller {
	
	
	Blackboard bb = new Blackboard();
	Duration d = new Duration();
	Shouts s = new Shouts();

	public void loop(SimilarTrack st, String artist, String track){
		
		st.getSimilar(bb);
		
		//bb.printTheSongs();
		d.getSimilarArtist(bb, artist, track);
		//bb.printTheSongs();
		s.getSimilarArtist(bb, artist, track);
		//bb.printTheSongs();
		bb.makeRecommendation();
		
		
	}
	public void nextSource(){
		
	}
	
	public void removeTheTrack(){
		bb.removeTheTrack();
	}
	
	public void getFirstSong(SimilarTrack st, String artist, String track){
		st.getFirstSong(artist, track);
	}
	
}
