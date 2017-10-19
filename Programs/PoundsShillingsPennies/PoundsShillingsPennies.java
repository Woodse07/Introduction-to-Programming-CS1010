package oldSterling;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class oldSterling {
	
	public static final int NEW_PENNIES_PER_OLD_PENNY = 67;
	public static final int PENNIES_PER_SHILLING = 12;
	public static final int SHILLINGS_PER_POUND  = 20;
	public static final int NEW_PENNIES_PER_NEW_POUND = 100;
	
	public static void main (String[] args){
		
		String coinsInput = JOptionPane.showInputDialog("Please enter the amount of old"
																+ " pounds, shillings and"
																+ " pennies respectively, "
																+ "with commas inbetween "
																+ "(Pounds,Shillings,Pennies");
		
		Scanner inputScanner = new Scanner(coinsInput);
		inputScanner.useDelimiter(",");
		
		int oldPounds = inputScanner.nextInt();
		int oldShillings = inputScanner.nextInt();
		int oldPennies = inputScanner.nextInt();
		
		inputScanner.close();
		
		double newPennies = oldPennies * NEW_PENNIES_PER_OLD_PENNY;
		double newPennies2 = oldShillings * PENNIES_PER_SHILLING * NEW_PENNIES_PER_OLD_PENNY; 
		double newPennies3 = oldPounds * SHILLINGS_PER_POUND * PENNIES_PER_SHILLING * NEW_PENNIES_PER_OLD_PENNY;
		
		double totalPound = (newPennies + newPennies2 + newPennies3) / NEW_PENNIES_PER_NEW_POUND;
		
		JOptionPane.showMessageDialog(null, oldPounds + " Old pounds, " + oldShillings + 
																" Old shillings and " + oldPennies +
																" Old pence, is equal to = £" + 
																totalPound + ".");
	}

}
