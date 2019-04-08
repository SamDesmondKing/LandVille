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
		System.out.println("\nYour Land:\n");
		for (int[] i : this.land) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println("\n");
		}
	}

	// Clears out the land. This involves setting each cell to be the character '0'.
	public void clearLand() {
		for (int i = 0; i < this.land.length; i++) {
			for (int j = 0; j < this.land[i].length; j++) {
				land[i][j] = 0;
			}
		}
		this.hasHouse = false;
	}

	// Builds House, sets hasHouse to true and displays house on the land.
	public void buildHouse(int rows, int columns) {

		// Check to see if the house will fit on the allocated land.
		if (rows > (this.maxRows - 2) || columns > (this.maxColumns - 2)) {
			System.out.println("\nSorry - your house is too big for the land you've allocated. Try again.");
			return;
		}

		// -- Building the House --
		// Loop through all the arrays.
		for (int i = 0; i < rows + 1; i++) {
			// Loop through all the elements of each array.
			for (int j = 0; j < columns + 1; j++) {
				// Setting every space of the house (including where the fence will be) to 8.
				// Fence will be built over the top of this.
				this.land[i][j] = 8;
			}
		}

		// -- Building the Fence --
		// Loop through all the arrays.
		for (int i = 0; i <= rows + 1; i++) {
			// Loop through all the elements of each array.
			for (int j = 0; j <= columns + 1; j++) {

				// Makes the value at index [0] equal to 1 in all arrays up to i (rows + 1).
				// This is the left hand side of the fence.
				this.land[i][0] = 1;

				// Find the array at index [0] and makes all values in it up to j (columns + 1)
				// equal to 1.
				// This is the top of the fence.
				this.land[0][j] = 1;

				// Makes the values of index (columns + 1) equal to 1 in all arrays up to i
				// (rows + 1).
				// This is the right hand side of the fence.
				this.land[i][columns + 1] = 1;

				// Finds array (rows+1), iterates through making all vales up to j (columns + 1)
				// equal to 1.
				// This is the bottom side of the fence.
				this.land[rows + 1][j] = 1;
			}
		}

		// Lets the program know that this instance of LandVille already has a house.
		this.hasHouse = true;

		// Displays the land for the user before they return to the main menu.
		this.displayLand();

		// Success message
		System.out.println("\nYou have built a house! It looks great!");
	}

	// Main Method.
	public static void main(String[] args) {

		int landRows = 0;
		int landColumns = 0;
		int houseRows = 0;
		int houseColumns = 0;
		int menuInput = 0;
		boolean loopCheck = false;

		// Initializing scanner object.
		Scanner sc = new Scanner(System.in);

		// Welcome banner plus taking row input.
		System.out.println(
				"\n\n\n             ~~~~~~~~~***~~~~~~~~~~\n             Welcome to LandVille!\n             ~~~~~~~~~***~~~~~~~~~~\n\nHow many rows of land would you like to build on? (1-9):");
		landRows = sc.nextInt();

		// Row error checking.
		while (landRows > 10 || landRows <= 0) {
			System.out.println("\nError - please enter a number of rows between 1 and 9.");
			landRows = sc.nextInt();
		}

		// User enters land columns.
		System.out.println("\nHow many columns of land would you like to build on? (1-9):");
		landColumns = sc.nextInt();

		// Column error checking.
		while (landColumns > 10 || landColumns <= 0) {
			System.out.println("\nError - please enter a numer of columns between 1 and 9");
			landColumns = sc.nextInt();
		}

		// Initializing LandVille instance under the variable 'go'.
		LandVille go = new LandVille(landRows, landColumns);

		// Storing the menu in an array for code cleanliness.
		String[] menu = { "\nWhat would you like to do first?", "\n (1) Build a House", "\n (2) Display Land",
				"\n (3) Clear Land", "\n (4) Quit" };

		// Menu choice if statement. Loops after option is executed unless user inputs
		// 4, which quits the program.
		while (menuInput != 4) {

			// Checks if user has already been through the menu, if so different wording
			// used for added engagement.
			if (loopCheck == true) {
				menu[0] = "\nWhat would you like to do next?";
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

					System.out.println("\nWhat is the length of your house?");
					houseRows = sc.nextInt();
					System.out.println("\nWhat is the width of your house?");
					houseColumns = sc.nextInt();

					go.buildHouse(houseRows, houseColumns);

				} else {
					System.out.println(
							"\nSorry - you already have a house on this land!\nRemember to 'clear land' before building a new house.");
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
				System.out.println("\nYour land has been cleared!");
				menuInput = 0;
			}
			// 'Quit' option - prints goodbye message, closes scanner and breaks menu loop.
			else if (menuInput == 4) {
				sc.close();
				System.out.println("\nGoodbye!");
			}
			// Catching invalid inputs here.
			else {
				System.out.println("\nError - please choose a valid option.");
			}

			// Lets the program know the user has completed their first loop of the menu.
			loopCheck = true;
		}
	}
}
