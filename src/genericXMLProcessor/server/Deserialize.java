package genericXMLProcessor.server;

import genericXMLProcessor.util.SerializableObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Deserialize implements DeserXML
{
	private static ArrayList<Object> objectList = new ArrayList<Object>();

	public static ArrayList<Object> getObjectList()
	{
		return objectList;
	}

	public static void setObjectList(ArrayList<Object> objectList)
	{
		Deserialize.objectList = objectList;
	}

	public SerializableObject readXML(String fileName)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			int i = 0;
			String parts[];
			String parts1[];
			String parts2[];
			String parts3[];
			String parts4[];

			String tag;
			String val;
			String type;
			String className;
			String methodName;
			while ((line = br.readLine()) != null)
			{
				line = line.trim();
				if (line.equals("") || line.equals("</complexType>") || line.equals("</DPSerialization>"))
					continue;
				if (line.equals("<DPSerialization>"))
				{
					line = br.readLine().trim();
					if (line.contains("genericXMLProcessor.util.MyAllTypesFirst"))
					{
						parts = line.split("\"");
						className = parts[1].trim();
						Class<?> cls = Class.forName(className);
						Object obj = cls.newInstance();
						Method method;
						for (i = 0; i < 5; i++)
						{
							line = br.readLine().trim();
							parts1 = line.split(" ");
							parts1[0] = parts1[0].trim();
							tag = parts1[0].replace("<", "");
							parts2 = line.split("\"");
							type = parts2[1].trim();
							type = type.replace("xsd:", "");
							parts3 = line.split(">");
							parts4 = parts3[1].trim().split("<");
							val = parts4[0].trim();
							methodName = "set" + Character.toUpperCase(tag.charAt(0)) + tag.substring(1);

							if (type.equalsIgnoreCase("int"))
							{
								method = cls.getDeclaredMethod(methodName, int.class);
								int intVal = Integer.parseInt(val);
								method.invoke(obj, intVal);
							}
							else if (type.equalsIgnoreCase("string"))
							{
								method = cls.getDeclaredMethod(methodName, String.class);
								method.invoke(obj, val);
							}
							else if (type.equalsIgnoreCase("double"))
							{
								method = cls.getDeclaredMethod(methodName, double.class);
								double doubleVal = Double.parseDouble(val);
								method.invoke(obj, doubleVal);
							}
							else if (type.equalsIgnoreCase("long"))
							{
								method = cls.getDeclaredMethod(methodName, long.class);
								long longVal = Long.parseLong(val);
								method.invoke(obj, longVal);
							}
							else if (type.equalsIgnoreCase("char"))
							{
								method = cls.getDeclaredMethod(methodName, char.class);
								char c = val.charAt(0);
								method.invoke(obj, c);
							}

						}

						objectList.add(obj);

					}
					else if (line.contains("genericXMLProcessor.util.MyAllTypesSecond"))
					{
						parts = line.split("\"");
						className = parts[1].trim();
						Class<?> cls2 = Class.forName(className);
						Object obj2 = cls2.newInstance();
						Method method;
						for (i = 0; i < 5; i++)
						{
							line = br.readLine().trim();
							parts1 = line.split(" ");
							parts1[0] = parts1[0].trim();
							tag = parts1[0].replace("<", "");
							parts2 = line.split("\"");
							type = parts2[1].trim();
							type = type.replace("xsd:", "");
							parts3 = line.split(">");
							parts4 = parts3[1].trim().split("<");
							val = parts4[0].trim();
							methodName = "set" + Character.toUpperCase(tag.charAt(0)) + tag.substring(1);

							if (type.equalsIgnoreCase("int"))
							{
								method = cls2.getDeclaredMethod(methodName, int.class);
								int intVal = Integer.parseInt(val);
								method.invoke(obj2, intVal);
							}
							else if (type.equalsIgnoreCase("string"))
							{
								method = cls2.getDeclaredMethod(methodName, String.class);
								method.invoke(obj2, val);
							}
							else if (type.equalsIgnoreCase("float"))
							{
								method = cls2.getDeclaredMethod(methodName, float.class);
								float floatVal = Float.parseFloat(val);
								method.invoke(obj2, floatVal);
							}
							else if (type.equalsIgnoreCase("short"))
							{
								method = cls2.getDeclaredMethod(methodName, short.class);
								short shortVal = Short.parseShort(val);
								method.invoke(obj2, shortVal);
							}
							else if (type.equalsIgnoreCase("char"))
							{
								method = cls2.getDeclaredMethod(methodName, char.class);
								char c = val.charAt(0);
								method.invoke(obj2, c);
							}
						}
						objectList.add(obj2);
					}
				}
			}
			br.close();
			SerializableObject retObj = (SerializableObject) objectList.get(objectList.size() - 1);
			objectList.clear();
			return retObj;
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
