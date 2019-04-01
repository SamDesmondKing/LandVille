import java.util.Scanner;

public class LandVilleMain {

	public static void main(String[] args) {

		int rows = 0;
		int columns = 0;
		int menuInput = 0;
		Scanner sc = new Scanner(System.in);

		// User enters rows
		System.out.println("Welcome to LandVille!\n\nHow many rows would you like to build on? (1-10):");
		rows = sc.nextInt();

		// Row error checking
		while (rows > 10 || rows <= 0) {
			System.out.println("Error - please enter a number of rows between 1 and 10.");
			rows = sc.nextInt();
		}

		// User enters columns
		System.out.println("How many columns would you like to build on? (1-10):");
		columns = sc.nextInt();

		// Column error checking
		while (columns > 10 || columns <= 0) {
			System.out.println("Error - please enter a numer of columns between 1 and 10");
			columns = sc.nextInt();
		}

		// Initializing LandVille
		LandVille go = new LandVille(rows, columns);


		// Menu choice if statement 
		
		//Bug - Menu not displaying error message after entering invalid int twice.
		
		while (menuInput != 4) {
			
			System.out.println("What would you like to do?\n1. Build a House\n2. Display Land\n3. Clear Land\n4. Quit");
			menuInput = sc.nextInt();
			
			if (menuInput == 1) {
				System.out.println("You chose one\n");
				menuInput = 0;
			} else if (menuInput == 2) {
				System.out.println("You chose two\n");
				menuInput = 0;
			} else if (menuInput == 3) {
				System.out.println("You chose three\n");
				menuInput = 0;
			} else if (menuInput == 4) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Error - please choose a valid option.");
			}
			
				
		}		
	}
}
