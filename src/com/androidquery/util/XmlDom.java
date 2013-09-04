package com.androidquery.util;

import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public class XmlDom
{
  private Element root;

  public XmlDom(InputStream paramInputStream)
    throws SAXException
  {
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    try
    {
      Element localElement = localDocumentBuilderFactory.newDocumentBuilder().parse(paramInputStream).getDocumentElement();
      this.root = localElement;
      return;
    }
    catch (IOException localIOException)
    {
      throw new SAXException(localIOException);
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
    }
  }

  public XmlDom(String paramString)
    throws SAXException
  {
    this(arrayOfByte);
  }

  public XmlDom(Element paramElement)
  {
    this.root = paramElement;
  }

  public XmlDom(byte[] paramArrayOfByte)
    throws SAXException
  {
    this(localByteArrayInputStream);
  }

  private static XmlDom convert(Node paramNode, String paramString1, String paramString2, String paramString3)
  {
    XmlDom localXmlDom;
    if (paramNode.getNodeType() != 1)
      localXmlDom = null;
    while (true)
    {
      return localXmlDom;
      Element localElement = (Element)paramNode;
      localXmlDom = null;
      if (paramString1 != null)
      {
        String str1 = localElement.getTagName();
        if (!paramString1.equals(str1));
      }
      else if ((paramString2 == null) || (localElement.hasAttribute(paramString2)))
      {
        if (paramString3 != null)
        {
          String str2 = localElement.getAttribute(paramString2);
          if (!paramString3.equals(str2));
        }
        else
        {
          localXmlDom = new XmlDom(localElement);
        }
      }
    }
  }

  private static List<XmlDom> convert(NodeList paramNodeList, String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (true)
    {
      int j = paramNodeList.getLength();
      if (i >= j)
        return localArrayList;
      XmlDom localXmlDom = convert(paramNodeList.item(i), paramString1, paramString2, paramString3);
      if (localXmlDom != null)
        boolean bool = localArrayList.add(localXmlDom);
      i += 1;
    }
  }

  private String serialize(Element paramElement, int paramInt)
  {
    Object localObject = null;
    try
    {
      XmlSerializer localXmlSerializer = Xml.newSerializer();
      StringWriter localStringWriter = new StringWriter();
      localXmlSerializer.setOutput(localStringWriter);
      localXmlSerializer.startDocument("utf-8", null);
      String str1 = null;
      if (paramInt > 0)
      {
        char[] arrayOfChar = new char[paramInt];
        Arrays.fill(arrayOfChar, ' ');
        str1 = new String(arrayOfChar);
      }
      Element localElement = this.root;
      serialize(localElement, localXmlSerializer, 0, str1);
      localXmlSerializer.endDocument();
      String str2 = localStringWriter.toString();
      localObject = str2;
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private void serialize(Element paramElement, XmlSerializer paramXmlSerializer, int paramInt, String paramString)
    throws Exception
  {
    String str1 = paramElement.getTagName();
    writeSpace(paramXmlSerializer, paramInt, paramString);
    XmlSerializer localXmlSerializer1 = paramXmlSerializer.startTag("", str1);
    NamedNodeMap localNamedNodeMap;
    int i;
    if (paramElement.hasAttributes())
    {
      localNamedNodeMap = paramElement.getAttributes();
      i = 0;
    }
    NodeList localNodeList;
    int k;
    while (true)
    {
      int j = localNamedNodeMap.getLength();
      if (i >= j)
      {
        if (paramElement.hasChildNodes())
        {
          localNodeList = paramElement.getChildNodes();
          k = 0;
          i = 0;
          int m = localNodeList.getLength();
          if (i < m)
            break;
          if (k > 0)
            writeSpace(paramXmlSerializer, paramInt, paramString);
        }
        XmlSerializer localXmlSerializer2 = paramXmlSerializer.endTag("", str1);
        return;
      }
      Attr localAttr = (Attr)localNamedNodeMap.item(i);
      String str2 = localAttr.getName();
      String str3 = localAttr.getValue();
      XmlSerializer localXmlSerializer3 = paramXmlSerializer.attribute("", str2, str3);
      i += 1;
    }
    Node localNode = localNodeList.item(i);
    switch (localNode.getNodeType())
    {
    case 2:
    default:
    case 1:
    case 3:
    case 4:
    }
    while (true)
    {
      i += 1;
      break;
      Element localElement = (Element)localNode;
      int n = paramInt + 1;
      serialize(localElement, paramXmlSerializer, n, paramString);
      int i1 = k + 1;
      continue;
      String str4 = text(localNode);
      XmlSerializer localXmlSerializer4 = paramXmlSerializer.text(str4);
      continue;
      String str5 = text(localNode);
      paramXmlSerializer.cdsect(str5);
    }
  }

  private String text(Node paramNode)
  {
    String str = null;
    switch (paramNode.getNodeType())
    {
    default:
    case 3:
    case 4:
    }
    while (true)
    {
      if (str == null)
        str = "";
      return str;
      str = paramNode.getNodeValue();
      if (str != null)
      {
        str = str.trim();
        continue;
        str = paramNode.getNodeValue();
      }
    }
  }

  private void writeSpace(XmlSerializer paramXmlSerializer, int paramInt, String paramString)
    throws Exception
  {
    if (paramString == null)
      return;
    XmlSerializer localXmlSerializer1 = paramXmlSerializer.text("\n");
    int i = 0;
    while (true)
    {
      if (i >= paramInt)
        return;
      XmlSerializer localXmlSerializer2 = paramXmlSerializer.text(paramString);
      i += 1;
    }
  }

  public String attr(String paramString)
  {
    return this.root.getAttribute(paramString);
  }

  public XmlDom child(String paramString)
  {
    return child(paramString, null, null);
  }

  public XmlDom child(String paramString1, String paramString2, String paramString3)
  {
    List localList = children(paramString1, paramString2, paramString3);
    if (localList.size() == 0);
    for (XmlDom localXmlDom = null; ; localXmlDom = (XmlDom)localList.get(0))
      return localXmlDom;
  }

  public List<XmlDom> children(String paramString)
  {
    return children(paramString, null, null);
  }

  public List<XmlDom> children(String paramString1, String paramString2, String paramString3)
  {
    return convert(this.root.getChildNodes(), paramString1, paramString2, paramString3);
  }

  public Element getElement()
  {
    return this.root;
  }

  public XmlDom tag(String paramString)
  {
    NodeList localNodeList = this.root.getElementsByTagName(paramString);
    XmlDom localXmlDom = null;
    if ((localNodeList != null) && (localNodeList.getLength() > 0))
    {
      Element localElement = (Element)localNodeList.item(0);
      localXmlDom = new XmlDom(localElement);
    }
    return localXmlDom;
  }

  public XmlDom tag(String paramString1, String paramString2, String paramString3)
  {
    List localList = tags(paramString1, paramString2, paramString3);
    if (localList.size() == 0);
    for (XmlDom localXmlDom = null; ; localXmlDom = (XmlDom)localList.get(0))
      return localXmlDom;
  }

  public List<XmlDom> tags(String paramString)
  {
    return tags(paramString, null, null);
  }

  public List<XmlDom> tags(String paramString1, String paramString2, String paramString3)
  {
    return convert(this.root.getElementsByTagName(paramString1), null, paramString2, paramString3);
  }

  public String text()
  {
    NodeList localNodeList = this.root.getChildNodes();
    String str1;
    if (localNodeList.getLength() == 1)
    {
      str1 = localNodeList.item(0).getNodeValue();
      return str1;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    while (true)
    {
      int j = localNodeList.getLength();
      if (i >= j)
      {
        str1 = localStringBuilder1.toString();
        break;
      }
      Node localNode = localNodeList.item(i);
      String str2 = text(localNode);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
      i += 1;
    }
  }

  public String text(String paramString)
  {
    XmlDom localXmlDom = child(paramString);
    if (localXmlDom == null);
    for (String str = null; ; str = localXmlDom.text())
      return str;
  }

  public String toString()
  {
    return toString(0);
  }

  public String toString(int paramInt)
  {
    Element localElement = this.root;
    return serialize(localElement, paramInt);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.util.XmlDom
 * JD-Core Version:    0.6.2
 */