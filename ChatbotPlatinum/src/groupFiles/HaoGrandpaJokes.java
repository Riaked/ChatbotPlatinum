package groupFiles;

public class HaoGrandpaJokes extends Object implements HaoGrandpaBot {
	private boolean inJokeLoop;
	
	public String [] jokePool = {"A broken pencil.", "Cows go.", "To", "Nanna"};
	public String [] jokeResponses ={"Never mind, it's pointless", "No, cows go moo!", 
			"You mean 'To whom'.", "Nanna your buisness!"};
	
	private String jokesResponse;
	String[] jokes = { };
	public void talk(){
		inJokeLoop = true;
		while (inJokeLoop){
			HaoGrandpaMain.print("(Type 'quit' to go back.)");
			jokesResponse = HaoGrandpaMain.promptInput();
			if (jokesResponse.indexOf("quit") >= 0){
				inJokeLoop = false;
				HaoGrandpaMain.promptForever();
			}
			HaoGrandpaMain.print("");
			
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"joke", "funny", "laugh"};
		//idea:create a for loop to iterate
		
		if (HaoGrandpaMain.findKeyword(userInput, "joke", 0) >= 0){
			return true;
		}
		if (HaoGrandpaMain.findKeyword(userInput, "funny", 0) >= 0){
			return true;
		}
		if (HaoGrandpaMain.findKeyword(userInput, "laugh", 0) >= 0){
			return true;
		}
		return false;
	}
}
