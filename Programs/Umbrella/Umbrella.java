package umbrella;

import javax.swing.JOptionPane;

public class Umbrella {
	
	public static void main(String[] args){
		
		int answer = JOptionPane.showConfirmDialog(null, "Does it look like it's going to rain?");
		
		boolean lookRain = (answer == JOptionPane.YES_OPTION);
		
		if (!lookRain)
		{
			JOptionPane.showMessageDialog(null, "Do not take the umbrella.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Take the umbrella.");
			
			int answer2 = JOptionPane.showConfirmDialog(null, "Is it raining?");
			
			boolean isRain = (answer2 == JOptionPane.YES_OPTION);
			
			if (!isRain)
			{
				JOptionPane.showMessageDialog(null, "Do not put up the umbrella.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Put up the umbrella.");
			}		
		}		
	}
}
