package org.simpleframework.xml.strategy;

import java.util.Map;

class Allocate
  implements Value
{
  private String key;
  private Map map;
  private Value value;

  public Allocate(Value paramValue, Map paramMap, String paramString)
  {
    this.value = paramValue;
    this.map = paramMap;
    this.key = paramString;
  }

  public int getLength()
  {
    return this.value.getLength();
  }

  public Class getType()
  {
    return this.value.getType();
  }

  public Object getValue()
  {
    Map localMap = this.map;
    String str = this.key;
    return localMap.get(str);
  }

  public boolean isReference()
  {
    return false;
  }

  public void setValue(Object paramObject)
  {
    if (this.key != null)
    {
      Map localMap = this.map;
      String str = this.key;
      Object localObject = localMap.put(str, paramObject);
    }
    this.value.setValue(paramObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Allocate
 * JD-Core Version:    0.6.2
 */