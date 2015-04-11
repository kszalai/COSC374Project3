import java.util.*;

public class Driver {

	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome");

		do {

			System.out.println("1. Send Money Order");
			System.out.println("2. Quit");
			int response = keyboard.nextInt();

			switch (response) {
			case 1:
				SendMoneyOrder();
				break;
			case 2:
				System.out.println("GoodBye");
			}

		} while (response > 0 && response < 3);
	}
}
