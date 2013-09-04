package org.simpleframework.xml.transform;

class DefaultMatcher
  implements Matcher
{
  private Matcher array;
  private Matcher matcher;
  private Matcher primitive;
  private Matcher stock;

  public DefaultMatcher(Matcher paramMatcher)
  {
    PrimitiveMatcher localPrimitiveMatcher = new PrimitiveMatcher();
    this.primitive = localPrimitiveMatcher;
    PackageMatcher localPackageMatcher = new PackageMatcher();
    this.stock = localPackageMatcher;
    ArrayMatcher localArrayMatcher = new ArrayMatcher(this);
    this.array = localArrayMatcher;
    this.matcher = paramMatcher;
  }

  private Transform matchType(Class paramClass)
    throws Exception
  {
    Transform localTransform;
    if (paramClass.isArray())
      localTransform = this.array.match(paramClass);
    while (true)
    {
      return localTransform;
      if (paramClass.isPrimitive())
        localTransform = this.primitive.match(paramClass);
      else
        localTransform = this.stock.match(paramClass);
    }
  }

  public Transform match(Class paramClass)
    throws Exception
  {
    Transform localTransform = this.matcher.match(paramClass);
    if (localTransform != null);
    while (true)
    {
      return localTransform;
      localTransform = matchType(paramClass);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.DefaultMatcher
 * JD-Core Version:    0.6.2
 */