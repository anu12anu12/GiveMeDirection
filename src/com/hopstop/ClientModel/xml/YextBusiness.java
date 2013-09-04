package com.hopstop.ClientModel.xml;

import java.util.Enumeration;
import java.util.Hashtable;

public class YextBusiness
{
  private String _address;
  private String _address2;
  private String _city;
  private String _displayAddress;
  private String _displayLatitude;
  private String _displayLongitude;
  private String _name;
  private Hashtable<String, String> _phoneNumbers;
  private String _postalCode;
  private String _specialOffer;
  private String _state;
  private String _status;
  private String _url;
  private String _visible;
  private String _yextId;

  public YextBusiness(String paramString)
  {
    Hashtable localHashtable = new Hashtable();
    this._phoneNumbers = localHashtable;
    this._status = paramString;
  }

  private String getHyperLink()
  {
    String str1 = "";
    StringBuilder localStringBuilder1;
    if (this._url != null)
    {
      localStringBuilder1 = new StringBuilder("<a href=\"");
      if (!isPrecededByHTTP())
        break label61;
    }
    label61: for (String str2 = ""; ; str2 = "http://")
    {
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
      String str3 = this._url;
      str1 = str3 + "\">";
      return str1;
    }
  }

  private String getOffer()
  {
    String str1 = this._specialOffer;
    if (this._url != null)
    {
      String str2 = String.valueOf(str1);
      str1 = str2 + "</a>";
    }
    if (str1 == null)
      str1 = "";
    return str1;
  }

  private String getPhoneNumber()
  {
    String str1 = "";
    Enumeration localEnumeration = this._phoneNumbers.elements();
    if (localEnumeration.hasMoreElements())
    {
      String str2 = String.valueOf((String)localEnumeration.nextElement());
      str1 = str2 + "<br />";
    }
    return str1;
  }

  private boolean isPrecededByHTTP()
  {
    return this._url.startsWith("http://");
  }

  public void addPhoneNumber(String paramString1, String paramString2)
  {
    Object localObject = this._phoneNumbers.put(paramString1, paramString2);
  }

  public String getAd()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("<p><b><font size=\"5\" color=#4a4a4a>");
    String str1 = this._name;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("</font></b><br /><font size=\"3\" color=#4a4a4a>");
    String str2;
    if (this._visible.equals("false"))
    {
      str2 = "";
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str2);
      String str3 = getPhoneNumber();
      return str3;
    }
    String str4 = String.valueOf(this._address);
    StringBuilder localStringBuilder4 = new StringBuilder(str4).append(", ");
    String str5;
    label103: StringBuilder localStringBuilder8;
    if (this._address2 == null)
    {
      str5 = "";
      StringBuilder localStringBuilder5 = localStringBuilder4.append(str5).append("<br />");
      String str6 = this._city;
      StringBuilder localStringBuilder6 = localStringBuilder5.append(str6).append(", ");
      String str7 = this._state;
      StringBuilder localStringBuilder7 = localStringBuilder6.append(str7).append(", ");
      String str8 = this._postalCode;
      localStringBuilder8 = localStringBuilder7.append(str8).append("<br />").append("<font size=\"1\" color=#4a4a4a>");
      if (this._displayAddress != null)
        break label222;
    }
    label222: for (String str9 = ""; ; str9 = this._displayAddress)
    {
      str2 = str9 + "<br />";
      break;
      str5 = this._address2;
      break label103;
    }
  }

  public String getCity()
  {
    return this._city;
  }

  public String getFormatedAddress()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = this._address;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    if (this._postalCode != null)
    {
      StringBuilder localStringBuilder3 = new StringBuilder(", ");
      String str2 = this._postalCode;
      String str3 = str2;
      StringBuilder localStringBuilder4 = localStringBuilder1.append(str3);
    }
    if ((this._displayLatitude != null) && (this._displayLongitude != null))
    {
      StringBuilder localStringBuilder5 = new StringBuilder(" (");
      String str4 = this._displayLatitude;
      StringBuilder localStringBuilder6 = localStringBuilder5.append(str4).append(", ");
      String str5 = this._displayLongitude;
      String str6 = str5 + ")";
      StringBuilder localStringBuilder7 = localStringBuilder1.append(str6);
    }
    return localStringBuilder1.toString();
  }

  public String getLatitude()
  {
    return this._displayLatitude;
  }

  public String getLongitude()
  {
    return this._displayLongitude;
  }

  public String getName()
  {
    return this._name;
  }

  public String getOfferInHtml()
  {
    String str1 = String.valueOf(getHyperLink());
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = getOffer();
    if (str2 != "");
    for (String str3 = special_offer(); ; str3 = "")
      return str3;
  }

  public String getSpecialOffer()
  {
    return this._specialOffer;
  }

  public String getURL()
  {
    return this._url;
  }

  public String getVisible()
  {
    return this._visible;
  }

  public String get_yextId()
  {
    return this._yextId;
  }

  public boolean hasSpecialOffer()
  {
    String str1 = String.valueOf(getHyperLink());
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = getOffer();
    if (str2 != "");
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void setAddress(String paramString)
  {
    this._address = paramString;
  }

  public void setAddress2(String paramString)
  {
    this._address2 = paramString;
  }

  public void setCity(String paramString)
  {
    this._city = paramString;
  }

  public void setDisplayAddress(String paramString)
  {
    this._displayAddress = paramString;
  }

  public void setDisplayLatitude(String paramString)
  {
    this._displayLatitude = paramString;
  }

  public void setDisplayLongitude(String paramString)
  {
    this._displayLongitude = paramString;
  }

  public void setName(String paramString)
  {
    this._name = paramString;
  }

  public void setPostalCode(String paramString)
  {
    this._postalCode = paramString;
  }

  public void setSpecialOffer(String paramString)
  {
    this._specialOffer = paramString;
  }

  public void setState(String paramString)
  {
    this._state = paramString;
  }

  public void setURL(String paramString)
  {
    this._url = paramString;
  }

  public void setVisible(String paramString)
  {
    this._visible = paramString;
  }

  public void set_yextId(String paramString)
  {
    this._yextId = paramString;
  }

  public String special_offer()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("<br/><br/><p>");
    String str1 = getHyperLink();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = getOffer();
    return str2 + "</p>";
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.YextBusiness
 * JD-Core Version:    0.6.2
 */