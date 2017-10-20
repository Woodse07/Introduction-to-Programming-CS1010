import java.util.Random;
import java.util.Scanner;

public class Cipher {
	
	public static void main(String args[])
	{
		boolean finished = false;
		
		char[] characterArray = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
		char[] cipherCharacterArray = null;
		char[] splitMessage = null;
		String cipherText = "";
		cipherCharacterArray = createCipher(characterArray, cipherCharacterArray);
		
		createCipher(characterArray, cipherCharacterArray);
		
		Scanner inputScanner = new Scanner(System.in);
		inputScanner.useDelimiter("[\\r\\n;]+");
			
		while (!finished)
		{
			
			System.out.println("Please enter the message you would like to encrypt: ");

			if (inputScanner.hasNext())
			{
				
				if (inputScanner.hasNext("quit") || inputScanner.hasNext("exit"))
				{
					System.out.println("Goodbye.");
					finished = true;
				}
				
				else if (inputScanner.hasNextInt() || inputScanner.hasNextDouble())
				{
					System.out.println("Invalid Input. Please input a String.");
					inputScanner.nextLine();
				}
				
				else
				{			
				String message = inputScanner.next();
				String lowerCaseMessage = message.toLowerCase();			
				splitMessage = lowerCaseMessage.toCharArray();
				
				System.out.println("Cipher Text: " + encrypt(characterArray, cipherCharacterArray, splitMessage));
				System.out.println("Plain Text: " + crypt(characterArray, cipherCharacterArray, splitMessage, cipherText));			
				}				
			}
			
			else
			{
				System.out.println("Invalid input. Try again.");
				inputScanner.nextLine();
			}
			
		}
		inputScanner.close();
	}

	public static char[] createCipher(char[] characterArray, char[] cipherCharacterArray)
	{
		cipherCharacterArray = characterArray.clone();
		
		Random generator = new Random();
		
	    for (int index=0; index< cipherCharacterArray.length; index++ )
	    {
	      int otherIndex = generator.nextInt(cipherCharacterArray.length);
	      char temp = cipherCharacterArray[index];
	      cipherCharacterArray[index] = cipherCharacterArray[otherIndex];
	      cipherCharacterArray[otherIndex] = temp;
	    }
		
		return(cipherCharacterArray);
	}
	
	public static String encrypt(char[] characterArray, char[] cipherCharacterArray, char[] splitMessage)
	{
		String cipherText = "";
		for(int index = 0; index < splitMessage.length; index++)
		{
			for(int index2 = 0; index2 < characterArray.length; index2++)
			{
				if(splitMessage[index] == characterArray[index2])
				{
					cipherText += cipherCharacterArray[index2];
				}
			}
		}
		return(cipherText);
	}
	
	public static String crypt(char[] characterArray, char[] cipherCharacterArray, char[] splitMessage, String cipherText)
	{
		String plainText = "";
		cipherText = encrypt(characterArray, cipherCharacterArray, splitMessage);
		char[] cipherTextArray = cipherText.toCharArray();
		for(int index = 0; index < cipherTextArray.length; index++)
		{
			for(int index2 = 0; index2 < cipherCharacterArray.length; index2++)
			{
				if(cipherTextArray[index] == cipherCharacterArray[index2])
				{
					plainText += characterArray[index2];
				}
			}
		}
		return(plainText);
	}
}
