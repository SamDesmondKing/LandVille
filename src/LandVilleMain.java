import java.util.Scanner;
// import whatever packages are needed here

public class LandVilleMain {

	public static void main(String[] args) {
		
		
		// Create a Scanner object for input

		// Input # of rows, # of columns for the land size, check for valid input.
		// If the either input is too small replace it with the smallest feasible size
		// the land could be.

		// Create an object of class LandVille using the 'new' operator, calling on the
		// LandVille constructor.

		// Build a loop to display the menu, prompt for input and process it as per
		// requirements.
		
		LandVille go = new LandVille(3,3);
		go.displayLand();

	}

}
