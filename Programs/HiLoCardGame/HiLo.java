import java.util.Scanner;
import java.util.Random;

public class HiLo {
	
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	public static void main (String[] args)
	{
		Scanner inputScanner = new Scanner(System.in);
		Random generator = new Random();
		int total = 0;
		int card = 0;
		int nextCard = generator.nextInt(KING) + 1;
		boolean finished = false;
	
		while (!finished)
		{
			card = nextCard;
			nextCard = generator.nextInt(KING) + 1;
			
			if (card == ACE)
			{
				System.out.println("The card is: Ace");
			}
			else if (card == JACK)
			{
				System.out.println("The card is: Jack");
			}
			else if (card == QUEEN)
			{
				System.out.println("The card is: Queen");
			}
			else if (card == KING)
			{
				System.out.println("The card is: King");
			}
			else
			{
			System.out.println("The card is: " + card);
			}
			
			System.out.println("Do you think the next card will be higher, lower or equal?");
			
			if (inputScanner.hasNext("higher") || inputScanner.hasNext("Higher"))
			{
				if (nextCard > card)
				{
					total++;
					System.out.println("Correct.");
					inputScanner.next();
				}	
				else
				{
					total = 0;
					System.out.println("Incorrect");
					inputScanner.next();
				}
			}
			else if (inputScanner.hasNext("lower") || inputScanner.hasNext("Lower"))
			{
				if (nextCard < card)
				{
					total++;
					System.out.println("Correct.");
					inputScanner.next();
				}
				else
				{
					total = 0;
					System.out.println("Incorrect");
					inputScanner.next();
				}
			}
			else if (inputScanner.hasNext("equal") || inputScanner.hasNext("Equal"))
			{
				if (nextCard == card)
				{
					total++;
					System.out.println("Correct.");
					inputScanner.next();
				}
				else
				{
					total = 0;
					System.out.println("Incorrect.");
					inputScanner.next();
				}
			}
			else if (inputScanner.hasNext("exit") || (inputScanner.hasNext("quit")))
			{
				System.out.println("Goodbye.");
				finished = true;
			}
			else
			{
				System.out.println("Invalid input. Try again.");
				inputScanner.next();
			}
				
			if (total == 4)
			{
				System.out.println("Congratulations! You won!");
				finished = true;
			}
			System.out.println("Current score: " + total);
		}
		inputScanner.close();	
	}
}
