import java.io.*;

public class Bank {
	private static String bankSignatureList[];
	private static String fileName = "BankSignatures.txt";
	private static int[] publicKey = {29,328583};
	private static int[] privateKey = {169349,328583};
	private static MoneyOrder[] moneyOrder = new MoneyOrder[100];
	private static int moneyOrderCount = 0;
	private static int comparison;
	private static String merchKey = "";

	public Bank(MoneyOrder[] moneyOrder)
	{
		Bank.moneyOrder = moneyOrder;
	}
	
	//Generates a random bitstring based of the number of moneyOrders
	//The bank requests for the customer to make for the one money order.
	public static void setMerchKey(int n)
	{
		for(int i = 0 ; i < n ; i++)
		{
			int randomBit = (int) Math.round(Math.random());
			merchKey = merchKey.concat(Integer.toString(randomBit));
		}
	}
	
	/*
	 * This method obtains an integer
	 * to be used during the unblinding process
	 * which will be used to determine the 
	 * legitimacy of the various money orders.
	 */
	public static void setComparisonInt(int comp)
	{
		comparison = comp;
	}
	
	/*
	 * This method determines the legitimacy
	 * of the various money orders that the bank 
	 * is given.
	 */
	public static boolean compare(int comp)
	{
		if(comparison != comp)
		{
			return true;
		}
		return false;
	}

	/*
	 * Returns the public key to a 
	 * calling function.
	 */
	public static int[] getPublicKey()
	{
		//returns the public key {e,n}
		return publicKey;
	}

	/*
	 * Returns the private key to a 
	 * calling function.
	 */
	public int[] getPrivateKey()
	{
		//returns the private key {d,n}
		return privateKey;
	}

	/*
	 * Gets a list of bank signatures from a
	 * file and stores them in a signature list.
	 * Then returns the list.
	 */
	public static String[] getBankSignatures()
	{
		try{
			retrieveSignaturesFromFile();
		}catch(IOException e)
		{
			System.out.println("File does not exist yet!");
			return null;
		}

		return bankSignatureList;
	}

	/*
	 * This function implements the RSA Digital Signature
	 * algorithm for the bank, it saves the digital signature
	 * to the end of the money order file.
	 * It first opens the file and then retrieves the data within,
	 * each line is run through the RSA algorithm and the private
	 * key and public keys are both saved for later use.
	 */

	public void makeBankDigitalSignature(MoneyOrder MO) throws IOException
	{
		//RSA variables.
		int p = 457;	//A prime
		int q = 719;	//Another Prime
		int n = 328583;	//p multiplied by q
		int tn = 327408;// (p-1)x(q-1)
		int e = 29;		//selected integer
		int d = 169349; //Gotten from wolfram alpha.

		
		/*
		 * This will read each character individually
		 * and then the RSA function will be applied to the 
		 * character (character is read as an int).
		 * The bank raises the message multiplied by
		 * the customer's random number by d.
		 * The result will be put into a string builder
		 * which will then be inserted into the file
		 * at the bottom of the file.
		 */

		for(int i=0;i<3;i++)
		{
			if(i == 0)
			{
				MO.setBankSig((int) Math.pow(MO.getAmount(),d)%n, i);
			}
			if(i == 1)
			{
				MO.setBankSig((int) Math.pow(MO.getUnString(),d)%n, i);
			}
			if(i == 2)
			{
				if(i == 1)
				{
					MO.setBankSig((int) Math.pow(MO.getK(),d)%n, i);
				}
			}
		}	


	}
	/*
	 * Verify the bank's signature given an
	 * unblinded money order.
	 */
	public static boolean verifyBankSignature(MoneyOrder MO)
	{
		int e = publicKey[0];
		int n = publicKey[1];
		int i = 0;
		if(MO.getAmount() != (Math.pow(MO.getBankSig(i), e)%n))
		{
			return false;
		} 
		i++;
		if(MO.getUnString() != (Math.pow(MO.getBankSig(i), e)%n))
		{
			return false;
		}
		i++;
		if(MO.getK() != (Math.pow(MO.getBankSig(i), e)%n))
		{
			return false;
		}
		
		return true;
	}

	/*
	 * This method excepts a file name and a digital signature string
	 * and stores the digital signature on the file by appending it
	 * to the end of the file.
	 */

	public static void storeDigitalSignature(String fileName, String digitalSignature) throws IOException{

		File f = new File(fileName);

		if(!f.exists())
		{
			f.createNewFile();
		}

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
			out.println(digitalSignature);
			out.close();
		} catch (IOException e) {
			System.out.println("File does not exist.");
		}

		System.out.println("Digital Signature Written to: " + fileName);

	}



	/*
	 * A method that obtains all bank uniqueness 
	 * strings from a file and stores them in the
	 * bankSignatureList string array.
	 */
	private static void retrieveSignaturesFromFile() throws IOException {
		//Total number of uniqueness strings should be at the top of the file.
		int totalEntries;

		//Set up a buffered reader to read each line from the file.
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		try {
			//get the first string at the top of the file
			//This should be the total number of uniqueness 
			//strings in the file.
			String line = br.readLine();

			//parse the first line into an integer.
			totalEntries = Integer.parseInt(line);

			bankSignatureList = new String[totalEntries];

			for(int i = 0; i < totalEntries; i++)
			{

				bankSignatureList[i] = br.readLine();

			}

		} finally {

			br.close();
		}			
	}

	//Adds a bank order to the database array of bank orders
	public static void addBankOrder(MoneyOrder x)
	{
		moneyOrder[moneyOrderCount] = x;
		moneyOrderCount++;
	}
	
	//Used to check to see if the bank order has been previously used
	//If already used, returns the MoneyOrder that is already in the 
	//database to find out who is the cheater, and their identification
	//information.
	public static MoneyOrder compareBankUniqueIDs(MoneyOrder x)
	{
		for (int i = 0; i < moneyOrderCount; i++)
		{
			if (x.getMOID() == moneyOrder[i].getMOID())
				return moneyOrder[i];	
		}
		return null;
	}

}
