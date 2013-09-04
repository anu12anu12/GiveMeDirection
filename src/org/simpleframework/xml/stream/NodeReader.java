package org.simpleframework.xml.stream;

class NodeReader
{
  private final EventReader reader;
  private final InputStack stack;
  private final StringBuilder text;

  public NodeReader(EventReader paramEventReader)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.text = localStringBuilder;
    InputStack localInputStack = new InputStack();
    this.stack = localInputStack;
    this.reader = paramEventReader;
  }

  private void fillText(InputNode paramInputNode)
    throws Exception
  {
    EventNode localEventNode = this.reader.peek();
    if (!localEventNode.isText())
      return;
    String str = localEventNode.getValue();
    StringBuilder localStringBuilder = this.text.append(str);
  }

  private boolean isName(EventNode paramEventNode, String paramString)
  {
    String str = paramEventNode.getName();
    if (str == null);
    for (boolean bool = false; ; bool = str.equals(paramString))
      return bool;
  }

  private String readBuffer(InputNode paramInputNode)
    throws Exception
  {
    String str;
    if (this.text.length() > 0)
    {
      str = this.text.toString();
      this.text.setLength(0);
    }
    while (true)
    {
      return str;
      str = null;
    }
  }

  private InputNode readStart(InputNode paramInputNode, EventNode paramEventNode)
    throws Exception
  {
    InputElement localInputElement = new InputElement(paramInputNode, this, paramEventNode);
    if (this.text.length() > 0)
      this.text.setLength(0);
    if (paramEventNode.isStart());
    for (Object localObject = (InputNode)this.stack.push(localInputElement); ; localObject = localInputElement)
      return localObject;
  }

  private String readText(InputNode paramInputNode)
    throws Exception
  {
    for (EventNode localEventNode1 = this.reader.peek(); (this.stack.top() == paramInputNode) && (localEventNode1.isText()); localEventNode1 = this.reader.peek())
    {
      fillText(paramInputNode);
      EventNode localEventNode2 = this.reader.next();
    }
    return readBuffer(paramInputNode);
  }

  public boolean isEmpty(InputNode paramInputNode)
    throws Exception
  {
    if ((this.stack.top() == paramInputNode) && (this.reader.peek().isEnd()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isRoot(InputNode paramInputNode)
  {
    if (this.stack.bottom() == paramInputNode);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public InputNode readElement(InputNode paramInputNode)
    throws Exception
  {
    InputNode localInputNode = null;
    if (!this.stack.isRelevant(paramInputNode));
    while (true)
    {
      return localInputNode;
      EventNode localEventNode = this.reader.next();
      label25: if (localEventNode != null)
      {
        if (localEventNode.isEnd())
          if (this.stack.pop() == paramInputNode)
            continue;
      }
      else
      {
        while (!localEventNode.isStart())
        {
          localEventNode = this.reader.next();
          break label25;
          break;
        }
        localInputNode = readStart(paramInputNode, localEventNode);
      }
    }
  }

  public InputNode readElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    InputNode localInputNode = null;
    if (!this.stack.isRelevant(paramInputNode));
    while (true)
    {
      return localInputNode;
      EventNode localEventNode1 = this.reader.peek();
      label26: if (localEventNode1 != null)
      {
        if (!localEventNode1.isText())
          break label71;
        fillText(paramInputNode);
      }
      label71: label104: 
      do
        while (true)
        {
          EventNode localEventNode2 = this.reader.next();
          localEventNode1 = this.reader.peek();
          break label26;
          break;
          if (!localEventNode1.isEnd())
            break label104;
          if (this.stack.top() == paramInputNode)
            break;
          Object localObject = this.stack.pop();
        }
      while (!localEventNode1.isStart());
      if (isName(localEventNode1, paramString))
        localInputNode = readElement(paramInputNode);
    }
  }

  public InputNode readRoot()
    throws Exception
  {
    InputNode localInputNode = null;
    if (this.stack.isEmpty())
    {
      localInputNode = readElement(null);
      if (localInputNode == null)
        throw new NodeException("Document has no root element");
    }
    return localInputNode;
  }

  public String readValue(InputNode paramInputNode)
    throws Exception
  {
    String str = null;
    if (!this.stack.isRelevant(paramInputNode));
    while (true)
    {
      return str;
      if ((this.text.length() <= 0) && (this.reader.peek().isEnd()))
      {
        if (this.stack.top() != paramInputNode)
        {
          Object localObject = this.stack.pop();
          EventNode localEventNode = this.reader.next();
        }
      }
      else
        str = readText(paramInputNode);
    }
  }

  public void skipElement(InputNode paramInputNode)
    throws Exception
  {
    while (readElement(paramInputNode) != null);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeReader
 * JD-Core Version:    0.6.2
 */