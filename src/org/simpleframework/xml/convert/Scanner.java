package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;

abstract interface Scanner
{
  public abstract <T extends Annotation> T scan(Class<T> paramClass);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.Scanner
 * JD-Core Version:    0.6.2
 */