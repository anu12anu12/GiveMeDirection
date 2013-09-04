package org.simpleframework.xml.core;

import java.lang.reflect.Method;
import java.util.Map;

class Function
{
  private final boolean contextual;
  private final Method method;

  public Function(Method paramMethod)
  {
    this(paramMethod, false);
  }

  public Function(Method paramMethod, boolean paramBoolean)
  {
    this.contextual = paramBoolean;
    this.method = paramMethod;
  }

  public Object call(Context paramContext, Object paramObject)
    throws Exception
  {
    Object localObject;
    if (paramObject != null)
    {
      Map localMap = paramContext.getSession().getMap();
      if (this.contextual)
      {
        Method localMethod1 = this.method;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localMap;
        localObject = localMethod1.invoke(paramObject, arrayOfObject1);
      }
    }
    while (true)
    {
      return localObject;
      Method localMethod2 = this.method;
      Object[] arrayOfObject2 = new Object[0];
      localObject = localMethod2.invoke(paramObject, arrayOfObject2);
      continue;
      localObject = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Function
 * JD-Core Version:    0.6.2
 */