package org.simpleframework.xml.filter;

import java.util.Stack;

public class StackFilter
  implements Filter
{
  private Stack<Filter> stack;

  public StackFilter()
  {
    Stack localStack = new Stack();
    this.stack = localStack;
  }

  public void push(Filter paramFilter)
  {
    Object localObject = this.stack.push(paramFilter);
  }

  public String replace(String paramString)
  {
    int i = this.stack.size();
    String str;
    do
    {
      i += -1;
      if (i < 0)
        break;
      str = ((Filter)this.stack.get(i)).replace(paramString);
    }
    while (str == null);
    while (true)
    {
      return str;
      str = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.filter.StackFilter
 * JD-Core Version:    0.6.2
 */