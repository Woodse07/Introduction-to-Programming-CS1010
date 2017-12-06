import java.util.Scanner;

public class testClientClimbing {

	public static void main(String[] args)
	{
		
		In inputStream = new In("harness.txt");
		String inputString = inputStream.readAll();
		String[] input = inputString.split("\\s*\r?\n");
		HarnessRecords record = new HarnessRecords(input);
		Scanner inputScanner = new Scanner(System.in);
		boolean finished = false;
		String options = "\n1) Add a newly purchased harness \n2) Remove a climbing harness from the club \n3) Record a safety check "
				+ "\n4) Loan a harness to a club member \n5) Return a harness that was on loan \n6)List current record of harnesses"
				+ " \n(or type help or quit)";
		
		System.out.println("Hi! Please select one of the following options " + options);
		while(!finished)
		{
			if(inputScanner.hasNext())
			{
				if(inputScanner.hasNext("quit") || inputScanner.hasNext("exit"))
				{
					System.out.println("Goodbye");
					finished = true;
					inputScanner.close();
				}
				else if(inputScanner.hasNext("help"))
				{
					System.out.println(options);
					inputScanner.nextLine();
				}
				else if(inputScanner.hasNextInt())
				{
					int optionChosen = inputScanner.nextInt();
					String make;
					int modelNumber;
					String climbingInstructor;
					String clubMember;
					switch(optionChosen)
					{
					case 1:
						System.out.println("Please enter the make, model number and the name of the climbing instructor that"
								+ " last checked the safety of the harness you would like to add. \n\nMake: ");
						make = inputScanner.next();
						System.out.println("Model Number: ");
						modelNumber = inputScanner.nextInt();
						System.out.println("Climbing Instructor: ");
						climbingInstructor = inputScanner.next();
						Harness newHarness = new Harness(make, modelNumber, climbingInstructor);
						record.addHarness(newHarness);
						inputScanner.nextLine();
						break;
					
					case 2:
						System.out.println("Please enter the make and model number of the harness you would like to remove.\n\nMake: ");
						make = inputScanner.next();
						System.out.println("Model Number: ");
						modelNumber = inputScanner.nextInt();
						record.removeHarness(make, modelNumber);
						inputScanner.nextLine();
						break;
					
					case 3:
						System.out.println("Please enter the make, model number and the name of the climbing instructor that"
								+ " will check the safety of the harness you would like to check. \n\nMake: ");
						make = inputScanner.next();
						System.out.println("Model Number: ");
						modelNumber = inputScanner.nextInt();
						System.out.println("Climbing instructor: ");
						climbingInstructor = inputScanner.next();
						record.checkHarness(climbingInstructor, make, modelNumber);
						inputScanner.nextLine();
						break;
						
					case 4:
						System.out.println("Please enter the name of a club member you would like to loan a harness to. \n\nCLub Member: ");
						clubMember = inputScanner.next();
						record.loanHarness(clubMember);
						inputScanner.nextLine();
						break;
						
					case 5:
						System.out.println("Please enter the make and model number of the harness you would like to return. \n\nMake:");
						make = inputScanner.next();
						System.out.println("Model Number: ");
						modelNumber = inputScanner.nextInt();
						record.returnHarness(make, modelNumber);
						inputScanner.nextLine();
						break;
						
					case 6:
						System.out.println(record.toString());
						inputScanner.nextLine();
						break;
						
					default:
						System.out.println("Invalid input. Please enter a number between 1-6");
						inputScanner.nextLine();
					}
				}
				else
				{
					System.out.println("Invalid input. Please choose an option, or type help or quit.");
					inputScanner.nextLine();
				}
				
			}
		}
		
	}
	
}
