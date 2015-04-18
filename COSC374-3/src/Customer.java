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
	private int[] publicKey = {29,328583};
	
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
		
		//For other left
		Left[1] = getHashValue(Left[0],BCL1,BCR2);
		
		Right[1] = getHashValue(Right[0],BCR1,BCR2);
	}
	
	public int getHashValue(int val1, int val2, int val3)
	{
		return Integer.toString(val1).hashCode() ^ Integer.toString(val2).hashCode() ^ Integer.toString(val3).hashCode();
	}
	
	public void secretSplit()
	{
		
	}
	
	//t = mk^e mod n
	public void blinding(MoneyOrder mo)
	{
		int[]pubKey = Bank.getPublicKey();
		int e = pubKey[0];
		int n = pubKey[1];
		int k = (int)Math.random()*9;
		int bssn = mo.getSSN();
		int bam = mo.getAmount();
	}
	
	//m^d mod n
	public void unblinding()
	{
		
	}
}
