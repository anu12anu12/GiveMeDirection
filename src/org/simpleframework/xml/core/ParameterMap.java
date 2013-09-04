package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class ParameterMap extends LinkedHashMap<Object, Parameter>
  implements Iterable<Parameter>
{
  public Parameter get(int paramInt)
  {
    return (Parameter)getAll().get(paramInt);
  }

  public List<Parameter> getAll()
  {
    Collection localCollection = values();
    if (!localCollection.isEmpty());
    for (Object localObject = new ArrayList(localCollection); ; localObject = Collections.emptyList())
      return localObject;
  }

  public Iterator<Parameter> iterator()
  {
    return values().iterator();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ParameterMap
 * JD-Core Version:    0.6.2
 */