package groupFiles;

import groupFiles.HaoGrandpaBot;
import groupFiles.HaoGrandpaMain;

public class HaoGrandpaMusic extends Object implements HaoGrandpaBot {
	private boolean inMusicLoop;
	
	private String musicResponses;
	
	public void talk(){
		inMusicLoop = true;
		while (inMusicLoop){
			HaoGrandpaMain.print("(Type 'quit' to go back.)");
			musicResponses = HaoGrandpaMain.promptInput();
			if (musicResponses.indexOf("quit") >= 0){
				inMusicLoop = false;
				HaoGrandpaMain.promptForever();
			}
			HaoGrandpaMain.print("I don't know what you kids are listening to these days, but"
					+ "all that gibberish can't be as good as my blues");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"music", "song", "songs"};
		//idea:create a for loop to iterate
		if (HaoGrandpaMain.findKeyword(userInput, "music", 0) >= 0){
			return true;
		}
		if (HaoGrandpaMain.findKeyword(userInput, "song", 0) >= 0){
			return true;
		}
		if (HaoGrandpaMain.findKeyword(userInput, "songs", 0) >= 0){
			return true;
		}
		
		return false;
	}
}
