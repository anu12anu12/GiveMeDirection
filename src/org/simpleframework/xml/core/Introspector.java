package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

class Introspector
{
  private final Contact contact;
  private final Format format;
  private final Label label;
  private final Annotation marker;

  public Introspector(Contact paramContact, Label paramLabel, Format paramFormat)
  {
    Annotation localAnnotation = paramContact.getAnnotation();
    this.marker = localAnnotation;
    this.contact = paramContact;
    this.format = paramFormat;
    this.label = paramLabel;
  }

  private String getDefault()
    throws Exception
  {
    String str = this.label.getOverride();
    if (!isEmpty(str));
    while (true)
    {
      return str;
      str = this.contact.getName();
    }
  }

  private String getName(Class paramClass)
    throws Exception
  {
    String str1 = getRoot(paramClass);
    if (str1 != null);
    for (String str2 = str1; ; str2 = Reflector.getName(paramClass.getSimpleName()))
      return str2;
  }

  private String getRoot(Class paramClass)
  {
    Class localClass = paramClass;
    String str;
    if (paramClass != null)
    {
      str = getRoot(localClass, paramClass);
      if (str == null);
    }
    while (true)
    {
      return str;
      paramClass = paramClass.getSuperclass();
      break;
      str = null;
    }
  }

  private String getRoot(Class<?> paramClass1, Class<?> paramClass2)
  {
    String str1 = paramClass2.getSimpleName();
    Root localRoot = (Root)paramClass2.getAnnotation(Root.class);
    String str2;
    if (localRoot != null)
    {
      str2 = localRoot.name();
      if (isEmpty(str2));
    }
    while (true)
    {
      return str2;
      str2 = Reflector.getName(str1);
      continue;
      str2 = null;
    }
  }

  public Contact getContact()
  {
    return this.contact;
  }

  public Type getDependent()
    throws Exception
  {
    return this.label.getDependent();
  }

  public String getEntry()
    throws Exception
  {
    Class localClass = getDependent().getType();
    if (localClass.isArray())
      localClass = localClass.getComponentType();
    return getName(localClass);
  }

  public Expression getExpression()
    throws Exception
  {
    String str = getPath();
    Contact localContact;
    Format localFormat1;
    if (str != null)
    {
      localContact = this.contact;
      localFormat1 = this.format;
    }
    Format localFormat2;
    for (Object localObject = new PathParser(str, localContact, localFormat1); ; localObject = new EmptyExpression(localFormat2))
    {
      return localObject;
      localFormat2 = this.format;
    }
  }

  public String getName()
    throws Exception
  {
    String str = this.label.getEntry();
    if (!this.label.isInline())
      str = getDefault();
    return str;
  }

  public String getPath()
    throws Exception
  {
    Path localPath = (Path)this.contact.getAnnotation(Path.class);
    if (localPath == null);
    for (String str = null; ; str = localPath.value())
      return str;
  }

  public boolean isEmpty(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.length() == 0));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    Annotation localAnnotation = this.marker;
    arrayOfObject[0] = localAnnotation;
    Contact localContact = this.contact;
    arrayOfObject[1] = localContact;
    return String.format("%s on %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Introspector
 * JD-Core Version:    0.6.2
 */