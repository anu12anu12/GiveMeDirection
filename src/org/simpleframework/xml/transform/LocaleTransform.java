package org.simpleframework.xml.transform;

import java.util.Locale;
import java.util.regex.Pattern;

class LocaleTransform
  implements Transform<Locale>
{
  private final Pattern pattern;

  public LocaleTransform()
  {
    Pattern localPattern = Pattern.compile("_");
    this.pattern = localPattern;
  }

  private Locale read(String[] paramArrayOfString)
    throws Exception
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    int i = 0;
    while (true)
    {
      int j = arrayOfString.length;
      if (i >= j)
        break;
      int k = paramArrayOfString.length;
      if (i < k)
      {
        String str1 = paramArrayOfString[i];
        arrayOfString[i] = str1;
      }
      i += 1;
    }
    String str2 = arrayOfString[0];
    String str3 = arrayOfString[1];
    String str4 = arrayOfString[2];
    return new Locale(str2, str3, str4);
  }

  public Locale read(String paramString)
    throws Exception
  {
    String[] arrayOfString = this.pattern.split(paramString);
    if (arrayOfString.length < 1)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramString;
      throw new InvalidFormatException("Invalid locale %s", arrayOfObject);
    }
    return read(arrayOfString);
  }

  public String write(Locale paramLocale)
  {
    return paramLocale.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.LocaleTransform
 * JD-Core Version:    0.6.2
 */