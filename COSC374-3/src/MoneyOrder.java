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
	private int ssn;
	private int unString; // uniqueString in driver

	// variables for info
	private double am;
	private int ID_String;
	
	private int bankSig;

	// parameterized constructor
	public MoneyOrder(int ssn, int uniqueString, double amount) {
		this.ssn = ssn;
		unString = uniqueString;
		am = amount;
	}

	public String toString() { // return parameters to the display method
		// in MoneyOrder class
		return (ssn + " " + unString + " " + am);
	}

	// Get uniqueString
	public int getMOID() {
		return unString;
	}
	
	//Set uniqueString
	public void setMOID(int uniqueString) {
		unString = uniqueString;
	}
	
	//Get bankSig
	public int getBankSig()
	{
		return bankSig;
	}
	
	//Set bankSig
	public void setBankSig(int bankSig)
	{
		this.bankSig = bankSig;
	}
}
