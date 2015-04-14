import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Bank {
	private String bankSignatureList[];
	private String fileName = "BankSignatures.txt";
	private int[] publicKey = {29,328583};
	private int[] privateKey = {169349,328583};
	
	/*
	 * Returns the public key to a 
	 * calling function.
	 */
	public int[] getPublicKey()
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
		//returns the private key {e,n}
		return privateKey;
	}
	
	/*
	 * Gets a list of bank signatures from a
	 * file and stores them in a signature list.
	 * Then returns the list.
	 */
	public String[] getBankSignatures()
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
	
	public void makeBankDigitalSignature(String fileName) throws IOException
	{
		int p = 457;
		int q = 719;
		int n = 328583;
		int tn = 327408;
		int e = 29;
		int d = 169349;
		
		//Set up a buffered reader to read each line from the file.
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		//String builder with a capacity 500 characters long
		//is this long enough too long? eh?
		StringBuilder sb = new StringBuilder(500);

		try {
				/*
				 * This will read each character individually
				 * and then the RSA function will be applied to the 
				 * character (character is read as an int).
				 * The result will be put into a string builder
				 * which will then be inserted into the file
				 * at the bottom of the file.
				 */
				int character = br.read();
					
				while(character != -1)
				{
					int c = (int) Math.pow(character,e)%n;
					sb.append(c);
				}

			} finally {

				br.close();
			}	
		
		storeDigitalSignature(fileName, sb.toString());
	}
	
	/*
	 * This method excepts a file name and a digital signature string
	 * and stores the digital signature on the file by appending it
	 * to the end of the file.
	 */
	
	public static void storeDigitalSignature(String fileName, String digitalSignatire) throws IOException{
		
		File f = new File(fileName);
		
		if(!f.exists())
		{
			f.createNewFile();
		}
		
		try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
		    out.println(digitalSignatire);
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
	private void retrieveSignaturesFromFile() throws IOException {
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

}
