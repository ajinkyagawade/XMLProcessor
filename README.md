XMLProcessor
============

Generic XML Serializer

The purpose of the project is to create a generic XML serializer. The code allows the conversion of objects into the XML wire format. The code uses dynamic proxies and reflection so that the addition of new objects or serialization formats causes minimal changes (i.e. reduces the ripple effect). First of all a dynamic proxy is created. Then, one instances each for MyAllTypesFirst and MyAllTypesSecond are created. Using MyAllTypesFirst instance, writeXML() method is called to generate the XML wireformat of the object passed as an argument. Then readXML() method is called to read the XML format from the file, deserialize it into an object and then return it. At last, both serialized and deserialized objects are compared to find out if they are equal. The same whole process is carried out in case of MyAllTypesSecond object instance.
