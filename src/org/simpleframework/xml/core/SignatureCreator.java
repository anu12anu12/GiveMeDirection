package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.List;

class SignatureCreator
  implements Creator
{
  private final List<Parameter> list;
  private final Signature signature;
  private final Class type;

  public SignatureCreator(Signature paramSignature)
  {
    Class localClass = paramSignature.getType();
    this.type = localClass;
    List localList = paramSignature.getAll();
    this.list = localList;
    this.signature = paramSignature;
  }

  private double getAdjustment(double paramDouble)
  {
    double d1 = this.list.size() / 1000.0D;
    double d2;
    if (paramDouble > 0.0D)
      d2 = this.list.size();
    double d4;
    for (double d3 = paramDouble / d2 + d1; ; d3 = paramDouble / d4)
    {
      return d3;
      d4 = this.list.size();
    }
  }

  private double getPercentage(Criteria paramCriteria)
    throws Exception
  {
    double d1 = -1.0D;
    double d2 = 0.0D;
    Iterator localIterator = this.list.iterator();
    Parameter localParameter;
    if (localIterator.hasNext())
    {
      localParameter = (Parameter)localIterator.next();
      Object localObject = localParameter.getKey();
      if (paramCriteria.get(localObject) == null)
        if (!localParameter.isRequired());
    }
    while (true)
    {
      return d1;
      if (!localParameter.isPrimitive())
        break;
      continue;
      d2 += 1.0D;
      break;
      d1 = getAdjustment(d2);
    }
  }

  private Object getVariable(Criteria paramCriteria, int paramInt)
    throws Exception
  {
    Object localObject1 = ((Parameter)this.list.get(paramInt)).getKey();
    Variable localVariable = paramCriteria.remove(localObject1);
    if (localVariable != null);
    for (Object localObject2 = localVariable.getValue(); ; localObject2 = null)
      return localObject2;
  }

  public Object getInstance()
    throws Exception
  {
    return this.signature.create();
  }

  public Object getInstance(Criteria paramCriteria)
    throws Exception
  {
    Object[] arrayOfObject = this.list.toArray();
    int i = 0;
    while (true)
    {
      int j = this.list.size();
      if (i >= j)
        break;
      Object localObject = getVariable(paramCriteria, i);
      arrayOfObject[i] = localObject;
      i += 1;
    }
    return this.signature.create(arrayOfObject);
  }

  public double getScore(Criteria paramCriteria)
    throws Exception
  {
    double d = -1.0D;
    Signature localSignature = this.signature.copy();
    Iterator localIterator = paramCriteria.iterator();
    Parameter localParameter;
    Contact localContact;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localParameter = localSignature.get(localObject);
      Variable localVariable = paramCriteria.get(localObject);
      localContact = localVariable.getContact();
      if (localParameter != null)
      {
        Class localClass1 = localVariable.getValue().getClass();
        Class localClass2 = localParameter.getType();
        if (Support.isAssignable(localClass1, localClass2));
      }
    }
    while (true)
    {
      return d;
      if ((!localContact.isReadOnly()) || (localParameter != null))
        break;
      continue;
      d = getPercentage(paramCriteria);
    }
  }

  public Signature getSignature()
  {
    return this.signature;
  }

  public Class getType()
  {
    return this.type;
  }

  public String toString()
  {
    return this.signature.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.SignatureCreator
 * JD-Core Version:    0.6.2
 */