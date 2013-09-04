package com.hopstop.ClientModel.SmartRoute;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class Fare
  implements Serializable
{

  @Element(name="CurrencyCode", required=false)
  private String _currencyCode;

  @Element(name="Notes", required=false)
  private String _notes;

  @Element(name="Price", required=false)
  private float _price;

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

  public float getPrice()
  {
    return this._price;
  }

  public String getPriceVerb()
  {
    return this._priceVerb;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.SmartRoute.Fare
 * JD-Core Version:    0.6.2
 */