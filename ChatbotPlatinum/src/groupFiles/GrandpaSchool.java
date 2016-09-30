package groupFiles;

public class GrandpaSchool extends Object implements GrandpaBot {
	private boolean inSchoolLoop;
	
	private String schoolResponse;
	
	public void talk(){
		inSchoolLoop = true;
		while (inSchoolLoop){
			GrandpaMain.print("(Type 'quit' to go back.)");
			schoolResponse = GrandpaMain.promptInput();
			if (schoolResponse.indexOf("quit") >= 0){
				inSchoolLoop = false;
				GrandpaMain.promptForever();
			}
			GrandpaMain.print("That's my favorite part about school!");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"school", "class", "teacher",};
		//idea:create a for loop to iterate
		
		if (GrandpaMain.findKeyword(userInput, "school", 0) >= 0){
			return true;
		}
		if (GrandpaMain.findKeyword(userInput, "class", 0) >= 0){
			return true;
		}
		return false;
	}
}
