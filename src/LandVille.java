import java.util.Scanner;

class LandVille {
	private int[][] land;
	private int maxRows;
	private int maxColumns;
	private boolean hasHouse;

	// Constructor.
	public LandVille(int maxRows, int maxColumns) {

		this.hasHouse = false;
		this.maxRows = maxRows;
		this.maxColumns = maxColumns;
		this.land = new int[maxRows][maxColumns];

	}

	// Displays the land grid.
	public void displayLand() {

		System.out.println("Your Land:\n");
		for (int[] i : this.land) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println("\n");
		}
	}

	// Clears out the land. This involves setting each cell to be the character '0'.
	public void clearLand() {

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				land[i][j] = 0;
			}
		}
		this.hasHouse = false;
	}

	// Builds House.
	public void buildHouse(int rows, int columns) {


		// Ensure none of the other rules are violated
		// - again display an error message and return if they are violated

		// If all is ok "build" the house on the land (using the character '8')
		// surrounded by a pretty little fence of '1' characters.
		// Finally update 'hasHouse' and call on displayLand().

		if (rows >= (this.maxRows - 2) || columns >= (this.maxColumns - 2)) {
			System.out.println("Sorry - your house is too big for the land you've allocated. Try again.");
			return;
		}

		
		
		
		//Building the fence
		for (int i = 0; i < rows + 2; i++) {
			land[i][0] = 1;
			land[rows+1][i] = 1;
			for (int j = 0; j < columns + 2; j++) {
				land[0][j] = 1;
				land[j][columns+1] = 1;
			}
		}
		
		//Building the house
		for (int i = 0; i < rows; i++) {
			land[i+1][1] = 8;
			land[rows][i+1] = 8;
			for (int j = 0; j < columns; j++) {
				land[1][j+1] = 8;
				land[j+1][columns] = 8;
			}
		}
		
		
		//land[rows][columns] = 8;
		
		
		
		
		
		this.hasHouse = true;
		this.displayLand();

	}

	// Main Method.
	public static void main(String[] args) {

		int landRows = 0;
		int landColumns = 0;
		int houseRows = 0;
		int houseColumns = 0;
		int menuInput = 0;
		boolean firstLoop = false;

		// Initializing scanner object.
		Scanner sc = new Scanner(System.in);

		// User enters land rows.
		System.out.println("Welcome to LandVille!\n\nHow many rows would you like to build on? (1-10):");
		landRows = sc.nextInt();

		// Row error checking.
		while (landRows > 10 || landRows <= 0) {
			System.out.println("Error - please enter a number of rows between 1 and 10.");
			landRows = sc.nextInt();
		}

		// User enters land columns.
		System.out.println("How many columns would you like to build on? (1-10):");
		landColumns = sc.nextInt();

		// Column error checking.
		while (landColumns > 10 || landColumns <= 0) {
			System.out.println("Error - please enter a numer of columns between 1 and 10");
			landColumns = sc.nextInt();
		}

		// Initializing LandVille instance under the variable 'go'.
		LandVille go = new LandVille(landRows, landColumns);

		// Storing the menu in an array for code cleanliness.
		String[] menu = { "What would you like to do first?", "\n (1) Build a House", "\n (2) Display Land",
				"\n (3) Clear Land", "\n (4) Quit" };

		// Menu choice if statement. Loops after option is executed unless user inputs
		// 4, which quits the program.
		while (menuInput != 4) {

			// Checks if user has already been through the menu, if so different wording
			// used for added engagement.
			if (firstLoop == true) {
				menu[0] = "What would you like to do next?";
			}
			// Prints menu array.
			for (int i = 0; i < menu.length; i++) {
				System.out.println(menu[i]);
			}
			// Taking menu input.
			menuInput = sc.nextInt();

			// 'Build house' option.
			if (menuInput == 1) {

				if (go.hasHouse == false) {

					System.out.println("What is the length of your house?");
					houseRows = sc.nextInt();
					System.out.println("What is the width of your house?");
					houseColumns = sc.nextInt();

					go.buildHouse(houseRows, houseColumns);

				} else {
					System.out.println(
							"Sorry - you already have a house on this land!\nRemember to 'clear land' before building a new house.");
				}
				menuInput = 0;
			}
			// 'Display land' option. Calls display land method.
			else if (menuInput == 2) {
				go.displayLand();
				menuInput = 0;
			}
			// 'Clear land' option. Calls clear land method.
			else if (menuInput == 3) {
				go.clearLand();
				System.out.println("Your land has been cleared!");
				menuInput = 0;
			}
			// 'Quit' option - prints goodbye message, closes scanner and breaks menu loop.
			else if (menuInput == 4) {
				sc.close();
				System.out.println("Goodbye!");
			}
			// Catching invalid inputs here.
			else {
				System.out.println("Error - please choose a valid option.");
			}

			// Lets the program know the user has completed their first loop of the menu.
			firstLoop = true;
		}
	}
}
