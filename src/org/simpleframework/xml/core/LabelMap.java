package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class LabelMap extends LinkedHashMap<String, Label>
  implements Iterable<Label>
{
  private final Policy policy;

  public LabelMap()
  {
    this(null);
  }

  public LabelMap(Policy paramPolicy)
  {
    this.policy = paramPolicy;
  }

  private String[] getArray(Set<String> paramSet)
  {
    String[] arrayOfString = new String[0];
    return (String[])paramSet.toArray(arrayOfString);
  }

  public String[] getKeys()
    throws Exception
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel != null)
      {
        String str1 = localLabel.getPath();
        String str2 = localLabel.getName();
        boolean bool1 = localHashSet.add(str1);
        boolean bool2 = localHashSet.add(str2);
      }
    }
    return getArray(localHashSet);
  }

  public Label getLabel(String paramString)
  {
    return (Label)remove(paramString);
  }

  public LabelMap getLabels()
    throws Exception
  {
    Policy localPolicy = this.policy;
    LabelMap localLabelMap = new LabelMap(localPolicy);
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel != null)
      {
        String str = localLabel.getPath();
        Object localObject = localLabelMap.put(str, localLabel);
      }
    }
    return localLabelMap;
  }

  public String[] getPaths()
    throws Exception
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel != null)
      {
        String str = localLabel.getPath();
        boolean bool = localHashSet.add(str);
      }
    }
    return getArray(localHashSet);
  }

  public boolean isStrict(Context paramContext)
  {
    boolean bool;
    if (this.policy == null)
      bool = paramContext.isStrict();
    while (true)
    {
      return bool;
      if ((paramContext.isStrict()) && (this.policy.isStrict()))
        bool = true;
      else
        bool = false;
    }
  }

  public Iterator<Label> iterator()
  {
    return values().iterator();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.LabelMap
 * JD-Core Version:    0.6.2
 */