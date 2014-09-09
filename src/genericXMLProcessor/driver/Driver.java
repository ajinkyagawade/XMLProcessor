package genericXMLProcessor.driver;

import genericXMLProcessor.server.DeserXML;
import genericXMLProcessor.server.SerDeserXML;
import genericXMLProcessor.server.SerXML;
import genericXMLProcessor.util.MyAllTypesFirst;
import genericXMLProcessor.util.MyAllTypesSecond;
import genericXMLProcessor.util.ProxyCreator;
import genericXMLProcessor.util.SerializableObject;
import genericXMLProcessor.xmlSerDeser.XMLHandler;

public class Driver
{

	public static void main(String[] args)
	{
		try
		{
			ProxyCreator pc = new ProxyCreator();
			SerDeserXML serDeserRef = (SerDeserXML) pc.createProxy(new Class[]
			{ SerXML.class, DeserXML.class }, new XMLHandler());

			SerializableObject myF = new MyAllTypesFirst(5, "Design Patterns", 3.14, 1212121, 'D');
			SerializableObject myS = new MyAllTypesSecond(3, "DP", 1.12f, (short) 12, 'P');

			((SerXML) serDeserRef).writeXML(myF, "myAllTypesA.txt");
			Object o1 = ((DeserXML) serDeserRef).readXML("myAllTypesA.txt");
			MyAllTypesFirst deserMyF = (MyAllTypesFirst) o1;
			System.out.println(deserMyF.toString());
			if (deserMyF.equals(myF))
			{
				System.out.println("Both objects of MyAllTypesFirst are EQUAL\n");
			}

			((SerXML) serDeserRef).writeXML(myS, "myAllTypesB.txt");
			Object o2 = ((DeserXML) serDeserRef).readXML("myAllTypesB.txt");
			MyAllTypesSecond deserMyS = (MyAllTypesSecond) o2;
			System.out.println(deserMyS.toString());
			if (deserMyS.equals(myS))
			{
				System.out.println("Both objects of MyAllTypesSecond are EQUAL");
			}
		}
		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}
}
