import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.lang.Math;
import java.util.Random;

public class SieveOfErathosthenesVisual {
	
	public static void main(String[] args)
	{
		Scanner inputScanner = new Scanner(System.in);
		boolean finished = false;
		StdDraw.setCanvasSize(1000, 800);
		StdDraw.setPenColor(StdDraw.BLACK);
		Font arial_italic_xpt = new Font("Arial", Font.ITALIC, 20);
	    StdDraw.setFont(arial_italic_xpt);
	    StdDraw.text(0.8, 0.95, "Prime Numbers");
	
		System.out.println("Please enter the number you would like prime numbers up to: ");
		
		while(!finished)
		{
			if(inputScanner.hasNext())
			{
				if(inputScanner.hasNextInt())
				{
					long startTime = System.nanoTime();
					int N = inputScanner.nextInt();		
					sieve(N);
					long endTime = System.nanoTime();
					double timeInSeconds = (double)(endTime - startTime) / 1000000000;
					System.out.println("Time taken: " + (timeInSeconds));
				}
				else if(inputScanner.hasNext("quit") || inputScanner.hasNext("exit"))
				{
					System.out.println("Goodbye.");
					inputScanner.close();
					finished = true;
				}
				else
				{
					System.out.println("Invalid input. Please enter an integer.");
					inputScanner.next();
				}
			}
		}
		
	}
	
	public static boolean[] createSequence(int N)
	{
		
		boolean[] sequence = new boolean[N - 1];
		
		for(int i = 0; i < sequence.length; i++)
		{
			sequence[i] = false;
		}
		
		return sequence;
		
	}
	
	public static boolean[] crossOutHigherMultiples(boolean[] sequence, int n)
	{
		if(sequence[n - 2] != true)
		{
			int step = n;
			for(n = n + n; n < sequence.length + 2; n += step)
			{
				sequence[n - 2] = true;
			}
		}
		
		return sequence;
	}
	
	public static boolean[] sieve(int N)
	{	
		boolean[] sequence = createSequence(N);
		int prime_count = 0;

		if(N >= 2)
		{
			int n = 2;
			displayNumbers2ToN(N);
			for(int i = 0; i < sequence.length; i++)
			{
				if(sequence[i] != true)
				{
					prime_count++;
					displayPrime((i + 2), prime_count);
					if(n <= Math.sqrt(N))
					{
						System.out.println(sequenceToString(sequence));
						crossOutHigherMultiples(sequence, n);
						displayComposite(((i + 2) * 2), (prime_count), N);
					}
					n++;						
				}
			}
			System.out.println(sequenceToString(sequence));
			System.out.println(nonCrossedOutSubseqToString(sequence));
		}
		
		return sequence;		
	}
	
	public static String sequenceToString(boolean[] sequence)
	{
		String sequenceString = "";

		for(int i = 0; i < sequence.length; i++)
		{
			if(sequence[i] == false && i == sequence.length - 1)
			{
				sequenceString += ("" + (i + 2)) + ".";
			}
			else if(sequence[i] == true && i == sequence.length - 1)
			{
				sequenceString += "[" + ("" + (i + 2)) + "]" + ".";
			}
			else if(sequence[i] == false)
			{
				sequenceString += ("" + (i + 2)) + ", ";
			}
			else if(sequence[i] == true)
			{
				sequenceString += "[" + ("" + (i + 2)) + "]" + ", ";
			}
		}
		
		return sequenceString;
		
	}
	
	public static String nonCrossedOutSubseqToString(boolean[] sequence)
	{
		String primeNumbers = "";
		int lastPrime = 0;
		for(int i = 0; i < sequence.length; i++)
		{
			if (sequence[i] == false)
			{
				lastPrime = i;
			}
		}
		
		for(int i = 0; i < sequence.length; i++)
		{
			if(sequence[i] == false && i == lastPrime)
			{
				primeNumbers += ("" + (i + 2) + ".");
			}
			else if(sequence[i] == false)
			{
				primeNumbers += ("" + (i + 2) + ", ");
			}
		}
		
		return primeNumbers;
	}
	
