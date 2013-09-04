package com.hopstop.ClientModel.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetCountImpressionsHandler extends DefaultHandler
{
  private StringBuffer buff = null;
  private boolean buffering = false;

  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (!this.buffering)
      return;
    StringBuffer localStringBuffer = this.buff.append(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void endDocument()
    throws SAXException
  {
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
  }

  public void startDocument()
    throws SAXException
  {
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.GetCountImpressionsHandler
 * JD-Core Version:    0.6.2
 */