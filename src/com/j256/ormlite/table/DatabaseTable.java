package com.j256.ormlite.table;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@AnnotationDefault(@DatabaseTable(daoClass=Void.class, tableName=""))
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface DatabaseTable
{
  public abstract Class<?> daoClass();

  public abstract String tableName();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.table.DatabaseTable
 * JD-Core Version:    0.6.2
 */