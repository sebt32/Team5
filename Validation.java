import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides various methods for receiving and validating inputs.
 * 
 * @author Josh Rivett
 * @version 1.1
 */
public class Validation {
	/**
	 * Receives input from the user until a valid integer is entered.
	 * 
	 * @return A valid integer value
	 */
	public static int validInt() {
		//Initialises the required variables.
		int integer = 0;
		boolean validInput = false;
		Scanner s = new Scanner(System.in);
		
		//Validates whether the input is an integer.
		while (validInput == false) {
			try {
				integer = s.nextInt();
				validInput = true;
			}
			//Catches the exception and asks the user to re-enter.
			catch (InputMismatchException e) {
				s.nextLine();
				System.out.print("Enter valid integer: ");
			}
		}
		
		//Returns a valid integer.
		return integer;
	}
	
	public static String validString() {
		//Initialises the required variables.
		String string = "";
		Scanner s = new Scanner(System.in);
		
		//Receives the next string entered by the user.
		string = s.nextLine();
		
		//Returns a valid string.
		return string;
	}
	
	/**
	 * Takes a file name as a parameter and determines whether it is readable or not.
	 * 
	 * @param fileName Path of the file trying to be read
	 * @return True or false depending on whether the file is readable
	 */
	public static boolean isReadable(String fileName) {
		//Creates an instance of the Java File class.
		File file = new File(fileName);
		
		//Returns true if the file is readable and false if not.
		return file.canRead();
	}
}
