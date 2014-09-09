package genericXMLProcessor.xmlSerDeser;

import genericXMLProcessor.server.DeserXML;
import genericXMLProcessor.server.Deserialize;
import genericXMLProcessor.server.SerXML;
import genericXMLProcessor.server.Serialize;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class XMLHandler implements InvocationHandler
{
	public XMLHandler()
	{

	}
	
	/**
	 * 
	 * @return Object
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		try
		{
			String meth;

			meth = method.getName();
			Class<?> className = method.getDeclaringClass();

			if (className.equals(SerXML.class) && (meth == "writeXML"))
			{
				method.invoke(new Serialize(), args[0], args[1]);
			}
			else if (className.equals(DeserXML.class) && meth == "readXML")
			{
				Object o = method.invoke(new Deserialize(), args[0]);
				return o;
			}
		}

		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
