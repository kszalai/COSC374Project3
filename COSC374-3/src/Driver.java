/***********************************
 * Kyle Szalai (E01006866)
 * Rob Kendall (E00958364)
 * Greg McKinstry (E00000000)
 * Bryan Andrews (E01244329)
 * COSC 374
 * Project 3
 * 
 * driver.java
 * 
 * This is the main driver program
 ***********************************/
import java.util.*;

public class Driver {

	public static Scanner keyboard = new Scanner(System.in);
	public static int n;

	public static void main(String[] args) {
		int response;

		System.out.println("Welcome to the Dank Memes Exchange");
		System.out.println("Who are you?");

		// Keep menu running while valid responses
		do {

			System.out.println("1. Customer");
			System.out.println("2. Merchant");
			System.out.println("3. Bank");
			System.out.println("4. Quit");
			response = keyboard.nextInt();
			keyboard.nextLine();

			switch (response) {
			case 1:
				// CustomerStuff
				customerStuff();
				break;
			case 2:
				// mechantStuff
				break;
			case 3:
				// bankStuff
				break;
			default:
			}

		} while (response < 4);

		System.out.println("Good bye!");
	}

	// Will take in the detail for a new money order
	public static void customerStuff() {

		// Ask the user how many money orders the user would like
		int n = 0;
		System.out.println("How many money orders would you like?");
		n = keyboard.nextInt();
		keyboard.nextLine();

		MoneyOrder[] orders = new MoneyOrder[n];

		// Variables needed for moneyOrder constructor
		String ssn;
		String uniqueString = "";
		double amount;

		// Make sure SSN is proper length
		do {
			System.out.println("Please enter your 9 digit SSN: ");
			ssn = keyboard.nextLine();
		} while (ssn.length() != 9);

		// When searching for already generated uniqueStrings
		// if found, keep going

		int toNum = 100000000;
		MoneyOrder found = null;

		// Enter the amount of each moneyOrder
		for (int i = 0; i < orders.length; i++) {
			// Generate the uniqueness String
			for (int j = 0; j < 8; j++) {
				uniqueString = Integer
						.toString((int) (Math.random() * (toNum)) + 1);
			}
			System.out.println();
			System.out
					.println("Please enter the amount of the money order you want:");
			System.out.print("$");
			amount = keyboard.nextDouble();
			orders[i] = new MoneyOrder(ssn, uniqueString, amount);

		}
		System.out.println("Data Structure: ");
		for (int i = 0; i < n; i++) {
			System.out.println(orders[i] + " ");
			System.out.println("");
		}

	}

}