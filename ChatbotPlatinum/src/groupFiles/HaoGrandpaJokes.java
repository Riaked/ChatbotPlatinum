package groupFiles;

public class HaoGrandpaJokes extends Object implements GrandpaBot {
	private boolean inJokeLoop;
	private String jokeResponse;
	
	public String [] jokePool = {"A broken pencil.", "Cows go.", "To", "Nanna"};
	public String [] jokeResponses ={"Never mind, it's pointless", "No, cows go moo!", 
			"You mean 'To whom'.", "Nanna your buisness!"};
	private int jokeCount;
	
	public HaoGrandpaJokes(){
		jokeCount = 0;
	}
	public void talk() {
		inJokeLoop = true;
		jokeCount = 0;
		while (inJokeLoop){
			jokeCount++;
			printResponse();//helper method
			jokeResponse = GrandpaMain.promptInput();
			
			//negate use
			if (!isTriggered(jokeResponse)){
				inJokeLoop = false;
				GrandpaMain.promptForever();
				}
			}
		}	
	private void printResponse() {
		if (jokeCount != 0){
			int jokeOrder = 1;
			GrandpaMain.print(jokeResponses[jokeOrder]);
			
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
