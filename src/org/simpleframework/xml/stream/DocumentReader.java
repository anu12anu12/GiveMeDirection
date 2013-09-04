package org.simpleframework.xml.stream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

class DocumentReader
  implements EventReader
{
  private static final String RESERVED = "xml";
  private EventNode peek;
  private NodeExtractor queue;
  private NodeStack stack;

  public DocumentReader(Document paramDocument)
  {
    NodeExtractor localNodeExtractor = new NodeExtractor(paramDocument);
    this.queue = localNodeExtractor;
    NodeStack localNodeStack = new NodeStack();
    this.stack = localNodeStack;
    Object localObject = this.stack.push(paramDocument);
  }

  private Entry attribute(Node paramNode)
  {
    return new Entry(paramNode);
  }

  private Start build(Start paramStart)
  {
    NamedNodeMap localNamedNodeMap = paramStart.getAttributes();
    int i = localNamedNodeMap.getLength();
    int j = 0;
    while (j < i)
    {
      Node localNode = localNamedNodeMap.item(j);
      Entry localEntry = attribute(localNode);
      if (!localEntry.isReserved())
        boolean bool = paramStart.add(localEntry);
      j += 1;
    }
    return paramStart;
  }

  private EventNode convert(Node paramNode)
    throws Exception
  {
    if (paramNode.getNodeType() == 1)
      if (paramNode != null)
        Object localObject1 = this.stack.push(paramNode);
    for (Object localObject2 = start(paramNode); ; localObject2 = text(paramNode))
      return localObject2;
  }

  private End end()
  {
    return new End(null);
  }

  private EventNode read()
    throws Exception
  {
    Node localNode = (Node)this.queue.peek();
    if (localNode == null);
    for (Object localObject = end(); ; localObject = read(localNode))
      return localObject;
  }

  private EventNode read(Node paramNode)
    throws Exception
  {
    Node localNode1 = paramNode.getParentNode();
    Node localNode2 = (Node)this.stack.top();
    if (localNode1 != localNode2)
      if (localNode2 != null)
        Object localObject1 = this.stack.pop();
    for (Object localObject2 = end(); ; localObject2 = convert(paramNode))
    {
      return localObject2;
      if (paramNode != null)
        Object localObject3 = this.queue.poll();
    }
  }

  private Start start(Node paramNode)
  {
    Start localStart = new Start(paramNode);
    if (localStart.isEmpty())
      localStart = build(localStart);
    return localStart;
  }

  private Text text(Node paramNode)
  {
    return new Text(paramNode);
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
    private final Node node;

    public Text(Node paramNode)
    {
      this.node = paramNode;
    }

    public Object getSource()
    {
      return this.node;
    }

    public String getValue()
    {
      return this.node.getNodeValue();
    }

    public boolean isText()
    {
      return true;
    }
  }

  private static class Start extends EventElement
  {
    private final Element element;

    public Start(Node paramNode)
    {
      Element localElement = (Element)paramNode;
      this.element = localElement;
    }

    public NamedNodeMap getAttributes()
    {
      return this.element.getAttributes();
    }

    public String getName()
    {
      return this.element.getLocalName();
    }

    public String getPrefix()
    {
      return this.element.getPrefix();
    }

    public String getReference()
    {
      return this.element.getNamespaceURI();
    }

    public Object getSource()
    {
      return this.element;
    }
  }

  private static class Entry extends EventAttribute
  {
    private final Node node;

    public Entry(Node paramNode)
    {
      this.node = paramNode;
    }

    public String getName()
    {
      return this.node.getLocalName();
    }

    public String getPrefix()
    {
      return this.node.getPrefix();
    }

    public String getReference()
    {
      return this.node.getNamespaceURI();
    }

    public Object getSource()
    {
      return this.node;
    }

    public String getValue()
    {
      return this.node.getNodeValue();
    }

    public boolean isReserved()
    {
      String str1 = getPrefix();
      String str2 = getName();
      if (str1 != null);
      for (boolean bool = str1.startsWith("xml"); ; bool = str2.startsWith("xml"))
        return bool;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.DocumentReader
 * JD-Core Version:    0.6.2
 */