package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

class ClassSchema
  implements Schema
{
  private final Caller caller;
  private final Decorator decorator;
  private final Instantiator factory;
  private final boolean primitive;
  private final Version revision;
  private final Section section;
  private final Label text;
  private final Class type;
  private final Label version;

  public ClassSchema(Scanner paramScanner, Context paramContext)
    throws Exception
  {
    Caller localCaller = paramScanner.getCaller(paramContext);
    this.caller = localCaller;
    Instantiator localInstantiator = paramScanner.getInstantiator();
    this.factory = localInstantiator;
    Version localVersion = paramScanner.getRevision();
    this.revision = localVersion;
    Decorator localDecorator = paramScanner.getDecorator();
    this.decorator = localDecorator;
    boolean bool = paramScanner.isPrimitive();
    this.primitive = bool;
    Label localLabel1 = paramScanner.getVersion();
    this.version = localLabel1;
    Section localSection = paramScanner.getSection();
    this.section = localSection;
    Label localLabel2 = paramScanner.getText();
    this.text = localLabel2;
    Class localClass = paramScanner.getType();
    this.type = localClass;
  }

  public Caller getCaller()
  {
    return this.caller;
  }

  public Decorator getDecorator()
  {
    return this.decorator;
  }

  public Instantiator getInstantiator()
  {
    return this.factory;
  }

  public Version getRevision()
  {
    return this.revision;
  }

  public Section getSection()
  {
    return this.section;
  }

  public Label getText()
  {
    return this.text;
  }

  public Label getVersion()
  {
    return this.version;
  }

  public boolean isPrimitive()
  {
    return this.primitive;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    Class localClass = this.type;
    arrayOfObject[0] = localClass;
    return String.format("schema for %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ClassSchema
 * JD-Core Version:    0.6.2
 */