package com.hopstop.ui;

import android.content.Context;
import android.content.Intent;
import com.crashlytics.android.Crashlytics;
import com.hopstop.SplashScreen;
import java.util.Stack;

public class TabManager
{
  public static final int DIRECTIONS_CLASS_CODE = 0;
  public static final int MORE_CLASS_CODE = 4;
  public static final int NEARBY_STATIONS_CLASS_CODE = 2;
  public static final int NONE = 255;
  public static final int SCHEDULES_CLASS_CODE = 1;
  public static final int TRANSITMAPS_CLASS_CODE = 3;
  private Class<?>[] classExceptions;
  public int currentTab;
  public Stack<Class<?>>[] tabArray;

  public TabManager()
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = SplashScreen.class;
    this.classExceptions = arrayOfClass;
    Stack[] arrayOfStack1 = new Stack[5];
    this.tabArray = arrayOfStack1;
    int i = 0;
    while (true)
    {
      if (i >= 5)
        return;
      if (this.tabArray[i] == null)
      {
        Stack[] arrayOfStack2 = this.tabArray;
        Stack localStack = new Stack();
        arrayOfStack2[i] = localStack;
      }
      i += 1;
    }
  }

  private int getTab(Class<?> paramClass)
  {
    String str = paramClass.getSimpleName();
    int i = -1;
    if (str.startsWith("Directions"))
      i = 0;
    while (true)
    {
      return i;
      if (str.startsWith("Schedules"))
        i = 1;
      else if (str.startsWith("NearbyStations"))
        i = 2;
      else if (str.startsWith("TransitMap"))
        i = 3;
      else if (str.startsWith("More"))
        i = 4;
    }
  }

  private void printStack()
  {
    int i = 0;
    while (true)
    {
      if (i > 4)
        return;
      i += 1;
    }
  }

  public int getCurrentTab()
  {
    return this.currentTab;
  }

  public Intent getIntentOnDestroy(Class<?> paramClass, Context paramContext)
  {
    Intent localIntent1 = null;
    int i = getTab(paramClass);
    this.currentTab = i;
    if (this.currentTab == -1)
      return localIntent1;
    int j = 0;
    while (true)
    {
      int k = this.classExceptions.length;
      if (j >= k)
      {
        Stack[] arrayOfStack1 = this.tabArray;
        int m = this.currentTab;
        if (arrayOfStack1[m].isEmpty())
          break;
        Stack[] arrayOfStack2 = this.tabArray;
        int n = this.currentTab;
        if (arrayOfStack2[n].isEmpty())
          break;
        Stack[] arrayOfStack3 = this.tabArray;
        int i1 = this.currentTab;
        Object localObject = arrayOfStack3[i1].pop();
        Stack[] arrayOfStack4 = this.tabArray;
        int i2 = this.currentTab;
        if (arrayOfStack4[i2].isEmpty())
          break;
        Stack[] arrayOfStack5 = this.tabArray;
        int i3 = this.currentTab;
        Class localClass = (Class)arrayOfStack5[i3].peek();
        localIntent1 = new Intent(paramContext, localClass);
        Intent localIntent2 = localIntent1.addFlags(131072);
        break;
      }
      if (this.classExceptions[j].equals(paramClass))
        break;
      j += 1;
    }
  }

  public Intent getIntentOnTabClick(Class<?> paramClass, Context paramContext)
  {
    int i = getTab(paramClass);
    this.currentTab = i;
    Intent localIntent1;
    if (this.currentTab == -1)
    {
      localIntent1 = null;
      return localIntent1;
    }
    Stack[] arrayOfStack1 = this.tabArray;
    int j = this.currentTab;
    if (arrayOfStack1[j].isEmpty())
      localIntent1 = new Intent(paramContext, paramClass);
    while (true)
    {
      StringBuilder localStringBuilder1 = new StringBuilder("tab click:");
      int k = this.currentTab;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(k).append("headClass: ");
      String str1 = paramClass.getSimpleName();
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str1).append(", previous screen: ");
      String str2 = paramContext.getClass().getSimpleName();
      Crashlytics.log(str2);
      break;
      Stack[] arrayOfStack2 = this.tabArray;
      int m = this.currentTab;
      Class localClass = (Class)arrayOfStack2[m].peek();
      localIntent1 = new Intent(paramContext, localClass);
      Intent localIntent2 = localIntent1.addFlags(131072);
    }
  }

  public void handleActivityOnCreate(Class<?> paramClass)
  {
    int i = getTab(paramClass);
    if (i == -1)
      return;
    if (this.tabArray[i] == null)
    {
      Stack[] arrayOfStack = this.tabArray;
      Stack localStack = new Stack();
      arrayOfStack[i] = localStack;
    }
    int j = 0;
    while (true)
    {
      int k = this.classExceptions.length;
      if (j >= k)
      {
        Object localObject = this.tabArray[i].push(paramClass);
        this.currentTab = i;
        return;
      }
      if (this.classExceptions[j].equals(paramClass))
        return;
      j += 1;
    }
  }

  public void setTab(Class<?> paramClass)
  {
    int i = getTab(paramClass);
    this.currentTab = i;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ui.TabManager
 * JD-Core Version:    0.6.2
 */