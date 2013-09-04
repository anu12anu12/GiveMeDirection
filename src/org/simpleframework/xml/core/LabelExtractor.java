package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class LabelExtractor
{
  private final Cache<LabelGroup> cache;
  private final Format format;

  public LabelExtractor(Format paramFormat)
  {
    ConcurrentCache localConcurrentCache = new ConcurrentCache();
    this.cache = localConcurrentCache;
    this.format = paramFormat;
  }

  private Annotation[] getAnnotations(Annotation paramAnnotation)
    throws Exception
  {
    Method[] arrayOfMethod = paramAnnotation.annotationType().getDeclaredMethods();
    Method localMethod;
    Object[] arrayOfObject;
    if (arrayOfMethod.length > 0)
    {
      localMethod = arrayOfMethod[0];
      arrayOfObject = new Object[0];
    }
    for (Annotation[] arrayOfAnnotation = (Annotation[])localMethod.invoke(paramAnnotation, arrayOfObject); ; arrayOfAnnotation = new Annotation[0])
      return arrayOfAnnotation;
  }

  private LabelBuilder getBuilder(Annotation paramAnnotation)
    throws Exception
  {
    LabelBuilder localLabelBuilder;
    if ((paramAnnotation instanceof Element))
      localLabelBuilder = new LabelBuilder(ElementLabel.class, Element.class);
    while (true)
    {
      return localLabelBuilder;
      if ((paramAnnotation instanceof ElementList))
      {
        localLabelBuilder = new LabelBuilder(ElementListLabel.class, ElementList.class);
      }
      else if ((paramAnnotation instanceof ElementArray))
      {
        localLabelBuilder = new LabelBuilder(ElementArrayLabel.class, ElementArray.class);
      }
      else if ((paramAnnotation instanceof ElementMap))
      {
        localLabelBuilder = new LabelBuilder(ElementMapLabel.class, ElementMap.class);
      }
      else if ((paramAnnotation instanceof ElementUnion))
      {
        localLabelBuilder = new LabelBuilder(ElementUnionLabel.class, ElementUnion.class, Element.class);
      }
      else if ((paramAnnotation instanceof ElementListUnion))
      {
        localLabelBuilder = new LabelBuilder(ElementListUnionLabel.class, ElementListUnion.class, ElementList.class);
      }
      else if ((paramAnnotation instanceof ElementMapUnion))
      {
        localLabelBuilder = new LabelBuilder(ElementMapUnionLabel.class, ElementMapUnion.class, ElementMap.class);
      }
      else if ((paramAnnotation instanceof Attribute))
      {
        localLabelBuilder = new LabelBuilder(AttributeLabel.class, Attribute.class);
      }
      else if ((paramAnnotation instanceof Version))
      {
        localLabelBuilder = new LabelBuilder(VersionLabel.class, Version.class);
      }
      else
      {
        if (!(paramAnnotation instanceof Text))
          break;
        localLabelBuilder = new LabelBuilder(TextLabel.class, Text.class);
      }
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramAnnotation;
    throw new PersistenceException("Annotation %s not supported", arrayOfObject);
  }

  private Constructor getConstructor(Annotation paramAnnotation)
    throws Exception
  {
    Constructor localConstructor = getBuilder(paramAnnotation).getConstructor();
    if (!localConstructor.isAccessible())
      localConstructor.setAccessible(true);
    return localConstructor;
  }

  private LabelGroup getGroup(Contact paramContact, Annotation paramAnnotation, Object paramObject)
    throws Exception
  {
    LabelGroup localLabelGroup1 = (LabelGroup)this.cache.fetch(paramObject);
    LabelGroup localLabelGroup2;
    if (localLabelGroup1 == null)
    {
      localLabelGroup2 = getLabels(paramContact, paramAnnotation);
      if (localLabelGroup2 != null)
        this.cache.cache(paramObject, localLabelGroup2);
    }
    while (true)
    {
      return localLabelGroup2;
      localLabelGroup2 = localLabelGroup1;
    }
  }

  private Object getKey(Contact paramContact, Annotation paramAnnotation)
  {
    return new LabelKey(paramContact, paramAnnotation);
  }

  private Label getLabel(Contact paramContact, Annotation paramAnnotation1, Annotation paramAnnotation2)
    throws Exception
  {
    Constructor localConstructor = getConstructor(paramAnnotation1);
    Object[] arrayOfObject1;
    if (paramAnnotation2 != null)
    {
      arrayOfObject1 = new Object[4];
      arrayOfObject1[0] = paramContact;
      arrayOfObject1[1] = paramAnnotation1;
      arrayOfObject1[2] = paramAnnotation2;
      Format localFormat1 = this.format;
      arrayOfObject1[3] = localFormat1;
    }
    Object[] arrayOfObject2;
    for (Label localLabel = (Label)localConstructor.newInstance(arrayOfObject1); ; localLabel = (Label)localConstructor.newInstance(arrayOfObject2))
    {
      return localLabel;
      arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = paramContact;
      arrayOfObject2[1] = paramAnnotation1;
      Format localFormat2 = this.format;
      arrayOfObject2[2] = localFormat2;
    }
  }

  private LabelGroup getLabels(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    LabelGroup localLabelGroup;
    if ((paramAnnotation instanceof ElementUnion))
      localLabelGroup = getUnion(paramContact, paramAnnotation);
    while (true)
    {
      return localLabelGroup;
      if ((paramAnnotation instanceof ElementListUnion))
        localLabelGroup = getUnion(paramContact, paramAnnotation);
      else if ((paramAnnotation instanceof ElementMapUnion))
        localLabelGroup = getUnion(paramContact, paramAnnotation);
      else
        localLabelGroup = getSingle(paramContact, paramAnnotation);
    }
  }

  private LabelGroup getSingle(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Object localObject = getLabel(paramContact, paramAnnotation, null);
    if (localObject != null)
      localObject = new CacheLabel((Label)localObject);
    return new LabelGroup((Label)localObject);
  }

  private LabelGroup getUnion(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Annotation[] arrayOfAnnotation1 = getAnnotations(paramAnnotation);
    LinkedList localLinkedList;
    if (arrayOfAnnotation1.length > 0)
    {
      localLinkedList = new LinkedList();
      Annotation[] arrayOfAnnotation2 = arrayOfAnnotation1;
      int i = arrayOfAnnotation2.length;
      int j = 0;
      while (j < i)
      {
        Annotation localAnnotation = arrayOfAnnotation2[j];
        Object localObject = getLabel(paramContact, paramAnnotation, localAnnotation);
        if (localObject != null)
          localObject = new CacheLabel((Label)localObject);
        boolean bool = localLinkedList.add(localObject);
        j += 1;
      }
    }
    for (LabelGroup localLabelGroup = new LabelGroup(localLinkedList); ; localLabelGroup = null)
      return localLabelGroup;
  }

  public Label getLabel(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Object localObject = getKey(paramContact, paramAnnotation);
    LabelGroup localLabelGroup = getGroup(paramContact, paramAnnotation, localObject);
    if (localLabelGroup != null);
    for (Label localLabel = localLabelGroup.getPrimary(); ; localLabel = null)
      return localLabel;
  }

  public List<Label> getList(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Object localObject = getKey(paramContact, paramAnnotation);
    LabelGroup localLabelGroup = getGroup(paramContact, paramAnnotation, localObject);
    if (localLabelGroup != null);
    for (List localList = localLabelGroup.getList(); ; localList = Collections.emptyList())
      return localList;
  }

  private static class LabelBuilder
  {
    private final Class entry;
    private final Class label;
    private final Class type;

    public LabelBuilder(Class paramClass1, Class paramClass2)
    {
      this(paramClass1, paramClass2, null);
    }

    public LabelBuilder(Class paramClass1, Class paramClass2, Class paramClass3)
    {
      this.entry = paramClass3;
      this.label = paramClass2;
      this.type = paramClass1;
    }

    private Constructor getConstructor(Class paramClass)
      throws Exception
    {
      Class localClass = this.type;
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = Contact.class;
      arrayOfClass[1] = paramClass;
      arrayOfClass[2] = Format.class;
      return localClass.getConstructor(arrayOfClass);
    }

    private Constructor getConstructor(Class paramClass1, Class paramClass2)
      throws Exception
    {
      Class localClass = this.type;
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Contact.class;
      arrayOfClass[1] = paramClass1;
      arrayOfClass[2] = paramClass2;
      arrayOfClass[3] = Format.class;
      return localClass.getConstructor(arrayOfClass);
    }

    public Constructor getConstructor()
      throws Exception
    {
      Class localClass1;
      Class localClass2;
      if (this.entry != null)
      {
        localClass1 = this.label;
        localClass2 = this.entry;
      }
      Class localClass3;
      for (Constructor localConstructor = getConstructor(localClass1, localClass2); ; localConstructor = getConstructor(localClass3))
      {
        return localConstructor;
        localClass3 = this.label;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.LabelExtractor
 * JD-Core Version:    0.6.2
 */