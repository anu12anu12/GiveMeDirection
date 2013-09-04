package org.simpleframework.xml.stream;

class Indenter
{
  private Cache cache;
  private int count;
  private int indent;
  private int index;

  public Indenter()
  {
    this(localFormat);
  }

  public Indenter(Format paramFormat)
  {
    this(paramFormat, 16);
  }

  private Indenter(Format paramFormat, int paramInt)
  {
    int i = paramFormat.getIndent();
    this.indent = i;
    Cache localCache = new Cache(paramInt);
    this.cache = localCache;
  }

  private String create()
  {
    char[] arrayOfChar = new char[this.count + 1];
    if (this.count > 0)
    {
      arrayOfChar[0] = '\n';
      int i = 1;
      while (true)
      {
        int j = this.count;
        if (i > j)
          break;
        arrayOfChar[i] = ' ';
        i += 1;
      }
    }
    for (String str = new String(arrayOfChar); ; str = "\n")
      return str;
  }

  private String indent(int paramInt)
  {
    String str;
    if (this.indent > 0)
    {
      str = this.cache.get(paramInt);
      if (str == null)
      {
        str = create();
        this.cache.set(paramInt, str);
      }
      if (this.cache.size() <= 0);
    }
    while (true)
    {
      return str;
      str = "";
    }
  }

  public String pop()
  {
    int i = this.index + -1;
    this.index = i;
    String str = indent(i);
    if (this.indent > 0)
    {
      int j = this.count;
      int k = this.indent;
      int m = j - k;
      this.count = m;
    }
    return str;
  }

  public String push()
  {
    int i = this.index;
    int j = i + 1;
    this.index = j;
    String str = indent(i);
    if (this.indent > 0)
    {
      int k = this.count;
      int m = this.indent;
      int n = k + m;
      this.count = n;
    }
    return str;
  }

  public String top()
  {
    int i = this.index;
    return indent(i);
  }

  private static class Cache
  {
    private int count;
    private String[] list;

    public Cache(int paramInt)
    {
      String[] arrayOfString = new String[paramInt];
      this.list = arrayOfString;
    }

    private void resize(int paramInt)
    {
      String[] arrayOfString = new String[paramInt];
      int i = 0;
      while (true)
      {
        int j = this.list.length;
        if (i >= j)
          break;
        String str = this.list[i];
        arrayOfString[i] = str;
        i += 1;
      }
      this.list = arrayOfString;
    }

    public String get(int paramInt)
    {
      int i = this.list.length;
      if (paramInt < i);
      for (String str = this.list[paramInt]; ; str = null)
        return str;
    }

    public void set(int paramInt, String paramString)
    {
      int i = this.list.length;
      if (paramInt >= i)
      {
        int j = paramInt * 2;
        resize(j);
      }
      int k = this.count;
      if (paramInt > k)
        this.count = paramInt;
      this.list[paramInt] = paramString;
    }

    public int size()
    {
      return this.count;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Indenter
 * JD-Core Version:    0.6.2
 */