package com.google.analytics.tracking.android;

import org.apache.http.client.HttpClient;

abstract interface HttpClientFactory
{
  public abstract HttpClient newInstance();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.HttpClientFactory
 * JD-Core Version:    0.6.2
 */