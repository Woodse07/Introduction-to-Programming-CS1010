
public class Connect4Grid2DArray implements Connect4Grid {
	
	private static final int ROWS = 6;
	private static final int COLUMNS = 7;
	public char[][] gridArray = new char[ROWS][COLUMNS];
	
	public void emptyGrid()
	{		
		for(int i = 0; i < gridArray.length; i++)
		{
			for(int j = 0; j < gridArray[0].length; j++)
			{
				gridArray[i][j] = ' ';
			}
		}		
	}
	
	
	public String toString()
	{
		String grid = "";
		for(int i = 0; i < gridArray.length + 2; i++)
		{
			for(int j = 0; j < gridArray[0].length; j++)
			{
				if(i == 7)
				{
					if(j == 0)
						grid += (" 1");
					else if(j == 1)
						grid += (" 2");
					else if(j == 2)
						grid += (" 3");
					else if(j == 3)
						grid += (" 4");
					else if(j == 4)
						grid += (" 5");
					else if(j == 5)
						grid += (" 6");
					else if(j == 6)
						grid += (" 7");
				}
				else if(i == 6)
				{
					if(j == 6)
						grid += ("---\n");
					else
					grid += ("--");
				}
				else
				{
					if(j == 0)
						grid += ("|" + gridArray[i][j] + "|");
					else if(j == 6)
						grid += (gridArray[i][j] + "|\n");
					else
						grid += (gridArray[i][j] + "|");
				}
			}
		}
		return grid;
	}
	
	
	public boolean isValidColumn(int column)
	{
		boolean isValid = false;
		for(int i = gridArray.length - 1; i >= 0; i--)
		{
			if(gridArray[i][column - 1] == ' ')
				isValid = true;
		}
		return isValid;
	}
	
	
	public boolean isColumnFull(int column)
	{	
		boolean isFull = true;
		for(int i = gridArray.length - 1; i >= 0; i--)
		{
			if(gridArray[i][column - 1] == ' ')
				isFull = false;
		}
		return isFull;		
	}
	
	
	public void dropPiece(ConnectPlayer player, int column)
	{	
		boolean pieceDropped = false;
		if(isValidColumn(column) && !isColumnFull(column))
		{
			for(int i = gridArray.length - 1; i >= 0; i--)
				if(!pieceDropped)
				{
					if(gridArray[i][column - 1] == ' ')
					{
						gridArray[i][column - 1] = player.getCounter();
						pieceDropped = true;
					}
				}	
		}
		else
			System.out.println("Invalid move.");
	}
	
	
	public boolean didLastPieceConnect4()
	{
		boolean win = false;	
		for(int i = 0; i < gridArray.length; i++)
		{
			for(int j = 0; j < gridArray.length; j++)
			{
				if(gridArray[i][j] != ' ')
				{
				//vertical check
					if(i <= gridArray.length - 4)
						if(gridArray[i][j] == gridArray[i + 1][j])
							if(gridArray[i][j] == gridArray[i + 2][j])
								if(gridArray[i][j] == gridArray[i + 3][j])
								{
										win = true;
										return win;
								}				
					//horizontal check
					if(j <= gridArray[0].length - 4)
						if(gridArray[i][j] == gridArray[i][j + 1])
							if(gridArray[i][j] == gridArray[i][j + 2])
								if(gridArray[i][j] == gridArray[i][j + 3])
								{
									win = true;
									return win;
								}
					//diagonal down check
					if(i <= gridArray.length - 4 && j <= gridArray[0].length - 4)
						if(gridArray[i][j] == gridArray[i + 1][j + 1])
							if(gridArray[i][j] == gridArray[i + 2][j + 2])
								if(gridArray[i][j] == gridArray[i + 3][j + 3])
								{
									win = true;
									return win;
								}	
					//diagonal up check
					if(i >= 4 && j <= gridArray[0].length - 4)
						if(gridArray[i][j] == gridArray[i - 1][j + 1])
							if(gridArray[i][j] == gridArray[i - 2][j + 2])
								if(gridArray[i][j] == gridArray[i - 3][j + 3])
								{
									win = true;
									return win;
								}
				}
			}
		}	
		return win;
	}
	
	
	public boolean isGridFull()
	{
		boolean gridFull = true;
		for(int i = 0; i < gridArray.length; i++)
		{
			for(int j = 0; j < gridArray[0].length; j++)
			{
				if(gridArray[i][j] == ' ')
				{
					gridFull = false;
				}
			}
		}
		return gridFull;
	}

}
