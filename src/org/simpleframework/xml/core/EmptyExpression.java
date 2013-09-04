package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class EmptyExpression
  implements Expression
{
  private final List<String> list;
  private final Style style;

  public EmptyExpression(Format paramFormat)
  {
    LinkedList localLinkedList = new LinkedList();
    this.list = localLinkedList;
    Style localStyle = paramFormat.getStyle();
    this.style = localStyle;
  }

  public String getAttribute(String paramString)
  {
    return this.style.getAttribute(paramString);
  }

  public String getElement(String paramString)
  {
    return this.style.getElement(paramString);
  }

  public String getFirst()
  {
    return null;
  }

  public int getIndex()
  {
    return 0;
  }

  public String getLast()
  {
    return null;
  }

  public String getPath()
  {
    return "";
  }

  public Expression getPath(int paramInt)
  {
    return null;
  }

  public Expression getPath(int paramInt1, int paramInt2)
  {
    return null;
  }

  public String getPrefix()
  {
    return null;
  }

  public boolean isAttribute()
  {
    return false;
  }

  public boolean isEmpty()
  {
    return true;
  }

  public boolean isPath()
  {
    return false;
  }

  public Iterator<String> iterator()
  {
    return this.list.iterator();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.EmptyExpression
 * JD-Core Version:    0.6.2
 */