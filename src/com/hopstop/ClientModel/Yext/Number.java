package com.hopstop.ClientModel.Yext;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="number", strict=false)
public class Number
  implements Serializable
{

  @Element(name="countryCode", required=false)
  private byte _countryCode;
  private boolean _has_countryCode;
  private boolean _has_number;

  @Element(name="number", required=false)
  private String _number;

  public void deleteCountryCode()
  {
    this._has_countryCode = false;
  }

  public void deleteNumber()
  {
    this._has_number = false;
  }

  public byte getCountryCode()
  {
    return this._countryCode;
  }

  public String getNumber()
  {
    return this._number;
  }

  public boolean hasCountryCode()
  {
    return this._has_countryCode;
  }

  public boolean hasNumber()
  {
    return this._has_number;
  }

  public void setCountryCode(byte paramByte)
  {
    this._countryCode = paramByte;
    this._has_countryCode = true;
  }

  public void setNumber(String paramString)
  {
    this._number = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Yext.Number
 * JD-Core Version:    0.6.2
 */