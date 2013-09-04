package org.simpleframework.xml.transform;

import java.text.SimpleDateFormat;
import java.util.Date;

 enum DateType
{
  private DateFormat format;

  static
  {
    DateType[] arrayOfDateType = new DateType[4];
    DateType localDateType1 = FULL;
    arrayOfDateType[0] = localDateType1;
    DateType localDateType2 = LONG;
    arrayOfDateType[1] = localDateType2;
    DateType localDateType3 = NORMAL;
    arrayOfDateType[2] = localDateType3;
    DateType localDateType4 = SHORT;
    arrayOfDateType[3] = localDateType4;
  }

  private DateType(String paramString)
  {
    DateFormat localDateFormat = new DateFormat(paramString);
    this.format = localDateFormat;
  }

  public static Date getDate(String paramString)
    throws Exception
  {
    return getType(paramString).getFormat().getDate(paramString);
  }

  private DateFormat getFormat()
  {
    return this.format;
  }

  public static String getText(Date paramDate)
    throws Exception
  {
    return FULL.getFormat().getText(paramDate);
  }

  public static DateType getType(String paramString)
  {
    int i = paramString.length();
    DateType localDateType;
    if (i > 23)
      localDateType = FULL;
    while (true)
    {
      return localDateType;
      if (i > 20)
        localDateType = LONG;
      else if (i > 11)
        localDateType = NORMAL;
      else
        localDateType = SHORT;
    }
  }

  private static class DateFormat
  {
    private SimpleDateFormat format;

    public DateFormat(String paramString)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString);
      this.format = localSimpleDateFormat;
    }

    /** @deprecated */
    public Date getDate(String paramString)
      throws Exception
    {
      try
      {
        Date localDate1 = this.format.parse(paramString);
        Date localDate2 = localDate1;
        return localDate2;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    /** @deprecated */
    public String getText(Date paramDate)
      throws Exception
    {
      try
      {
        String str1 = this.format.format(paramDate);
        String str2 = str1;
        return str2;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.DateType
 * JD-Core Version:    0.6.2
 */