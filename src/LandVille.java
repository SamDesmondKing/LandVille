class LandVille {
	private int[][] land;
	private boolean hasHouse;
	

	//Constructor
	public LandVille(int maxRows, int maxColumns) {
		
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

		System.out.println("\nYour Land:\n");
		for (int[] i : land) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println("\n");
		}
	}

	// Clear out the land. This involves setting each cell to be the character '0'.
	public void clearLand() {

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				land[i][j] = 0;
			}
		}
		this.hasHouse = false;
	}

	public void buildHouse(int rows, int columns) {
		
		// Build a house
		// Validate the inputs to ensure they make sense for the size of the land
		// - display an error message and return if they don't.

		// Ensure none of the other rules are violated
		// - again display an error message and return if they are violated

		// If all is ok "build" the house on the land (using the character '8')
		// surrounded
		// by a pretty little fence of '1' characters.
		// Finally update 'hasHouse' and call on displayLand().

	}

}
