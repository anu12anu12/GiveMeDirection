package com.google.analytics.tracking.android;

abstract interface ParameterLoader
{
  public abstract boolean getBoolean(String paramString);

  public abstract Double getDoubleFromString(String paramString);

  public abstract int getInt(String paramString, int paramInt);

  public abstract String getString(String paramString);

  public abstract boolean isBooleanKeyPresent(String paramString);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.ParameterLoader
 * JD-Core Version:    0.6.2
 */