	public static void displayNumber(int n, Color c, int N)
	{
		StdDraw.setPenColor(c);
		int columnsRows = (int)Math.sqrt(N);
		double sides = 10 / (double)N;
		double xpos = 0.025;
		double ypos = 0.975;
		int fontSize = 22;
		
		while((sides * 2) * columnsRows >= 0.55)
		{
			sides -= 0.0001;
		}
		
		while(fontSize > sides * 1000)
		{
			fontSize -= 5;
		}
		

		if(n >= columnsRows + 2)
		{
			int stepY1 = (int)((n - 2)/ columnsRows);
			int stepX1 = (int)((n - 2) % columnsRows);		
			double stepY = ((stepY1) * (sides + sides + 0.005));
			double stepX = ((stepX1) * (sides + sides + 0.005));
			ypos -= stepY;
			xpos += stepX;
		}
		else
		{
			xpos += ((n - 2) * (sides + sides + 0.005));
		}
		
		
		Font arial_italic_xpt = new Font("Arial", Font.ITALIC, fontSize);
	    StdDraw.setFont(arial_italic_xpt);

	    String number = "" + (n);
		n++;
		StdDraw.setPenColor(c);
		StdDraw.filledSquare(xpos, ypos, sides);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(xpos, ypos, number);
	}
	
	public static void displayNumbers2ToN(int N)
	{		
		Color c = StdDraw.GRAY;
		int n = 2;
		for(int index = 0; index < N - 1; index++)
		{
			displayNumber(n, c, N);
			n++;
		}
	}
	
	public static void displayComposite(int m, int prime_count, int N)
	{
//		Random generator = new Random();
//		int randomR = generator.nextInt(255);
//		int randomG = generator.nextInt(255);
//		int randomB = generator.nextInt(255);
		Color[] compositeColorArray = new Color[100];
		Color compositeColor;
		int r = 50;
		int g = 0;
		int b = 250;
		
		for(int i = 0; i < compositeColorArray.length; i++)
		{
			compositeColorArray[i] = new Color(r, g, b);
			r += 30;
			g += 70;
			b += 100;
			if(r > 255) r = r - 255;
			if(g > 255) g = g - 255;
			if(b > 255) b = b - 255;
		}
		
		int composite = m;
		int lastPrime = composite / 2;
		int possiblePrime = 2;
		int prime;
		boolean nextLoop;
		
		for(int i = composite; i <= N; i += lastPrime)
		{
			nextLoop = false;
			possiblePrime = 2;
			while(!nextLoop)
			{
				if(i % possiblePrime == 0)
				{
					prime = possiblePrime;
					compositeColor = compositeColorArray[prime - 2];
					displayNumber(i , compositeColor, N);
					nextLoop = true;
				}
				else
				{
					possiblePrime++;
				}
			}
			
		}
		
		try 
		{
		    Thread.sleep(50);                
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	public static void displayPrime(int p, int prime_count)
	{
		StdDraw.setPenColor(StdDraw.BLACK);
		Font arial_italic_xpt = new Font("Arial", Font.ITALIC, 15);
	    StdDraw.setFont(arial_italic_xpt);
	    int rowSize = 5;
	    double xpos = 0.7;
	    double ypos = 0.9;
	    
	    if(prime_count > 5)
		{
			int stepY1 = (int)((prime_count - 1) / rowSize);
			int stepX1 = (int)((prime_count - 1) % rowSize);		
			double stepY = ((stepY1) * (0.05));
			double stepX = ((stepX1) * (0.05));
			ypos -= stepY;
			xpos += stepX;
		}
		else
		{
			xpos += ((prime_count - 1) * (0.05));
		}
	    
	    String primeNumber = "" + p;
	    StdDraw.text(xpos, ypos, primeNumber);
	    
	    try 
		{
		    Thread.sleep(50);                
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	    
	}
}
