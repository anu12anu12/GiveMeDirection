package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class Collector
  implements Criteria
{
  private final Registry alias;
  private final Registry registry;

  public Collector()
  {
    Registry localRegistry1 = new Registry(null);
    this.registry = localRegistry1;
    Registry localRegistry2 = new Registry(null);
    this.alias = localRegistry2;
  }

  public void commit(Object paramObject)
    throws Exception
  {
    Iterator localIterator = this.registry.values().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Variable localVariable = (Variable)localIterator.next();
      Contact localContact = localVariable.getContact();
      Object localObject = localVariable.getValue();
      localContact.set(paramObject, localObject);
    }
  }

  public Variable get(Object paramObject)
  {
    return (Variable)this.registry.get(paramObject);
  }

  public Variable get(Label paramLabel)
    throws Exception
  {
    Object localObject;
    if (paramLabel != null)
      localObject = paramLabel.getKey();
    for (Variable localVariable = (Variable)this.registry.get(localObject); ; localVariable = null)
      return localVariable;
  }

  public Iterator<Object> iterator()
  {
    return this.registry.iterator();
  }

  public Variable remove(Object paramObject)
    throws Exception
  {
    return (Variable)this.registry.remove(paramObject);
  }

  public Variable resolve(String paramString)
  {
    return (Variable)this.alias.get(paramString);
  }

  public void set(Label paramLabel, Object paramObject)
    throws Exception
  {
    Variable localVariable = new Variable(paramLabel, paramObject);
    if (paramLabel == null)
      return;
    String[] arrayOfString1 = paramLabel.getPaths();
    Object localObject1 = paramLabel.getKey();
    String[] arrayOfString2 = arrayOfString1;
    int i = arrayOfString2.length;
    int j = 0;
    while (j < i)
    {
      String str = arrayOfString2[j];
      Object localObject2 = this.alias.put(str, localVariable);
      j += 1;
    }
    Object localObject3 = this.registry.put(localObject1, localVariable);
  }

  private static class Registry extends LinkedHashMap<Object, Variable>
  {
    public Iterator<Object> iterator()
    {
      return keySet().iterator();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Collector
 * JD-Core Version:    0.6.2
 */