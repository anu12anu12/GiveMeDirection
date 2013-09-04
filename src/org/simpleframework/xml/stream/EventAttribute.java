package org.simpleframework.xml.stream;

abstract class EventAttribute
  implements Attribute
{
  public String getPrefix()
  {
    return null;
  }

  public String getReference()
  {
    return null;
  }

  public Object getSource()
  {
    return null;
  }

  public boolean isReserved()
  {
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.EventAttribute
 * JD-Core Version:    0.6.2
 */