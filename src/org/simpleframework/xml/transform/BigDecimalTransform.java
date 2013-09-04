package org.simpleframework.xml.transform;

import java.math.BigDecimal;

class BigDecimalTransform
  implements Transform<BigDecimal>
{
  public BigDecimal read(String paramString)
  {
    return new BigDecimal(paramString);
  }

  public String write(BigDecimal paramBigDecimal)
  {
    return paramBigDecimal.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.BigDecimalTransform
 * JD-Core Version:    0.6.2
 */