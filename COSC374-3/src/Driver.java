import java.util.*;

public class Driver {

	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		int response;

		System.out.println("Welcome");

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

		} while (response > 0 && response < 3 && response !=2);
	}

	private static void SendMoneyOrder() {
		// TODO Auto-generated method stub
		
	}
}
