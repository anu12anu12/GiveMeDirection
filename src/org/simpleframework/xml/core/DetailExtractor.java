package org.simpleframework.xml.core;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class DetailExtractor
{
  private final Cache<Detail> details;
  private final Cache<ContactList> fields;
  private final Cache<ContactList> methods;
  private final Support support;

  public DetailExtractor(Support paramSupport)
  {
    ConcurrentCache localConcurrentCache1 = new ConcurrentCache();
    this.methods = localConcurrentCache1;
    ConcurrentCache localConcurrentCache2 = new ConcurrentCache();
    this.fields = localConcurrentCache2;
    ConcurrentCache localConcurrentCache3 = new ConcurrentCache();
    this.details = localConcurrentCache3;
    this.support = paramSupport;
  }

  private ContactList getFields(Detail paramDetail)
    throws Exception
  {
    Support localSupport = this.support;
    FieldScanner localFieldScanner = new FieldScanner(paramDetail, localSupport);
    if (paramDetail != null)
      this.fields.cache(paramDetail, localFieldScanner);
    return localFieldScanner;
  }

  private ContactList getMethods(Detail paramDetail)
    throws Exception
  {
    Support localSupport = this.support;
    MethodScanner localMethodScanner = new MethodScanner(paramDetail, localSupport);
    if (paramDetail != null)
      this.methods.cache(paramDetail, localMethodScanner);
    return localMethodScanner;
  }

  public Detail getDetail(Class paramClass)
  {
    Object localObject = (Detail)this.details.fetch(paramClass);
    if (localObject == null)
    {
      localObject = new DetailScanner(paramClass);
      this.details.cache(paramClass, localObject);
    }
    return localObject;
  }

  public ContactList getFields(Class paramClass)
    throws Exception
  {
    ContactList localContactList = (ContactList)this.fields.fetch(paramClass);
    if (localContactList == null)
    {
      Detail localDetail = getDetail(paramClass);
      if (localDetail != null)
        localContactList = getFields(localDetail);
    }
    return localContactList;
  }

  public ContactList getMethods(Class paramClass)
    throws Exception
  {
    ContactList localContactList = (ContactList)this.methods.fetch(paramClass);
    if (localContactList == null)
    {
      Detail localDetail = getDetail(paramClass);
      if (localDetail != null)
        localContactList = getMethods(localDetail);
    }
    return localContactList;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.DetailExtractor
 * JD-Core Version:    0.6.2
 */