package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

class StreamProvider
  implements Provider
{
  private final XMLInputFactory factory;

  public StreamProvider()
  {
    XMLInputFactory localXMLInputFactory = XMLInputFactory.newInstance();
    this.factory = localXMLInputFactory;
  }

  private EventReader provide(XMLEventReader paramXMLEventReader)
    throws Exception
  {
    return new StreamReader(paramXMLEventReader);
  }

  public EventReader provide(InputStream paramInputStream)
    throws Exception
  {
    XMLEventReader localXMLEventReader = this.factory.createXMLEventReader(paramInputStream);
    return provide(localXMLEventReader);
  }

  public EventReader provide(Reader paramReader)
    throws Exception
  {
    XMLEventReader localXMLEventReader = this.factory.createXMLEventReader(paramReader);
    return provide(localXMLEventReader);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.StreamProvider
 * JD-Core Version:    0.6.2
 */