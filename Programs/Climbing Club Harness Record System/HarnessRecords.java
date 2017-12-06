import java.util.ArrayList;

public class HarnessRecords {
	
	private boolean isEmpty = true;
	private ArrayList<Harness> harnessValues = new ArrayList<Harness>();
	
	public HarnessRecords()
	{

		this.harnessValues = new ArrayList<Harness>();
		
	}
	
	public HarnessRecords(String[] input)
	{
		
		this.harnessValues = new ArrayList<Harness>();
		boolean old = true;
		for(int i = 0; i < input.length; i++)
		{
			String[] parameters = input[i].split(",");
			if(parameters.length == 3)
			{
				old = false;
			}
			else if(parameters.length == 6)
			{
				old = true;
			}
			
			if(!old)
			{
				String make = parameters[0];
				int modelNumber = Integer.parseInt(parameters[1]);
				String climbingInstructor = parameters[2];
				Harness newHarness = new Harness(make, modelNumber, climbingInstructor);
				harnessValues.add(newHarness);
			}
			else if(old)
			{
				String make = parameters[0];
				int modelNumber = Integer.parseInt(parameters[1]);
				int numOfTimesUsed = Integer.parseInt(parameters[2]);
				String climbingInstructor = parameters[3];
				boolean onLoan = false;
				if(parameters[4].equals("True"))
				{
					onLoan = true;
				}
				else if(parameters[4].equals("False"))
				{
					onLoan = false;
				}
				String clubMember = parameters[5];
				Harness newHarness = new Harness(make, modelNumber, numOfTimesUsed, climbingInstructor, onLoan, clubMember);
				harnessValues.add(newHarness);
			}
		}
		
	}
	
	public boolean isEmpty()
	{
		boolean found = false;
		for(int i = 0; i < harnessValues.size(); i++)
		{
			if(harnessValues.get(i) != null && !found)
			{
				isEmpty = false;
				found = true;
			}
		}
		
		return isEmpty;
	}
	
	public void addHarness(Harness newHarness)
	{
		
		harnessValues.add(newHarness);
		System.out.println("Harness Added!");
		
	}
	
	public Harness findHarness(String make, int modelNumber)
	{
		
		for(int i = 0; i < harnessValues.size(); i++)
		{
			if(harnessValues.get(i).make.equals(make))
			{
				if(harnessValues.get(i).modelNumber == modelNumber)
				{
					return harnessValues.get(i);
				}
			}
		}
		return null;
	}	
	
	public Harness checkHarness(String climbingInstructor, String make, int modelNumber)
	{
		
		if(findHarness(make, modelNumber) != null)
		{
			Harness currentHarness = findHarness(make, modelNumber);
			if(currentHarness.isHarnessOnLoan() == false)
			{
				currentHarness.checkHarness(climbingInstructor);
				System.out.println("Harness Checked!");
				return currentHarness;
			}
			else if(currentHarness.isHarnessOnLoan() == true)
			{
				System.out.println("Can't check the harness if it's on loan.");
			}
		}
		System.out.println("Harness doesn't exit.");
		return null;	
	}
	
	public Harness loanHarness(String clubMember)
	{
		boolean found = false;
		for(int i = 0; i < harnessValues.size(); i++)
		{
			if(harnessValues.get(i).canHarnessBeLoaned() == true && !found)
			{
				harnessValues.get(i).loanHarness(clubMember);
				found = true;
				System.out.println("Harness Loaned!");
				return harnessValues.get(i);
			}
			else
			{
				System.out.println("Harness is already on loan or doesn't exist.");
			}
		}
		return null;		
	}
	
	public Harness returnHarness(String make, int modelNumber)
	{
		
		if(findHarness(make, modelNumber) != null)
		{
			Harness currentHarness = findHarness(make, modelNumber);
			if(currentHarness.isHarnessOnLoan() == true)
			{
				currentHarness.returnHarness();
				System.out.println("Harness returned!");
				return currentHarness;
			}
			else
			{
				System.out.println("This harness isn't on loan.");
			}
		}
		return null;	
	}
	
	public Harness removeHarness(String make, int modelNumber)
	{
		
		if(findHarness(make, modelNumber) != null)
		{
			Harness currentHarness = findHarness(make, modelNumber);
			harnessValues.remove(currentHarness);
			System.out.println("Harness Removed!");
			return currentHarness;
		}
		else
		{
			System.out.println("This harness doesn't exist.");
		}
		return null;
	}
	
	public String toString()
	{
		String harnessList = "";
		for(int i = 0; i < harnessValues.size(); i++)
		{
			harnessList += harnessValues.get(i).toString() + "\n";
		}
		return(harnessList);
	}
}
