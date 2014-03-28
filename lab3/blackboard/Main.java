package blackboard;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import de.umass.lastfm.Artist;
import de.umass.lastfm.Authenticator;
import de.umass.lastfm.Chart;
import de.umass.lastfm.Session;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

//This is a simple UI class that asks the user for input and presents recommendations.  There's no input validation.

public class Main {

	static SimilarTrack st = new SimilarTrack();
	static Controller control = new Controller();
	
	/**
	 * @param args
	 */

	
	public static void main(String[] args){
		
		

		System.out.println("Enter an artist. Try 'ColdPlay'");
		Scanner keyboard = new Scanner(System.in);
		String artist = keyboard.nextLine();
		System.out.println("Enter an track.  Try 'Clocks'");
		String track = keyboard.nextLine();
		//st.getFirstSong(artist, track);
		control.getFirstSong(st, artist, track);
		while (true){
		//bb.getTheTrack(st);
		control.loop(st, artist, track);
		System.out.println("Do you like this song? Yes/No");
		String answer = keyboard.nextLine();
			if(answer.equalsIgnoreCase("yes")){
				System.out.println("Great! Goodbye");
				return;
			} else if (answer.equalsIgnoreCase("no")){
				System.out.println("Okay, I'll find another recommendation");
				control.removeTheTrack();
			}
		}
		}
		
		

		
		
	

}
