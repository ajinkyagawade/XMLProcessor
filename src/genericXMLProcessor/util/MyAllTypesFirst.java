package genericXMLProcessor.util;

public class MyAllTypesFirst extends SerializableObject
{

	private int myInt;
	private String myString;
	private double myDouble;
	private long myLong;
	private char myChar;

	public MyAllTypesFirst()
	{

	}

	public MyAllTypesFirst(int myInt, String myString, double myDouble, long myLong, char myChar)
	{
		this.myInt = myInt;
		this.myString = myString;
		this.myDouble = myDouble;
		this.myLong = myLong;
		this.myChar = myChar;
	}

	public int getMyInt()
	{
		return myInt;
	}

	public void setMyInt(int myInt)
	{
		this.myInt = myInt;
	}

	public String getMyString()
	{
		return myString;
	}

	public void setMyString(String myString)
	{
		this.myString = myString;
	}

	public double getMyDouble()
	{
		return myDouble;
	}

	public void setMyDouble(double myDouble)
	{
		this.myDouble = myDouble;
	}

	public long getMyLong()
	{
		return myLong;
	}

	public void setMyLong(long myLong)
	{
		this.myLong = myLong;
	}

	public char getMyChar()
	{
		return myChar;
	}

	public void setMyChar(char myChar)
	{
		this.myChar = myChar;
	}

	/**
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj)
	{

		MyAllTypesFirst frst = (MyAllTypesFirst) obj;
		return ((this.myInt == frst.myInt) && (this.myString.equals(frst.myString)) && (this.myDouble == frst.myDouble)
				&& (this.myLong == frst.myLong) && (this.myChar == frst.myChar));
	}

	/**
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{

		return (myInt * 13 + myString.hashCode() * 17 + (int) myDouble * 19 + (int) myLong * 23 + (int) myChar * 29);
	}

	/**
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return getMyInt() + ", " + getMyString() + ", " + getMyDouble() + ", " + getMyLong() + ", " + getMyChar();
	}
}
