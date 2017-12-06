import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {

	Scanner inputScanner = new Scanner(System.in);
	private int column;
	C4HumanPlayer(char counter)
	{
		super(counter);
	}
	
	public int pickColumn()
	{
		System.out.println("Pick a column...");
		column = inputScanner.nextInt();
		inputScanner.nextLine();
		return column;
	}

}
