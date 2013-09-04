package org.simpleframework.xml.stream;

class InputPosition
  implements Position
{
  private EventNode source;

  public InputPosition(EventNode paramEventNode)
  {
    this.source = paramEventNode;
  }

  public int getLine()
  {
    return this.source.getLine();
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    Integer localInteger = Integer.valueOf(getLine());
    arrayOfObject[0] = localInteger;
    return String.format("line %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.InputPosition
 * JD-Core Version:    0.6.2
 */