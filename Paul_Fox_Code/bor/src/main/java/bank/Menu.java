package bank;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

	Scanner scanner = null;

	public Menu() {
		scanner = new Scanner(System.in);
		printMessage("welcome");
	}

	/**
	 * @param action What to prompt the user for.
	 * @return User's response.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public String prompt(String action) throws InterruptedException, IOException {
		
		String selection = null;
		
		switch (action) {

		case "login": {

			do {
				System.out.print("email address > ");
				selection = scanner.nextLine();
			} while (!validEmail(selection));

			break;
		}

		case "password": {

			do {
				System.out.print("password > ");
				selection = scanner.nextLine();
			} while (!validPassword(selection));

			//Arrays.fill(password, ' ');
			//Main.logger.info(email + " has logged in.");

			break;
		}

			case "incorrect": {

				System.out.print("\n\tUser / Password combination does not exist, create account? (y/n) > \n");
				selection = scanner.nextLine();
				break;

			}

		}

		return selection;

	}


	public void printMessage(String message) {
		
		switch(message) {

		case "welcome": {
			System.out.println("Welcome to the Bank of Revature, LLC.\n");
			System.out.println("\tPlease login or register.\n");
			break;
		}

		case "try again": {
			System.out.println("\n\tEnter\n");
			break;
		}

		case "landing": {
			System.out.println("\n" +
					"\t(1) make a transaction\n" +
					"\t(2) view accounts\n" +
					"\t(3) edit profile\n" +
					"\t(4) exit\n");
			break;
		}

		}
			
	}
	
	public static boolean validEmail(String email) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher mat = pattern.matcher(email);

		if(mat.matches()){
			return true;
		}
		
		System.out.println("\nInvalid email address; please try again.");
		return false;
	}

	public static boolean validPassword(String password) {

		if(password.length() > 5){
			return true;
		}
		
		System.out.println("\n\tInvalid password; please try again.");
		System.out.println("\n\tA password must be longer than 5 characters.\n");
		return false;
	}

}
