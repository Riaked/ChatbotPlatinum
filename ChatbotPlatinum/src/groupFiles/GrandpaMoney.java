package groupFiles;

import groupFiles.GrandpaBot;
import groupFiles.GrandpaMain;

public class GrandpaMoney extends Object implements GrandpaBot {
	private boolean inMoneyLoop;
	
	private String moneyResponse;
	
	public void talk(){
		inMoneyLoop = true;
		while (inMoneyLoop){
			GrandpaMain.print("(Type 'quit' to go back.)");
			moneyResponse = GrandpaMain.promptInput();
			if (moneyResponse.indexOf("quit") >= 0){
				inMoneyLoop = false;
				GrandpaMain.promptForever();
			}
			GrandpaMain.print("I have this thing called pension. I have more money than I know what"
					+ "do with.");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"money",};
		//idea:create a for loop to iterate
		if (GrandpaMain.findKeyword(userInput, "money", 0) >= 0){
			return true;
		}
		
		return false;
	}
}
