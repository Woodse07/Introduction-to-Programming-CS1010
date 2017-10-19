
public class TwelveDays {
	
	public static final String SECOND_LINE = "Two Turtle Doves";
	public static final String THIRD_LINE = "Three French Hens";
	public static final String FOURTH_LINE = "Four Calling Birds";
	public static final String FIFTH_LINE = "Five Golden Rings";
	public static final String SIXTH_LINE = "Six Geese a Laying";
	public static final String SEVENTH_LINE = "Seven Swans a Swimming";
	public static final String EIGHTH_LINE = "Eight Maids a Milking";
	public static final String NINETH_LINE = "Nine Ladies Dancing";
	public static final String TENTH_LINE = "Ten Lords a Leaping";
	public static final String ELEVENTH_LINE = "Eleven Pipers Piping";
	public static final String TWELVTH_LINE = "Twelve Drummers Drumming";
	
	public static void main(String[] args)
	{
		String firstLine = "A Partridge in a Pear Tree.\n";
		String num = "first";
		String verse = "";
		int lineNum = 1;
		
		for(lineNum = 1; lineNum < 12; lineNum ++)
		{
			if (lineNum > 1)
			{
				firstLine = "And a partrige in a pear tree.\n";
			}
			
			String mainLine = "On the " + num + " day of Christmas\nmy true love gave to me: ";
			System.out.println(mainLine);
			
			switch (lineNum)
			{
			case 2:
				num = "second";
				break;
			
			case 3:
				num = "third";
				break;
			
			case 4:
				num = "fourth";
				break;
			
			case 5:
				num = "fifth";
				break;
			
			case 6:
				num = "sixth";
				break;
			
			case 7:
				num = "seventh";
				break;
			
			case 8:
				num = "eighth";
				break;
			
			case 9:			
				num = "nineth";
				break;
			
			case 10:
				num = "tenth";
				break;
			
			case 11:
				num = "eleventh";
				break;
			
			case 12:
				num = "twelvth";
				break;	
			}
			
			switch (lineNum)
			{
			case 12:
				verse = TWELVTH_LINE;
				System.out.println(verse);
			
			case 11:
				verse = ELEVENTH_LINE;	
				System.out.println(verse);
				
			case 10:
				verse = TENTH_LINE;
				System.out.println(verse);
			
			case 9:
				verse = NINETH_LINE;	
				System.out.println(verse);
			
			case 8:
				verse = EIGHTH_LINE;	
				System.out.println(verse);
			
			case 7:
				verse = SEVENTH_LINE;
				System.out.println(verse);
			
			case 6:
				verse = SIXTH_LINE;	
				System.out.println(verse);
			
			case 5:
				verse = FIFTH_LINE;	
				System.out.println(verse);
			
			case 4:			
				verse = FOURTH_LINE;	
				System.out.println(verse);
			
			case 3:
				verse = THIRD_LINE;
				System.out.println(verse);
			
			case 2:
				verse = SECOND_LINE;	
				System.out.println(verse);
			}
			
			System.out.println(firstLine);
		}
	}
}
