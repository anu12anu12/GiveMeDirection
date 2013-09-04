package org.simpleframework.xml.core;

abstract interface Group
{
  public abstract LabelMap getElements()
    throws Exception;

  public abstract Label getLabel(Class paramClass);

  public abstract Label getText()
    throws Exception;

  public abstract boolean isInline();

  public abstract boolean isTextList();

  public abstract String toString();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Group
 * JD-Core Version:    0.6.2
 */