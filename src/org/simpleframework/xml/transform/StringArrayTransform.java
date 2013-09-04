package org.simpleframework.xml.transform;

import java.util.regex.Pattern;

class StringArrayTransform
  implements Transform<String[]>
{
  private final Pattern pattern;
  private final String token;

  public StringArrayTransform()
  {
    this(",");
  }

  public StringArrayTransform(String paramString)
  {
    Pattern localPattern = Pattern.compile(paramString);
    this.pattern = localPattern;
    this.token = paramString;
  }

  private String[] read(String paramString1, String paramString2)
  {
    String[] arrayOfString = this.pattern.split(paramString1);
    int i = 0;
    while (true)
    {
      int j = arrayOfString.length;
      if (i >= j)
        break;
      String str1 = arrayOfString[i];
      if (str1 != null)
      {
        String str2 = str1.trim();
        arrayOfString[i] = str2;
      }
      i += 1;
    }
    return arrayOfString;
  }

  private String write(String[] paramArrayOfString, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    while (true)
    {
      int j = paramArrayOfString.length;
      if (i >= j)
        break;
      String str = paramArrayOfString[i];
      if (str != null)
      {
        if (localStringBuilder1.length() > 0)
        {
          StringBuilder localStringBuilder2 = localStringBuilder1.append(paramString);
          StringBuilder localStringBuilder3 = localStringBuilder1.append(' ');
        }
        StringBuilder localStringBuilder4 = localStringBuilder1.append(str);
      }
      i += 1;
    }
    return localStringBuilder1.toString();
  }

  public String[] read(String paramString)
  {
    String str = this.token;
    return read(paramString, str);
  }

  public String write(String[] paramArrayOfString)
  {
    String str = this.token;
    return write(paramArrayOfString, str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.StringArrayTransform
 * JD-Core Version:    0.6.2
 */