package com.j256.ormlite.field;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@AnnotationDefault(@ForeignCollectionField(columnName="", eager=false, foreignColumnName="", foreignFieldName="", maxEagerForeignCollectionLevel=1, maxEagerLevel=1, orderColumnName=""))
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ForeignCollectionField
{
  public static final int MAX_EAGER_LEVEL = 1;

  public abstract String columnName();

  public abstract boolean eager();

  @Deprecated
  public abstract String foreignColumnName();

  public abstract String foreignFieldName();

  @Deprecated
  public abstract int maxEagerForeignCollectionLevel();

  public abstract int maxEagerLevel();

  public abstract String orderColumnName();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.ForeignCollectionField
 * JD-Core Version:    0.6.2
 */