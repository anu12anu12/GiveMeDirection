package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

class DocumentProvider
  implements Provider
{
  private final DocumentBuilderFactory factory;

  public DocumentProvider()
  {
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    this.factory = localDocumentBuilderFactory;
    this.factory.setNamespaceAware(true);
  }

  private EventReader provide(InputSource paramInputSource)
    throws Exception
  {
    Document localDocument = this.factory.newDocumentBuilder().parse(paramInputSource);
    return new DocumentReader(localDocument);
  }

  public EventReader provide(InputStream paramInputStream)
    throws Exception
  {
    InputSource localInputSource = new InputSource(paramInputStream);
    return provide(localInputSource);
  }

  public EventReader provide(Reader paramReader)
    throws Exception
  {
    InputSource localInputSource = new InputSource(paramReader);
    return provide(localInputSource);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.DocumentProvider
 * JD-Core Version:    0.6.2
 */