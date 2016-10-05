package groupFiles;

public class HaoGrandpaLife extends Object implements HaoGrandpaBot {
	private boolean inLifeLoop;
	private String lifeResponses;
	
	private String[] calmLifeResponses = {"I remember when I was just a little boy.."
					+ "..." + "oh forgive me I was just rambling on.", 
			"I remember this one time...." + "..." + "oh dear me rambling on again"};
	private String [] angryLifeResponses = {"I've told you about my life already sonny",
			"I have no more stories to tell, sonny"};
	
	private int lifeCount;
	public HaoGrandpaLife(){
		lifeCount = 0;
	}
	
	public void talk() {
		inLifeLoop = true;
		while (inLifeLoop){
			lifeCount++;
			printResponse();//helper method
			lifeResponses = HaoGrandpaMain.promptInput();
			
			//negate use
			if (!isTriggered(lifeResponses)){
				inLifeLoop = false;
				HaoGrandpaMain.promptForever();
				}
			}
		}	
	private void printResponse() {
		if (lifeCount > 2){
			int responseSelection = (int) (Math.random()* angryLifeResponses.length);
			HaoGrandpaMain.print(angryLifeResponses[responseSelection]);
			inLifeLoop = false;
			lifeCount = 0;
			HaoGrandpaMain.promptLife();
			inLifeLoop = false;
		}
		else {
			int responseSelection = (int) (Math.random()* calmLifeResponses.length);
			HaoGrandpaMain.print(calmLifeResponses[responseSelection]);
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"life", "growing up"};
		//idea:create a for loop to iterate
		
		if (HaoGrandpaMain.findKeyword(userInput, "life", 0) >= 0){
			return true;
		}
		if (HaoGrandpaMain.findKeyword(userInput, "growing up", 0) >= 0){
			return true;
		}
		return false;
	}
}