package org.simpleframework.xml;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationDefault(@ElementMap(attribute=false, data=false, empty=true, entry="", inline=false, key="", keyType=void.class, name="", required=true, value="", valueType=void.class))
@Retention(RetentionPolicy.RUNTIME)
public @interface ElementMap
{
  public abstract boolean attribute();

  public abstract boolean data();

  public abstract boolean empty();

  public abstract String entry();

  public abstract boolean inline();

  public abstract String key();

  public abstract Class keyType();

  public abstract String name();

  public abstract boolean required();

  public abstract String value();

  public abstract Class valueType();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.ElementMap
 * JD-Core Version:    0.6.2
 */