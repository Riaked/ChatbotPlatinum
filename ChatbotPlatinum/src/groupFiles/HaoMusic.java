package groupFiles;

import groupFiles.Chatbot;
import groupFiles.NocklesMain;

public class HaoMusic extends Object implements Chatbot {
	private boolean inMusicLoop;
	
	private String moneyResponse;
	
	public void talk(){
		inMusicLoop = true;
		while (inMusicLoop){
			NocklesMain.print("(Type 'quit' to go back.)");
			moneyResponse = NocklesMain.promptInput();
			if (moneyResponse.indexOf("quit") >= 0){
				inMusicLoop = false;
				NocklesMain.promptForever();
			}
			NocklesMain.print("I have this thing called pension. I have more money than I know what"
					+ "do with.");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"money",};
		//idea:create a for loop to iterate
		if (NocklesMain.findKeyword(userInput, "money", 0) >= 0){
			return true;
		}
		
		return false;
	}
}
