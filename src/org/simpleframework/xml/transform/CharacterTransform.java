package org.simpleframework.xml.transform;

class CharacterTransform
  implements Transform<Character>
{
  public Character read(String paramString)
    throws Exception
  {
    if (paramString.length() != 1)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramString;
      throw new InvalidFormatException("Cannot convert '%s' to a character", arrayOfObject);
    }
    return Character.valueOf(paramString.charAt(0));
  }

  public String write(Character paramCharacter)
    throws Exception
  {
    return paramCharacter.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.CharacterTransform
 * JD-Core Version:    0.6.2
 */