package com.skyhookwireless.wps;

abstract interface _sdkx
{
  public static final int BLOCK_ACCURACY = 250;
  public static final int CITY_ACCURACY = 3000;
  public static final int EXACT_ACCURACY = 50;

  public abstract void getXPSLocation(WPSAuthentication paramWPSAuthentication, int paramInt1, int paramInt2, WPSPeriodicLocationCallback paramWPSPeriodicLocationCallback);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkx
 * JD-Core Version:    0.6.2
 */