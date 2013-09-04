package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

class FieldDetail
{
  private final Field field;
  private final Annotation[] list;
  private final String name;

  public FieldDetail(Field paramField)
  {
    Annotation[] arrayOfAnnotation = paramField.getDeclaredAnnotations();
    this.list = arrayOfAnnotation;
    String str = paramField.getName();
    this.name = str;
    this.field = paramField;
  }

  public Annotation[] getAnnotations()
  {
    return this.list;
  }

  public Field getField()
  {
    return this.field;
  }

  public String getName()
  {
    return this.name;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.FieldDetail
 * JD-Core Version:    0.6.2
 */