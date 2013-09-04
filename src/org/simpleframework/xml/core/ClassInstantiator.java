package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ClassInstantiator
  implements Instantiator
{
  private final List<Creator> creators;
  private final Detail detail;
  private final Creator primary;
  private final ParameterMap registry;

  public ClassInstantiator(List<Creator> paramList, Creator paramCreator, ParameterMap paramParameterMap, Detail paramDetail)
  {
    this.creators = paramList;
    this.registry = paramParameterMap;
    this.primary = paramCreator;
    this.detail = paramDetail;
  }

  private Creator getCreator(Criteria paramCriteria)
    throws Exception
  {
    Object localObject = this.primary;
    double d1 = 0.0D;
    Iterator localIterator = this.creators.iterator();
    while (localIterator.hasNext())
    {
      Creator localCreator = (Creator)localIterator.next();
      double d2 = localCreator.getScore(paramCriteria);
      if (d2 > d1)
      {
        localObject = localCreator;
        d1 = d2;
      }
    }
    return localObject;
  }

  public List<Creator> getCreators()
  {
    List localList = this.creators;
    return new ArrayList(localList);
  }

  public Object getInstance()
    throws Exception
  {
    return this.primary.getInstance();
  }

  public Object getInstance(Criteria paramCriteria)
    throws Exception
  {
    Creator localCreator = getCreator(paramCriteria);
    if (localCreator == null)
    {
      Object[] arrayOfObject = new Object[1];
      Detail localDetail = this.detail;
      arrayOfObject[0] = localDetail;
      throw new PersistenceException("Constructor not matched for %s", arrayOfObject);
    }
    return localCreator.getInstance(paramCriteria);
  }

  public Parameter getParameter(String paramString)
  {
    return (Parameter)this.registry.get(paramString);
  }

  public List<Parameter> getParameters()
  {
    return this.registry.getAll();
  }

  public boolean isDefault()
  {
    int i = 1;
    if (this.creators.size() <= i)
      if (this.primary == null);
    while (true)
    {
      return i;
      int j = 0;
      continue;
      j = 0;
    }
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    Detail localDetail = this.detail;
    arrayOfObject[0] = localDetail;
    return String.format("creator for %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ClassInstantiator
 * JD-Core Version:    0.6.2
 */