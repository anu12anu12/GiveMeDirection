package org.simpleframework.xml.stream;

public class Format
{
  private int indent;
  private String prolog;
  private Style style;

  public Format()
  {
    this(3);
  }

  public Format(int paramInt)
  {
    this(paramInt, null, localIdentityStyle);
  }

  public Format(int paramInt, String paramString)
  {
    this(paramInt, paramString, localIdentityStyle);
  }

  public Format(int paramInt, String paramString, Style paramStyle)
  {
    this.prolog = paramString;
    this.indent = paramInt;
    this.style = paramStyle;
  }

  public Format(int paramInt, Style paramStyle)
  {
    this(paramInt, null, paramStyle);
  }

  public Format(String paramString)
  {
    this(3, paramString);
  }

  public Format(Style paramStyle)
  {
    this(3, null, paramStyle);
  }

  public int getIndent()
  {
    return this.indent;
  }

  public String getProlog()
  {
    return this.prolog;
  }

  public Style getStyle()
  {
    return this.style;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Format
 * JD-Core Version:    0.6.2
 */