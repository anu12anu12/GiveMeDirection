package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

class Variable
  implements Label
{
  private final Label label;
  private final Object value;

  public Variable(Label paramLabel, Object paramObject)
  {
    this.label = paramLabel;
    this.value = paramObject;
  }

  public Annotation getAnnotation()
  {
    return this.label.getAnnotation();
  }

  public Contact getContact()
  {
    return this.label.getContact();
  }

  public Converter getConverter(Context paramContext)
    throws Exception
  {
    Object localObject1 = this.label.getConverter(paramContext);
    if ((localObject1 instanceof Adapter));
    while (true)
    {
      return localObject1;
      Label localLabel = this.label;
      Object localObject2 = this.value;
      localObject1 = new Adapter((Converter)localObject1, localLabel, localObject2);
    }
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.label.getDecorator();
  }

  public Type getDependent()
    throws Exception
  {
    return this.label.getDependent();
  }

  public Object getEmpty(Context paramContext)
    throws Exception
  {
    return this.label.getEmpty(paramContext);
  }

  public String getEntry()
    throws Exception
  {
    return this.label.getEntry();
  }

  public Expression getExpression()
    throws Exception
  {
    return this.label.getExpression();
  }

  public Object getKey()
    throws Exception
  {
    return this.label.getKey();
  }

  public Label getLabel(Class paramClass)
  {
    return this;
  }

  public String getName()
    throws Exception
  {
    return this.label.getName();
  }

  public String[] getNames()
    throws Exception
  {
    return this.label.getNames();
  }

  public String getOverride()
  {
    return this.label.getOverride();
  }

  public String getPath()
    throws Exception
  {
    return this.label.getPath();
  }

  public String[] getPaths()
    throws Exception
  {
    return this.label.getPaths();
  }

  public Class getType()
  {
    return this.label.getType();
  }

  public Type getType(Class paramClass)
    throws Exception
  {
    return this.label.getType(paramClass);
  }

  public Object getValue()
  {
    return this.value;
  }

  public boolean isAttribute()
  {
    return this.label.isAttribute();
  }

  public boolean isCollection()
  {
    return this.label.isCollection();
  }

  public boolean isData()
  {
    return this.label.isData();
  }

  public boolean isInline()
  {
    return this.label.isInline();
  }

  public boolean isRequired()
  {
    return this.label.isRequired();
  }

  public boolean isText()
  {
    return this.label.isText();
  }

  public boolean isTextList()
  {
    return this.label.isTextList();
  }

  public boolean isUnion()
  {
    return this.label.isUnion();
  }

  public String toString()
  {
    return this.label.toString();
  }

  private static class Adapter
    implements Repeater
  {
    private final Label label;
    private final Converter reader;
    private final Object value;

    public Adapter(Converter paramConverter, Label paramLabel, Object paramObject)
    {
      this.reader = paramConverter;
      this.value = paramObject;
      this.label = paramLabel;
    }

    public Object read(InputNode paramInputNode)
      throws Exception
    {
      Object localObject = this.value;
      return read(paramInputNode, localObject);
    }

    public Object read(InputNode paramInputNode, Object paramObject)
      throws Exception
    {
      Position localPosition = paramInputNode.getPosition();
      String str = paramInputNode.getName();
      if ((this.reader instanceof Repeater))
        return ((Repeater)this.reader).read(paramInputNode, paramObject);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = str;
      Label localLabel = this.label;
      arrayOfObject[1] = localLabel;
      arrayOfObject[2] = localPosition;
      throw new PersistenceException("Element '%s' is already used with %s at %s", arrayOfObject);
    }

    public boolean validate(InputNode paramInputNode)
      throws Exception
    {
      Position localPosition = paramInputNode.getPosition();
      String str = paramInputNode.getName();
      if ((this.reader instanceof Repeater))
        return ((Repeater)this.reader).validate(paramInputNode);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str;
      arrayOfObject[1] = localPosition;
      throw new PersistenceException("Element '%s' declared twice at %s", arrayOfObject);
    }

    public void write(OutputNode paramOutputNode, Object paramObject)
      throws Exception
    {
      write(paramOutputNode, paramObject);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Variable
 * JD-Core Version:    0.6.2
 */