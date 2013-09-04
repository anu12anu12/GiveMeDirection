package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Version;

class PrimitiveScanner
  implements Scanner
{
  private final Detail detail;
  private final Section section;

  public PrimitiveScanner(Detail paramDetail)
  {
    EmptySection localEmptySection = new EmptySection(this);
    this.section = localEmptySection;
    this.detail = paramDetail;
  }

  public Caller getCaller(Context paramContext)
  {
    return new Caller(this, paramContext);
  }

  public Function getCommit()
  {
    return null;
  }

  public Function getComplete()
  {
    return null;
  }

  public Decorator getDecorator()
  {
    return null;
  }

  public Instantiator getInstantiator()
  {
    return null;
  }

  public String getName()
  {
    return null;
  }

  public Order getOrder()
  {
    return null;
  }

  public ParameterMap getParameters()
  {
    return new ParameterMap();
  }

  public Function getPersist()
  {
    return null;
  }

  public Function getReplace()
  {
    return null;
  }

  public Function getResolve()
  {
    return null;
  }

  public Version getRevision()
  {
    return null;
  }

  public Section getSection()
  {
    return this.section;
  }

  public Signature getSignature()
  {
    return null;
  }

  public List<Signature> getSignatures()
  {
    return new LinkedList();
  }

  public Label getText()
  {
    return null;
  }

  public Class getType()
  {
    return this.detail.getType();
  }

  public Function getValidate()
  {
    return null;
  }

  public Label getVersion()
  {
    return null;
  }

  public boolean isEmpty()
  {
    return true;
  }

  public boolean isPrimitive()
  {
    return true;
  }

  public boolean isStrict()
  {
    return true;
  }

  private static class EmptySection
    implements Section
  {
    private final List<String> list;
    private final Scanner scanner;

    public EmptySection(Scanner paramScanner)
    {
      LinkedList localLinkedList = new LinkedList();
      this.list = localLinkedList;
      this.scanner = paramScanner;
    }

    public String getAttribute(String paramString)
    {
      return null;
    }

    public LabelMap getAttributes()
    {
      Scanner localScanner = this.scanner;
      return new LabelMap(localScanner);
    }

    public Label getElement(String paramString)
    {
      return null;
    }

    public LabelMap getElements()
    {
      Scanner localScanner = this.scanner;
      return new LabelMap(localScanner);
    }

    public String getName()
    {
      return null;
    }

    public String getPath(String paramString)
    {
      return null;
    }

    public String getPrefix()
    {
      return null;
    }

    public Section getSection(String paramString)
    {
      return null;
    }

    public Label getText()
    {
      return null;
    }

    public boolean isSection(String paramString)
    {
      return false;
    }

    public Iterator<String> iterator()
    {
      return this.list.iterator();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveScanner
 * JD-Core Version:    0.6.2
 */