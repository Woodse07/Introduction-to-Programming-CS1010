
public abstract class ConnectPlayer {
	private char counter = ' ';
	
	ConnectPlayer(char counter)
	{
		this.counter = counter;
	}
	
	public char getCounter()
	{
		return counter;
	}
	
	public abstract int pickColumn();
}
