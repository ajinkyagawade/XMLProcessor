package genericXMLProcessor.server;

import genericXMLProcessor.util.MyAllTypesFirst;
import genericXMLProcessor.util.MyAllTypesSecond;
import genericXMLProcessor.util.SerializableObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Serialize implements SerXML
{

	public static BufferedWriter bw;

	/**
	 * 
	 * @return void
	 */

	public void writeXML(SerializableObject myF, String fileName)
	{
		try
		{
			File file = new File(fileName);
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);

			if (myF instanceof MyAllTypesFirst)
			{

				serializeStrategy(myF, new StrategyFirst());

			}
			else if (myF instanceof MyAllTypesSecond)
			{
				serializeStrategy(myF, new StrategySecond());
			}

			bw.close();
		}
		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			System.exit(1);
		}
	}
	
	/**
	 * 
	 * @return void
	 */
	public void serializeStrategy(Object obj, Strategy strat)
	{
		strat.serialize(bw, obj);
	}

}
