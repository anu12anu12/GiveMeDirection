package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class ModelMap extends LinkedHashMap<String, ModelList>
  implements Iterable<ModelList>
{
  private final Detail detail;

  public ModelMap(Detail paramDetail)
  {
    this.detail = paramDetail;
  }

  public ModelMap getModels()
    throws Exception
  {
    Detail localDetail1 = this.detail;
    ModelMap localModelMap = new ModelMap(localDetail1);
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ModelList localModelList = (ModelList)get(str);
      if (localModelList != null)
        localModelList = localModelList.build();
      if (localModelMap.containsKey(str))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        Detail localDetail2 = this.detail;
        arrayOfObject[1] = localDetail2;
        throw new PathException("Path with name '%s' is a duplicate in %s ", arrayOfObject);
      }
      Object localObject = localModelMap.put(str, localModelList);
    }
    return localModelMap;
  }

  public Iterator<ModelList> iterator()
  {
    return values().iterator();
  }

  public Model lookup(String paramString, int paramInt)
  {
    ModelList localModelList = (ModelList)get(paramString);
    if (localModelList != null);
    for (Model localModel = localModelList.lookup(paramInt); ; localModel = null)
      return localModel;
  }

  public void register(String paramString, Model paramModel)
  {
    ModelList localModelList = (ModelList)get(paramString);
    if (localModelList == null)
    {
      localModelList = new ModelList();
      Object localObject = put(paramString, localModelList);
    }
    localModelList.register(paramModel);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ModelMap
 * JD-Core Version:    0.6.2
 */