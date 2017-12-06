import java.util.Random;
import java.util.Scanner;

public class C4RandomAIPlayer extends ConnectPlayer {

	Scanner inputScanner = new Scanner(System.in);
	private int column;
	private boolean columnFound = false;
	C4RandomAIPlayer(char counter) 
	{
		super(counter);
	}
	
	public int pickColumn()
	{
		columnFound = false;
		while(!columnFound)
		{
			Random generator = new Random();
			column = generator.nextInt(7) + 1;
			columnFound = true;
		}
		return column;
	}

}
