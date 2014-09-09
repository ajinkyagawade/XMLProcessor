package genericXMLProcessor.util;

public class MyAllTypesSecond extends SerializableObject
{
	private int myIntS;
	private String myStringS;
	private float myFloatS;
	private short myShortS;
	private char myCharS;

	public MyAllTypesSecond()
	{

	}

	public MyAllTypesSecond(int myIntS, String myStringS, float myFloatS, short myShortS, char myCharS)
	{
		this.myIntS = myIntS;
		this.myStringS = myStringS;
		this.myFloatS = myFloatS;
		this.myShortS = myShortS;
		this.myCharS = myCharS;
	}

	public int getMyIntS()
	{
		return myIntS;
	}

	public void setMyIntS(int myIntS)
	{
		this.myIntS = myIntS;
	}

	public String getMyStringS()
	{
		return myStringS;
	}

	public void setMyStringS(String myStringS)
	{
		this.myStringS = myStringS;
	}

	public float getMyFloatS()
	{
		return myFloatS;
	}

	public void setMyFloatS(float myFloatS)
	{
		this.myFloatS = myFloatS;
	}

	public short getMyShortS()
	{
		return myShortS;
	}

	public void setMyShortS(short myShortS)
	{
		this.myShortS = myShortS;
	}

	public char getMyCharS()
	{
		return myCharS;
	}

	public void setMyCharS(char myCharS)
	{
		this.myCharS = myCharS;
	}

	/**
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj)
	{
		MyAllTypesSecond snd = (MyAllTypesSecond) obj;
		return ((this.myIntS == snd.myIntS) && (this.myStringS.equals(snd.myStringS)) && (this.myFloatS == snd.myFloatS)
				&& (this.myShortS == snd.myShortS) && (this.myCharS == snd.myCharS));
	}

	/**
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		return (myIntS * 13 + myStringS.hashCode() * 17 + (int) myFloatS * 19 + myShortS * 23 + (int) myCharS * 29);
	}

	/**
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return getMyIntS() + ", " + getMyStringS() + ", " + getMyFloatS() + ", " + getMyShortS() + ", " + getMyCharS();
	}

}
