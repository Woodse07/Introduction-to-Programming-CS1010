import java.util.Arrays;
import java.util.Scanner;

public class WordLinksPuzzleGame {

	public static void main(String[] agrs)
	{		
		System.out.println("Enter a comma separated list of words (or an empty list to quit):");
		Scanner inputScanner = new Scanner(System.in);
		inputScanner.useDelimiter("[\\r\\n;]+");
		boolean finished = false;
		String input = "";
		while(!finished)
		{
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
					input = inputScanner.next();
					String[] wordList = readWordList(input);
					if(isWordChain(wordList))
					{
						System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
					}
					else
					{
						System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
					}
				}			
			}
			
			else if(inputScanner.equals(""))
			{
				System.out.println("Goodbye");
				finished = true;
			}
			
			else
			{
				System.out.println("Invalid input. Try again.");
				inputScanner.nextLine();
			}
		}
		inputScanner.close();
	}
	
	public static String[] readDictionary()
	{		
		In dictionaryStream = new In("words.txt");
		String dictionaryString = dictionaryStream.readAll();
		String[] dictionary = dictionaryString.split("\\s*\r?\n");
		Arrays.sort(dictionary);
		return dictionary;
	}
	
	public static String[] readWordList(String input)
	{		
		String[] wordList = input.split("\\s*,\\s*");
		return wordList;		
	}
	
	public static boolean isUniqueList(String[] wordList)
	{
		String string1 = "";
		String string2 = "";
		boolean isUnique = true;
		for(int x = 0; x < wordList.length; x++)
		{
			string1 = wordList[x];
			for(int y = 0; y < wordList.length; y++)
			{
				if(y != x)
				{
					string2 = wordList[y];
					if(string1.equals(string2))
					{
						isUnique = false;
					}
				}
			}
		}	
		return isUnique;
	}
	
	public static boolean isEnglishWord(String word, String[] dictionary)
	{
		boolean isEnglishWord = true;
		int index = Arrays.binarySearch(dictionary, word);
		if(index < 0)
		{
			isEnglishWord = false;
		}
		return isEnglishWord;		
	}
	
	public static boolean isDifferentByOne(String string1, String string2)
	{
		char[] string1Size = string1.toCharArray();
		char[] string2Size = string2.toCharArray();
		boolean sameSize = false;
		boolean differentByOne = false;
		int count = 0;
		char char1;
		char char2;
		
		if(string1Size.length == string2Size.length)
		{
			sameSize = true;
		}
		
		if(sameSize)
		{
			for(int i = 0; i < string1Size.length; i++)
			{
				char1 = string1Size[i];
				char2 = string2Size[i];
				if(char1 != char2)
				{
					count++;
				}
			}
		}
		
		if(count == 1)
		{
			differentByOne = true;
		}
		return differentByOne;		
	}
	
	public static boolean isWordChain(String[] wordList)
	{
		String[] dictionary = readDictionary();
		boolean validWordChain = true;
		
		if(isUniqueList(wordList))
		{
			for(int i = 0; i < wordList.length; i++)
			{
				if(isEnglishWord(wordList[i], dictionary) == false)
				{
					validWordChain = false;
				}
				if(i <= wordList.length - 2)
				{
					if(isDifferentByOne(wordList[i], wordList[i + 1]) == false)
					{
						validWordChain = false;
					}
				}
			}
		}
		return validWordChain;
	}
	
}
