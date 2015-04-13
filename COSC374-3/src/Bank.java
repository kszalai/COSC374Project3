import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Bank {
	private String bankSignatureList[];
	private String fileName = "BankSignatures.txt";
	
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
