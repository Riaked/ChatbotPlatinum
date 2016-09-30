package groupFiles;

public class GrandpaJokes extends Object implements GrandpaBot {
	private boolean inJokeLoop;
	
	private String jokesResponse;
	String[] jokes = { };
	public void talk(){
		inJokeLoop = true;
		while (inJokeLoop){
			GrandpaMain.print("(Type 'quit' to go back.)");
			jokesResponse = GrandpaMain.promptInput();
			if (jokesResponse.indexOf("quit") >= 0){
				inJokeLoop = false;
				GrandpaMain.promptForever();
			}
			GrandpaMain.print("");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"joke", "funny", "laugh"};
		//idea:create a for loop to iterate
		
		if (GrandpaMain.findKeyword(userInput, "joke", 0) >= 0){
			return true;
		}
		if (GrandpaMain.findKeyword(userInput, "funny", 0) >= 0){
			return true;
		}
		if (GrandpaMain.findKeyword(userInput, "laugh", 0) >= 0){
			return true;
		}
		return false;
	}
}
