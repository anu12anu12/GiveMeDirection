package org.simpleframework.xml.transform;

class PrimitiveMatcher
  implements Matcher
{
  public Transform match(Class paramClass)
    throws Exception
  {
    Class localClass1 = Integer.TYPE;
    Object localObject;
    if (paramClass == localClass1)
      localObject = new IntegerTransform();
    while (true)
    {
      return localObject;
      Class localClass2 = Boolean.TYPE;
      if (paramClass == localClass2)
      {
        localObject = new BooleanTransform();
      }
      else
      {
        Class localClass3 = Long.TYPE;
        if (paramClass == localClass3)
        {
          localObject = new LongTransform();
        }
        else
        {
          Class localClass4 = Double.TYPE;
          if (paramClass == localClass4)
          {
            localObject = new DoubleTransform();
          }
          else
          {
            Class localClass5 = Float.TYPE;
            if (paramClass == localClass5)
            {
              localObject = new FloatTransform();
            }
            else
            {
              Class localClass6 = Short.TYPE;
              if (paramClass == localClass6)
              {
                localObject = new ShortTransform();
              }
              else
              {
                Class localClass7 = Byte.TYPE;
                if (paramClass == localClass7)
                {
                  localObject = new ByteTransform();
                }
                else
                {
                  Class localClass8 = Character.TYPE;
                  if (paramClass == localClass8)
                    localObject = new CharacterTransform();
                  else
                    localObject = null;
                }
              }
            }
          }
        }
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.PrimitiveMatcher
 * JD-Core Version:    0.6.2
 */