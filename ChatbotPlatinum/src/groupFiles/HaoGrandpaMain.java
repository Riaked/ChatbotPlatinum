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
		promptName();
		promptForever();
	}
	
	public static void promptName(){
		print("Ey there sonny, I'm GrandpaBot. What's your name?");
		String user = input.nextLine();
		char aChar = user.charAt(0);
		double rand=Math.random();
		int roll = (int) (3*rand);
		if(roll == 0){
			String newUser = user.replaceAll(user, aChar+"ob");
			print("Good ta meet cha "+newUser+". How are ya doing?");
		}
		if(roll == 1){
			String newUser = user.replaceAll(user, aChar+"ill");
			print("Good ta meet cha "+newUser+". How are ya doing?");
		}
		if(roll > 1){
			String newUser = user.replaceAll(user, aChar+"en");
			print("Good ta meet cha "+newUser+". How are ya doing?");
		}
	}
	public static void promptNameAgain(){
		print("What did you say your name was again?");
		String user = input.nextLine();
		char aChar = user.charAt(0);
		double rand=Math.random();
		int roll = (int) (3*rand);
		if(roll == 0){
			String newUser = user.replaceAll(user, aChar+"ob");
			print("Oh yeah, I do remember talking to a "+user+". How are you doing, "+newUser+"?");
		}
		if(roll == 1){
			String newUser = user.replaceAll(user, aChar+"ill");
			print("Oh yeah, I do remember talking to a "+user+". How are you doing, "+newUser+"?");
		}
		if(roll > 1){
			String newUser = user.replaceAll(user, aChar+"en");
			print("Oh yeah, I do remember talking to a "+user+". How are you doing, "+newUser+"?");
		}
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
				print("My life isn't that great to talk about but here goes..");
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
				print("Oh sonny, I've forgotten all my jokes..");
			}
			else if (findKeyword(response, "How are you?", 0) >= 0){
				print("I am doing fine thanks for asking!");
			}
			else if ((findKeyword(response, "politics", 0) >= 0) || (findKeyword(response, "political", 0) >= 0)
					|| (findKeyword(response, "politic", 0) >= 0)){
				print("The government is crazy nowadays! These candidates are gonna make this country go under, don't you think so?");
				if ((findKeyword(response, "yes", 0) >0) || (findKeyword(response, "yup", 0) >0)
						|| (findKeyword(response, "yeah", 0) >0) || (findKeyword(response, "yea", 0) >0)){
					print("I remember when the country wasn't this bad. *sigh*");
				}
				else{
					print("Goddamn crazy! Yer outta yer mind! It's people like you who make this country suffer! I remember when "
							+ "the people made respectable votes and candidates..");
				}
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
		int psn = searchString.indexOf(keyword);
		while (psn >= 0){
			String before = " ";
			String after = " ";
			if (psn > 0){
				before = searchString.substring(psn-1, psn);
				}
			if (psn + keyword.length() < searchString.length()){
				after = searchString.substring(psn+keyword.length(), psn+keyword.length() + 1);
			}
			if (before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, psn)){
				return psn;
			}
			else{
				psn = searchString.indexOf(keyword, psn + 1);
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

