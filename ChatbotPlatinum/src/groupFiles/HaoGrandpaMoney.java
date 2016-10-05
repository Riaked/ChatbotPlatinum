package groupFiles;

import groupFiles.HaoGrandpaBot;
import groupFiles.HaoGrandpaMain;

public class HaoGrandpaMoney extends Object implements HaoGrandpaBot {
	private boolean inMoneyLoop;
	
	private String moneyResponse;
	
	public void talk(){
		inMoneyLoop = true;
		while (inMoneyLoop){
			HaoGrandpaMain.print("(Type 'quit' to go back.)");
			moneyResponse = HaoGrandpaMain.promptInput();
			if (moneyResponse.indexOf("quit") >= 0){
				inMoneyLoop = false;
				HaoGrandpaMain.promptForever();
			}
			HaoGrandpaMain.print("I have this thing called pension. I have more money than I know what"
					+ "do with.");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"money",};
		//idea:create a for loop to iterate
		if (HaoGrandpaMain.findKeyword(userInput, "money", 0) >= 0){
			return true;
		}
		
		return false;
	}
}
