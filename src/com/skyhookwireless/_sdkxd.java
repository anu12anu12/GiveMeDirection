package com.skyhookwireless;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class _sdkxd
{
  private DocumentBuilder _sdka;

  public _sdkxd()
  {
    try
    {
      DocumentBuilder localDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      this._sdka = localDocumentBuilder;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException(localThrowable);
    }
  }

  public static String _sdka(Document paramDocument, String paramString1, String paramString2)
  {
    String str = null;
    Object localObject = _sdka(paramDocument, paramString1);
    if (localObject == null);
    while (true)
    {
      return str;
      localObject = ((Node)localObject).getAttributes();
      if (localObject != null)
      {
        localObject = ((NamedNodeMap)localObject).getNamedItem(paramString2);
        if (localObject != null)
          str = ((Node)localObject).getNodeValue();
      }
    }
  }

  public static Node _sdka(Document paramDocument, String paramString)
  {
    NodeList localNodeList = paramDocument.getElementsByTagName(paramString);
    if ((localNodeList == null) || (localNodeList.getLength() != 1));
    for (Node localNode = null; ; localNode = localNodeList.item(0))
      return localNode;
  }

  public static Integer _sdkb(Document paramDocument, String paramString1, String paramString2)
  {
    String str = _sdka(paramDocument, paramString1, paramString2);
    if (str == null);
    for (Integer localInteger = null; ; localInteger = Integer.valueOf(str))
      return localInteger;
  }

  public static String _sdkb(Document paramDocument, String paramString)
  {
    String str = null;
    Object localObject = _sdka(paramDocument, paramString);
    if (localObject == null);
    while (true)
    {
      return str;
      localObject = ((Node)localObject).getChildNodes();
      if ((localObject != null) && (((NodeList)localObject).getLength() == 1))
        str = ((NodeList)localObject).item(0).getNodeValue();
    }
  }

  public static Double _sdkc(Document paramDocument, String paramString1, String paramString2)
  {
    String str = _sdka(paramDocument, paramString1, paramString2);
    if (str == null);
    for (Double localDouble = null; ; localDouble = Double.valueOf(str))
      return localDouble;
  }

  public static String[] _sdkc(Document paramDocument, String paramString)
  {
    String[] arrayOfString = null;
    boolean bool = _sdkpc._sdkb;
    NodeList localNodeList = paramDocument.getElementsByTagName(paramString);
    if (localNodeList == null)
      break label45;
    while (true)
    {
      return arrayOfString;
      int i = localNodeList.getLength();
      if (i != 0)
      {
        arrayOfString = new String[i];
        int j = 0;
        label45: if (j < i)
        {
          String str = localNodeList.item(j).getChildNodes().item(0).getNodeValue();
          arrayOfString[j] = str;
          j += 1;
          if (!bool)
            break;
        }
      }
    }
  }

  public static Integer _sdkd(Document paramDocument, String paramString)
  {
    String str = _sdkb(paramDocument, paramString);
    if (str == null);
    for (Integer localInteger = null; ; localInteger = Integer.valueOf(str))
      return localInteger;
  }

  public static Double _sdke(Document paramDocument, String paramString)
  {
    String str = _sdkb(paramDocument, paramString);
    if (str == null);
    for (Double localDouble = null; ; localDouble = Double.valueOf(str))
      return localDouble;
  }

  /** @deprecated */
  public Document _sdka(InputStream paramInputStream)
    throws SAXException, IOException
  {
    try
    {
      Document localDocument1 = this._sdka.parse(paramInputStream);
      Document localDocument2 = localDocument1;
      return localDocument2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkxd
 * JD-Core Version:    0.6.2
 */