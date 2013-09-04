package org.simpleframework.xml.transform;

import java.util.Date;
import java.util.GregorianCalendar;

class GregorianCalendarTransform
  implements Transform<GregorianCalendar>
{
  private final DateTransform transform;

  public GregorianCalendarTransform()
    throws Exception
  {
    this(Date.class);
  }

  public GregorianCalendarTransform(Class paramClass)
    throws Exception
  {
    DateTransform localDateTransform = new DateTransform(paramClass);
    this.transform = localDateTransform;
  }

  private GregorianCalendar read(Date paramDate)
    throws Exception
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramDate != null)
      localGregorianCalendar.setTime(paramDate);
    return localGregorianCalendar;
  }

  public GregorianCalendar read(String paramString)
    throws Exception
  {
    Date localDate = this.transform.read(paramString);
    return read(localDate);
  }

  public String write(GregorianCalendar paramGregorianCalendar)
    throws Exception
  {
    DateTransform localDateTransform = this.transform;
    Date localDate = paramGregorianCalendar.getTime();
    return localDateTransform.write(localDate);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.GregorianCalendarTransform
 * JD-Core Version:    0.6.2
 */