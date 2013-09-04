package org.simpleframework.xml.transform;

import java.util.TimeZone;

class TimeZoneTransform
  implements Transform<TimeZone>
{
  public TimeZone read(String paramString)
  {
    return TimeZone.getTimeZone(paramString);
  }

  public String write(TimeZone paramTimeZone)
  {
    return paramTimeZone.getID();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.TimeZoneTransform
 * JD-Core Version:    0.6.2
 */