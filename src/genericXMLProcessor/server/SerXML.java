package genericXMLProcessor.server;

import genericXMLProcessor.util.SerializableObject;

public interface SerXML extends SerDeserXML
{
	public void writeXML(SerializableObject myF, String fileName);

}
