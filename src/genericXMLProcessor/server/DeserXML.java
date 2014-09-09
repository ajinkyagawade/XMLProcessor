package genericXMLProcessor.server;

import genericXMLProcessor.util.SerializableObject;

public interface DeserXML extends SerDeserXML
{
	public SerializableObject readXML(String fileNam);

}
