package org.simpleframework.xml.stream;

import org.xmlpull.v1.XmlPullParser;

class PullReader
  implements EventReader
{
  private XmlPullParser parser;
  private EventNode peek;

  public PullReader(XmlPullParser paramXmlPullParser)
  {
    this.parser = paramXmlPullParser;
  }

  private Entry attribute(int paramInt)
    throws Exception
  {
    XmlPullParser localXmlPullParser = this.parser;
    return new Entry(localXmlPullParser, paramInt);
  }

  private Start build(Start paramStart)
    throws Exception
  {
    int i = this.parser.getAttributeCount();
    int j = 0;
    while (j < i)
    {
      Entry localEntry = attribute(j);
      if (!localEntry.isReserved())
        boolean bool = paramStart.add(localEntry);
      j += 1;
    }
    return paramStart;
  }

  private End end()
    throws Exception
  {
    return new End(null);
  }

  private EventNode read()
    throws Exception
  {
    int i = this.parser.next();
    Object localObject;
    if (i != 1)
      if (i == 2)
        localObject = start();
    while (true)
    {
      return localObject;
      if (i == 4)
      {
        localObject = text();
      }
      else if (i == 3)
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

  private Start start()
    throws Exception
  {
    XmlPullParser localXmlPullParser = this.parser;
    Start localStart = new Start(localXmlPullParser);
    if (localStart.isEmpty())
      localStart = build(localStart);
    return localStart;
  }

  private Text text()
    throws Exception
  {
    XmlPullParser localXmlPullParser = this.parser;
    return new Text(localXmlPullParser);
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
    private final XmlPullParser source;
    private final String text;

    public Text(XmlPullParser paramXmlPullParser)
    {
      String str = paramXmlPullParser.getText();
      this.text = str;
      this.source = paramXmlPullParser;
    }

    public Object getSource()
    {
      return this.source;
    }

    public String getValue()
    {
      return this.text;
    }

    public boolean isText()
    {
      return true;
    }
  }

  private static class Start extends EventElement
  {
    private final int line;
    private final String name;
    private final String prefix;
    private final String reference;
    private final XmlPullParser source;

    public Start(XmlPullParser paramXmlPullParser)
    {
      String str1 = paramXmlPullParser.getNamespace();
      this.reference = str1;
      int i = paramXmlPullParser.getLineNumber();
      this.line = i;
      String str2 = paramXmlPullParser.getPrefix();
      this.prefix = str2;
      String str3 = paramXmlPullParser.getName();
      this.name = str3;
      this.source = paramXmlPullParser;
    }

    public int getLine()
    {
      return this.line;
    }

    public String getName()
    {
      return this.name;
    }

    public String getPrefix()
    {
      return this.prefix;
    }

    public String getReference()
    {
      return this.reference;
    }

    public Object getSource()
    {
      return this.source;
    }
  }

  private static class Entry extends EventAttribute
  {
    private final String name;
    private final String prefix;
    private final String reference;
    private final XmlPullParser source;
    private final String value;

    public Entry(XmlPullParser paramXmlPullParser, int paramInt)
    {
      String str1 = paramXmlPullParser.getAttributeNamespace(paramInt);
      this.reference = str1;
      String str2 = paramXmlPullParser.getAttributePrefix(paramInt);
      this.prefix = str2;
      String str3 = paramXmlPullParser.getAttributeValue(paramInt);
      this.value = str3;
      String str4 = paramXmlPullParser.getAttributeName(paramInt);
      this.name = str4;
      this.source = paramXmlPullParser;
    }

    public String getName()
    {
      return this.name;
    }

    public String getPrefix()
    {
      return this.prefix;
    }

    public String getReference()
    {
      return this.reference;
    }

    public Object getSource()
    {
      return this.source;
    }

    public String getValue()
    {
      return this.value;
    }

    public boolean isReserved()
    {
      return false;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.PullReader
 * JD-Core Version:    0.6.2
 */