package password;

import java.util.Random;

public class Password {
	private int length = 0, numSpec = 0;
	private boolean specials = false;
	private String word = "";
	private String password = "";


	public Password(){
		length = 8;
		password = makePassword();
	}

	public Password(int n){
		length = n;
		password = makePassword();
	}

	public Password(int n, int numSpec) {
		length = n;
		this.numSpec = numSpec;
		specials = true;
		password = makePassword();
	}

	public Password(int n, int numSpec, String phrase){
		length = n;
		this.numSpec = numSpec;
		specials = true;
		word = phrase;
		password = makePassword();
	}

	@Override public String toString(){
		String print = "\nLength: " + length + "\n" + 
				"Number of Special Characters: " + numSpec + "\n" +
				"Special Word: " + word;
		return print;
	}

	//makePassword does the leg work of creating the password
	//from the user input
	//This method creates a StringBuilder element
	//and appends the given elements, randomizes the entire 
	//password, then converts toString();
	private String makePassword() {
		StringBuilder pass = new StringBuilder();
		Random rdm = new Random();
		int count = 0;
		int amtLeft;
		boolean uppers = false;

		//Array for special characters allowed
		char[] spec = { '!', '@', '#', '$', '%', '&', '*'};
		//Array for lower case letters
		char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
				'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z'};
		//Array for upper case letters
		char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U',
				'V', 'W', 'X', 'Y', 'Z'};

		//Appends a word.charAt(i) to StringBuilder
		//until i = word.length or i = this.length
		if (!word.equals("")){
			for (int i = 0; i < word.length(); i++){
				if(i < length){
					pass.append(word.charAt(i));				
					count++;
				}
			}
		}
		//How many spaces are left for password
		amtLeft = length - count;
		//Appends special characters < amtLeft
		if (specials && amtLeft > 0){
			for (int i = 1; i <= numSpec; i++){
				if (i <= amtLeft){
					pass.append(spec[(int)(Math.random() * 7)]);
					count++;
				}
			}
		}

		amtLeft = length - count;

		if(amtLeft > 0) {
			//If space remains, the remaining spaces are filled 
			//with random upper and lower case letters until length is filled
			for (int i = 1; i <= amtLeft; i++){
				uppers = rdm.nextBoolean();
				if (uppers){
					pass.append(upper[(int)(Math.random() * 26)]);
				}
				else {
					pass.append(lower[(int)(Math.random() * 26)]);
				}
			}
		}

		password = makeRandom(pass);
		return password;
	}

	//Randomizes the password String characters
	private String makeRandom(StringBuilder pass){
		char temp = ' ';
		for (int i = 0; i < pass.length(); i++){
			int c = (int)(Math.random() * pass.length());
			temp = pass.charAt(i);
			pass.setCharAt(i, pass.charAt(c));
			pass.setCharAt(c, temp);
		}

		String password = pass.toString();
		return password;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isSpecials() {
		return specials;
	}

	public void setSpecials(boolean specials) {
		this.specials = specials;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getNumSpec() {
		return numSpec;
	}

	public void setNumSpec(int numSpec) {
		this.numSpec = numSpec;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}


