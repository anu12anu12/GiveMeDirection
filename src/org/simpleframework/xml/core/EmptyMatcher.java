package org.simpleframework.xml.core;

import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;

class EmptyMatcher
  implements Matcher
{
  public Transform match(Class paramClass)
    throws Exception
  {
    return null;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.EmptyMatcher
 * JD-Core Version:    0.6.2
 */