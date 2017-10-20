package triangularStar;

public class triangularStar {
	
	public static void main(String args[])
	{
		
		long starNum = 1;
		long triangleNum = 1;
		
		while ((determineStarNumber(starNum) < Integer.MAX_VALUE) && (determineTriangleNumber(triangleNum) < Integer.MAX_VALUE))
		{
			if (isStarNumber(triangleNum, starNum))
			{
				System.out.println("Mutual: " + determineStarNumber(starNum));
				if (determineStarNumber(starNum) <= determineTriangleNumber(triangleNum))
				{
					starNum++;
				}
				else
				{
					triangleNum++;
				}
			}
			else if (determineStarNumber(starNum) <= determineTriangleNumber(triangleNum))
			{
				starNum++;
			}
			else
			{
				triangleNum++;
			}
		}
		
	}
	
	public static long determineStarNumber(long starNum)
	{
		long starNumber = (6 * starNum) * (starNum - 1) + 1;
		return starNumber;
	}
	
	public static long determineTriangleNumber(long triangleNum)
	{
		long triangleNumber = (triangleNum * (triangleNum + 1)) / 2;
		return triangleNumber;
	}
	
	public static boolean isStarNumber(long triangleNum, long starNum)
	{
		return(determineStarNumber(starNum) == determineTriangleNumber(triangleNum));
	}
}
