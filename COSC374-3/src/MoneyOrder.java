/***********************************
 * Kyle Szalai (E01006866)
 * Rob Kendall (E00958364)
 * Greg McKinstry (E00000000)
 * Bryan Andrews (E00000000)
 * COSC 374
 * Project 3
 * 
 * MoneyOrder.java
 * 
 * [Add a description for the MoneyOrder
 * class later]
 ***********************************/
// i will update this as we go through it
import java.util.*;

public class MoneyOrder {
	// variables for customer info
	private String ssn;
	private String MO_ID; //uniqueString in driver

	// variables for:
	// 1) amount
	// 2) number of money orders to generate
	// 3) large string with all the info concatinated excluding the number of money orders generated
	private double am;
	private int ID_String;

	// parameterized constructor
	public MoneyOrder(String ssn, String MonOrdID, double amount) {
		this.ssn = ssn;
		MO_ID = MonOrdID;
		am= amount;

	}

	public String toString() { // return parameters to the display method
		// in MoneyOrder class
		return (ssn + " " + MO_ID + " " + am);
	}
	
	//Get ID_String
	public String getMOID()
	{
		return MO_ID;
	}

	public void display() {
		System.out.println(ssn + " " + MO_ID + " " + am);
	}
}
