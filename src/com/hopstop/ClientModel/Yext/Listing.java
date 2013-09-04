package com.hopstop.ClientModel.Yext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

@Root(name="listing", strict=false)
public class Listing
  implements Serializable
{

  @Element(name="address", required=false)
  private Address _address;

  @Element(name="description", required=false)
  private String _description;
  private Hashtable<String, String> _enhancedListsHash;

  @Element(name="geoData", required=false)
  private GeoData _geoData;
  private boolean _has_yextId;

  @ElementList(name="lists", required=false)
  private ArrayList<List> _lists;

  @Element(name="name", required=false)
  private String _name;

  @ElementList(inline=false, name="phones", required=false)
  private ArrayList<Phone> _phones;

  @Element(name="specialOffer", required=false)
  private SpecialOffer _specialOffer;

  @Element(name="status", required=false)
  private String _status;

  @Element(name="yextId", required=false)
  private String _yextId;

  @Commit
  private void build()
  {
    if (this._lists == null)
      return;
    Hashtable localHashtable1 = new Hashtable();
    this._enhancedListsHash = localHashtable1;
    Iterator localIterator = this._lists.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      List localList = (List)localIterator.next();
      Hashtable localHashtable2 = this._enhancedListsHash;
      String str1 = localList.getType();
      if (!localHashtable2.containsKey(str1))
      {
        Hashtable localHashtable3 = this._enhancedListsHash;
        String str2 = localList.getType();
        String str3 = localList.getDescription();
        Object localObject = localHashtable3.put(str2, str3);
      }
    }
  }

  private String getHyperLink()
  {
    String str1 = "";
    StringBuilder localStringBuilder1;
    if ((getSpecialOffer() != null) && (getSpecialOffer().getUrl() != null))
    {
      localStringBuilder1 = new StringBuilder("<a href=\"");
      if (!isPrecededByHTTP())
        break label74;
    }
    label74: for (String str2 = ""; ; str2 = "http://")
    {
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
      String str3 = getSpecialOffer().getUrl();
      str1 = str3 + "\">";
      return str1;
    }
  }

  private String getOffer()
  {
    String str1;
    if (this._specialOffer == null)
      str1 = "";
    while (true)
    {
      return str1;
      str1 = this._specialOffer.getMessage();
      if (this._specialOffer.getUrl() != null)
      {
        String str2 = String.valueOf(str1);
        String str3 = str2 + "</a>";
      }
      if (str1 == null)
        str1 = "";
    }
  }

  private String getPhoneHTML()
  {
    String str1 = "";
    if ((this._phones != null) && (this._phones.size() > 0))
    {
      String str2 = String.valueOf("");
      StringBuilder localStringBuilder = new StringBuilder(str2);
      String str3 = ((Phone)this._phones.get(0)).getNumber().getNumber();
      str1 = str3 + "<br />";
    }
    return str1;
  }

  private boolean isPrecededByHTTP()
  {
    if ((this._specialOffer != null) && (this._specialOffer.getUrl() != null));
    for (boolean bool = this._specialOffer.getUrl().startsWith("http://"); ; bool = false)
      return bool;
  }

  public String getAd()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("<p><b><font size=\"5\" color=#4a4a4a>");
    String str1 = this._name;
    String str2 = str1 + "</font></b><br /><font size=\"3\" color=#4a4a4a>";
    String str3 = "";
    if (this._address != null)
    {
      if (this._address.getVisible().equals("false"))
        str3 = "";
    }
    else
    {
      String str4 = String.valueOf(str2);
      String str5 = String.valueOf(str4 + str3);
      StringBuilder localStringBuilder2 = new StringBuilder(str5);
      String str6 = getPhoneHTML();
      return str6;
    }
    String str7 = String.valueOf(this._address.getAddress());
    StringBuilder localStringBuilder3 = new StringBuilder(str7).append(", ");
    String str8;
    label157: StringBuilder localStringBuilder7;
    if (this._address.getAddress2() == null)
    {
      str8 = "";
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str8).append("<br />");
      String str9 = this._address.getCity();
      StringBuilder localStringBuilder5 = localStringBuilder4.append(str9).append(", ");
      String str10 = this._address.getState();
      StringBuilder localStringBuilder6 = localStringBuilder5.append(str10).append(", ");
      String str11 = this._address.getPostalCode();
      localStringBuilder7 = localStringBuilder6.append(str11).append("<br />").append("<font size=\"1\" color=#4a4a4a>");
      if (this._address.getDisplayAddress() != null)
        break label291;
    }
    label291: for (String str12 = ""; ; str12 = this._address.getDisplayAddress())
    {
      str3 = str12 + "<br />";
      break;
      str8 = this._address.getAddress2();
      break label157;
    }
  }

  public Address getAddress()
  {
    return this._address;
  }

  public String getDescription()
  {
    return this._description;
  }

  public Hashtable<String, String> getEnhancedListsHash()
  {
    return this._enhancedListsHash;
  }

  public String getFormatedAddress()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (this._address != null)
    {
      String str1 = this._address.getAddress();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    }
    if ((getAddress() != null) && (getAddress().getPostalCode() != null))
    {
      StringBuilder localStringBuilder3 = new StringBuilder(", ");
      String str2 = getAddress().getPostalCode();
      String str3 = str2;
      StringBuilder localStringBuilder4 = localStringBuilder1.append(str3);
    }
    if ((getGeoData() != null) && (getGeoData().getDisplayLatitude() != null) && (getGeoData().getDisplayLongitude() != null))
    {
      StringBuilder localStringBuilder5 = new StringBuilder(" (");
      String str4 = getGeoData().getDisplayLatitude();
      StringBuilder localStringBuilder6 = localStringBuilder5.append(str4).append(", ");
      String str5 = getGeoData().getDisplayLongitude();
      String str6 = str5 + ")";
      StringBuilder localStringBuilder7 = localStringBuilder1.append(str6);
    }
    return localStringBuilder1.toString();
  }

  public GeoData getGeoData()
  {
    return this._geoData;
  }

  public ArrayList<List> getLists()
  {
    return this._lists;
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

  public ArrayList<Phone> getPhones()
  {
    return this._phones;
  }

  public SpecialOffer getSpecialOffer()
  {
    return this._specialOffer;
  }

  public String getStatus()
  {
    return this._status;
  }

  public String getYextId()
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

  public boolean hasYextId()
  {
    return this._has_yextId;
  }

  public void setAddress(Address paramAddress)
  {
    this._address = paramAddress;
  }

  public void setDescription(String paramString)
  {
    this._description = paramString;
  }

  public void setEnhancedListsHash(Hashtable<String, String> paramHashtable)
  {
    this._enhancedListsHash = paramHashtable;
  }

  public void setLists(ArrayList<List> paramArrayList)
  {
    this._lists = paramArrayList;
  }

  public void setName(String paramString)
  {
    this._name = paramString;
  }

  public void setPhones(ArrayList<Phone> paramArrayList)
  {
    this._phones = paramArrayList;
  }

  public void setSpecialOffer(SpecialOffer paramSpecialOffer)
  {
    this._specialOffer = paramSpecialOffer;
  }

  public void setStatus(String paramString)
  {
    this._status = paramString;
  }

  public void setYextId(String paramString)
  {
    this._yextId = paramString;
    this._has_yextId = true;
  }

  public String special_offer()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("<br /><br /><p>");
    String str1 = getHyperLink();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = getOffer();
    return str2 + "</p>";
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Yext.Listing
 * JD-Core Version:    0.6.2
 */