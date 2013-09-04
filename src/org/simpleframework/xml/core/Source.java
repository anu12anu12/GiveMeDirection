package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class Source
  implements Context
{
  private TemplateEngine engine;
  private Filter filter;
  private Session session;
  private Strategy strategy;
  private Support support;

  public Source(Strategy paramStrategy, Support paramSupport, Session paramSession)
  {
    TemplateFilter localTemplateFilter = new TemplateFilter(this, paramSupport);
    this.filter = localTemplateFilter;
    Filter localFilter = this.filter;
    TemplateEngine localTemplateEngine = new TemplateEngine(localFilter);
    this.engine = localTemplateEngine;
    this.strategy = paramStrategy;
    this.support = paramSupport;
    this.session = paramSession;
  }

  private Scanner getScanner(Class paramClass)
    throws Exception
  {
    return this.support.getScanner(paramClass);
  }

  public Object getAttribute(Object paramObject)
  {
    return this.session.get(paramObject);
  }

  public Caller getCaller(Class paramClass)
    throws Exception
  {
    return getScanner(paramClass).getCaller(this);
  }

  public Decorator getDecorator(Class paramClass)
    throws Exception
  {
    return getScanner(paramClass).getDecorator();
  }

  public Instance getInstance(Class paramClass)
  {
    return this.support.getInstance(paramClass);
  }

  public Instance getInstance(Value paramValue)
  {
    return this.support.getInstance(paramValue);
  }

  public String getName(Class paramClass)
    throws Exception
  {
    return this.support.getName(paramClass);
  }

  public Value getOverride(Type paramType, InputNode paramInputNode)
    throws Exception
  {
    NodeMap localNodeMap = paramInputNode.getAttributes();
    if (localNodeMap == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramInputNode;
      throw new PersistenceException("No attributes for %s", arrayOfObject);
    }
    Strategy localStrategy = this.strategy;
    Session localSession = this.session;
    return localStrategy.read(paramType, localNodeMap, localSession);
  }

  public String getProperty(String paramString)
  {
    return this.engine.process(paramString);
  }

  public Schema getSchema(Class paramClass)
    throws Exception
  {
    Scanner localScanner = getScanner(paramClass);
    if (localScanner == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramClass;
      throw new PersistenceException("Invalid schema class %s", arrayOfObject);
    }
    return new ClassSchema(localScanner, this);
  }

  public Session getSession()
  {
    return this.session;
  }

  public Style getStyle()
  {
    return this.support.getStyle();
  }

  public Support getSupport()
  {
    return this.support;
  }

  public Class getType(Type paramType, Object paramObject)
  {
    if (paramObject != null);
    for (Class localClass = paramObject.getClass(); ; localClass = paramType.getType())
      return localClass;
  }

  public Version getVersion(Class paramClass)
    throws Exception
  {
    return getScanner(paramClass).getRevision();
  }

  public boolean isFloat(Class paramClass)
    throws Exception
  {
    Support localSupport = this.support;
    return Support.isFloat(paramClass);
  }

  public boolean isFloat(Type paramType)
    throws Exception
  {
    Class localClass = paramType.getType();
    return isFloat(localClass);
  }

  public boolean isPrimitive(Class paramClass)
    throws Exception
  {
    return this.support.isPrimitive(paramClass);
  }

  public boolean isPrimitive(Type paramType)
    throws Exception
  {
    Class localClass = paramType.getType();
    return isPrimitive(localClass);
  }

  public boolean isStrict()
  {
    return this.session.isStrict();
  }

  public boolean setOverride(Type paramType, Object paramObject, OutputNode paramOutputNode)
    throws Exception
  {
    NodeMap localNodeMap = paramOutputNode.getAttributes();
    if (localNodeMap == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramOutputNode;
      throw new PersistenceException("No attributes for %s", arrayOfObject);
    }
    Strategy localStrategy = this.strategy;
    Session localSession = this.session;
    return localStrategy.write(paramType, paramObject, localNodeMap, localSession);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Source
 * JD-Core Version:    0.6.2
 */