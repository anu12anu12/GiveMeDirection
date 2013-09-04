package org.simpleframework.xml.transform;

import java.util.Currency;

class CurrencyTransform
  implements Transform<Currency>
{
  public Currency read(String paramString)
  {
    return Currency.getInstance(paramString);
  }

  public String write(Currency paramCurrency)
  {
    return paramCurrency.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.CurrencyTransform
 * JD-Core Version:    0.6.2
 */