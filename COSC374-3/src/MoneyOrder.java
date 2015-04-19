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
	private int am;
	private int ID_String;
	
	private int[] bankSig;
	private int k;
	
	private int[] randomNum;
	private int[] secretNum;

	// parameterized constructor
	public MoneyOrder(int ssn, int uniqueString, int amount) {
		this.ssn = ssn;
		unString = uniqueString;
		am = amount;
		k = (int)(Math.random()*9);
	}

	public String toString() { // return parameters to the display method
		// in MoneyOrder class
		return (ssn + " " + unString + " " + am);
	}
	
	public int[] getRandomNum()
	{
		return randomNum;
	}
	
	public int[] getSecretNum()
	{
		return secretNum;
	}
	
	// Get uniqueString
	public int getMOID() {
		return unString;
	}
	
	//Set uniqueString
	public void setMOID(int uniqueString) {
		unString = uniqueString;
	}
	
	//Get SSN
	public int getSSN()
	{
		return ssn;
	}
	
	//Get uniqueString
	public int getUnString()
	{
		return unString;
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

	public int getAmount() 
	{
		return am;
	}

	public void setSSN(int i) 
	{
		ssn = i;
	}

	public void setAmount(int i) 
	{
		am = i;	
	}

	public void setUnString(int i) 
	{
		unString = i;	
	}

	public int getK()
	{
		return k;
	}
	
	public void setK(int k) 
	{
		this.k = k;
	}
}
