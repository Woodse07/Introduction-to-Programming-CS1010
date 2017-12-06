import java.util.Scanner;

public class Connect4Game {
	
	public static void main(String[] args)
	{
		
		Scanner inputScanner = new Scanner(System.in);
		String option = "";
		ConnectPlayer player1 = null;
		ConnectPlayer player2 = null;
		final char player1Counter = 'x';
		final char player2Counter = 'o';
		boolean finished = false;
		
		System.out.println("Welcome to Connect Four! \n(Players can either be (1)Human or (2)Ai) \nPlease enter the type of \nPlayer 1:");
		if(inputScanner.hasNext())
		{
			if(inputScanner.hasNextInt())
			{
				boolean chosen = false;
				while(!chosen)
				{
					int optionChosen = inputScanner.nextInt();
					if(optionChosen == 1)
					{
						option = "Human";
						chosen = true;
						player1 = new C4HumanPlayer(player1Counter);
						inputScanner.nextLine();
					}
					else if(optionChosen == 2)
					{
						option = "Ai";
						chosen = true;
						player1 = new C4RandomAIPlayer(player1Counter);
						inputScanner.nextLine();
					}
					else
					{
						System.out.println("Please enter a valid option.");
						inputScanner.nextLine();
					}
				}
				
				System.out.println(option);
			}
			
			System.out.println("\nPlayer 2:");
			boolean chosen2 = false;
			while(!chosen2)
			{
				int optionChosen2 = inputScanner.nextInt();
				if(optionChosen2 == 1)
				{
					option = "Human";
					inputScanner.nextLine();
					chosen2 = true;
					player2 = new C4HumanPlayer(player2Counter);
				}
				else if(optionChosen2 == 2)
				{
					option = "Ai";
					inputScanner.nextLine();
					chosen2 = true;
					player2 = new C4RandomAIPlayer(player2Counter);
				}
				else
				{
					System.out.println("Please enter a valid option.");
					inputScanner.nextLine();
				}
			}
			System.out.println(option);
		}
		Connect4Grid2DArray connect4 = new Connect4Grid2DArray();
		connect4.emptyGrid();
		System.out.println(connect4.toString());
		int columnChosen;
		while(!finished)
		{
			if(connect4.didLastPieceConnect4() || connect4.isGridFull())
			{
				finished = true;
			}
			columnChosen = player1.pickColumn();
			connect4.dropPiece(player1, columnChosen);
			System.out.println(connect4.toString());
			if(connect4.didLastPieceConnect4())
			{
				System.out.println("Player1 Wins!");
				finished = true;
			}
			if(connect4.isGridFull())
			{
				System.out.println("Tie!");
				finished = true;
			}
			if(!finished)
			{
				columnChosen = player2.pickColumn();
				connect4.dropPiece(player2, columnChosen);
				System.out.println(connect4.toString());
				if(connect4.didLastPieceConnect4())
				{
					System.out.println("Player2 Wins!");
					finished = true;
				}
				if(connect4.isGridFull())
				{
					System.out.println("Tie!");
					finished = true;
				}
			}
		}
		
		inputScanner.close();
	}
	
}
