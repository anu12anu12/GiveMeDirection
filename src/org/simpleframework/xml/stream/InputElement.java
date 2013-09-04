package org.simpleframework.xml.stream;

class InputElement
  implements InputNode
{
  private final InputNodeMap map;
  private final EventNode node;
  private final InputNode parent;
  private final NodeReader reader;

  public InputElement(InputNode paramInputNode, NodeReader paramNodeReader, EventNode paramEventNode)
  {
    InputNodeMap localInputNodeMap = new InputNodeMap(this, paramEventNode);
    this.map = localInputNodeMap;
    this.reader = paramNodeReader;
    this.parent = paramInputNode;
    this.node = paramEventNode;
  }

  public InputNode getAttribute(String paramString)
  {
    return this.map.get(paramString);
  }

  public NodeMap<InputNode> getAttributes()
  {
    return this.map;
  }

  public String getName()
  {
    return this.node.getName();
  }

  public InputNode getNext()
    throws Exception
  {
    return this.reader.readElement(this);
  }

  public InputNode getNext(String paramString)
    throws Exception
  {
    return this.reader.readElement(this, paramString);
  }

  public InputNode getParent()
  {
    return this.parent;
  }

  public Position getPosition()
  {
    EventNode localEventNode = this.node;
    return new InputPosition(localEventNode);
  }

  public String getPrefix()
  {
    return this.node.getPrefix();
  }

  public String getReference()
  {
    return this.node.getReference();
  }

  public Object getSource()
  {
    return this.node.getSource();
  }

  public String getValue()
    throws Exception
  {
    return this.reader.readValue(this);
  }

  public boolean isElement()
  {
    return true;
  }

  public boolean isEmpty()
    throws Exception
  {
    if (!this.map.isEmpty());
    for (boolean bool = false; ; bool = this.reader.isEmpty(this))
      return bool;
  }

  public boolean isRoot()
  {
    return this.reader.isRoot(this);
  }

  public void skip()
    throws Exception
  {
    this.reader.skipElement(this);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    String str = getName();
    arrayOfObject[0] = str;
    return String.format("element %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.InputElement
 * JD-Core Version:    0.6.2
 */