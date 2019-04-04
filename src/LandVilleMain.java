import java.util.Scanner;

public class LandVilleMain {
	

	public static void main(String[] args) {

		int landRows = 0;
		int landColumns = 0;
		int houseRows = 0;
		int houseColumns = 0;
		int menuInput = 0;
		boolean firstLoop = false;
		Scanner sc = new Scanner(System.in);

		// User enters rows
		System.out.println("Welcome to LandVille!\n\nHow many rows would you like to build on? (1-10):");
		landRows = sc.nextInt();

		// Row error checking
		while (landRows > 10 || landRows <= 0) {
			System.out.println("Error - please enter a number of rows between 1 and 10.");
			landRows = sc.nextInt();
		}

		// User enters columns
		System.out.println("How many columns would you like to build on? (1-10):");
		landColumns = sc.nextInt();

		// Column error checking
		while (landColumns > 10 || landColumns <= 0) {
			System.out.println("Error - please enter a numer of columns between 1 and 10");
			landColumns = sc.nextInt();
		}

		// Initializing LandVille
		LandVille go = new LandVille(landRows, landColumns);

		//Storing the menu in an array for code cleanliness
		String[] menu = { "What would you like to do first?", "\n (1) Build a House", "\n (2) Display Land",
				"\n (3) Clear Land", "\n (4) Quit" };

		// Menu choice if statement. Loops after option is executed unless user inputs
		// 4, which quits the program.
		while (menuInput != 4) {

			if (firstLoop == true) {
				menu[0] = "What would you like to do next?"; 
			}
			
			for (int i = 0; i < menu.length; i++) {
				System.out.println(menu[i]);
			}
			
			menuInput = sc.nextInt();

			if (menuInput == 1) {
				
				System.out.println("What is the length of your house?");
				houseRows = sc.nextInt();
				System.out.println("What is the width of your house?");
				houseColumns = sc.nextInt();
				
				go.buildHouse(houseRows, houseColumns);
				
				menuInput = 0;
			} else if (menuInput == 2) {
				go.displayLand();
				menuInput = 0;
			} else if (menuInput == 3) {
				go.clearLand();
				System.out.println("Your land has been cleared!");
				menuInput = 0;
			} else if (menuInput == 4) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Error - please choose a valid option.");
			}
			
			firstLoop = true;
		}
	}
}
