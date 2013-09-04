package org.simpleframework.xml.core;

class SessionManager
{
  private ThreadLocal<Reference> local;

  public SessionManager()
  {
    ThreadLocal localThreadLocal = new ThreadLocal();
    this.local = localThreadLocal;
  }

  private Session create(boolean paramBoolean)
    throws Exception
  {
    Reference localReference = new Reference(paramBoolean);
    if (localReference != null)
      this.local.set(localReference);
    return localReference.get();
  }

  public void close()
    throws Exception
  {
    Reference localReference = (Reference)this.local.get();
    if (localReference == null)
    {
      Object[] arrayOfObject = new Object[0];
      throw new PersistenceException("Session does not exist", arrayOfObject);
    }
    if (localReference.clear() != 0)
      return;
    this.local.remove();
  }

  public Session open()
    throws Exception
  {
    return open(true);
  }

  public Session open(boolean paramBoolean)
    throws Exception
  {
    Reference localReference = (Reference)this.local.get();
    if (localReference != null);
    for (Session localSession = localReference.get(); ; localSession = create(paramBoolean))
      return localSession;
  }

  private static class Reference
  {
    private int count;
    private Session session;

    public Reference(boolean paramBoolean)
    {
      Session localSession = new Session(paramBoolean);
      this.session = localSession;
    }

    public int clear()
    {
      int i = this.count + -1;
      this.count = i;
      return i;
    }

    public Session get()
    {
      if (this.count >= 0)
      {
        int i = this.count + 1;
        this.count = i;
      }
      return this.session;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.SessionManager
 * JD-Core Version:    0.6.2
 */