import java.util.Scanner;
import java.lang.Math;
import javax.swing.JOptionPane;

public class DayOfTheWeek {
	
	public static final int NUMBER_OF_MONTHS = 12;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final String JANUARY = "January";
	public static final String FEBRUARY = "February";
	public static final String MARCH = "March";
	public static final String APRIL = "April";
	public static final String MAY = "May";
	public static final String JUNE = "June";
	public static final String JULY = "July";
	public static final String AUGUST = "August";
	public static final String SEPTEMBER = "September";
	public static final String OCTOBER = "October";
	public static final String NOVEMBER = "November";
	public static final String DECEMBER = "December";
	public static final String SUNDAY = "Sunday";
	public static final String MONDAY = "Monday";
	public static final String TUESDAY = "Tuesday";
	public static final String WEDNESDAY = "Wednesday";
	public static final String THURSDAY = "Thursday";
	public static final String FRIDAY = "Friday";
	public static final String SATURDAY = "Saturday";
	
	public static void main (String[] args)
	{		
	try
	{
		String input = JOptionPane.showInputDialog("Please enter a date (dd/mm/yyyy)");
		Scanner inputScanner = new Scanner (input);
		inputScanner.useDelimiter("/");
		int day = inputScanner.nextInt();
		int month = inputScanner.nextInt();
		int year = inputScanner.nextInt();
	
		if (validDate( day, month, year)) // Your code.
		{
			JOptionPane.showMessageDialog(null, dayOfTheWeek(day, month, year) + ", " + numEnding(day) + " " + monthName(month) + " " + year );
		}
		else
		{
			JOptionPane.showMessageDialog(null, day + "/" + month + "/" + year + " is not a valid date.");
		}
		inputScanner.close();
	
	}
	catch (NullPointerException exception)
	{	
	}
	catch (java.util.NoSuchElementException exception)
	{
		System.out.println("No number entered.");
	}
	}
	public static boolean validDate( int day, int month, int year) // Your code.
	{
		return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) &&
				(day >= 1) && (day <= daysInMonth( month, year )));
	}
	
	public static int daysInMonth( int month, int year ) // Your code.
	{
		int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case 2:
			numberOfDaysInMonth = isLeapYear( year ) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR :
				                                       DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return numberOfDaysInMonth;
	}
	
	public static boolean isLeapYear( int year ) // Your code.
	{
		return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
	}
	
	public static String numEnding(int day)
	{	
		String numEnd = "";
		if ((day == 11 || day == 12 || day == 13))
		{
			numEnd = (day + "th");
		}
		 else if (day % 10 == 1)
		{
			numEnd = (day + "st");
		}
		else if (day % 10 == 2)
		{
			numEnd = (day + "nd");
		}
		else if (day % 10 == 3)
		{
			numEnd = (day + "rd");
		}
		else
		{
			numEnd = (day + "th");
		}
		return numEnd;
	}
	
	public static String monthName(int month)
	{
		String monthNam = "";
		switch (month)
		{
		case 1:
			monthNam = JANUARY;
			break;
		case 2:
			monthNam = FEBRUARY;
			break;
		case 3:
			monthNam = MARCH;
			break;
		case 4:
			monthNam = APRIL;
			break;
		case 5:
			monthNam = MAY;
			break;
		case 6:
			monthNam = JUNE;
			break;
		case 7:
			monthNam = JULY;
			break;
		case 8: 
			monthNam = AUGUST;
			break;
		case 9:
			monthNam = SEPTEMBER;
			break;
		case 10:
			monthNam = OCTOBER;
			break;
		case 11:
			monthNam = NOVEMBER;
			break;
		case 12:
			monthNam = DECEMBER;
			break;
		default:
			System.out.println("Something went wrong.");
		}
		return monthNam;
	}
	
	public static int firstTwoDigits(int year) // I used this approach to finding the first two and last two digits of the year so I
	{										   // could find the two digits for when the year is more than 4 digits.
		int firstTwo = 0;
		int tempYear = year;
		int count = 0;
		while (tempYear > 10)
		{
			tempYear /= 10;
			count++;
		}
		
		count--;
		double divider = Math.pow(10, count);
		int tempYear2 = year;
		tempYear2 /= divider;
		firstTwo = tempYear2;
		return firstTwo;
	}
	
	public static int lastTwoDigits(int year)
	{
		int lastTwo = 0;
		int tempYear = 0;
		int count = 0;
		while (tempYear > 10)
		{
			tempYear /= 10;
			count++;
		}
		count -= (count - 2);
		double divider = Math.pow(10, count);
		int tempYear2 = year;
		tempYear2 %= divider;
		lastTwo = tempYear2;
		return lastTwo;
	}
	
	public static String dayOfTheWeek(int day, int month, int year)
	{
		if (month == 1 || month == 2)
		{
			 year = year - 1;
		}
		
		String dayOfTheWeek = "";
		int y = lastTwoDigits(year);
		int c = firstTwoDigits(year);
		int w = 0;

		double part1OfGaussian = (Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2 ));
		double part2OfGaussian = (Math.floor(y/4) + Math.floor(c/4) - 2*c);
		double part3OfGaussian = (part1OfGaussian + part2OfGaussian + y + day);
		w = (int)(part3OfGaussian % 7);

		switch (w)
		{
		case 0:
			dayOfTheWeek = SUNDAY;
			break;
		case 1:
			dayOfTheWeek = MONDAY;
			break;
		case 2:
			dayOfTheWeek = TUESDAY;
			break;
		case 3:
			dayOfTheWeek = WEDNESDAY;
			break;
		case 4:
			dayOfTheWeek = THURSDAY;
			break;
		case 5:
			dayOfTheWeek = FRIDAY;
			break;
		case 6:
			dayOfTheWeek = SATURDAY;
			break;
		default:
			System.out.println("Something went wrong.");
		}
		return dayOfTheWeek;
	}
}
