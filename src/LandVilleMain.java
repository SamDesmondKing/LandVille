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

		//Storing the menu in an array for code cleanliness
		String[] menu = { "\nWhat would you like to do?", "\n (1) Build a House", "\n (2) Display Land",
				"\n (3) Clear Land", "\n (4) Quit" };

		// Menu choice if statement. Loops after option is executed unless user inputs
		// 4, which quits the program.
		while (menuInput != 4) {

			for (int i = 0; i < menu.length; i++) {
				System.out.println(menu[i]);
			}
			
			menuInput = sc.nextInt();

			if (menuInput == 1) {
				System.out.println("You chose one");
				menuInput = 0;
			} else if (menuInput == 2) {
				System.out.println("You chose two");
				menuInput = 0;
			} else if (menuInput == 3) {
				System.out.println("You chose three");
				menuInput = 0;
			} else if (menuInput == 4) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Error - please choose a valid option.");
			}
		}
	}
}
