package org.simpleframework.xml.stream;

import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

class StreamReader
  implements EventReader
{
  private EventNode peek;
  private XMLEventReader reader;

  public StreamReader(XMLEventReader paramXMLEventReader)
  {
    this.reader = paramXMLEventReader;
  }

  private Entry attribute(Attribute paramAttribute)
  {
    return new Entry(paramAttribute);
  }

  private Start build(Start paramStart)
  {
    Iterator localIterator = paramStart.getAttributes();
    while (localIterator.hasNext())
    {
      Attribute localAttribute = (Attribute)localIterator.next();
      Entry localEntry = attribute(localAttribute);
      if (!localEntry.isReserved())
        boolean bool = paramStart.add(localEntry);
    }
    return paramStart;
  }

  private End end()
  {
    return new End(null);
  }

  private EventNode read()
    throws Exception
  {
    XMLEvent localXMLEvent = this.reader.nextEvent();
    Object localObject;
    if (!localXMLEvent.isEndDocument())
      if (localXMLEvent.isStartElement())
        localObject = start(localXMLEvent);
    while (true)
    {
      return localObject;
      if (localXMLEvent.isCharacters())
      {
        localObject = text(localXMLEvent);
      }
      else if (localXMLEvent.isEndElement())
      {
        localObject = end();
      }
      else
      {
        localObject = read();
        continue;
        localObject = null;
      }
    }
  }

  private Start start(XMLEvent paramXMLEvent)
  {
    Start localStart = new Start(paramXMLEvent);
    if (localStart.isEmpty())
      localStart = build(localStart);
    return localStart;
  }

  private Text text(XMLEvent paramXMLEvent)
  {
    return new Text(paramXMLEvent);
  }

  public EventNode next()
    throws Exception
  {
    EventNode localEventNode = this.peek;
    if (localEventNode == null)
      localEventNode = read();
    while (true)
    {
      return localEventNode;
      this.peek = null;
    }
  }

  public EventNode peek()
    throws Exception
  {
    if (this.peek == null)
    {
      EventNode localEventNode = next();
      this.peek = localEventNode;
    }
    return this.peek;
  }

  private static class End extends EventToken
  {
    public boolean isEnd()
    {
      return true;
    }
  }

  private static class Text extends EventToken
  {
    private final Characters text;

    public Text(XMLEvent paramXMLEvent)
    {
      Characters localCharacters = paramXMLEvent.asCharacters();
      this.text = localCharacters;
    }

    public Object getSource()
    {
      return this.text;
    }

    public String getValue()
    {
      return this.text.getData();
    }

    public boolean isText()
    {
      return true;
    }
  }

  private static class Start extends EventElement
  {
    private final StartElement element;
    private final Location location;

    public Start(XMLEvent paramXMLEvent)
    {
      StartElement localStartElement = paramXMLEvent.asStartElement();
      this.element = localStartElement;
      Location localLocation = paramXMLEvent.getLocation();
      this.location = localLocation;
    }

    public Iterator<Attribute> getAttributes()
    {
      return this.element.getAttributes();
    }

    public int getLine()
    {
      return this.location.getLineNumber();
    }

    public String getName()
    {
      return this.element.getName().getLocalPart();
    }

    public String getPrefix()
    {
      return this.element.getName().getPrefix();
    }

    public String getReference()
    {
      return this.element.getName().getNamespaceURI();
    }

    public Object getSource()
    {
      return this.element;
    }
  }

  private static class Entry extends EventAttribute
  {
    private final Attribute entry;

    public Entry(Attribute paramAttribute)
    {
      this.entry = paramAttribute;
    }

    public String getName()
    {
      return this.entry.getName().getLocalPart();
    }

    public String getPrefix()
    {
      return this.entry.getName().getPrefix();
    }

    public String getReference()
    {
      return this.entry.getName().getNamespaceURI();
    }

    public Object getSource()
    {
      return this.entry;
    }

    public String getValue()
    {
      return this.entry.getValue();
    }

    public boolean isReserved()
    {
      return false;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.StreamReader
 * JD-Core Version:    0.6.2
 */