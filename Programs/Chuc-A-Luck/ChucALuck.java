import java.util.Scanner;

public class ChucALuck {
	
	public static final String TRIPLE = "Triple";
	public static final String FIELD = "Field";
	public static final String HIGH = "High";
	public static final String LOW = "Low";

	public static void main(String[] args)
	{	
		Scanner inputScanner = new Scanner(System.in);
		boolean finished = false;
		boolean finishedBetting = false;
		System.out.println("How much cash do you have?");
		while(!finished)
		{
			if(inputScanner.hasNext())
			{
				if(inputScanner.hasNext("quit") || inputScanner.hasNext("exit"))
				{
					System.out.println("Thanks for playing.");
					finished = true;
				}
				else if(inputScanner.hasNextInt() || inputScanner.hasNextDouble())
				{
					double money = inputScanner.nextDouble();
					double initialMoney = money;
					Wallet wallet = new Wallet();
					wallet.put(money);
					while(!finishedBetting)
					{
						if(wallet.check() == 0)
						{
							System.out.println("You started with " + initialMoney);
							System.out.println("and ended up with " + wallet.check());
							System.out.println("Thanks for playing.");
						}
						System.out.println("What type of bet would you like to place?");
						if(inputScanner.hasNext())
						{
							if(inputScanner.hasNext("quit") || inputScanner.hasNext("exit") || wallet.check() == 0)
							{
								System.out.println("You started with " + initialMoney);
								System.out.println("and ended up with " + wallet.check());
								System.out.println("Thanks for playing.");
								finishedBetting = true;
								finished = true;
							}
							else if(inputScanner.hasNextInt() || inputScanner.hasNextDouble())
							{
								System.out.println("Please enter a String.");
								inputScanner.next();
							}
							else
							{
								String betType = inputScanner.next();
								if(betType.equals(TRIPLE) || betType.equals(FIELD) || betType.equals(HIGH) || betType.equals(LOW))
								{
									System.out.println("Your bet: " + betType);
									resolveBet(betType, wallet);
								}
								else
								{
									System.out.println("Please enter a valid bet.");
								}
							}
						}
					}					
				}
				else
				{
					System.out.print("Please enter an amount of money.");
					inputScanner.next();
				}
			}
		}
		inputScanner.close();
	}
	
	public static void resolveBet(String betType, Wallet wallet)
	{
		Scanner input = new Scanner(System.in);
		boolean finished = false;
		System.out.println(wallet.toString());
		System.out.println("How much cash would you like to bet?");
		while(!finished)
		{
			if(input.hasNext())
			{
				if(input.hasNextInt() || input.hasNextDouble())
				{
					double bet = input.nextDouble();
					if(!wallet.get(bet))
					{
						System.out.println("You don't have that much money.");
					}
					else
					{
						Dice dice1 = new Dice(6);
						Dice dice2 = new Dice(6);
						Dice dice3 = new Dice(6);
						System.out.println(dice1.toString());
						System.out.println(dice2.toString());
						System.out.println(dice3.toString());
						dice1.roll();
						dice2.roll();
						dice3.roll();
						System.out.println("Rolling...");
						System.out.println(dice1.toString());
						System.out.println(dice2.toString());
						System.out.println(dice3.toString());
						
						if(betType.equals(TRIPLE))
						{
							if(dice1.topFace() == dice2.topFace() && dice1.topFace() == dice3.topFace() && dice2.topFace() == dice3.topFace())
							{
								if(dice1.topFace() == 1 || dice1.topFace() == 6)
								{
									System.out.println("You lost.");
									System.out.println(wallet.toString());
									finished = true;
								}
								else
								{
									System.out.println("You won!");
									double winnings = bet * 30;
									wallet.put(winnings);
									System.out.println(wallet.toString());
									finished = true;
								}
							}
							else
							{
								System.out.println("You lost.");
								System.out.println(wallet.toString());
								finished = true;
							}
						}
						else if(betType.equals(FIELD))
						{
							int total = dice1.topFace() + dice2.topFace() + dice3.topFace();
							if(total < 8 || total > 12)
							{
								System.out.println("You won!");
								double winnings = bet + bet;
								wallet.put(winnings);
								System.out.println(wallet.toString());
								finished = true;
							}
							else
							{
								System.out.println("You lost.");
								System.out.println(wallet.toString());
								finished = true;
							}
						}
						else if(betType.equals(HIGH))
						{
							int total = dice1.topFace() + dice2.topFace() + dice3.topFace();
							if(dice1.topFace() == dice2.topFace() && dice1.topFace() == dice3.topFace() && dice2.topFace() == dice3.topFace())
							{
								System.out.println("You lost.");
								System.out.println(wallet.toString());
								finished = true;
							}
							else if(total > 10)
							{
								System.out.println("You won!");
								double winnings = bet + bet;
								wallet.put(winnings);
								System.out.println(wallet.toString());
								finished = true;
							}
							else
							{
								System.out.println("You lost.");
								System.out.println(wallet.toString());
								finished = true;
							}

						}
						else if(betType.equals(LOW))
						{
							int total = dice1.topFace() + dice2.topFace() + dice3.topFace();
							if(dice1.topFace() == dice2.topFace() && dice1.topFace() == dice3.topFace() && dice2.topFace() == dice3.topFace())
							{
								System.out.println("You lost.");
								System.out.println(wallet.toString());
								finished = true;
							}
							else if(total < 11)
							{
								System.out.println("You won!");
								double winnings = bet + bet;
								wallet.put(winnings);
								System.out.println(wallet.toString());
								finished = true;
							}
							else
							{
								System.out.println("You lost.");
								System.out.println(wallet.toString());
								finished = true;
							}
						}
					}
				}
				else
				{
					System.out.println("Please enter an amount of money.");
					input.next();
				}
			}
		}
	}	
}
