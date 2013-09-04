package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

class Signature
  implements Iterable<Parameter>
{
  private final Constructor factory;
  private final ParameterMap parameters;
  private final Class type;

  public Signature(Constructor paramConstructor)
  {
    this(paramConstructor, localClass);
  }

  public Signature(Constructor paramConstructor, Class paramClass)
  {
    ParameterMap localParameterMap = new ParameterMap();
    this.parameters = localParameterMap;
    this.factory = paramConstructor;
    this.type = paramClass;
  }

  public Signature(Signature paramSignature)
  {
    this(localConstructor, localClass);
  }

  public void add(Parameter paramParameter)
  {
    Object localObject1 = paramParameter.getKey();
    if (localObject1 == null)
      return;
    Object localObject2 = this.parameters.put(localObject1, paramParameter);
  }

  public boolean contains(Object paramObject)
  {
    return this.parameters.containsKey(paramObject);
  }

  public Signature copy()
    throws Exception
  {
    Signature localSignature = new Signature(this);
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Parameter localParameter = (Parameter)localIterator.next();
      localSignature.add(localParameter);
    }
    return localSignature;
  }

  public Object create()
    throws Exception
  {
    if (!this.factory.isAccessible())
      this.factory.setAccessible(true);
    Constructor localConstructor = this.factory;
    Object[] arrayOfObject = new Object[0];
    return localConstructor.newInstance(arrayOfObject);
  }

  public Object create(Object[] paramArrayOfObject)
    throws Exception
  {
    if (!this.factory.isAccessible())
      this.factory.setAccessible(true);
    return this.factory.newInstance(paramArrayOfObject);
  }

  public Parameter get(int paramInt)
  {
    return this.parameters.get(paramInt);
  }

  public Parameter get(Object paramObject)
  {
    return (Parameter)this.parameters.get(paramObject);
  }

  public List<Parameter> getAll()
  {
    return this.parameters.getAll();
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isEmpty()
  {
    return this.parameters.isEmpty();
  }

  public Iterator<Parameter> iterator()
  {
    return this.parameters.iterator();
  }

  public Parameter remove(Object paramObject)
  {
    return (Parameter)this.parameters.remove(paramObject);
  }

  public void set(Object paramObject, Parameter paramParameter)
  {
    Object localObject = this.parameters.put(paramObject, paramParameter);
  }

  public int size()
  {
    return this.parameters.size();
  }

  public String toString()
  {
    return this.factory.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Signature
 * JD-Core Version:    0.6.2
 */