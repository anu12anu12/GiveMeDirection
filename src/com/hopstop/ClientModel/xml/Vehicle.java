package com.hopstop.ClientModel.xml;

public class Vehicle
{
  private String name;

  public Vehicle(String paramString)
  {
    String[] arrayOfString1 = paramString.replace("=>", "").split(";");
    int i = 0;
    int j = arrayOfString1.length;
    if (i >= j)
      return;
    String[] arrayOfString2 = paramString.split(",");
    int k = arrayOfString1.length + -1;
    String str3;
    if (i != k)
    {
      String str1 = String.valueOf(this.name);
      StringBuilder localStringBuilder1 = new StringBuilder(str1);
      String str2 = arrayOfString2[4];
      str3 = str2;
    }
    String str6;
    for (this.name = str3; ; this.name = str6)
    {
      i += 1;
      break;
      String str4 = String.valueOf(this.name);
      StringBuilder localStringBuilder2 = new StringBuilder(str4);
      String str5 = arrayOfString2[4];
      str6 = str5 + ",";
    }
  }

  public String getName()
  {
    return this.name;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.Vehicle
 * JD-Core Version:    0.6.2
 */