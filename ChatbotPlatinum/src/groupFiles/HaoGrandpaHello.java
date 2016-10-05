package groupFiles;

public class HaoGrandpaHello  extends Object implements HaoGrandpaBot{

	private String helloResponse;
	private boolean inHelloLoop;
	
	private String [] calmHelloResponses = {"Ey sonny", "I've been hearin lots a hello lately", 
			"Yes, yes hello sonny"};
	private String [] angryHelloResponses = {"Zzzzzzzz", "Ey I haven't seen ya around these parts before",
			"Who are you again?"};
	
	private int helloCount;
	
	public HaoGrandpaHello(){
		helloCount = 0;
	}
	@Override
	public void talk() {
		inHelloLoop = true;
		while (inHelloLoop){
			helloCount++;
			printResponse();//helper method
			helloResponse = HaoGrandpaMain.promptInput();
			
			//negate use
			if (!isTriggered(helloResponse)){
				inHelloLoop = false;
				HaoGrandpaMain.promptForever();
				}
			}
		}	

	private void printResponse() {
		if (helloCount > 3){
			int responseSelection = (int) (Math.random()* angryHelloResponses.length);
			HaoGrandpaMain.print(angryHelloResponses[responseSelection]);
			inHelloLoop = false;
			helloCount = 0;
			HaoGrandpaMain.promptNameAgain();
		}
		else {
			int responseSelection = (int) (Math.random()* calmHelloResponses.length);
			HaoGrandpaMain.print(calmHelloResponses[responseSelection]);
		}
		
	}
	@Override
	public boolean isTriggered(String userInput) {
		if (HaoGrandpaMain.findKeyword(userInput, "hello", 0) >= 0){
			return true;
		}
		if (HaoGrandpaMain.findKeyword(userInput, "hi", 0) >= 0){
			return true;
		}
		if (HaoGrandpaMain.findKeyword(userInput, "hey", 0) >= 0){
			return true;
		}
		return false;
	}

}
