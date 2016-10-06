package groupFiles;

import java.util.Scanner;

public class HaoGrandpaMain {
	
	static String response;
	static boolean inMainLoop;
	static Scanner input;
	static String user;
	static HaoGrandpaBot school;
	static HaoGrandpaBot life;
	static HaoGrandpaBot hello;
	static HaoGrandpaBot joke;
	
	public static void main(String[] args) {
		//demonstrateStringMethods();
		createFields();
		String s1 = " ";
		String s2 = "a";
		System.out.println(s1.compareTo(s2)); 
		promptName();
		promptForever();
	}
	
	public static void promptName(){
		print("Ey there sonny, I'm GrandpaBot. What's your name?");
		user = input.nextLine();
		print("Good ta meet cha "+user+". How are ya doing?");
	}
	public static void promptNameAgain(){
		print("What did you say your name was again?");
		user = input.nextLine();
		print("Oh yeah, I do remember talking to a "+user+". How are you doing, "+user+"?");
		promptForever();
	}
	public static void promptLife(){
		promptForever();
	}
	public static void promptForever(){
		inMainLoop = true;
		while (inMainLoop){
			response = promptInput();
			if(findKeyword(response, "good", 0) >= 0 ) {
				print("That's wonderful. So glad you feel good.");
			}
			else if((response.indexOf("life") >= 0) || (response.indexOf("growing up") >= 0)){
				print("My life isn't that great to talk about but here goes");
				inMainLoop = false;
				life.talk();
			}
			else if((response.indexOf("hello") >= 0) || (response.indexOf("hi") >= 0)
					|| (response.indexOf("hey") >= 0)){
				inMainLoop = false;
				hello.talk();
			}
			else if((response.indexOf("joke") >= 0) || (response.indexOf("funny") >= 0) 
					|| (response.indexOf("laugh") >= 0)){
				print("Knock Knock..");
				inMainLoop = false;
				joke.talk();
			}
			else if (findKeyword(response, "How are you?", 0) >= 0){
				print("I am doing fine thanks for asking!");
			}
			else{
				print("You sound like those damn Nazi's. Always talking gibberish.");
			}
		}
	}
	
	public static int findKeyword(String searchString, String keyword, int startpsn) {
		searchString = searchString.trim();
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		System.out.println("The phrase is "+searchString);
		System.out.println("The keyword is "+keyword);
		int psn = searchString.indexOf(keyword);
		System.out.println("The keyword was found at "+psn);
		while (psn >= 0){
			String before = " ";
			String after = " ";
			if (psn > 0){
				before = searchString.substring(psn-1, psn);
				System.out.println("The character before is "+before);
				}
			if (psn + keyword.length() < searchString.length()){
				after = searchString.substring(psn+keyword.length(), psn+keyword.length() + 1);
				System.out.println("The character after is " + after);
			}
			if (before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, psn)){
				System.out.println("Found "+keyword+" at " + psn);
				return psn;
			}
			else{
				psn = searchString.indexOf(keyword, psn + 1);
				System.out.println("Did not find "+keyword+", checking position "+psn);
			}
			
		}
		return psn;
	}

	private static boolean noNegations(String searchString, int psn) {
		if (psn - 3 >= 0 && searchString.substring(psn - 3, psn).equals("no ") ){
			return false;
		}
		if (psn - 4 >= 0 && searchString.substring(psn - 4, psn).equals("not ") ){
			return false;
		}
		if (psn - 6 >= 0 && searchString.substring(psn - 6, psn).equals("never ") ){
			return false;
		}
		if (psn - 4 >= 0 && searchString.substring(psn - 4, psn).equals("n't ") ){
			return false;
		}
		return true;
	}

	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
	}

	public static void createFields(){
		input = new Scanner(System.in);
		user = "";
		life = new HaoGrandpaLife();
		hello = new HaoGrandpaHello();
		joke = new HaoGrandpaJokes();
		
	}
	
	public static void print(String s){
		String printString = "";
		int cutoff = 35;
		//check for words to add
		//In other words, s has a length greater than 0
		while (s.length()> 0){
			String cut = "";
			String nextWord = "";
			//check if next word fits on the line
			//there must still be words to add
			while (cut.length() + nextWord.length() < cutoff && s.length() > 0){
				//add next word to the line
				cut += nextWord;
				
				s = s.substring(nextWord.length());
				
				//identify following word w/o space
				int endOfWord = s.indexOf(" ");
				//if no more spaces this is the last word so add the whole word
				if (endOfWord == -1){
					endOfWord = s.length()-1;//-1 for the index
				}
				nextWord = s.substring(0, endOfWord+1);
				
			}
			printString += cut+"\n";
		}
		System.out.println(printString);
		
	}
	private static String getCut(String s, int cutoff, int cut){
		int cutIndex = cut * cutoff;
		if(cutIndex > s.length()) cutIndex = s.length();
		String currentCut = s.substring(0,cutIndex);
		
		//start at last index
		int indexOfLastSpace = currentCut.length()-1;
		for(int i = indexOfLastSpace; i >= 0; i--){
			String letter = currentCut.substring(i, i+1);
			if(letter.equals(" ")){
				indexOfLastSpace = i;
				break;
			}
		}
			//shorten cut
			currentCut = currentCut.substring(0,indexOfLastSpace);
			return currentCut;
	}
}

