package password;

import java.util.Scanner;

/* The main program serves as a means for the user to
 * generate a random password after giving the computer
 * three criteria. Desired password length, Desired amount
 * of special characters, and a desired special phrase.
 */
public class PasswordTest {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like to generate a new password? (y/n): ");
		String ans = input.next();
		
		while(ans.substring(0,1).equalsIgnoreCase("y")){
			int length = 0, numSpec = 0;
			String word = "";
			System.out.println("Enter desired length of password: ");
			length = input.nextInt();
			System.out.println("Any special characters? (y/n)");
			ans = input.next();
			if (ans.substring(0,1).equalsIgnoreCase("y")) {
				System.out.println("Enter desired amount of special characters: ");
				numSpec = input.nextInt();
			}
			System.out.println("Would you like to enter a special word? (y/n): ");
			ans = input.next();
			if (ans.substring(0,1).equalsIgnoreCase("y")){
				System.out.println("Enter special word: ");
				word = input.next();
			}
			
			Password myPass = new Password(length, numSpec, word);
			System.out.println(myPass.getPassword());
			System.out.println(myPass.toString());
			System.out.println("\nCreate another password? (y/n) ");
			ans = input.next();
		}
		System.out.println("End of program");
	}
}
