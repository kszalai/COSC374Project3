/***********************************
 * Kyle Szalai (E01006866)
 * Rob Kendall (E00958364)
 * Greg McKinstry (E00000000)
 * Bryan Andrews (E00000000)
 * COSC 374
 * Project 3
 * 
 * driver.java
 * 
 * This is the main driver program
 ***********************************/
import java.util.*;

public class Driver {

	// initialize Customer array
	static Customer myStructure = new Customer();

	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		int response;

		System.out.println("Welcome");

		// Keep menu running while valid responses
		do {

			System.out.println("1. Send Money Order");
			System.out.println("2. Quit");
			response = keyboard.nextInt();

			switch (response) {
			case 1:
				SendMoneyOrder();
				break;
			case 2:
				System.out.println("GoodBye");
			}

		} while (response > 0 && response < 3 && response != 2);
	}

	// Will take in the detail for a new money order
	private static void SendMoneyOrder() {
		String fName, lName, strNumber, strName, strType, city, state, zip, MonOrdID;
		double amount;
		int MonOrdNums;

		System.out.println("Enter first name");
		fName = keyboard.nextLine();
		System.out.println("Enter last name");
		lName = keyboard.nextLine();

	}
}
