package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

public class ThreadLocalSelectArg extends BaseArgumentHolder
  implements ArgumentHolder
{
  private ThreadLocal<ValueWrapper> threadValue;

  public ThreadLocalSelectArg()
  {
    ThreadLocal localThreadLocal = new ThreadLocal();
    this.threadValue = localThreadLocal;
  }

  public ThreadLocalSelectArg(SqlType paramSqlType, Object paramObject)
  {
    super(paramSqlType);
    ThreadLocal localThreadLocal = new ThreadLocal();
    this.threadValue = localThreadLocal;
    setValue(paramObject);
  }

  public ThreadLocalSelectArg(Object paramObject)
  {
    ThreadLocal localThreadLocal = new ThreadLocal();
    this.threadValue = localThreadLocal;
    setValue(paramObject);
  }

  public ThreadLocalSelectArg(String paramString, Object paramObject)
  {
    super(paramString);
    ThreadLocal localThreadLocal = new ThreadLocal();
    this.threadValue = localThreadLocal;
    setValue(paramObject);
  }

  protected Object getValue()
  {
    ValueWrapper localValueWrapper = (ValueWrapper)this.threadValue.get();
    if (localValueWrapper == null);
    for (Object localObject = null; ; localObject = localValueWrapper.value)
      return localObject;
  }

  protected boolean isValueSet()
  {
    if (this.threadValue.get() != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void setValue(Object paramObject)
  {
    ThreadLocal localThreadLocal = this.threadValue;
    ValueWrapper localValueWrapper = new ValueWrapper(paramObject);
    localThreadLocal.set(localValueWrapper);
  }

  private static class ValueWrapper
  {
    Object value;

    public ValueWrapper(Object paramObject)
    {
      this.value = paramObject;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.ThreadLocalSelectArg
 * JD-Core Version:    0.6.2
 */