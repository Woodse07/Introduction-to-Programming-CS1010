package squareAges;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class SquareAges {
	
	public static final int MAX_AGE = 123;
	public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	public static final int MIN_YEAR = CURRENT_YEAR - MAX_AGE;
	
	public static void main(String[] args)
	{
		int age = 0;
		for (age = 0; age <= MAX_AGE; age++)
		{
			int year = age*age;
			int yearOfBirth = year - age;
			System.out.println(age + "= " + year + " ");	
			
			if (MIN_YEAR <= (yearOfBirth) && (yearOfBirth) <= CURRENT_YEAR)
			{
				JOptionPane.showMessageDialog(null, "Someone born in the year " + (yearOfBirth) 
														+ " will be alive when their age is"
														+ " the square of the year, "
														+ "and is also alive now. \n Age= " 
														+ age + "\n Year= " + (year));
			}
		}
	}
}
