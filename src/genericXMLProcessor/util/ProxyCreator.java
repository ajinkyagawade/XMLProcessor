package genericXMLProcessor.util;

import genericXMLProcessor.server.SerDeserXML;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyCreator
{

	/**
	 * 
	 * @return SerDeserXML
	 */
	public SerDeserXML createProxy(Class<?>[] interfaceArray, InvocationHandler handler){
		SerDeserXML serDeserObj =
            (SerDeserXML)
            Proxy.newProxyInstance(
                                   getClass().getClassLoader(),
                                   interfaceArray,
                                   handler
                                   );

		return serDeserObj;
	}
}
