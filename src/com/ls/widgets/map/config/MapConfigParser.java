package com.ls.widgets.map.config;

import android.graphics.Point;
import android.location.Location;
import android.util.Log;
import android.util.Pair;
import com.ls.widgets.map.utils.MapCalibrationData;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MapConfigParser
{
  private int a;
  private int b;
  private int c;
  private int d;
  private String e;
  private String f;
  private MapCalibrationData g;

  public MapConfigParser(String paramString)
  {
    this.f = paramString;
  }

  private OfflineMapConfig a(InputStream paramInputStream)
    throws ParserConfigurationException, FactoryConfigurationError, SAXException, IOException
  {
    DocumentBuilder localDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    InputStream localInputStream = paramInputStream;
    Node localNode1 = localDocumentBuilder.parse(localInputStream).getElementsByTagName("Image").item(0);
    NamedNodeMap localNamedNodeMap1 = localNode1.getAttributes();
    Node localNode2 = localNamedNodeMap1.getNamedItem("TileSize");
    Node localNode3 = localNamedNodeMap1.getNamedItem("Overlap");
    Node localNode4 = localNamedNodeMap1.getNamedItem("Format");
    Object localObject1 = null;
    NodeList localNodeList1 = localNode1.getChildNodes();
    int i = 0;
    int j = 0;
    int k = localNodeList1.getLength();
    Object localObject2;
    if (j < k)
    {
      localObject2 = localNodeList1.item(j);
      if ((localObject2 != null) && (((Node)localObject2).getNodeName().equals("Size")))
        Object localObject3 = localObject2;
      if ((localObject2 == null) || (!((Node)localObject2).getNodeName().equals("CalibrationRect")))
        break label888;
    }
    while (true)
    {
      j += 1;
      localObject1 = localObject2;
      break;
      NamedNodeMap localNamedNodeMap2 = null.getAttributes();
      Node localNode5 = localNamedNodeMap2.getNamedItem("Width");
      Node localNode6 = localNamedNodeMap2.getNamedItem("Height");
      if (localObject1 != null)
      {
        NodeList localNodeList2 = localObject1.getChildNodes();
        Pair localPair1 = null;
        Object localObject4 = null;
        i = 0;
        int m = localNodeList2.getLength();
        if (i < m)
        {
          Node localNode7 = localNodeList2.item(i);
          double d1;
          double d2;
          int i1;
          int i2;
          Object localObject5;
          if ((localNode7 != null) && (localNode7.getNodeName().equals("Point")))
          {
            NamedNodeMap localNamedNodeMap3 = localNode7.getAttributes();
            Node localNode8 = localNamedNodeMap3.getNamedItem("topLeft");
            d1 = localNamedNodeMap3.getNamedItem("lat");
            Node localNode9 = localNamedNodeMap3.getNamedItem("lon");
            int n = localNamedNodeMap3.getNamedItem("x");
            String str1 = "y";
            localNode7 = localNamedNodeMap3.getNamedItem(str1);
            if ((d1 != null) && (localNode9 != null))
            {
              d2 = Double.parseDouble(d1.getNodeValue());
              d1 = Double.parseDouble(localNode9.getNodeValue());
              i1 = Integer.parseInt(n.getNodeValue());
              i2 = Integer.parseInt(localNode7.getNodeValue());
              if ((localNode8 != null) && (localNode8.getNodeValue().equals("1")))
              {
                Point localPoint1 = new Point();
                String str2 = "config";
                Location localLocation1 = new Location(str2);
                localPair1 = new Pair(localPoint1, localLocation1);
                Point localPoint2 = (Point)localPair1.first;
                int i3 = i2;
                localPoint2.set(i1, i3);
                Location localLocation2 = (Location)localPair1.second;
                double d3 = d2;
                localLocation2.setLatitude(d3);
                ((Location)localPair1.second).setLongitude(d1);
                localObject5 = localObject4;
              }
            }
          }
          for (Pair localPair2 = localPair1; ; localPair2 = localPair1)
          {
            i += 1;
            Pair localPair3 = localPair2;
            localObject4 = localObject5;
            break;
            Point localPoint3 = new Point();
            String str3 = "config";
            Location localLocation3 = new Location(str3);
            localObject4 = new Pair(localPoint3, localLocation3);
            Point localPoint4 = (Point)((Pair)localObject4).first;
            int i4 = i2;
            localPoint4.set(i1, i4);
            Location localLocation4 = (Location)((Pair)localObject4).second;
            double d4 = d2;
            localLocation4.setLatitude(d4);
            ((Location)((Pair)localObject4).second).setLongitude(d1);
            localObject5 = localObject4;
          }
        }
        if ((localPair1 != null) && (localObject4 != null))
        {
          MapCalibrationData localMapCalibrationData1 = new MapCalibrationData(localPair1, (Pair)localObject4);
          this.g = localMapCalibrationData1;
        }
      }
      while (true)
      {
        if (localNode2 != null)
        {
          int i5 = Integer.parseInt(localNode2.getNodeValue());
          this.c = i5;
        }
        if (localNode3 != null)
        {
          int i6 = Integer.parseInt(localNode3.getNodeValue());
          this.d = i6;
        }
        if (localNode4 != null)
        {
          String str4 = localNode4.getNodeValue();
          this.e = str4;
        }
        if (localNode5 != null)
        {
          int i7 = Integer.parseInt(localNode5.getNodeValue());
          this.a = i7;
        }
        if (localNode6 != null)
        {
          int i8 = Integer.parseInt(localNode6.getNodeValue());
          this.b = i8;
        }
        String str5 = this.f;
        int i9 = this.a;
        int i10 = this.b;
        int i11 = this.c;
        int i12 = this.d;
        String str6 = this.e;
        OfflineMapConfig localOfflineMapConfig = new OfflineMapConfig(str5, i9, i10, i11, i12, str6);
        GPSConfig localGPSConfig = localOfflineMapConfig.getGpsConfig();
        MapCalibrationData localMapCalibrationData2 = this.g;
        localGPSConfig.setGeoArea(localMapCalibrationData2);
        return localOfflineMapConfig;
        int i13 = Log.w("MapConfigParser", "No geo area is set");
        continue;
        int i14 = Log.w("MapConfigParser", "GeoArea is not configured.");
      }
      label888: localObject2 = localObject1;
    }
  }

  // ERROR //
  public OfflineMapConfig parse(android.content.Context paramContext, java.io.File paramFile)
    throws IOException, SAXException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: invokevirtual 217	java/io/File:exists	()Z
    //   6: ifeq +36 -> 42
    //   9: new 219	java/io/FileInputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 4
    //   19: aload_0
    //   20: aload 4
    //   22: invokespecial 224	com/ls/widgets/map/config/MapConfigParser:a	(Ljava/io/InputStream;)Lcom/ls/widgets/map/config/OfflineMapConfig;
    //   25: astore 5
    //   27: aload 5
    //   29: astore_3
    //   30: aload 4
    //   32: ifnull +8 -> 40
    //   35: aload 4
    //   37: invokevirtual 229	java/io/InputStream:close	()V
    //   40: aload_3
    //   41: areturn
    //   42: ldc 200
    //   44: ldc 231
    //   46: invokestatic 233	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   49: istore 6
    //   51: iconst_0
    //   52: ifeq -12 -> 40
    //   55: aconst_null
    //   56: invokevirtual 229	java/io/InputStream:close	()V
    //   59: goto -19 -> 40
    //   62: astore 7
    //   64: aconst_null
    //   65: astore 4
    //   67: new 235	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   74: ldc 238
    //   76: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 7
    //   81: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 8
    //   89: ldc 200
    //   91: aload 8
    //   93: invokestatic 233	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   96: istore 9
    //   98: aload 7
    //   100: invokevirtual 251	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   103: aload 4
    //   105: ifnull -65 -> 40
    //   108: aload 4
    //   110: invokevirtual 229	java/io/InputStream:close	()V
    //   113: goto -73 -> 40
    //   116: astore 7
    //   118: aconst_null
    //   119: astore 4
    //   121: new 235	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   128: ldc 238
    //   130: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 7
    //   135: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore 10
    //   143: ldc 200
    //   145: aload 10
    //   147: invokestatic 233	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   150: istore 11
    //   152: aload 7
    //   154: invokevirtual 252	javax/xml/parsers/FactoryConfigurationError:printStackTrace	()V
    //   157: aload 4
    //   159: ifnull -119 -> 40
    //   162: aload 4
    //   164: invokevirtual 229	java/io/InputStream:close	()V
    //   167: goto -127 -> 40
    //   170: astore 12
    //   172: aconst_null
    //   173: astore 4
    //   175: aload 12
    //   177: astore 13
    //   179: aload 4
    //   181: ifnull +8 -> 189
    //   184: aload 4
    //   186: invokevirtual 229	java/io/InputStream:close	()V
    //   189: aload 13
    //   191: athrow
    //   192: astore 13
    //   194: goto -15 -> 179
    //   197: astore 7
    //   199: goto -78 -> 121
    //   202: astore 7
    //   204: goto -137 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	62	javax/xml/parsers/ParserConfigurationException
    //   42	51	62	javax/xml/parsers/ParserConfigurationException
    //   2	19	116	javax/xml/parsers/FactoryConfigurationError
    //   42	51	116	javax/xml/parsers/FactoryConfigurationError
    //   2	19	170	finally
    //   42	51	170	finally
    //   19	27	192	finally
    //   67	103	192	finally
    //   121	157	192	finally
    //   19	27	197	javax/xml/parsers/FactoryConfigurationError
    //   19	27	202	javax/xml/parsers/ParserConfigurationException
  }

  // ERROR //
  public OfflineMapConfig parse(android.content.Context paramContext, String paramString)
    throws IOException, SAXException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokevirtual 259	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: aload_2
    //   7: invokevirtual 265	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore 4
    //   12: aload 4
    //   14: astore 5
    //   16: aload_0
    //   17: aload 5
    //   19: invokespecial 224	com/ls/widgets/map/config/MapConfigParser:a	(Ljava/io/InputStream;)Lcom/ls/widgets/map/config/OfflineMapConfig;
    //   22: astore 4
    //   24: aload 4
    //   26: astore_3
    //   27: aload 5
    //   29: ifnull +8 -> 37
    //   32: aload 5
    //   34: invokevirtual 229	java/io/InputStream:close	()V
    //   37: aload_3
    //   38: areturn
    //   39: astore 6
    //   41: aconst_null
    //   42: astore 5
    //   44: new 235	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   51: ldc 238
    //   53: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 6
    //   58: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 7
    //   66: ldc 200
    //   68: aload 7
    //   70: invokestatic 233	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   73: istore 8
    //   75: aload 6
    //   77: invokevirtual 251	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   80: aload 5
    //   82: ifnull -45 -> 37
    //   85: aload 5
    //   87: invokevirtual 229	java/io/InputStream:close	()V
    //   90: goto -53 -> 37
    //   93: astore 6
    //   95: aconst_null
    //   96: astore 5
    //   98: new 235	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   105: ldc 238
    //   107: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 6
    //   112: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 9
    //   120: ldc 200
    //   122: aload 9
    //   124: invokestatic 233	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   127: istore 10
    //   129: aload 6
    //   131: invokevirtual 252	javax/xml/parsers/FactoryConfigurationError:printStackTrace	()V
    //   134: aload 5
    //   136: ifnull -99 -> 37
    //   139: aload 5
    //   141: invokevirtual 229	java/io/InputStream:close	()V
    //   144: goto -107 -> 37
    //   147: astore 11
    //   149: aconst_null
    //   150: astore 5
    //   152: aload 11
    //   154: astore 12
    //   156: aload 5
    //   158: ifnull +8 -> 166
    //   161: aload 5
    //   163: invokevirtual 229	java/io/InputStream:close	()V
    //   166: aload 12
    //   168: athrow
    //   169: astore 12
    //   171: goto -15 -> 156
    //   174: astore 6
    //   176: goto -78 -> 98
    //   179: astore 6
    //   181: goto -137 -> 44
    //
    // Exception table:
    //   from	to	target	type
    //   2	12	39	javax/xml/parsers/ParserConfigurationException
    //   2	12	93	javax/xml/parsers/FactoryConfigurationError
    //   2	12	147	finally
    //   16	24	169	finally
    //   44	80	169	finally
    //   98	134	169	finally
    //   16	24	174	javax/xml/parsers/FactoryConfigurationError
    //   16	24	179	javax/xml/parsers/ParserConfigurationException
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.config.MapConfigParser
 * JD-Core Version:    0.6.2
 */