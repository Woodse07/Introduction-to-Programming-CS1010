import java.util.Scanner;

public class HighScores {
	
	public static void main(String args[])
	{
		int[] scoreBoard = null;
		int index = 0;
		int scoreBoardSize = 0;
		int currentScore = 0;
		int newPlace = 0;
		int currentSize = 0;
		int temp = 0;
		boolean finished = false;
		Scanner inputScanner = new Scanner (System.in);
		
		try
		{
			while(!finished)
			{
				System.out.println("Please enter the amount of scores you would like to maintain >>");
				if (inputScanner.hasNextInt())
				{
					scoreBoardSize = inputScanner.nextInt();
					scoreBoard = new int[scoreBoardSize];			
					System.out.println("Please enter your scores (or enter 'quit') >>");
					while(!finished)
					{	
						if (inputScanner.hasNextInt())
						{
							currentSize++;
							currentScore = inputScanner.nextInt();
							insertScore(newPlace, index, currentScore, currentSize, scoreBoard, temp);	
							printHighScores(index, scoreBoard);
						}
						else if (inputScanner.hasNext("quit"))
						{
							finished = true;
							index = scoreBoard.length;
							System.out.println("Goodbye.");
						}	
						else
						{
							System.out.println("Invalid input.");
							inputScanner.next();
						}

					}			
				}
				else if(inputScanner.hasNext("quit"))
				{
					finished = true;
					System.out.println("Goodbye.");
				}
				else
				{
					System.out.println("Invalid input, please enter a number.");
					inputScanner.next();
				}
			}
			inputScanner.close();
		}
		catch (java.util.InputMismatchException exception)
		{
			inputScanner.nextLine();
		}
		catch (java.lang.ArrayIndexOutOfBoundsException exception)
		{
			System.out.print("Index is out of bounds.");
		}
	}

	public static void initialiseHighScores(int index, int[] scoreBoard)
	{
		for(index = 0; index < scoreBoard.length; index++)
		{
			scoreBoard[index] = 0;
		}
	}
	
	public static void printHighScores(int index, int[] scoreBoard)
	{
		System.out.println("The high scores are: ");
		for(index = 0; index < scoreBoard.length; index++)
		{	
			if (index == (scoreBoard.length - 1))
			{
				System.out.print(scoreBoard[index]);
				System.out.print(".\n");
			}
			else
			{
				System.out.print(scoreBoard[index]);
				System.out.print(", ");
			}
		}
	}
	
	public static boolean higherThan(int index, int currentScore, int[] scoreBoard)
	{
		boolean higher = false;
		for(index = 0; index < scoreBoard.length; index++)
		{
			if (currentScore > scoreBoard[index])
			{
				higher = true;
			}
		}
		
		return (higher);
	}
	
	public static int place(int newPlace, int index, int currentScore, int[] scoreBoard, int temp)
	{
		boolean fin = false;
		for(index = 0; index < scoreBoard.length; index++)
		{
			if (higherThan(index, currentScore, scoreBoard))
			{
				if ((currentScore > scoreBoard[index]) && (!fin))
				{
					fin = true;
					temp = scoreBoard[index];
					newPlace = index;
				}
			}
		}
		
		return newPlace;
	}
	
	public static void insertScore(int newPlace, int index, int currentScore, int currentSize, int[] scoreBoard, int temp)
	{
		if (higherThan(index, currentScore, scoreBoard))
		{
			int current = 0;
			for(index = place(newPlace, index, currentScore, scoreBoard, temp); index < scoreBoard.length; index++)
			{	
				current = scoreBoard[index];
				scoreBoard[index] = currentScore;
				currentScore = current;
			}
		}
		else if(currentSize == scoreBoard.length)
		{
			scoreBoard[scoreBoard.length] = currentScore;
		}
	}
}
