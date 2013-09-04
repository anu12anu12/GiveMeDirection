package org.simpleframework.xml.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeBuilder;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.Matcher;

public class Persister
  implements Serializer
{
  private final Format format;
  private final SessionManager manager;
  private final Strategy strategy;
  private final Support support;

  public Persister()
  {
    this(localHashMap);
  }

  public Persister(Map paramMap)
  {
    this(localPlatformFilter);
  }

  public Persister(Map paramMap, Format paramFormat)
  {
    this(localPlatformFilter);
  }

  public Persister(Filter paramFilter)
  {
    this(localTreeStrategy, paramFilter);
  }

  public Persister(Filter paramFilter, Format paramFormat)
  {
    this(localTreeStrategy, paramFilter, paramFormat);
  }

  public Persister(Filter paramFilter, Matcher paramMatcher)
  {
    this(localTreeStrategy, paramFilter, paramMatcher);
  }

  public Persister(Filter paramFilter, Matcher paramMatcher, Format paramFormat)
  {
    this(localTreeStrategy, paramFilter, paramMatcher, paramFormat);
  }

  public Persister(Strategy paramStrategy)
  {
    this(paramStrategy, localHashMap);
  }

  public Persister(Strategy paramStrategy, Map paramMap)
  {
    this(paramStrategy, localPlatformFilter);
  }

  public Persister(Strategy paramStrategy, Map paramMap, Format paramFormat)
  {
    this(paramStrategy, localPlatformFilter, paramFormat);
  }

  public Persister(Strategy paramStrategy, Filter paramFilter)
  {
    this(paramStrategy, paramFilter, localFormat);
  }

  public Persister(Strategy paramStrategy, Filter paramFilter, Format paramFormat)
  {
    this(paramStrategy, paramFilter, localEmptyMatcher, paramFormat);
  }

  public Persister(Strategy paramStrategy, Filter paramFilter, Matcher paramMatcher)
  {
    this(paramStrategy, paramFilter, paramMatcher, localFormat);
  }

  public Persister(Strategy paramStrategy, Filter paramFilter, Matcher paramMatcher, Format paramFormat)
  {
    Support localSupport = new Support(paramFilter, paramMatcher, paramFormat);
    this.support = localSupport;
    SessionManager localSessionManager = new SessionManager();
    this.manager = localSessionManager;
    this.strategy = paramStrategy;
    this.format = paramFormat;
  }

  public Persister(Strategy paramStrategy, Format paramFormat)
  {
    this(paramStrategy, localHashMap, paramFormat);
  }

  public Persister(Strategy paramStrategy, Matcher paramMatcher)
  {
    this(paramStrategy, localPlatformFilter, paramMatcher);
  }

  public Persister(Strategy paramStrategy, Matcher paramMatcher, Format paramFormat)
  {
    this(paramStrategy, localPlatformFilter, paramMatcher, paramFormat);
  }

  public Persister(Format paramFormat)
  {
    this(localTreeStrategy, paramFormat);
  }

  public Persister(Matcher paramMatcher)
  {
    this(localTreeStrategy, paramMatcher);
  }

  public Persister(Matcher paramMatcher, Format paramFormat)
  {
    this(localTreeStrategy, paramMatcher, paramFormat);
  }

  private <T> T read(Class<? extends T> paramClass, InputNode paramInputNode, Context paramContext)
    throws Exception
  {
    return new Traverser(paramContext).read(paramInputNode, paramClass);
  }

  private <T> T read(Class<? extends T> paramClass, InputNode paramInputNode, Session paramSession)
    throws Exception
  {
    Strategy localStrategy = this.strategy;
    Support localSupport = this.support;
    Source localSource = new Source(localStrategy, localSupport, paramSession);
    return read(paramClass, paramInputNode, localSource);
  }

  private <T> T read(T paramT, InputNode paramInputNode, Context paramContext)
    throws Exception
  {
    return new Traverser(paramContext).read(paramInputNode, paramT);
  }

  private <T> T read(T paramT, InputNode paramInputNode, Session paramSession)
    throws Exception
  {
    Strategy localStrategy = this.strategy;
    Support localSupport = this.support;
    Source localSource = new Source(localStrategy, localSupport, paramSession);
    return read(paramT, paramInputNode, localSource);
  }

  private boolean validate(Class paramClass, InputNode paramInputNode, Context paramContext)
    throws Exception
  {
    return new Traverser(paramContext).validate(paramInputNode, paramClass);
  }

  private boolean validate(Class paramClass, InputNode paramInputNode, Session paramSession)
    throws Exception
  {
    Strategy localStrategy = this.strategy;
    Support localSupport = this.support;
    Source localSource = new Source(localStrategy, localSupport, paramSession);
    return validate(paramClass, paramInputNode, localSource);
  }

  private void write(Object paramObject, OutputNode paramOutputNode, Context paramContext)
    throws Exception
  {
    new Traverser(paramContext).write(paramOutputNode, paramObject);
  }

  private void write(Object paramObject, OutputNode paramOutputNode, Session paramSession)
    throws Exception
  {
    Strategy localStrategy = this.strategy;
    Support localSupport = this.support;
    Source localSource = new Source(localStrategy, localSupport, paramSession);
    write(paramObject, paramOutputNode, localSource);
  }

  public <T> T read(Class<? extends T> paramClass, File paramFile)
    throws Exception
  {
    return read(paramClass, paramFile, true);
  }

  public <T> T read(Class<? extends T> paramClass, File paramFile, boolean paramBoolean)
    throws Exception
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      Object localObject1 = read(paramClass, localFileInputStream, paramBoolean);
      Object localObject2 = localObject1;
      return localObject2;
    }
    finally
    {
      localFileInputStream.close();
    }
  }

  public <T> T read(Class<? extends T> paramClass, InputStream paramInputStream)
    throws Exception
  {
    return read(paramClass, paramInputStream, true);
  }

  public <T> T read(Class<? extends T> paramClass, InputStream paramInputStream, boolean paramBoolean)
    throws Exception
  {
    InputNode localInputNode = NodeBuilder.read(paramInputStream);
    return read(paramClass, localInputNode, paramBoolean);
  }

  public <T> T read(Class<? extends T> paramClass, Reader paramReader)
    throws Exception
  {
    return read(paramClass, paramReader, true);
  }

  public <T> T read(Class<? extends T> paramClass, Reader paramReader, boolean paramBoolean)
    throws Exception
  {
    InputNode localInputNode = NodeBuilder.read(paramReader);
    return read(paramClass, localInputNode, paramBoolean);
  }

  public <T> T read(Class<? extends T> paramClass, String paramString)
    throws Exception
  {
    return read(paramClass, paramString, true);
  }

  public <T> T read(Class<? extends T> paramClass, String paramString, boolean paramBoolean)
    throws Exception
  {
    StringReader localStringReader = new StringReader(paramString);
    return read(paramClass, localStringReader, paramBoolean);
  }

  public <T> T read(Class<? extends T> paramClass, InputNode paramInputNode)
    throws Exception
  {
    return read(paramClass, paramInputNode, true);
  }

  public <T> T read(Class<? extends T> paramClass, InputNode paramInputNode, boolean paramBoolean)
    throws Exception
  {
    Session localSession = this.manager.open(paramBoolean);
    try
    {
      Object localObject1 = read(paramClass, paramInputNode, localSession);
      Object localObject2 = localObject1;
      return localObject2;
    }
    finally
    {
      this.manager.close();
    }
  }

  public <T> T read(T paramT, File paramFile)
    throws Exception
  {
    return read(paramT, paramFile, true);
  }

  public <T> T read(T paramT, File paramFile, boolean paramBoolean)
    throws Exception
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      Object localObject1 = read(paramT, localFileInputStream, paramBoolean);
      Object localObject2 = localObject1;
      return localObject2;
    }
    finally
    {
      localFileInputStream.close();
    }
  }

  public <T> T read(T paramT, InputStream paramInputStream)
    throws Exception
  {
    return read(paramT, paramInputStream, true);
  }

  public <T> T read(T paramT, InputStream paramInputStream, boolean paramBoolean)
    throws Exception
  {
    InputNode localInputNode = NodeBuilder.read(paramInputStream);
    return read(paramT, localInputNode, paramBoolean);
  }

  public <T> T read(T paramT, Reader paramReader)
    throws Exception
  {
    return read(paramT, paramReader, true);
  }

  public <T> T read(T paramT, Reader paramReader, boolean paramBoolean)
    throws Exception
  {
    InputNode localInputNode = NodeBuilder.read(paramReader);
    return read(paramT, localInputNode, paramBoolean);
  }

  public <T> T read(T paramT, String paramString)
    throws Exception
  {
    return read(paramT, paramString, true);
  }

  public <T> T read(T paramT, String paramString, boolean paramBoolean)
    throws Exception
  {
    StringReader localStringReader = new StringReader(paramString);
    return read(paramT, localStringReader, paramBoolean);
  }

  public <T> T read(T paramT, InputNode paramInputNode)
    throws Exception
  {
    return read(paramT, paramInputNode, true);
  }

  public <T> T read(T paramT, InputNode paramInputNode, boolean paramBoolean)
    throws Exception
  {
    Session localSession = this.manager.open(paramBoolean);
    try
    {
      Object localObject1 = read(paramT, paramInputNode, localSession);
      Object localObject2 = localObject1;
      return localObject2;
    }
    finally
    {
      this.manager.close();
    }
  }

  public boolean validate(Class paramClass, File paramFile)
    throws Exception
  {
    return validate(paramClass, paramFile, true);
  }

  public boolean validate(Class paramClass, File paramFile, boolean paramBoolean)
    throws Exception
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      boolean bool1 = validate(paramClass, localFileInputStream, paramBoolean);
      boolean bool2 = bool1;
      return bool2;
    }
    finally
    {
      localFileInputStream.close();
    }
  }

  public boolean validate(Class paramClass, InputStream paramInputStream)
    throws Exception
  {
    return validate(paramClass, paramInputStream, true);
  }

  public boolean validate(Class paramClass, InputStream paramInputStream, boolean paramBoolean)
    throws Exception
  {
    InputNode localInputNode = NodeBuilder.read(paramInputStream);
    return validate(paramClass, localInputNode, paramBoolean);
  }

  public boolean validate(Class paramClass, Reader paramReader)
    throws Exception
  {
    return validate(paramClass, paramReader, true);
  }

  public boolean validate(Class paramClass, Reader paramReader, boolean paramBoolean)
    throws Exception
  {
    InputNode localInputNode = NodeBuilder.read(paramReader);
    return validate(paramClass, localInputNode, paramBoolean);
  }

  public boolean validate(Class paramClass, String paramString)
    throws Exception
  {
    return validate(paramClass, paramString, true);
  }

  public boolean validate(Class paramClass, String paramString, boolean paramBoolean)
    throws Exception
  {
    StringReader localStringReader = new StringReader(paramString);
    return validate(paramClass, localStringReader, paramBoolean);
  }

  public boolean validate(Class paramClass, InputNode paramInputNode)
    throws Exception
  {
    return validate(paramClass, paramInputNode, true);
  }

  public boolean validate(Class paramClass, InputNode paramInputNode, boolean paramBoolean)
    throws Exception
  {
    Session localSession = this.manager.open(paramBoolean);
    try
    {
      boolean bool1 = validate(paramClass, paramInputNode, localSession);
      boolean bool2 = bool1;
      return bool2;
    }
    finally
    {
      this.manager.close();
    }
  }

  public void write(Object paramObject, File paramFile)
    throws Exception
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      write(paramObject, localFileOutputStream);
      return;
    }
    finally
    {
      localFileOutputStream.close();
    }
  }

  public void write(Object paramObject, OutputStream paramOutputStream)
    throws Exception
  {
    write(paramObject, paramOutputStream, "utf-8");
  }

  public void write(Object paramObject, OutputStream paramOutputStream, String paramString)
    throws Exception
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, paramString);
    write(paramObject, localOutputStreamWriter);
  }

  public void write(Object paramObject, Writer paramWriter)
    throws Exception
  {
    Format localFormat = this.format;
    OutputNode localOutputNode = NodeBuilder.write(paramWriter, localFormat);
    write(paramObject, localOutputNode);
  }

  public void write(Object paramObject, OutputNode paramOutputNode)
    throws Exception
  {
    Session localSession = this.manager.open();
    try
    {
      write(paramObject, paramOutputNode, localSession);
      return;
    }
    finally
    {
      this.manager.close();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Persister
 * JD-Core Version:    0.6.2
 */