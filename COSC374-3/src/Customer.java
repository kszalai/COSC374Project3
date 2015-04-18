/***********************************
 * Kyle Szalai (E01006866)
 * Rob Kendall (E00958364)
 * Greg McKinstry (E01242940)
 * Bryan Andrews (E01244329)
 * COSC 374
 * Project 3
 * 
 * customer.java
 * 
 * This is the main driver program
 ***********************************/
/*
 * TODO List
 * -Secret splitting
 * -Bit commit
 * -Accepts money orders and blinds them
 * -Unblinding method
 * -Reveal method for Secret Splitting
 */

import java.util.*;

public class Customer {
	
	
	private int [] Left;
	private int [] Right;
	private MoneyOrder theOrder;
	
	//Constructor so we can work with a moneyOrder
	public Customer(MoneyOrder moneyOrder)
	{
		Left = new int[2];
		Right = new int[2];
		theOrder = moneyOrder;
	}
	
	public void bitCommit()
	{
		//Generate random numbers for bit commit
		Random random = new Random();
		//Left is a random integer
		Left[0] = random.nextInt();
		//Right is the XOR of Left and the moneyOrder ID
		Right[0]  = Left[0] ^ theOrder.getMOID();
		
		int BCL1 = random.nextInt();
		int BCR1 = random.nextInt();
		int BCR2 = random.nextInt();
		
		//For Left
		int hL = hashCode(Left,BCL1,BCR2);
	}
	
	public void secretSplit()
	{
		
	}
	
	//t = mk^e mod n
	public void blinding()
	{
		
	}
	
	//m^d mod n
	public void unblinding()
	{
		
	}
}
