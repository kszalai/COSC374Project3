public class Customer {

	MoneyOrder[] data = new MoneyOrder[10];
	int location = 0;

	// constructor
	public void insert(String first, String last, String strNumber,
			String strName, String strType, String city, String state,
			String zip, String MonOrdID, double amount, int MonOrdNums)

	{
		data[location] = new MoneyOrder(first, last, strNumber, strName,
				strType, city, state, zip, MonOrdID, amount, MonOrdNums);
		location++;
	}
}