package groupFiles;

public class HaoSchool extends Object implements Chatbot {
	private boolean inSchoolLoop;
	
	private String schoolResponse;
	
	public void talk(){
		inSchoolLoop = true;
		while (inSchoolLoop){
			NocklesMain.print("(Type 'quit' to go back.)");
			schoolResponse = NocklesMain.promptInput();
			if (schoolResponse.indexOf("quit") >= 0){
				inSchoolLoop = false;
				NocklesMain.promptForever();
			}
			NocklesMain.print("That's my favorite part about school!");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"school", "class", "teacher",};
		//idea:create a for loop to iterate
		
		if (NocklesMain.findKeyword(userInput, "school", 0) >= 0){
			return true;
		}
		if (NocklesMain.findKeyword(userInput, "class", 0) >= 0){
			return true;
		}
		return false;
	}
}
