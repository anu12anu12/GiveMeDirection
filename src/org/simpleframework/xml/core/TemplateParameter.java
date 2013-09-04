package org.simpleframework.xml.core;

abstract class TemplateParameter
  implements Parameter
{
  public boolean isAttribute()
  {
    return false;
  }

  public boolean isText()
  {
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TemplateParameter
 * JD-Core Version:    0.6.2
 */