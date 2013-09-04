package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StandardExceptionParser
  implements ExceptionParser
{
  private final TreeSet<String> includedPackages;

  public StandardExceptionParser(Context paramContext, Collection<String> paramCollection)
  {
    TreeSet localTreeSet = new TreeSet();
    this.includedPackages = localTreeSet;
    setIncludedPackages(paramContext, paramCollection);
  }

  protected StackTraceElement getBestStackTraceElement(Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement1 = paramThrowable.getStackTrace();
    StackTraceElement localStackTraceElement;
    if ((arrayOfStackTraceElement1 == null) || (arrayOfStackTraceElement1.length == 0))
      localStackTraceElement = null;
    while (true)
    {
      return localStackTraceElement;
      StackTraceElement[] arrayOfStackTraceElement2 = arrayOfStackTraceElement1;
      int i = arrayOfStackTraceElement2.length;
      int j = 0;
      while (true)
      {
        if (j >= i)
          break label101;
        localStackTraceElement = arrayOfStackTraceElement2[j];
        String str1 = localStackTraceElement.getClassName();
        Iterator localIterator = this.includedPackages.iterator();
        while (true)
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if (str1.startsWith(str2))
              break;
          }
        j += 1;
      }
      label101: localStackTraceElement = arrayOfStackTraceElement1[0];
    }
  }

  protected Throwable getCause(Throwable paramThrowable)
  {
    for (Throwable localThrowable = paramThrowable; localThrowable.getCause() != null; localThrowable = localThrowable.getCause());
    return localThrowable;
  }

  public String getDescription(String paramString, Throwable paramThrowable)
  {
    Throwable localThrowable1 = getCause(paramThrowable);
    Throwable localThrowable2 = getCause(paramThrowable);
    StackTraceElement localStackTraceElement = getBestStackTraceElement(localThrowable2);
    return getDescription(localThrowable1, localStackTraceElement, paramString);
  }

  protected String getDescription(Throwable paramThrowable, StackTraceElement paramStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = paramThrowable.getClass().getSimpleName();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    if (paramStackTraceElement != null)
    {
      String[] arrayOfString = paramStackTraceElement.getClassName().split("\\.");
      String str2 = "unknown";
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int i = arrayOfString.length + -1;
        str2 = arrayOfString[i];
      }
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = str2;
      String str3 = paramStackTraceElement.getMethodName();
      arrayOfObject1[1] = str3;
      String str4 = String.format(" (@%s:%s)", arrayOfObject1);
      StringBuilder localStringBuilder3 = localStringBuilder1.append(str4);
    }
    if (paramString != null)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramString;
      String str5 = String.format(" {%s}", arrayOfObject2);
      StringBuilder localStringBuilder4 = localStringBuilder1.append(str5);
    }
    return localStringBuilder1.toString();
  }

  public void setIncludedPackages(Context paramContext, Collection<String> paramCollection)
  {
    this.includedPackages.clear();
    HashSet localHashSet = new HashSet();
    if (paramCollection != null)
    {
      Collection<String> localCollection = paramCollection;
      boolean bool1 = localHashSet.addAll(localCollection);
    }
    if (paramContext != null)
      try
      {
        String str1 = paramContext.getApplicationContext().getPackageName();
        boolean bool2 = this.includedPackages.add(str1);
        ActivityInfo[] arrayOfActivityInfo1 = paramContext.getApplicationContext().getPackageManager().getPackageInfo(str1, 15).activities;
        if (arrayOfActivityInfo1 != null)
        {
          ActivityInfo[] arrayOfActivityInfo2 = arrayOfActivityInfo1;
          int i = arrayOfActivityInfo2.length;
          int j = 0;
          while (j < i)
          {
            String str2 = arrayOfActivityInfo2[j].packageName;
            boolean bool3 = localHashSet.add(str2);
            j += 1;
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        int k = Log.i("No package found");
      }
    Iterator localIterator1 = localHashSet.iterator();
    if (!localIterator1.hasNext())
      return;
    String str3 = (String)localIterator1.next();
    int m = 1;
    Iterator localIterator2 = this.includedPackages.iterator();
    while (true)
    {
      if (localIterator2.hasNext())
      {
        String str4 = (String)localIterator2.next();
        if (str3.startsWith(str4))
          break label252;
        if (str4.startsWith(str3))
          boolean bool4 = this.includedPackages.remove(str4);
      }
      if (m == 0)
        break;
      boolean bool5 = this.includedPackages.add(str3);
      break;
      label252: m = 0;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.StandardExceptionParser
 * JD-Core Version:    0.6.2
 */