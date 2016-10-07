package groupFiles;

public class SyedGrandpaLife extends Object implements GrandpaBot {
	private boolean inLifeLoop;
	private String lifeResponses;
	
	private String[] calmLifeResponses = {"I remember when I was just a lad "
					+ "my pals and I hit up the rootin tootin spatoon, we ordered every drink they had with a spiffy 20 dollar bill..." + "oh forgive me I was just rambling on.", 
			"I remember this one time" + " I wrastled a 90 foot penguin, it wanted my damn Ritz crackers..." + "oh dear me rambling on again"};
	private String [] angryLifeResponses = {"I've told you about my life already sonny",
			"I have no more stories to tell, sonny"};
	
	private int lifeCount;
	public SyedGrandpaLife(){
		lifeCount = 0;
	}
	
	public void talk() {
		inLifeLoop = true;
		while (inLifeLoop){
			lifeCount++;
			printResponse();//helper method
			lifeResponses = GrandpaMain.promptInput();
			
			//negate use
			if (!isTriggered(lifeResponses)){
				inLifeLoop = false;
				GrandpaMain.promptForever();
				}
			}
		}	
	private void printResponse() {
		if (lifeCount > 2){
			int responseSelection = (int) (Math.random()* angryLifeResponses.length);
			GrandpaMain.print(angryLifeResponses[responseSelection]);
			inLifeLoop = false;
			lifeCount = 0;
			GrandpaMain.promptLife();
			inLifeLoop = false;
		}
		else {
			int responseSelection = (int) (Math.random()* calmLifeResponses.length);
			GrandpaMain.print(calmLifeResponses[responseSelection]);
		}
	}
	public boolean isTriggered(String userInput) {
		String [] triggers = {"life", "growing up"};
		//idea:create a for loop to iterate
		
		if (GrandpaMain.findKeyword(userInput, "life", 0) >= 0){
			return true;
		}
		if (GrandpaMain.findKeyword(userInput, "growing up", 0) >= 0){
			return true;
		}
		return false;
	}
}
