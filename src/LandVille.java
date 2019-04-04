class LandVille {
	private int[][] land;
	private int maxRows;
	private int maxColumns;
	private boolean hasHouse;

	//Constructor
	public LandVille(int maxRows, int maxColumns) {
		
		this.hasHouse = false;
		this.maxRows = maxRows;
		this.maxColumns = maxColumns;
		this.land = new int[maxRows][maxColumns];

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				land[i][j] = 0;
			}
		}
	}

	// Display the land grid
	public void displayLand() {

		System.out.println("Your Land:\n");
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

		// Ensure none of the other rules are violated
		// - again display an error message and return if they are violated

		// If all is ok "build" the house on the land (using the character '8')
		// surrounded by a pretty little fence of '1' characters.
		// Finally update 'hasHouse' and call on displayLand().

		if (rows >= (this.maxRows - 2) || columns >= (this.maxColumns - 2)) {
			System.out.println("Sorry - your house is too big for the land you've allocated. Try again.");
			return;
		}	
	}
}
