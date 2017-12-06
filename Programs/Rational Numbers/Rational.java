import java.math.BigInteger;

public class Rational {

	private double rationalNumber;
	private int numerator;
	private int denominator;

	Rational(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
		if(this.denominator < 0)
		{
			this.numerator *= -1;
			this.denominator *= -1;
		}
		else if(this.denominator == 0)
		{
			throw new IllegalArgumentException("The denominator can't be zero.");
		}
		rationalNumber = (double)numerator / denominator;
		
	}
	
	Rational(int numerator)
	{
		this.numerator = numerator;
		this.denominator = 1;
		rationalNumber = (double)numerator / denominator;
		
	}
	
	public Rational add(Rational rationalValue)
	{
		int numerator = this.numerator;
		int denominator = this.denominator;
		int newNumerator1 = numerator * rationalValue.denominator;
		this.denominator = denominator * rationalValue.denominator;
		int newNumerator2 = rationalValue.numerator * denominator;
		this.numerator = newNumerator1 + newNumerator2;
		simplify();
		Rational fraction = new Rational(this.numerator, this.denominator);
		return fraction;
		
	}
	
	public Rational subtract(Rational rationalValue)
	{
		int numerator = this.numerator;
		int denominator = this.denominator;
		int newNumerator1 = numerator * rationalValue.denominator;
		this.denominator = denominator * rationalValue.denominator;
		int newNumerator2 = rationalValue.numerator * denominator;
		this.numerator = newNumerator1 - newNumerator2;
		simplify();
		Rational fraction = new Rational(this.numerator, this.denominator);
		return fraction;
		
	}
	
	public Rational multiply(Rational rationalValue)
	{
		
		this.numerator *= rationalValue.numerator;
		this.denominator *= rationalValue.denominator;
		simplify();
		Rational newRational = new Rational(numerator, denominator);
		return newRational;
		
	}
	
	public Rational divide(Rational rationalValue)
	{

		this.numerator *= rationalValue.denominator;
		this.denominator *= rationalValue.numerator;
		simplify();
		Rational newRational = new Rational(numerator, denominator);
		return newRational;
		
	}
	
	public boolean equals(Rational rationalValue)
	{
		
		return(rationalNumber == rationalValue.rationalNumber);
		
	}
	
	public boolean isLessThan(Rational rationalValue)
	{
		
		return(rationalNumber < rationalValue.rationalNumber);
		
	}
	
	public Rational simplify()
	{
		
		int gcd = greatestCommonDivisor();
		this.numerator /= gcd;
		this.denominator /= gcd;
		Rational rationalValue = new Rational(numerator, denominator);
		return rationalValue;
		
	}
	
	public String toString()
	{
		
		String fraction = this.numerator + "/" + this.denominator;
		return fraction;
	}
	
	public int greatestCommonDivisor()
	{
		
		BigInteger numeratorB = new BigInteger("" + numerator);
		BigInteger denominatorB = new BigInteger("" + denominator);
		BigInteger gcd = numeratorB.gcd(denominatorB);
		return gcd.intValue();
	}
}
