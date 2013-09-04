package org.simpleframework.xml.stream;

import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class NodeWriter
{
  private final Set active;
  private final OutputStack stack;
  private final boolean verbose;
  private final Formatter writer;

  public NodeWriter(Writer paramWriter)
  {
    this(paramWriter, localFormat);
  }

  public NodeWriter(Writer paramWriter, Format paramFormat)
  {
    this(paramWriter, paramFormat, false);
  }

  private NodeWriter(Writer paramWriter, Format paramFormat, boolean paramBoolean)
  {
    Formatter localFormatter = new Formatter(paramWriter, paramFormat);
    this.writer = localFormatter;
    HashSet localHashSet = new HashSet();
    this.active = localHashSet;
    Set localSet = this.active;
    OutputStack localOutputStack = new OutputStack(localSet);
    this.stack = localOutputStack;
    this.verbose = paramBoolean;
  }

  private void writeAttributes(OutputNode paramOutputNode)
    throws Exception
  {
    NodeMap localNodeMap = paramOutputNode.getAttributes();
    Iterator localIterator = localNodeMap.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      OutputNode localOutputNode = (OutputNode)localNodeMap.get(str1);
      String str2 = localOutputNode.getValue();
      boolean bool1 = this.verbose;
      String str3 = localOutputNode.getPrefix(bool1);
      this.writer.writeAttribute(str1, str2, str3);
    }
    boolean bool2 = this.active.remove(paramOutputNode);
  }

  private void writeComment(OutputNode paramOutputNode)
    throws Exception
  {
    String str = paramOutputNode.getComment();
    if (str == null)
      return;
    this.writer.writeComment(str);
  }

  private void writeEnd(OutputNode paramOutputNode)
    throws Exception
  {
    String str1 = paramOutputNode.getName();
    boolean bool = this.verbose;
    String str2 = paramOutputNode.getPrefix(bool);
    if (paramOutputNode.getValue() != null)
      writeValue(paramOutputNode);
    if (str1 == null)
      return;
    this.writer.writeEnd(str1, str2);
    this.writer.flush();
  }

  private void writeName(OutputNode paramOutputNode)
    throws Exception
  {
    boolean bool = this.verbose;
    String str1 = paramOutputNode.getPrefix(bool);
    String str2 = paramOutputNode.getName();
    if (str2 == null)
      return;
    this.writer.writeStart(str2, str1);
  }

  private void writeNamespaces(OutputNode paramOutputNode)
    throws Exception
  {
    NamespaceMap localNamespaceMap = paramOutputNode.getNamespaces();
    Iterator localIterator = localNamespaceMap.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str1 = (String)localIterator.next();
      String str2 = localNamespaceMap.getPrefix(str1);
      this.writer.writeNamespace(str1, str2);
    }
  }

  private OutputNode writeStart(OutputNode paramOutputNode, String paramString)
    throws Exception
  {
    OutputElement localOutputElement = new OutputElement(paramOutputNode, this, paramString);
    if (paramString == null)
      throw new NodeException("Can not have a null name");
    return this.stack.push(localOutputElement);
  }

  private void writeStart(OutputNode paramOutputNode)
    throws Exception
  {
    writeComment(paramOutputNode);
    writeName(paramOutputNode);
    writeAttributes(paramOutputNode);
    writeNamespaces(paramOutputNode);
  }

  private void writeValue(OutputNode paramOutputNode)
    throws Exception
  {
    Mode localMode1 = paramOutputNode.getMode();
    String str = paramOutputNode.getValue();
    Iterator localIterator;
    if (str != null)
      localIterator = this.stack.iterator();
    while (true)
    {
      OutputNode localOutputNode;
      if (localIterator.hasNext())
      {
        localOutputNode = (OutputNode)localIterator.next();
        Mode localMode2 = Mode.INHERIT;
        if (localMode1 == localMode2);
      }
      else
      {
        this.writer.writeText(str, localMode1);
        paramOutputNode.setValue(null);
        return;
      }
      localMode1 = localOutputNode.getMode();
    }
  }

  public void commit(OutputNode paramOutputNode)
    throws Exception
  {
    if (!this.stack.contains(paramOutputNode))
      return;
    OutputNode localOutputNode1 = this.stack.top();
    if (!isCommitted(localOutputNode1))
      writeStart(localOutputNode1);
    while (this.stack.top() != paramOutputNode)
    {
      OutputNode localOutputNode2 = this.stack.pop();
      writeEnd(localOutputNode2);
    }
    writeEnd(paramOutputNode);
    OutputNode localOutputNode3 = this.stack.pop();
  }

  public boolean isCommitted(OutputNode paramOutputNode)
  {
    if (!this.active.contains(paramOutputNode));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isRoot(OutputNode paramOutputNode)
  {
    if (this.stack.bottom() == paramOutputNode);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void remove(OutputNode paramOutputNode)
    throws Exception
  {
    if (this.stack.top() != paramOutputNode)
      throw new NodeException("Cannot remove node");
    OutputNode localOutputNode = this.stack.pop();
  }

  public OutputNode writeElement(OutputNode paramOutputNode, String paramString)
    throws Exception
  {
    OutputNode localOutputNode1;
    if (this.stack.isEmpty())
      localOutputNode1 = writeStart(paramOutputNode, paramString);
    while (true)
    {
      return localOutputNode1;
      if (this.stack.contains(paramOutputNode))
      {
        OutputNode localOutputNode2 = this.stack.top();
        if (!isCommitted(localOutputNode2))
          writeStart(localOutputNode2);
        while (this.stack.top() != paramOutputNode)
        {
          OutputNode localOutputNode3 = this.stack.pop();
          writeEnd(localOutputNode3);
        }
        if (!this.stack.isEmpty())
          writeValue(paramOutputNode);
        localOutputNode1 = writeStart(paramOutputNode, paramString);
      }
      else
      {
        localOutputNode1 = null;
      }
    }
  }

  public OutputNode writeRoot()
    throws Exception
  {
    OutputStack localOutputStack = this.stack;
    OutputDocument localOutputDocument = new OutputDocument(this, localOutputStack);
    if (this.stack.isEmpty())
      this.writer.writeProlog();
    return localOutputDocument;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeWriter
 * JD-Core Version:    0.6.2
 */