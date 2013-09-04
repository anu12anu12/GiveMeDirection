package org.simpleframework.xml.stream;

import java.util.ArrayList;

class Stack<T> extends ArrayList<T>
{
  public Stack(int paramInt)
  {
    super(paramInt);
  }

  public T bottom()
  {
    if (size() <= 0);
    for (Object localObject = null; ; localObject = get(0))
      return localObject;
  }

  public T pop()
  {
    int i = size();
    if (i <= 0);
    int j;
    for (Object localObject = null; ; localObject = remove(j))
    {
      return localObject;
      j = i + -1;
    }
  }

  public T push(T paramT)
  {
    boolean bool = add(paramT);
    return paramT;
  }

  public T top()
  {
    int i = size();
    if (i <= 0);
    int j;
    for (Object localObject = null; ; localObject = get(j))
    {
      return localObject;
      j = i + -1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Stack
 * JD-Core Version:    0.6.2
 */