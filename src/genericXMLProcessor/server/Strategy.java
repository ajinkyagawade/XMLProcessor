package genericXMLProcessor.server;

import java.io.BufferedWriter;

public interface Strategy
{
	public void serialize(BufferedWriter bw, Object o);

}
