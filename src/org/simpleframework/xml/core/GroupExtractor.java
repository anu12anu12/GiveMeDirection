package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

class GroupExtractor
  implements Group
{
  private final LabelMap elements;
  private final ExtractorFactory factory;
  private final Annotation label;
  private final Registry registry;

  public GroupExtractor(Contact paramContact, Annotation paramAnnotation, Format paramFormat)
    throws Exception
  {
    ExtractorFactory localExtractorFactory = new ExtractorFactory(paramContact, paramAnnotation, paramFormat);
    this.factory = localExtractorFactory;
    LabelMap localLabelMap1 = new LabelMap();
    this.elements = localLabelMap1;
    LabelMap localLabelMap2 = this.elements;
    Registry localRegistry = new Registry(localLabelMap2);
    this.registry = localRegistry;
    this.label = paramAnnotation;
    extract();
  }

  private void extract()
    throws Exception
  {
    Extractor localExtractor = this.factory.getInstance();
    if (localExtractor == null)
      return;
    extract(localExtractor);
  }

  private void extract(Extractor paramExtractor)
    throws Exception
  {
    Annotation[] arrayOfAnnotation = paramExtractor.getAnnotations();
    int i = arrayOfAnnotation.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Annotation localAnnotation = arrayOfAnnotation[j];
      extract(paramExtractor, localAnnotation);
      j += 1;
    }
  }

  private void extract(Extractor paramExtractor, Annotation paramAnnotation)
    throws Exception
  {
    Label localLabel = paramExtractor.getLabel(paramAnnotation);
    Class localClass = paramExtractor.getType(paramAnnotation);
    if (this.registry == null)
      return;
    this.registry.register(localClass, localLabel);
  }

  public LabelMap getElements()
    throws Exception
  {
    return this.elements.getLabels();
  }

  public Label getLabel(Class paramClass)
  {
    return this.registry.resolve(paramClass);
  }

  public String[] getNames()
    throws Exception
  {
    return this.elements.getKeys();
  }

  public String[] getPaths()
    throws Exception
  {
    return this.elements.getPaths();
  }

  public Label getText()
  {
    return this.registry.resolveText();
  }

  public boolean isDeclared(Class paramClass)
  {
    return this.registry.containsKey(paramClass);
  }

  public boolean isInline()
  {
    boolean bool = false;
    Iterator localIterator = this.registry.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((Label)localIterator.next()).isInline());
    while (true)
    {
      return bool;
      if (!this.registry.isEmpty())
        bool = true;
    }
  }

  public boolean isTextList()
  {
    return this.registry.isText();
  }

  public boolean isValid(Class paramClass)
  {
    if (this.registry.resolve(paramClass) != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public String toString()
  {
    return this.label.toString();
  }

  private static class Registry extends LinkedHashMap<Class, Label>
    implements Iterable<Label>
  {
    private LabelMap elements;
    private Label text;

    public Registry(LabelMap paramLabelMap)
    {
      this.elements = paramLabelMap;
    }

    private void registerElement(Class paramClass, Label paramLabel)
      throws Exception
    {
      String str = paramLabel.getName();
      if (!this.elements.containsKey(str))
        Object localObject1 = this.elements.put(str, paramLabel);
      if (containsKey(paramClass))
        return;
      Object localObject2 = put(paramClass, paramLabel);
    }

    private void registerText(Label paramLabel)
      throws Exception
    {
      Text localText = (Text)paramLabel.getContact().getAnnotation(Text.class);
      if (localText == null)
        return;
      TextListLabel localTextListLabel = new TextListLabel(paramLabel, localText);
      this.text = localTextListLabel;
    }

    private Label resolveElement(Class paramClass)
    {
      Label localLabel;
      if (paramClass != null)
      {
        localLabel = (Label)get(paramClass);
        if (localLabel == null);
      }
      while (true)
      {
        return localLabel;
        paramClass = paramClass.getSuperclass();
        break;
        localLabel = null;
      }
    }

    private Label resolveText(Class paramClass)
    {
      if ((this.text != null) && (paramClass == String.class));
      for (Label localLabel = this.text; ; localLabel = null)
        return localLabel;
    }

    public boolean isText()
    {
      if (this.text != null);
      for (boolean bool = true; ; bool = false)
        return bool;
    }

    public Iterator<Label> iterator()
    {
      return values().iterator();
    }

    public void register(Class paramClass, Label paramLabel)
      throws Exception
    {
      CacheLabel localCacheLabel = new CacheLabel(paramLabel);
      registerElement(paramClass, localCacheLabel);
      registerText(localCacheLabel);
    }

    public Label resolve(Class paramClass)
    {
      Label localLabel = resolveText(paramClass);
      if (localLabel == null)
        localLabel = resolveElement(paramClass);
      return localLabel;
    }

    public Label resolveText()
    {
      return resolveText(String.class);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.GroupExtractor
 * JD-Core Version:    0.6.2
 */