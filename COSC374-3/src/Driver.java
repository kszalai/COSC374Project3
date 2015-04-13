/***********************************
 * Kyle Szalai (E01006866)
 * Rob Kendall (E00958364)
 * Greg McKinstry (E01242940)
 * Bryan Andrews (E01244329)
 * COSC 374
 * Project 3
 * 
 * driver.java
 * 
 * This is the main driver program
 ***********************************/


/* TODO ****************************
 * 
 * format the amount variable to make sure it is like real money (2 decimal places)
 */
import java.util.*;

public class Driver {

	public static Scanner keyboard = new Scanner(System.in);
	public static int n;
	public static MoneyOrder[] orders;
	public static Merchant merchant = new Merchant();

	public static void main(String[] args) {
		int response;

		System.out.println("Welcome to the Dank Memes Exchange");

		// Keep menu running while valid responses
		do {

			System.out.println("Please select a party");
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
				System.out.println("Bit: " + merchant.randomSelectorBit());
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
		int n;

		do {
			System.out.println("How many money orders would you like?");
			n = keyboard.nextInt();
			keyboard.nextLine();

			if (n > 10)
				System.out
						.println("Error: Maximum of 10 Money Orders at a time!");
		} while (n < 0 || n > 10);

		orders = new MoneyOrder[n];

		// Variables needed for moneyOrder constructor
		int ssn;
		int uniqueString;
		double amount;

		// Make sure SSN is proper length
		do {
			System.out.println("Please enter your 9 digit SSN: ");
			ssn = keyboard.nextInt();

			if (Integer.toString(ssn).length() != 9)
				System.out.println("Error: Invalid SSN");
		} while (Integer.toString(ssn).length() != 9);

		int toNum = 100000000;

		// Enter the amount of each moneyOrder
		for (int i = 0; i < orders.length; i++) {
			System.out.println();
			System.out
					.println("Please enter the amount you want for money order "
							+ (i + 1));
			System.out.print("$");
			amount = keyboard.nextDouble();

			// randomly assign a uniqueString
			do {
				uniqueString = ((int) (Math.random() * (toNum)) + 1);

				orders[i] = new MoneyOrder(ssn, uniqueString, amount);
			} while (Integer.toString(uniqueString).length() != 8);

			// Check for duplicated uniqueStrings to maintain identity
			// (unlikely, but just in case)
			for (int j = 0; j < i; j++) {
				if (orders[j].getMOID() == (orders[i].getMOID()))
					orders[j].setMOID((int) (Math.random() * (toNum)) + 1);
			}
		}

		System.out.println("Data Structure: ");
		for (int i = 0; i < n; i++) {
			System.out.println(orders[i] + " ");
			System.out.println("");
		}
	}
}
