import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Bank {
	private String bankSignatureList[];
	private String fileName = "BankSignatures.txt";
	private int[] publickey = {29,328583};
	private int[] privatekey = {169349,328583};
	
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

		try {
				//get the first string at the top of the file
				//This should be the amount, but it doesn't matter
				//strings in the file.
				String line = br.readLine();
					
				while(line != null)
				{

				}

			} finally {

				br.close();
			}	
				
		
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
