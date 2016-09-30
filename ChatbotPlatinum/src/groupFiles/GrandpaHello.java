package groupFiles;

public class GrandpaHello  extends Object implements GrandpaBot{

	private String helloResponse;
	private boolean inHelloLoop;
	
	private String [] calmHelloResponses = {"Ey sonny", "I've been hearin lots a hello lately", 
			"Yes, yes hello sonny"};
	private String [] angryHelloResponses = {"Zzzzzzzz", "Ey I haven't seen ya around these parts before",
			"Who are you again?"};
	
	private int helloCount;
	
	public GrandpaHello(){
		helloCount = 0;
	}
	@Override
	public void talk() {
		inHelloLoop = true;
		while (inHelloLoop){
			helloCount++;
			printResponse();//helper method
			helloResponse = GrandpaMain.promptInput();
			
			//negate use
			if (!isTriggered(helloResponse)){
				inHelloLoop = false;
				GrandpaMain.promptForever();
				}
			}
		}	

	private void printResponse() {
		if (helloCount > 3){
			int responseSelection = (int) (Math.random()* angryHelloResponses.length);
			GrandpaMain.print(angryHelloResponses[responseSelection]);
			inHelloLoop = false;
			helloCount = 0;
			GrandpaMain.promptNameAgain();
		}
		else {
			int responseSelection = (int) (Math.random()* calmHelloResponses.length);
			GrandpaMain.print(calmHelloResponses[responseSelection]);
		}
		
	}
	@Override
	public boolean isTriggered(String userInput) {
		if (GrandpaMain.findKeyword(userInput, "hello", 0) >= 0){
			return true;
		}
		if (GrandpaMain.findKeyword(userInput, "hi", 0) >= 0){
			return true;
		}
		if (GrandpaMain.findKeyword(userInput, "hey", 0) >= 0){
			return true;
		}
		return false;
	}

}
