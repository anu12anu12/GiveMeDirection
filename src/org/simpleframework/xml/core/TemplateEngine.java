package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

class TemplateEngine
{
  private Filter filter;
  private Template name;
  private int off;
  private Template source;
  private Template text;

  public TemplateEngine(Filter paramFilter)
  {
    Template localTemplate1 = new Template();
    this.source = localTemplate1;
    Template localTemplate2 = new Template();
    this.name = localTemplate2;
    Template localTemplate3 = new Template();
    this.text = localTemplate3;
    this.filter = paramFilter;
  }

  private void name()
  {
    while (true)
    {
      int i = this.off;
      int j = this.source.count;
      char c;
      if (i < j)
      {
        char[] arrayOfChar = this.source.buf;
        int k = this.off;
        int m = k + 1;
        this.off = m;
        c = arrayOfChar[k];
        if (c == '}')
          replace();
      }
      else
      {
        if (this.name.length() <= 0)
          return;
        this.text.append("${");
        Template localTemplate1 = this.text;
        Template localTemplate2 = this.name;
        localTemplate1.append(localTemplate2);
        return;
      }
      this.name.append(c);
    }
  }

  private void parse()
  {
    while (true)
    {
      int i = this.off;
      int j = this.source.count;
      if (i >= j)
        return;
      char[] arrayOfChar1 = this.source.buf;
      int k = this.off;
      int m = k + 1;
      this.off = m;
      char c = arrayOfChar1[k];
      if (c == '$')
      {
        int n = this.off;
        int i1 = this.source.count;
        if (n < i1)
        {
          char[] arrayOfChar2 = this.source.buf;
          int i2 = this.off;
          int i3 = i2 + 1;
          this.off = i3;
          if (arrayOfChar2[i2] == '{')
          {
            name();
            continue;
          }
          int i4 = this.off + -1;
          this.off = i4;
        }
      }
      else
      {
        this.text.append(c);
      }
    }
  }

  private void replace()
  {
    if (this.name.length() > 0)
    {
      Template localTemplate = this.name;
      replace(localTemplate);
    }
    this.name.clear();
  }

  private void replace(String paramString)
  {
    String str = this.filter.replace(paramString);
    if (str == null)
    {
      this.text.append("${");
      this.text.append(paramString);
      this.text.append("}");
      return;
    }
    this.text.append(str);
  }

  private void replace(Template paramTemplate)
  {
    String str = paramTemplate.toString();
    replace(str);
  }

  public void clear()
  {
    this.name.clear();
    this.text.clear();
    this.source.clear();
    this.off = 0;
  }

  public String process(String paramString)
  {
    if (paramString.indexOf('$') < 0);
    while (true)
    {
      return paramString;
      try
      {
        this.source.append(paramString);
        parse();
        String str = this.text.toString();
        paramString = str;
        clear();
      }
      finally
      {
        clear();
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TemplateEngine
 * JD-Core Version:    0.6.2
 */