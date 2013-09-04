package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

abstract interface Contact extends Type
{
  public abstract Object get(Object paramObject)
    throws Exception;

  public abstract Annotation getAnnotation();

  public abstract Class getDeclaringClass();

  public abstract Class getDependent();

  public abstract Class[] getDependents();

  public abstract String getName();

  public abstract boolean isReadOnly();

  public abstract void set(Object paramObject1, Object paramObject2)
    throws Exception;

  public abstract String toString();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Contact
 * JD-Core Version:    0.6.2
 */