
public class Harness {
	
	public final String make;
	public final int modelNumber;
	private int numOfTimesUsed = 0;
	private String climbingInstructor = "";
	private boolean onLoan = false;
	private String clubMember = "";

	public Harness(String make, int modelNumber, int numOfTimesUsed, String climbingInstructor, boolean onLoan, String clubMember)
	{
		
		this.make = make;
		this.modelNumber = modelNumber;
		this.numOfTimesUsed = numOfTimesUsed;
		this.climbingInstructor = climbingInstructor;
		this.onLoan = onLoan;
		this.clubMember = clubMember;
		
	}
	
	public Harness(String make, int modelNumber, String climbingInstructor)
	{
		
		this.make = make;
		this.modelNumber = modelNumber;
		this.climbingInstructor = climbingInstructor;
		this.numOfTimesUsed = 0;
		this.clubMember = "None";
		this.onLoan = false;
		
	}
	
	public void checkHarness(String climbingInstructor)
	{
		
		if(!onLoan)
		{		
			this.climbingInstructor = climbingInstructor;
			this.numOfTimesUsed = 0;			
		}
		else
		{
			System.out.println("This harness is out on loan.");
		}
		
	}
	
	public boolean isHarnessOnLoan()
	{
		
		return(onLoan);
		
	}
	
	public boolean canHarnessBeLoaned()
	{
		
		return(!onLoan);
		
	}
	
	public void loanHarness(String clubMember)
	{
		
		if(canHarnessBeLoaned())
		{
			onLoan = true;
			this.clubMember = clubMember;
		}
		
	}
	
	public void returnHarness()
	{
		if(onLoan)
		{
			this.onLoan = false;
			this.clubMember = "None";
		}
		else
		{
			System.out.println("This harness is not out on loan.");
		}
		
	}
	
	public String toString()
	{
		
		String harnessString = ("Make: " + make + "\nModel Number: " + modelNumber + "\nNumber of times used: " + numOfTimesUsed +
						"\nClimbing Instructor: " + climbingInstructor + "\nOn Loan: " + onLoan + "\nClub Member: " + clubMember + "\n");
		
		return harnessString;
		
	}
}
