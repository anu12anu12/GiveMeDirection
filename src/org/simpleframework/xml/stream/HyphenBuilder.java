package org.simpleframework.xml.stream;

class HyphenBuilder
  implements Style
{
  public String getAttribute(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = new Parser(paramString, null).process();
    return str;
  }

  public String getElement(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = new Parser(paramString, null).process();
    return str;
  }

  private class Parser extends Splitter
  {
    private Parser(String arg2)
    {
      super();
    }

    protected void commit(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      StringBuilder localStringBuilder1 = this.builder.append(paramArrayOfChar, paramInt1, paramInt2);
      int i = paramInt1 + paramInt2;
      int j = this.count;
      if (i >= j)
        return;
      StringBuilder localStringBuilder2 = this.builder.append('-');
    }

    protected void parse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      char c = paramArrayOfChar[paramInt1];
      int i = toLower(c);
      paramArrayOfChar[paramInt1] = i;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.HyphenBuilder
 * JD-Core Version:    0.6.2
 */