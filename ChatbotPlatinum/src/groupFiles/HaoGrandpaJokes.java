package groupFiles;

public class HaoGrandpaJokes extends Object implements HaoGrandpaBot {
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
			jokeResponse = HaoGrandpaMain.promptInput();
			
			//negate use
			if (!isTriggered(jokeResponse)){
				inJokeLoop = false;
				HaoGrandpaMain.promptForever();
				}
			}
		}	
	private void printResponse() {
		if (jokeCount != 0){
			int jokeOrder = 1;
			HaoGrandpaMain.print(jokeResponses[jokeOrder]);
			
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
