package org.simpleframework.xml.stream;

class CamelCaseBuilder
  implements Style
{
  protected final boolean attribute;
  protected final boolean element;

  public CamelCaseBuilder(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.attribute = paramBoolean2;
    this.element = paramBoolean1;
  }

  public String getAttribute(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = new Attribute(paramString, null).process();
    return str;
  }

  public String getElement(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = new Element(paramString, null).process();
    return str;
  }

  private class Element extends CamelCaseBuilder.Attribute
  {
    private boolean capital;

    private Element(String arg2)
    {
      super(str, null);
    }

    protected void parse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      if ((CamelCaseBuilder.this.element) || (this.capital))
      {
        char c = paramArrayOfChar[paramInt1];
        int i = toUpper(c);
        paramArrayOfChar[paramInt1] = i;
      }
      this.capital = true;
    }
  }

  private class Attribute extends Splitter
  {
    private boolean capital;

    private Attribute(String arg2)
    {
      super();
    }

    protected void commit(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      StringBuilder localStringBuilder = this.builder.append(paramArrayOfChar, paramInt1, paramInt2);
    }

    protected void parse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      if ((CamelCaseBuilder.this.attribute) || (this.capital))
      {
        char c = paramArrayOfChar[paramInt1];
        int i = toUpper(c);
        paramArrayOfChar[paramInt1] = i;
      }
      this.capital = true;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.CamelCaseBuilder
 * JD-Core Version:    0.6.2
 */