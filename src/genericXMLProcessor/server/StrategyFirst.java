package genericXMLProcessor.server;

import genericXMLProcessor.util.MyAllTypesFirst;

import java.io.BufferedWriter;

public class StrategyFirst implements Strategy
{

	/**
	 * 
	 * @return void
	 */
	public void serialize(BufferedWriter bw, Object o)
	{

		try
		{
			
			MyAllTypesFirst frst = (MyAllTypesFirst) o;
			String content = "<DPSerialization>" + "\n" + " <complexType xsi:type=" + "\"genericXMLProcessor.util.MyAllTypesFirst\">"
					+ "\n";

			content = content + "  <myInt xsi:type=\"xsd:int\">" + frst.getMyInt() + "</myInt>" + "\n";
			content = content + "  <myString xsi:type=\"xsd:string\">" + frst.getMyString() + "</myString>" + "\n";
			content = content + "  <myDouble xsi:type=\"xsd:double\">" + frst.getMyDouble() + "</myDouble>" + "\n";
			content = content + "  <myLong xsi:type=\"xsd:long\">" + frst.getMyLong() + "</myLong>" + "\n";
			content = content + "  <myChar xsi:type=\"xsd:char\">" + frst.getMyChar() + "</myChar>" + "\n";
			content = content + " </complexType>" + "\n" + "</DPSerialization>" + "\n";

			bw.write(content);
		}

		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			System.exit(1);
		}

	}

}
