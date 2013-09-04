package org.simpleframework.xml.core;

class Caller
{
  private final Function commit;
  private final Function complete;
  private final Context context;
  private final Function persist;
  private final Function replace;
  private final Function resolve;
  private final Function validate;

  public Caller(Scanner paramScanner, Context paramContext)
  {
    Function localFunction1 = paramScanner.getValidate();
    this.validate = localFunction1;
    Function localFunction2 = paramScanner.getComplete();
    this.complete = localFunction2;
    Function localFunction3 = paramScanner.getReplace();
    this.replace = localFunction3;
    Function localFunction4 = paramScanner.getResolve();
    this.resolve = localFunction4;
    Function localFunction5 = paramScanner.getPersist();
    this.persist = localFunction5;
    Function localFunction6 = paramScanner.getCommit();
    this.commit = localFunction6;
    this.context = paramContext;
  }

  public void commit(Object paramObject)
    throws Exception
  {
    if (this.commit == null)
      return;
    Function localFunction = this.commit;
    Context localContext = this.context;
    Object localObject = localFunction.call(localContext, paramObject);
  }

  public void complete(Object paramObject)
    throws Exception
  {
    if (this.complete == null)
      return;
    Function localFunction = this.complete;
    Context localContext = this.context;
    Object localObject = localFunction.call(localContext, paramObject);
  }

  public void persist(Object paramObject)
    throws Exception
  {
    if (this.persist == null)
      return;
    Function localFunction = this.persist;
    Context localContext = this.context;
    Object localObject = localFunction.call(localContext, paramObject);
  }

  public Object replace(Object paramObject)
    throws Exception
  {
    if (this.replace != null)
    {
      Function localFunction = this.replace;
      Context localContext = this.context;
      paramObject = localFunction.call(localContext, paramObject);
    }
    return paramObject;
  }

  public Object resolve(Object paramObject)
    throws Exception
  {
    if (this.resolve != null)
    {
      Function localFunction = this.resolve;
      Context localContext = this.context;
      paramObject = localFunction.call(localContext, paramObject);
    }
    return paramObject;
  }

  public void validate(Object paramObject)
    throws Exception
  {
    if (this.validate == null)
      return;
    Function localFunction = this.validate;
    Context localContext = this.context;
    Object localObject = localFunction.call(localContext, paramObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Caller
 * JD-Core Version:    0.6.2
 */