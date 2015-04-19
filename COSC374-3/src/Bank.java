import java.io.*;

public class Bank {
	private static String bankSignatureList[];
	private static String fileName = "BankSignatures.txt";
	private static int[] publicKey = {29,328583};
	private static int[] privateKey = {169349,328583};
	private static MoneyOrder[] moneyOrder = new MoneyOrder[100];
	private static int moneyOrderCount = 0;

	public Bank(MoneyOrder[] moneyOrder)
	{
		Bank.moneyOrder = moneyOrder;
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

	public void makeBankDigitalSignature() throws IOException
	{
		//RSA variables.
		int p = 457;	//A prime
		int q = 719;	//Another Prime
		int n = 328583;	//p multiplied by q
		int tn = 327408;// (p-1)x(q-1)
		int e = 29;		//selected integer
		int d = 169349; //Gotten from wolfram alpha.

		//String builder with a capacity 500 characters long
		//is this long enough too long? eh?
		StringBuilder sb = new StringBuilder(500);

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
		String signature = "B@nK$1GnAtUR3";

		for(int i=0;i<signature.length();i++)
		{
			int character = signature.charAt(i);
			int c = (int) Math.pow(character,d)%n;
			sb.append(c);
		}	

		storeDigitalSignature("bankSigs.txt", sb.toString());
		for(int i=0;i<moneyOrder.length;i++)
		{
			moneyOrder[i].setBankSig(Integer.parseInt(sb.toString()));
		}
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
