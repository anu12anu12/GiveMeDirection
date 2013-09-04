package com.androidquery.callback;

public abstract interface Transformer
{
  public abstract <T> T transform(String paramString1, Class<T> paramClass, String paramString2, byte[] paramArrayOfByte, AjaxStatus paramAjaxStatus);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.callback.Transformer
 * JD-Core Version:    0.6.2
 */