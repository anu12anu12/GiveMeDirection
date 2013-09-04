package org.simpleframework.xml.stream;

abstract class Splitter
{
  protected StringBuilder builder;
  protected int count;
  protected int off;
  protected char[] text;

  public Splitter(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.builder = localStringBuilder;
    char[] arrayOfChar = paramString.toCharArray();
    this.text = arrayOfChar;
    int i = this.text.length;
    this.count = i;
  }

  private boolean acronym()
  {
    boolean bool = true;
    int i = this.off;
    int j = 0;
    while (true)
    {
      int k = this.count;
      if (i >= k)
        break;
      char c1 = this.text[i];
      if (!isUpper(c1))
        break;
      j += 1;
      i += 1;
    }
    if (j > 1)
    {
      int m = this.count;
      if (i < m)
      {
        char[] arrayOfChar1 = this.text;
        int n = i + -1;
        char c2 = arrayOfChar1[n];
        if (isUpper(c2))
          i += -1;
      }
      char[] arrayOfChar2 = this.text;
      int i1 = this.off;
      int i2 = this.off;
      int i3 = i - i2;
      commit(arrayOfChar2, i1, i3);
      this.off = i;
    }
    if (j > 1);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  private boolean isDigit(char paramChar)
  {
    return Character.isDigit(paramChar);
  }

  private boolean isLetter(char paramChar)
  {
    return Character.isLetter(paramChar);
  }

  private boolean isSpecial(char paramChar)
  {
    if (!Character.isLetterOrDigit(paramChar));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private boolean isUpper(char paramChar)
  {
    return Character.isUpperCase(paramChar);
  }

  private boolean number()
  {
    int i = this.off;
    int j = 0;
    while (true)
    {
      int k = this.count;
      if (i >= k)
        break;
      char c = this.text[i];
      if (!isDigit(c))
        break;
      j += 1;
      i += 1;
    }
    if (j > 0)
    {
      char[] arrayOfChar = this.text;
      int m = this.off;
      int n = this.off;
      int i1 = i - n;
      commit(arrayOfChar, m, i1);
    }
    this.off = i;
    if (j > 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void token()
  {
    int i = this.off;
    while (true)
    {
      int j = this.count;
      char c;
      if (i < j)
      {
        c = this.text[i];
        if (isLetter(c))
          break label116;
      }
      label116: int i5;
      do
      {
        int k = this.off;
        if (i > k)
        {
          char[] arrayOfChar1 = this.text;
          int m = this.off;
          int n = this.off;
          int i1 = i - n;
          parse(arrayOfChar1, m, i1);
          char[] arrayOfChar2 = this.text;
          int i2 = this.off;
          int i3 = this.off;
          int i4 = i - i3;
          commit(arrayOfChar2, i2, i4);
        }
        this.off = i;
        return;
        i5 = this.off;
      }
      while ((i > i5) && (isUpper(c)));
      i += 1;
    }
  }

  protected abstract void commit(char[] paramArrayOfChar, int paramInt1, int paramInt2);

  protected abstract void parse(char[] paramArrayOfChar, int paramInt1, int paramInt2);

  public String process()
  {
    int i = this.off;
    int j = this.count;
    if (i < j)
      while (true)
      {
        int k = this.off;
        int m = this.count;
        if (k < m)
        {
          char[] arrayOfChar = this.text;
          int n = this.off;
          char c = arrayOfChar[n];
          if (isSpecial(c));
        }
        else
        {
          if (acronym())
            break;
          token();
          boolean bool = number();
          break;
        }
        int i1 = this.off + 1;
        this.off = i1;
      }
    return this.builder.toString();
  }

  protected char toLower(char paramChar)
  {
    return Character.toLowerCase(paramChar);
  }

  protected char toUpper(char paramChar)
  {
    return Character.toUpperCase(paramChar);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Splitter
 * JD-Core Version:    0.6.2
 */