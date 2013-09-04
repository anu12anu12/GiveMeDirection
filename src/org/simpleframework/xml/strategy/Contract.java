package org.simpleframework.xml.strategy;

class Contract
{
  private String label;
  private String length;
  private String mark;
  private String refer;

  public Contract(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.length = paramString4;
    this.label = paramString3;
    this.refer = paramString2;
    this.mark = paramString1;
  }

  public String getIdentity()
  {
    return this.mark;
  }

  public String getLabel()
  {
    return this.label;
  }

  public String getLength()
  {
    return this.length;
  }

  public String getReference()
  {
    return this.refer;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Contract
 * JD-Core Version:    0.6.2
 */