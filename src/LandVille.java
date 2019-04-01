// import whatever packages are needed here

// Programming note: this class does NOT need to do any input
// at all. All the input should occur in LandVilleMain.java
//
// If you find yourself needing to do input here rethink your solution.

class LandVille {
	private int[][] land;
	private boolean hasHouse;
	// you will need to add the variable 'hasHouse'

	// Constructor...

	// Assumption - rows and columns has been validated beforehand.

	// Create the array that the land variable above will reference (using the 'new'
	// operator)

	// Initialize the land so that each cell is set to the character '0' (hint: use
	// one of your methods!).

	// Set the value of any other variables

	public LandVille(int maxRows, int maxColumns) {

		/*
		 * The constructor of the LandVille class takes 2 parameters: the number of rows
		 * of the land, the number of columns of the land. In the constructor of this
		 * class, write code to initialize land with the size of row and column.
		 * Initialize each value of the array land with the value 0, which means that
		 * plot is empty. Initialize the value of hasHouse to false
		 */

		
		this.hasHouse = false;
		this.land = new int[maxRows][maxColumns];

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				land[i][j] = 0;
			}
		}
	}

	// Display the land grid
	public void displayLand() {

		for (int[] i : land) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println("\n");
		}
	}

	// Clear out the land. This involves setting each cell to be the character '0'
	public void clearLand() {

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				land[i][j] = 0;
			}
		}
		
	}

	// Build a house
	// Validate the inputs to ensure they make sense for the size of the land
	// - display an error message and return if they don't.

	// Ensure none of the other rules are violated
	// - again display an error message and return if they are violated

	// If all is ok "build" the house on the land (using the character '8')
	// surrounded
	// by a pretty little fence of '1' characters.
	// Finally update 'hasHouse' and call on displayLand().

	public void buildHouse(int rows, int columns) {

	}

}
