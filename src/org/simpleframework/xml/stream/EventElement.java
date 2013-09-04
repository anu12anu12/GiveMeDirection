package org.simpleframework.xml.stream;

import java.util.ArrayList;

abstract class EventElement extends ArrayList<Attribute>
  implements EventNode
{
  public int getLine()
  {
    return -1;
  }

  public String getValue()
  {
    return null;
  }

  public boolean isEnd()
  {
    return false;
  }

  public boolean isStart()
  {
    return true;
  }

  public boolean isText()
  {
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.EventElement
 * JD-Core Version:    0.6.2
 */