package com.hopstop.ClientModel;

import com.hopstop.ClientModel.Schedules.Day;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil
{
  public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
  public static final String TIME_FORMAT = "hh:mm a";

  public static String HSTime(int paramInt1, int paramInt2, int paramInt3)
  {
    return HSTime(Day.values()[paramInt1], paramInt2, paramInt3);
  }

  public static String HSTime(Day paramDay, int paramInt1, int paramInt2)
  {
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("hh:mm a");
    localDate.setHours(paramInt1);
    localDate.setMinutes(paramInt2);
    String str1 = String.valueOf(paramDay.toString());
    StringBuilder localStringBuilder = new StringBuilder(str1).append(" ");
    String str2 = localSimpleDateFormat.format(localDate);
    return str2;
  }

  public String now()
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date localDate = localCalendar.getTime();
    return localSimpleDateFormat.format(localDate);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.DateTimeUtil
 * JD-Core Version:    0.6.2
 */