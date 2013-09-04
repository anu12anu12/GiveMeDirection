package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.LimitedCache;

class ExpressionBuilder
{
  private final Cache<Expression> cache;
  private final Format format;
  private final Class type;

  public ExpressionBuilder(Detail paramDetail, Support paramSupport)
  {
    LimitedCache localLimitedCache = new LimitedCache();
    this.cache = localLimitedCache;
    Format localFormat = paramSupport.getFormat();
    this.format = localFormat;
    Class localClass = paramDetail.getType();
    this.type = localClass;
  }

  private Expression create(String paramString)
    throws Exception
  {
    Class localClass = this.type;
    ClassType localClassType = new ClassType(localClass);
    Format localFormat = this.format;
    PathParser localPathParser = new PathParser(paramString, localClassType, localFormat);
    if (this.cache != null)
      this.cache.cache(paramString, localPathParser);
    return localPathParser;
  }

  public Expression build(String paramString)
    throws Exception
  {
    Expression localExpression = (Expression)this.cache.fetch(paramString);
    if (localExpression == null)
      localExpression = create(paramString);
    return localExpression;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ExpressionBuilder
 * JD-Core Version:    0.6.2
 */