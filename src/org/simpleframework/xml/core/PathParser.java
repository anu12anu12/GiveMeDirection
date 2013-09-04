package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class PathParser
  implements Expression
{
  protected boolean attribute;
  protected Cache<String> attributes;
  protected StringBuilder builder;
  protected String cache;
  protected int count;
  protected char[] data;
  protected Cache<String> elements;
  protected List<Integer> indexes;
  protected String location;
  protected List<String> names;
  protected int off;
  protected String path;
  protected List<String> prefixes;
  protected int start;
  protected Style style;
  protected Type type;

  public PathParser(String paramString, Type paramType, Format paramFormat)
    throws Exception
  {
    ConcurrentCache localConcurrentCache1 = new ConcurrentCache();
    this.attributes = localConcurrentCache1;
    ConcurrentCache localConcurrentCache2 = new ConcurrentCache();
    this.elements = localConcurrentCache2;
    ArrayList localArrayList1 = new ArrayList();
    this.indexes = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.prefixes = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    this.names = localArrayList3;
    StringBuilder localStringBuilder = new StringBuilder();
    this.builder = localStringBuilder;
    Style localStyle = paramFormat.getStyle();
    this.style = localStyle;
    this.type = paramType;
    this.path = paramString;
    parse(paramString);
  }

  private void align()
    throws Exception
  {
    int i = this.names.size();
    int j = this.indexes.size();
    if (i <= j)
      return;
    List localList = this.indexes;
    Integer localInteger = Integer.valueOf(1);
    boolean bool = localList.add(localInteger);
  }

  private void attribute()
    throws Exception
  {
    int i = this.off + 1;
    this.off = i;
    char c;
    do
    {
      int j = this.off;
      int k = this.count;
      if (j >= k)
        break;
      char[] arrayOfChar = this.data;
      int m = this.off;
      int n = m + 1;
      this.off = n;
      c = arrayOfChar[m];
    }
    while (isValid(c));
    Object[] arrayOfObject1 = new Object[3];
    Character localCharacter = Character.valueOf(c);
    arrayOfObject1[0] = localCharacter;
    String str1 = this.path;
    arrayOfObject1[1] = str1;
    Type localType1 = this.type;
    arrayOfObject1[2] = localType1;
    throw new PathException("Illegal character '%s' in attribute for '%s' in %s", arrayOfObject1);
    if (this.off <= i)
    {
      Object[] arrayOfObject2 = new Object[2];
      String str2 = this.path;
      arrayOfObject2[0] = str2;
      Type localType2 = this.type;
      arrayOfObject2[1] = localType2;
      throw new PathException("Attribute reference in '%s' for %s is empty", arrayOfObject2);
    }
    this.attribute = true;
    int i1 = this.off - i;
    attribute(i, i1);
  }

  private void attribute(int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = this.data;
    String str = new String(arrayOfChar, paramInt1, paramInt2);
    if (paramInt2 <= 0)
      return;
    attribute(str);
  }

  private void attribute(String paramString)
  {
    String str = this.style.getAttribute(paramString);
    boolean bool1 = this.prefixes.add(null);
    boolean bool2 = this.names.add(str);
  }

  private void build()
  {
    int i = this.names.size();
    int j = i + -1;
    int k = 0;
    if (k < i)
    {
      String str1 = (String)this.prefixes.get(k);
      String str2 = (String)this.names.get(k);
      int m = ((Integer)this.indexes.get(k)).intValue();
      if (k > 0)
        StringBuilder localStringBuilder1 = this.builder.append('/');
      if ((this.attribute) && (k != j))
      {
        StringBuilder localStringBuilder2 = this.builder.append('@');
        StringBuilder localStringBuilder3 = this.builder.append(str2);
      }
      while (true)
      {
        k += 1;
        break;
        if (str1 != null)
        {
          StringBuilder localStringBuilder4 = this.builder.append(str1);
          StringBuilder localStringBuilder5 = this.builder.append(':');
        }
        StringBuilder localStringBuilder6 = this.builder.append(str2);
        StringBuilder localStringBuilder7 = this.builder.append('[');
        StringBuilder localStringBuilder8 = this.builder.append(m);
        StringBuilder localStringBuilder9 = this.builder.append(']');
      }
    }
    String str3 = this.builder.toString();
    this.location = str3;
  }

  private void element()
    throws Exception
  {
    int i = this.off;
    int j = 0;
    while (true)
    {
      int k = this.off;
      int m = this.count;
      char c;
      if (k < m)
      {
        char[] arrayOfChar = this.data;
        int n = this.off;
        int i1 = n + 1;
        this.off = i1;
        c = arrayOfChar[n];
        if (isValid(c))
          break label169;
        if (c != '@')
          break label93;
        int i2 = this.off + -1;
        this.off = i2;
      }
      label93: 
      do
        while (true)
        {
          element(i, j);
          return;
          if (c != '[')
            break;
          index();
        }
      while (c == '/');
      Object[] arrayOfObject = new Object[3];
      Character localCharacter = Character.valueOf(c);
      arrayOfObject[0] = localCharacter;
      String str = this.path;
      arrayOfObject[1] = str;
      Type localType = this.type;
      arrayOfObject[2] = localType;
      throw new PathException("Illegal character '%s' in element for '%s' in %s", arrayOfObject);
      label169: j += 1;
    }
  }

  private void element(int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = this.data;
    String str = new String(arrayOfChar, paramInt1, paramInt2);
    if (paramInt2 <= 0)
      return;
    element(str);
  }

  private void element(String paramString)
  {
    int i = paramString.indexOf(':');
    String str1 = null;
    if (i > 0)
    {
      str1 = paramString.substring(0, i);
      int j = i + 1;
      paramString = paramString.substring(j);
    }
    String str2 = this.style.getElement(paramString);
    boolean bool1 = this.prefixes.add(str1);
    boolean bool2 = this.names.add(str2);
  }

  private void index()
    throws Exception
  {
    int i = 0;
    char[] arrayOfChar1 = this.data;
    int j = this.off + -1;
    if (arrayOfChar1[j] == '[');
    while (true)
    {
      int k = this.off;
      int m = this.count;
      int i2;
      if (k < m)
      {
        char[] arrayOfChar2 = this.data;
        int n = this.off;
        int i1 = n + 1;
        this.off = i1;
        i2 = arrayOfChar2[n];
        if (isDigit(i2));
      }
      else
      {
        char[] arrayOfChar3 = this.data;
        int i3 = this.off;
        int i4 = i3 + 1;
        this.off = i4;
        int i5 = i3 + -1;
        if (arrayOfChar3[i5] == ']')
          break;
        Object[] arrayOfObject = new Object[2];
        String str = this.path;
        arrayOfObject[0] = str;
        Type localType = this.type;
        arrayOfObject[1] = localType;
        throw new PathException("Invalid index for path '%s' in %s", arrayOfObject);
      }
      i = i * 10 + i2 + -48;
    }
    List localList = this.indexes;
    Integer localInteger = Integer.valueOf(i);
    boolean bool = localList.add(localInteger);
  }

  private boolean isDigit(char paramChar)
  {
    return Character.isDigit(paramChar);
  }

  private boolean isEmpty(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private boolean isLetter(char paramChar)
  {
    return Character.isLetterOrDigit(paramChar);
  }

  private boolean isSpecial(char paramChar)
  {
    if ((paramChar == '_') || (paramChar == '-') || (paramChar == ':'));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private boolean isValid(char paramChar)
  {
    if ((isLetter(paramChar)) || (isSpecial(paramChar)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void parse(String paramString)
    throws Exception
  {
    if (paramString != null)
    {
      int i = paramString.length();
      this.count = i;
      char[] arrayOfChar1 = new char[this.count];
      this.data = arrayOfChar1;
      int j = this.count;
      char[] arrayOfChar2 = this.data;
      paramString.getChars(0, j, arrayOfChar2, 0);
    }
    path();
  }

  private void path()
    throws Exception
  {
    char[] arrayOfChar1 = this.data;
    int i = this.off;
    if (arrayOfChar1[i] == '/')
    {
      Object[] arrayOfObject1 = new Object[2];
      String str1 = this.path;
      arrayOfObject1[0] = str1;
      Type localType1 = this.type;
      arrayOfObject1[1] = localType1;
      throw new PathException("Path '%s' in %s references document root", arrayOfObject1);
    }
    char[] arrayOfChar2 = this.data;
    int j = this.off;
    if (arrayOfChar2[j] == '.')
      skip();
    while (true)
    {
      int k = this.off;
      int m = this.count;
      if (k >= m)
        break;
      if (this.attribute)
      {
        Object[] arrayOfObject2 = new Object[2];
        String str2 = this.path;
        arrayOfObject2[0] = str2;
        Type localType2 = this.type;
        arrayOfObject2[1] = localType2;
        throw new PathException("Path '%s' in %s references an invalid attribute", arrayOfObject2);
      }
      segment();
    }
    truncate();
    build();
  }

  private void segment()
    throws Exception
  {
    char[] arrayOfChar = this.data;
    int i = this.off;
    int j = arrayOfChar[i];
    if (j == 47)
    {
      Object[] arrayOfObject = new Object[2];
      String str = this.path;
      arrayOfObject[0] = str;
      Type localType = this.type;
      arrayOfObject[1] = localType;
      throw new PathException("Invalid path expression '%s' in %s", arrayOfObject);
    }
    if (j == 64)
      attribute();
    while (true)
    {
      align();
      return;
      element();
    }
  }

  private void skip()
    throws Exception
  {
    if (this.data.length > 1)
    {
      char[] arrayOfChar = this.data;
      int i = this.off + 1;
      if (arrayOfChar[i] != '/')
      {
        Object[] arrayOfObject = new Object[2];
        String str = this.path;
        arrayOfObject[0] = str;
        Type localType = this.type;
        arrayOfObject[1] = localType;
        throw new PathException("Path '%s' in %s has an illegal syntax", arrayOfObject);
      }
      int j = this.off + 1;
      this.off = j;
    }
    int k = this.off + 1;
    this.off = k;
    this.start = k;
  }

  private void truncate()
    throws Exception
  {
    int i = this.off + -1;
    int j = this.data.length;
    if (i >= j)
    {
      int k = this.off + -1;
      this.off = k;
      return;
    }
    char[] arrayOfChar = this.data;
    int m = this.off + -1;
    if (arrayOfChar[m] != '/')
      return;
    int n = this.off + -1;
    this.off = n;
  }

  public String getAttribute(String paramString)
  {
    String str1 = this.location;
    String str2;
    if (!isEmpty(str1))
    {
      str2 = (String)this.attributes.fetch(paramString);
      if (str2 == null)
      {
        String str3 = this.location;
        str2 = getAttributePath(str3, paramString);
        if (str2 != null)
          this.attributes.cache(paramString, str2);
      }
    }
    while (true)
    {
      return str2;
      str2 = this.style.getAttribute(paramString);
    }
  }

  protected String getAttributePath(String paramString1, String paramString2)
  {
    String str = this.style.getAttribute(paramString2);
    if (isEmpty(paramString1));
    while (true)
    {
      return str;
      str = paramString1 + "/@" + str;
    }
  }

  public String getElement(String paramString)
  {
    String str1 = this.location;
    String str2;
    if (!isEmpty(str1))
    {
      str2 = (String)this.elements.fetch(paramString);
      if (str2 == null)
      {
        String str3 = this.location;
        str2 = getElementPath(str3, paramString);
        if (str2 != null)
          this.elements.cache(paramString, str2);
      }
    }
    while (true)
    {
      return str2;
      str2 = this.style.getElement(paramString);
    }
  }

  protected String getElementPath(String paramString1, String paramString2)
  {
    String str = this.style.getElement(paramString2);
    if (isEmpty(str));
    while (true)
    {
      return paramString1;
      if (isEmpty(paramString1))
        paramString1 = str;
      else
        paramString1 = paramString1 + "/" + str + "[1]";
    }
  }

  public String getFirst()
  {
    return (String)this.names.get(0);
  }

  public int getIndex()
  {
    return ((Integer)this.indexes.get(0)).intValue();
  }

  public String getLast()
  {
    int i = this.names.size() + -1;
    return (String)this.names.get(i);
  }

  public String getPath()
  {
    return this.location;
  }

  public Expression getPath(int paramInt)
  {
    return getPath(paramInt, 0);
  }

  public Expression getPath(int paramInt1, int paramInt2)
  {
    int i = this.names.size() + -1;
    int j;
    if (i - paramInt2 >= paramInt1)
      j = i - paramInt2;
    for (PathSection localPathSection = new PathSection(paramInt1, j); ; localPathSection = new PathSection(paramInt1, paramInt1))
      return localPathSection;
  }

  public String getPrefix()
  {
    return (String)this.prefixes.get(0);
  }

  public boolean isAttribute()
  {
    return this.attribute;
  }

  public boolean isEmpty()
  {
    String str = this.location;
    return isEmpty(str);
  }

  public boolean isPath()
  {
    int i = 1;
    if (this.names.size() > i);
    while (true)
    {
      return i;
      int j = 0;
    }
  }

  public Iterator<String> iterator()
  {
    return this.names.iterator();
  }

  public String toString()
  {
    int i = this.off;
    int j = this.start;
    int k = i - j;
    if (this.cache == null)
    {
      char[] arrayOfChar = this.data;
      int m = this.start;
      String str = new String(arrayOfChar, m, k);
      this.cache = str;
    }
    return this.cache;
  }

  private class PathSection
    implements Expression
  {
    private int begin;
    private List<String> cache;
    private int end;
    private String path;
    private String section;

    public PathSection(int paramInt1, int arg3)
    {
      ArrayList localArrayList = new ArrayList();
      this.cache = localArrayList;
      this.begin = paramInt1;
      int i;
      this.end = i;
    }

    private String getCanonicalPath()
    {
      int i = 0;
      int j = 0;
      while (true)
      {
        int k = this.begin;
        if (j >= k)
          break;
        String str1 = PathParser.this.location;
        int m = i + 1;
        i = str1.indexOf('/', m);
        j += 1;
      }
      int n = i;
      while (true)
      {
        int i1 = this.end;
        if (j > i1)
          break;
        String str2 = PathParser.this.location;
        int i2 = n + 1;
        n = str2.indexOf('/', i2);
        if (n == -1)
          int i3 = PathParser.this.location.length();
        j += 1;
      }
      String str3 = PathParser.this.location;
      int i4 = i + 1;
      return str3.substring(i4, n);
    }

    private String getFragment()
    {
      int i = PathParser.this.start;
      int j = 0;
      int k = 0;
      while (true)
      {
        int m = this.end;
        if (k <= m)
        {
          int n = PathParser.this.count;
          if (i >= n)
            i += 1;
        }
        else
        {
          char[] arrayOfChar1 = PathParser.this.data;
          int i1 = i + -1 - j;
          return new String(arrayOfChar1, j, i1);
        }
        char[] arrayOfChar2 = PathParser.this.data;
        int i2 = i + 1;
        if (arrayOfChar2[i] == '/')
        {
          k += 1;
          int i3 = this.begin;
          if (k != i3)
          {
            j = i2;
            i = i2;
          }
        }
        else
        {
          i = i2;
        }
      }
    }

    public String getAttribute(String paramString)
    {
      String str = getPath();
      if (str != null)
        paramString = PathParser.this.getAttributePath(str, paramString);
      return paramString;
    }

    public String getElement(String paramString)
    {
      String str = getPath();
      if (str != null)
        paramString = PathParser.this.getElementPath(str, paramString);
      return paramString;
    }

    public String getFirst()
    {
      List localList = PathParser.this.names;
      int i = this.begin;
      return (String)localList.get(i);
    }

    public int getIndex()
    {
      List localList = PathParser.this.indexes;
      int i = this.begin;
      return ((Integer)localList.get(i)).intValue();
    }

    public String getLast()
    {
      List localList = PathParser.this.names;
      int i = this.end;
      return (String)localList.get(i);
    }

    public String getPath()
    {
      if (this.section == null)
      {
        String str = getCanonicalPath();
        this.section = str;
      }
      return this.section;
    }

    public Expression getPath(int paramInt)
    {
      return getPath(paramInt, 0);
    }

    public Expression getPath(int paramInt1, int paramInt2)
    {
      PathParser localPathParser = PathParser.this;
      int i = this.begin + paramInt1;
      int j = this.end - paramInt2;
      return new PathSection(localPathParser, i, j);
    }

    public String getPrefix()
    {
      List localList = PathParser.this.prefixes;
      int i = this.begin;
      return (String)localList.get(i);
    }

    public boolean isAttribute()
    {
      boolean bool = false;
      if (PathParser.this.attribute)
      {
        int i = this.end;
        int j = PathParser.this.names.size() + -1;
        if (i >= j)
          bool = true;
      }
      return bool;
    }

    public boolean isEmpty()
    {
      int i = this.begin;
      int j = this.end;
      if (i != j);
      for (boolean bool = true; ; bool = false)
        return bool;
    }

    public boolean isPath()
    {
      int i = 1;
      int k = this.end;
      int m = this.begin;
      if (k - m >= i);
      while (true)
      {
        return i;
        int j = 0;
      }
    }

    public Iterator<String> iterator()
    {
      if (this.cache.isEmpty())
      {
        int i = this.begin;
        while (true)
        {
          int j = this.end;
          if (i > j)
            break;
          String str = (String)PathParser.this.names.get(i);
          if (str != null)
            boolean bool = this.cache.add(str);
          i += 1;
        }
      }
      return this.cache.iterator();
    }

    public String toString()
    {
      if (this.path == null)
      {
        String str = getFragment();
        this.path = str;
      }
      return this.path;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PathParser
 * JD-Core Version:    0.6.2
 */