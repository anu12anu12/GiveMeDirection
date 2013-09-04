package org.simpleframework.xml.stream;

import java.util.LinkedList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class NodeExtractor extends LinkedList<Node>
{
  public NodeExtractor(Document paramDocument)
  {
    extract(paramDocument);
  }

  private void extract(Document paramDocument)
  {
    Element localElement = paramDocument.getDocumentElement();
    if (localElement == null)
      return;
    boolean bool = offer(localElement);
    extract(localElement);
  }

  private void extract(Node paramNode)
  {
    NodeList localNodeList = paramNode.getChildNodes();
    int i = localNodeList.getLength();
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Node localNode = localNodeList.item(j);
      if (localNode.getNodeType() != 8)
      {
        boolean bool = offer(localNode);
        extract(localNode);
      }
      j += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeExtractor
 * JD-Core Version:    0.6.2
 */