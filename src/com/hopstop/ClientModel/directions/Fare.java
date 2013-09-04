package com.hopstop.ClientModel.directions;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Fare
  implements Serializable, Cloneable
{

  @Element(name="CurrencyCode", required=false)
  private String _currencyCode;

  @Element(name="Notes", required=false)
  private String _notes;

  @Element(name="Price", required=false)
  private String _price;

  @Element(name="PriceVerb", required=false)
  private String _priceVerb;

  public String getCurrencyCode()
  {
    return this._currencyCode;
  }

  public String getNotes()
  {
    return this._notes;
  }

  public String getPrice()
  {
    return this._price;
  }

  public String getPriceVerb()
  {
    return this._priceVerb;
  }

  public void setCurrencyCode(String paramString)
  {
    this._currencyCode = paramString;
  }

  public void setNotes(String paramString)
  {
    this._notes = paramString;
  }

  public void setPrice(String paramString)
  {
    this._price = paramString;
  }

  public void setPriceVerb(String paramString)
  {
    this._priceVerb = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.Fare
 * JD-Core Version:    0.6.2
 */