package org.simpleframework.xml.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

class OutputStack extends ArrayList<OutputNode>
{
  private final Set active;

  public OutputStack(Set paramSet)
  {
    this.active = paramSet;
  }

  public OutputNode bottom()
  {
    if (size() <= 0);
    for (OutputNode localOutputNode = null; ; localOutputNode = (OutputNode)get(0))
      return localOutputNode;
  }

  public Iterator<OutputNode> iterator()
  {
    return new Sequence();
  }

  public OutputNode pop()
  {
    int i = size();
    if (i <= 0);
    int j;
    for (OutputNode localOutputNode = null; ; localOutputNode = purge(j))
    {
      return localOutputNode;
      j = i + -1;
    }
  }

  public OutputNode purge(int paramInt)
  {
    OutputNode localOutputNode = (OutputNode)remove(paramInt);
    if (localOutputNode != null)
      boolean bool = this.active.remove(localOutputNode);
    return localOutputNode;
  }

  public OutputNode push(OutputNode paramOutputNode)
  {
    boolean bool1 = this.active.add(paramOutputNode);
    boolean bool2 = add(paramOutputNode);
    return paramOutputNode;
  }

  public OutputNode top()
  {
    int i = size();
    if (i <= 0);
    int j;
    for (OutputNode localOutputNode = null; ; localOutputNode = (OutputNode)get(j))
    {
      return localOutputNode;
      j = i + -1;
    }
  }

  private class Sequence
    implements Iterator<OutputNode>
  {
    private int cursor;

    public Sequence()
    {
      int i = OutputStack.this.size();
      this.cursor = i;
    }

    public boolean hasNext()
    {
      if (this.cursor > 0);
      for (boolean bool = true; ; bool = false)
        return bool;
    }

    public OutputNode next()
    {
      OutputStack localOutputStack;
      int i;
      if (hasNext())
      {
        localOutputStack = OutputStack.this;
        i = this.cursor + -1;
        this.cursor = i;
      }
      for (OutputNode localOutputNode = (OutputNode)localOutputStack.get(i); ; localOutputNode = null)
        return localOutputNode;
    }

    public void remove()
    {
      OutputStack localOutputStack = OutputStack.this;
      int i = this.cursor;
      OutputNode localOutputNode = localOutputStack.purge(i);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.OutputStack
 * JD-Core Version:    0.6.2
 */