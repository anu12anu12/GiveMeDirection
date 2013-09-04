package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

class PullProvider
  implements Provider
{
  private final XmlPullParserFactory factory;

  public PullProvider()
    throws Exception
  {
    XmlPullParserFactory localXmlPullParserFactory = XmlPullParserFactory.newInstance();
    this.factory = localXmlPullParserFactory;
    this.factory.setNamespaceAware(true);
  }

  public EventReader provide(InputStream paramInputStream)
    throws Exception
  {
    XmlPullParser localXmlPullParser = this.factory.newPullParser();
    if (paramInputStream != null)
      localXmlPullParser.setInput(paramInputStream, null);
    return new PullReader(localXmlPullParser);
  }

  public EventReader provide(Reader paramReader)
    throws Exception
  {
    XmlPullParser localXmlPullParser = this.factory.newPullParser();
    if (paramReader != null)
      localXmlPullParser.setInput(paramReader);
    return new PullReader(localXmlPullParser);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.PullProvider
 * JD-Core Version:    0.6.2
 */