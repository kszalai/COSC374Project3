Kyle Szalai (E01006866)
Rob Kendall (E00958364)
Greg McKinstry (E01242940)
Bryan Andrews (E01244329)
COSC 374
4/19/15
Project 3
README.txt

How to compile and run
-You could open these files on a lab computer using eclipse 
and compile and run the code from there, or you could run it 
through terminal (Mac/Linux) or command prompt (Windows)

Windows Instructions
1. Make sure the Java Development Kit is installed on your machine.
2. Navigate to the "bin" folder
3. Hold either shift key and right click
4. Select "Open command window here"
5. Type in "java driver"

Mac/Linux Instructions
1. Go to terminal
2. Change to the directory that contains this folder
3. Change the directory to the "bin" folder
4. Type in "java driver"
---------------------------------------------------------------------------------
Expected Input
You will be met with a menu when the program starts. 
You will have a menu displayed, select an option by typing in the option and 
pressing enter.
You will then be asked to enter in your SSN to indentify yourself, and then
the corresponding fields for the amount of your money order. 
The driver will then ask which merchant you would like to spend the money
order with.
The bank will then verify the money order.
---------------------------------------------------------------------------------
How the Program Performs the Conversion
The program will randomly generate the n copies of the same money order. The
customer will then perform secret splitting, bit commitment, and blinding on
the money order. For the secret splitting, left and right are calculated independently
where the left is a random number and the right is the calculation of the XOR of
the ID and the random number. This "secret" is the right half of the secret
splitting. From here, bit commitment is performed. For the left, 2 random numbers
are generated and saved. The hash code of Left, BCL1, and BCR2 is calculated and
stored. Then the Left set is the hash of those 3 values and BCL1. For the right,
1 more random number is calculated, BCR1. The hash of Right, BCR1, and BCR2 is
calculated, and the Right set is made up of the hash of those 3 values and BCR1.
The bank then asks to open n-1 of the money orders, while the customer blinds the
n'th money order for the bank to sign. This is calculated by doing t=mk^e mod n.
The bank then signs the blinded money order by doing t^d. The money order is then
unblinded after being signed by the bank. We perform this by dividing by a stored k
value. The merchant has their own hard-coded n-bit merchant string. The merchant 
then asks to open either the left or the right side of the money order based on
what their bit string is. Based on this, the merchant accepts the money order and
sends it to the bank where it undergoes further validation.
The bank then recieves the money order from the merchant, and if the unique ID has already
been put into the database, the bank will refuse the order.  Depending on whether or not the
bit string of undoing the bit commitment is the same or not, the bank will know whether or not
it is the customer or the merchant that is attempting to cheat the system.  If the customer is cheating,
then the bank will then XOR one identity string line from their money order in the records with 
one of the other identity string lines in the merchant's copy, a left and right string.  The xor'ed 
identity string will then contain all of the information as to the customer, and in this case, their
Social security number.
----------------------------------------------------------------------------------
Output Formatting
Output is returned to the user in the form of print out statements.
When the conversion process is completed, the following information is returned to
the user.
-Success or fail of the money order transaction.
