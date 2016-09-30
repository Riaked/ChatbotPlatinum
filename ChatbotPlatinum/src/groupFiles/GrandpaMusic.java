package groupFiles;

import groupFiles.GrandpaBot;
import groupFiles.GrandpaMain;

public class GrandpaMusic extends Object implements GrandpaBot {
	private boolean inMusicLoop;
	
	private String musicResponses;
	
	public void talk(){
		inMusicLoop = true;
		while (inMusicLoop){
			GrandpaMain.print("(Type 'quit' to go back.)");
			musicResponses = GrandpaMain.promptInput();
			if (musicResponses.indexOf("quit") >= 0){
				inMusicLoop = false;
				GrandpaMain.promptForever();
			}
			GrandpaMain.print("I don't know what you kids are listening to these days, but"
					+ "all that gibberish can't be as good as my blues");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"music", "song", "songs"};
		//idea:create a for loop to iterate
		if (GrandpaMain.findKeyword(userInput, "music", 0) >= 0){
			return true;
		}
		if (GrandpaMain.findKeyword(userInput, "song", 0) >= 0){
			return true;
		}
		if (GrandpaMain.findKeyword(userInput, "songs", 0) >= 0){
			return true;
		}
		
		return false;
	}
}
