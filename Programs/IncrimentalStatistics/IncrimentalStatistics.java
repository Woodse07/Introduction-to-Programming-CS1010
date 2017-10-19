import java.util.Scanner;

public class AverageAndVariance {
	
	public static void main (String[] args)
	{
		System.out.println("This program computes the average and variance of all numbers entered. ");
		Scanner inputScanner = new Scanner (System.in);
		boolean finished = false;
		double numCount = 0.0;
		double average = 0.0;
		double variance = 0.0;	
		System.out.println("Enter a number (or type 'exit'): ");
		
		while (!finished)
		{		
			if (inputScanner.hasNextDouble())
			{	
				numCount++;
				double currentNum = inputScanner.nextDouble();
				average = (average) + (currentNum - average) / numCount;
				double prevAverage = ((average * numCount) - currentNum) / (numCount - 1);
				
				if (numCount > 1)
				{
					variance = ((variance * (numCount - 1)) + (currentNum - prevAverage) 
							* (currentNum - average)) / numCount;
				}
				System.out.println("So far the average is: " + average + " and the variance is: " + variance);
				System.out.println("Enter another number (or type 'exit'): ");
			}
			else if (inputScanner.hasNext("exit") || inputScanner.hasNext("quit"))
			{
				finished = true;
				System.out.println("Goodbye.");
			}
			else
			{
				System.out.println("Invalid input.");
				inputScanner.next();
			}
		}
		inputScanner.close();
	}
}
