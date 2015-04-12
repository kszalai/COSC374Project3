
public class Merchant {
	
	/*
	 * A method that accepts a list if uniqueness strings from the bank
	 * and a moneyorder object. If a signature matches the moneyorder, true is 
	 * returned, else false is returned.
	 * This is the merchant's step in the verification of the legitimacy
	 * of the money order.
	 */
	public boolean verifyBankSigniture(String signatureList[], MoneyOrder MO)
	{
		//for loop to search through a list of uniqueness strings from the bank.
		for(int i = 0; i < signatureList.length; i++)
		{
			//an if statement tests each string and compares it to the moneyorder's
			// signature to find a match.
			if(signatureList[i].equalsIgnoreCase(MO.getMOID()))
			{
				return true;
			}
		}
		//No match was found, person is lying.
		return false;
		
	}

}
