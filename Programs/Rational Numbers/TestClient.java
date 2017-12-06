import java.util.Scanner;	

public class TestClient {

	public static void main(String[] args)
	{
		boolean finished = false;
		Scanner inputScanner = new Scanner(System.in);
		while(!finished)
		{
			
			System.out.println("Please enter two sets of fractions in the from ('a/b c/d') or enter 'quit'.");
			if(inputScanner.hasNext())
			{
				if(inputScanner.hasNext("quit"))
				{
					inputScanner.close();
					System.out.println("Goodbye.");
					finished = true;
				}
							
				else
				{
					String input = inputScanner.nextLine();
					String[] halves = input.split(" ");
					String[] first = halves[0].split("/");
					String[] second = halves[1].split("/");
					
					int firstNumerator = 1;
					int firstDenominator = 1;
					int secondNumerator = 1;
					int secondDenominator = 1;
					Rational fraction1;
					Rational fraction2;
					
					if(first.length == 2)
					{
						firstNumerator = Integer.parseInt(first[0]);
						firstDenominator = Integer.parseInt(first[1]);
					}
					
					if(second.length == 2)
					{
						secondNumerator = Integer.parseInt(second[0]);
						secondDenominator = Integer.parseInt(second[1]);
					}
					
					if(first.length == 2)
					{
						fraction1 = new Rational(firstNumerator, firstDenominator);
					}
					else
					{
						int number = Integer.parseInt(halves[0]);
						fraction1 = new Rational(number);
					}
					
					if(second.length == 2)
					{
						fraction2 = new Rational(secondNumerator, secondDenominator);
					}
					else
					{
						int number = Integer.parseInt(halves[1]);
						fraction2 = new Rational(number);
					}
					
					if(firstDenominator == 0 || secondDenominator == 0)
					{
						System.out.println("You can't divide by zero.");
						inputScanner.nextLine();
					}
					else
					{
						System.out.println("Fraction one: " + fraction1.toString() + "\nFraction two: " + fraction2.toString());
						fraction1.add(fraction2);
						System.out.println("Added: " + fraction1.toString());
						
						fraction1 = new Rational(firstNumerator, firstDenominator);
						fraction2 = new Rational(secondNumerator, secondDenominator);
						fraction1.subtract(fraction2);
						System.out.println("Subtracted: " + fraction1.toString());
						
						fraction1 = new Rational(firstNumerator, firstDenominator);
						fraction2 = new Rational(secondNumerator, secondDenominator);
						fraction1.multiply(fraction2);
						System.out.println("Multiplied: " + fraction1.toString());
						
						fraction1 = new Rational(firstNumerator, firstDenominator);
						fraction2 = new Rational(secondNumerator, secondDenominator);
						fraction1.divide(fraction2);
						System.out.println("Divided: " + fraction1.toString());
						
						fraction1 = new Rational(firstNumerator, firstDenominator);
						fraction2 = new Rational(secondNumerator, secondDenominator);
						System.out.println("Equal: " + fraction1.equals(fraction2));
						
						fraction1 = new Rational(firstNumerator, firstDenominator);
						fraction2 = new Rational(secondNumerator, secondDenominator);
						System.out.println("Less than: " + fraction1.isLessThan(fraction2));
					}
				}
			}		
		}
		inputScanner.close();
	}
}
