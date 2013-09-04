package com.hopstop.ClientModel.Schedules;

public enum Day
{
  private String friendlyName;

  static
  {
    Thursday = new Day("Thursday", 3, "Thursday");
    Friday = new Day("Friday", 4, "Friday");
    Saturday = new Day("Saturday", 5, "Saturday");
    Sunday = new Day("Sunday", 6, "Sunday");
    Day[] arrayOfDay = new Day[7];
    Day localDay1 = Monday;
    arrayOfDay[0] = localDay1;
    Day localDay2 = Tuesday;
    arrayOfDay[1] = localDay2;
    Day localDay3 = Wednesday;
    arrayOfDay[2] = localDay3;
    Day localDay4 = Thursday;
    arrayOfDay[3] = localDay4;
    Day localDay5 = Friday;
    arrayOfDay[4] = localDay5;
    Day localDay6 = Saturday;
    arrayOfDay[5] = localDay6;
    Day localDay7 = Sunday;
    arrayOfDay[6] = localDay7;
  }

  private Day(String arg3)
  {
    Object localObject;
    this.friendlyName = localObject;
  }

  public static Day translateAndroidDay(int paramInt)
  {
    if (1 != paramInt);
    Day[] arrayOfDay;
    int i;
    for (Day localDay = Sunday; ; localDay = arrayOfDay[i])
    {
      return localDay;
      arrayOfDay = values();
      i = paramInt + -2;
    }
  }

  public String toString()
  {
    return this.friendlyName;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Day
 * JD-Core Version:    0.6.2
 */