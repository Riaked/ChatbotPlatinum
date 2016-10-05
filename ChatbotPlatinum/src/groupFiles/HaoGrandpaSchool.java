package groupFiles;

public class HaoGrandpaSchool extends Object implements HaoGrandpaBot {
	private boolean inSchoolLoop;
	
	private String schoolResponse;
	
	public void talk(){
		inSchoolLoop = true;
		while (inSchoolLoop){
			HaoGrandpaMain.print("(Type 'quit' to go back.)");
			schoolResponse = HaoGrandpaMain.promptInput();
			if (schoolResponse.indexOf("quit") >= 0){
				inSchoolLoop = false;
				HaoGrandpaMain.promptForever();
			}
			HaoGrandpaMain.print("That's my favorite part about school!");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"school", "class", "teacher",};
		//idea:create a for loop to iterate
		
		if (HaoGrandpaMain.findKeyword(userInput, "school", 0) >= 0){
			return true;
		}
		if (HaoGrandpaMain.findKeyword(userInput, "class", 0) >= 0){
			return true;
		}
		return false;
	}
}
