package org.simpleframework.xml.transform;

class ArrayMatcher
  implements Matcher
{
  private final Matcher primary;

  public ArrayMatcher(Matcher paramMatcher)
  {
    this.primary = paramMatcher;
  }

  private Transform matchArray(Class paramClass)
    throws Exception
  {
    Transform localTransform = this.primary.match(paramClass);
    if (localTransform == null);
    for (Object localObject = null; ; localObject = new ArrayTransform(localTransform, paramClass))
      return localObject;
  }

  public Transform match(Class paramClass)
    throws Exception
  {
    Class localClass1 = paramClass.getComponentType();
    Class localClass2 = Character.TYPE;
    Object localObject;
    if (localClass1 == localClass2)
      localObject = new CharacterArrayTransform(localClass1);
    while (true)
    {
      return localObject;
      if (localClass1 == Character.class)
        localObject = new CharacterArrayTransform(localClass1);
      else if (localClass1 == String.class)
        localObject = new StringArrayTransform();
      else
        localObject = matchArray(localClass1);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.ArrayMatcher
 * JD-Core Version:    0.6.2
 */