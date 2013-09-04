package org.simpleframework.xml.core;

class Template
{
  protected char[] buf;
  protected String cache;
  protected int count;

  public Template()
  {
    this(16);
  }

  public Template(int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    this.buf = arrayOfChar;
  }

  public void append(char paramChar)
  {
    int i = this.count + 1;
    ensureCapacity(i);
    char[] arrayOfChar = this.buf;
    int j = this.count;
    int k = j + 1;
    this.count = k;
    arrayOfChar[j] = paramChar;
  }

  public void append(String paramString)
  {
    int i = this.count;
    int j = paramString.length();
    int k = i + j;
    ensureCapacity(k);
    int m = paramString.length();
    char[] arrayOfChar = this.buf;
    int n = this.count;
    paramString.getChars(0, m, arrayOfChar, n);
    int i1 = this.count;
    int i2 = paramString.length();
    int i3 = i1 + i2;
    this.count = i3;
  }

  public void append(String paramString, int paramInt1, int paramInt2)
  {
    int i = this.count + paramInt2;
    ensureCapacity(i);
    char[] arrayOfChar = this.buf;
    int j = this.count;
    paramString.getChars(paramInt1, paramInt2, arrayOfChar, j);
    int k = this.count + paramInt2;
    this.count = k;
  }

  public void append(Template paramTemplate)
  {
    char[] arrayOfChar = paramTemplate.buf;
    int i = paramTemplate.count;
    append(arrayOfChar, 0, i);
  }

  public void append(Template paramTemplate, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = paramTemplate.buf;
    append(arrayOfChar, paramInt1, paramInt2);
  }

  public void append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = this.count + paramInt2;
    ensureCapacity(i);
    char[] arrayOfChar = this.buf;
    int j = this.count;
    System.arraycopy(paramArrayOfChar, paramInt1, arrayOfChar, j, paramInt2);
    int k = this.count + paramInt2;
    this.count = k;
  }

  public void clear()
  {
    this.cache = null;
    this.count = 0;
  }

  protected void ensureCapacity(int paramInt)
  {
    if (this.buf.length >= paramInt)
      return;
    int i = this.buf.length * 2;
    char[] arrayOfChar1 = new char[Math.max(paramInt, i)];
    char[] arrayOfChar2 = this.buf;
    int j = this.count;
    System.arraycopy(arrayOfChar2, 0, arrayOfChar1, 0, j);
    this.buf = arrayOfChar1;
  }

  public int length()
  {
    return this.count;
  }

  public String toString()
  {
    char[] arrayOfChar = this.buf;
    int i = this.count;
    return new String(arrayOfChar, 0, i);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Template
 * JD-Core Version:    0.6.2
 */