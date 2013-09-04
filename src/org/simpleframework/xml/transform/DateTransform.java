package org.simpleframework.xml.transform;

import java.util.Date;

class DateTransform<T extends Date>
  implements Transform<T>
{
  private final DateFactory<T> factory;

  public DateTransform(Class<T> paramClass)
    throws Exception
  {
    DateFactory localDateFactory = new DateFactory(paramClass);
    this.factory = localDateFactory;
  }

  /** @deprecated */
  public T read(String paramString)
    throws Exception
  {
    try
    {
      Long localLong = Long.valueOf(DateType.getDate(paramString).getTime());
      DateFactory localDateFactory = this.factory;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localLong;
      Date localDate1 = localDateFactory.getInstance(arrayOfObject);
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
  public String write(T paramT)
    throws Exception
  {
    try
    {
      String str1 = DateType.getText(paramT);
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

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.DateTransform
 * JD-Core Version:    0.6.2
 */