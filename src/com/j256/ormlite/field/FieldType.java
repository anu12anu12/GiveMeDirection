package com.j256.ormlite.field;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class FieldType
{
  private static boolean DEFAULT_VALUE_BOOLEAN = false;
  private static byte DEFAULT_VALUE_BYTE = 0;
  private static char DEFAULT_VALUE_CHAR = '\000';
  private static double DEFAULT_VALUE_DOUBLE = 0.0D;
  private static float DEFAULT_VALUE_FLOAT = 0.0F;
  private static int DEFAULT_VALUE_INT = 0;
  private static long DEFAULT_VALUE_LONG = 0L;
  private static short DEFAULT_VALUE_SHORT = 0;
  public static final String FOREIGN_ID_FIELD_SUFFIX = "_id";
  private static final ThreadLocal<LevelCounters> threadLevelCounters = new ThreadLocal()
  {
    protected FieldType.LevelCounters initialValue()
    {
      return new FieldType.LevelCounters(null);
    }
  };
  private final String columnName;
  private final ConnectionSource connectionSource;
  private DataPersister dataPersister;
  private Object dataTypeConfigObj;
  private Object defaultValue;
  private final Field field;
  private final DatabaseFieldConfig fieldConfig;
  private FieldConverter fieldConverter;
  private final Method fieldGetMethod;
  private final Method fieldSetMethod;
  private Constructor<?> foreignConstructor;
  private Dao<?, ?> foreignDao;
  private FieldType foreignFieldType;
  private FieldType foreignIdField;
  private final String generatedIdSequence;
  private final boolean isGeneratedId;
  private final boolean isId;
  private MappedQueryForId<Object, Object> mappedQueryForId;
  private final String tableName;

  // ERROR //
  public FieldType(ConnectionSource paramConnectionSource, String paramString, Field paramField, DatabaseFieldConfig paramDatabaseFieldConfig, Class<?> paramClass)
    throws SQLException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 89	java/lang/Object:<init>	()V
    //   4: aload_1
    //   5: astore 6
    //   7: aload_0
    //   8: aload 6
    //   10: putfield 91	com/j256/ormlite/field/FieldType:connectionSource	Lcom/j256/ormlite/support/ConnectionSource;
    //   13: aload_2
    //   14: astore 7
    //   16: aload_0
    //   17: aload 7
    //   19: putfield 93	com/j256/ormlite/field/FieldType:tableName	Ljava/lang/String;
    //   22: aload_1
    //   23: invokeinterface 99 1 0
    //   28: astore 8
    //   30: aload_3
    //   31: astore 9
    //   33: aload_0
    //   34: aload 9
    //   36: putfield 101	com/j256/ormlite/field/FieldType:field	Ljava/lang/reflect/Field;
    //   39: aload_3
    //   40: invokevirtual 107	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   43: astore 10
    //   45: aload 4
    //   47: invokevirtual 113	com/j256/ormlite/field/DatabaseFieldConfig:getDataPersister	()Lcom/j256/ormlite/field/DataPersister;
    //   50: ifnonnull +350 -> 400
    //   53: aload 4
    //   55: invokevirtual 116	com/j256/ormlite/field/DatabaseFieldConfig:getPersisterClass	()Ljava/lang/Class;
    //   58: astore 11
    //   60: aload 11
    //   62: ifnull +10 -> 72
    //   65: aload 11
    //   67: ldc 118
    //   69: if_acmpne +112 -> 181
    //   72: aload_3
    //   73: invokestatic 124	com/j256/ormlite/field/DataPersisterManager:lookupForField	(Ljava/lang/reflect/Field;)Lcom/j256/ormlite/field/DataPersister;
    //   76: astore 12
    //   78: aload 4
    //   80: invokevirtual 128	com/j256/ormlite/field/DatabaseFieldConfig:getForeignColumnName	()Ljava/lang/String;
    //   83: astore 13
    //   85: aload_3
    //   86: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   89: astore 14
    //   91: aload 4
    //   93: invokevirtual 135	com/j256/ormlite/field/DatabaseFieldConfig:isForeign	()Z
    //   96: ifne +16 -> 112
    //   99: aload 4
    //   101: invokevirtual 138	com/j256/ormlite/field/DatabaseFieldConfig:isForeignAutoRefresh	()Z
    //   104: ifne +8 -> 112
    //   107: aload 13
    //   109: ifnull +517 -> 626
    //   112: aload 12
    //   114: ifnull +367 -> 481
    //   117: aload 12
    //   119: invokeinterface 143 1 0
    //   124: ifeq +357 -> 481
    //   127: new 145	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   134: ldc 148
    //   136: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: astore 15
    //   141: aload_0
    //   142: astore 16
    //   144: aload 15
    //   146: aload 16
    //   148: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: ldc 157
    //   153: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 10
    //   158: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: ldc 159
    //   163: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore 17
    //   171: new 164	java/lang/IllegalArgumentException
    //   174: dup
    //   175: aload 17
    //   177: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   180: athrow
    //   181: iconst_0
    //   182: anewarray 169	java/lang/Class
    //   185: astore 18
    //   187: aload 11
    //   189: ldc 171
    //   191: aload 18
    //   193: invokevirtual 175	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   196: astore 19
    //   198: aload 19
    //   200: astore 20
    //   202: aconst_null
    //   203: astore 21
    //   205: iconst_0
    //   206: istore 22
    //   208: iload 22
    //   210: anewarray 4	java/lang/Object
    //   213: astore 23
    //   215: aload 20
    //   217: aload 21
    //   219: aload 23
    //   221: invokevirtual 181	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   224: astore 24
    //   226: aload 24
    //   228: astore 25
    //   230: aload 25
    //   232: ifnonnull +130 -> 362
    //   235: new 145	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   242: ldc 183
    //   244: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 11
    //   249: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: astore 26
    //   257: new 82	java/sql/SQLException
    //   260: dup
    //   261: aload 26
    //   263: invokespecial 184	java/sql/SQLException:<init>	(Ljava/lang/String;)V
    //   266: athrow
    //   267: astore 27
    //   269: new 145	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   276: ldc 186
    //   278: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload 11
    //   283: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: aload 27
    //   291: invokestatic 192	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   294: athrow
    //   295: astore 28
    //   297: new 145	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   304: ldc 194
    //   306: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 11
    //   311: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: astore 29
    //   319: aload 28
    //   321: invokevirtual 198	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   324: astore 30
    //   326: aload 29
    //   328: aload 30
    //   330: invokestatic 192	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   333: athrow
    //   334: astore 31
    //   336: new 145	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   343: ldc 194
    //   345: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 11
    //   350: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: aload 31
    //   358: invokestatic 192	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   361: athrow
    //   362: aload 25
    //   364: checkcast 140	com/j256/ormlite/field/DataPersister
    //   367: astore 12
    //   369: goto -291 -> 78
    //   372: astore 32
    //   374: new 145	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   381: ldc 200
    //   383: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 11
    //   388: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: aload 32
    //   396: invokestatic 192	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   399: athrow
    //   400: aload 4
    //   402: invokevirtual 113	com/j256/ormlite/field/DatabaseFieldConfig:getDataPersister	()Lcom/j256/ormlite/field/DataPersister;
    //   405: astore 12
    //   407: aload_3
    //   408: astore 33
    //   410: aload 12
    //   412: aload 33
    //   414: invokeinterface 204 2 0
    //   419: ifne -341 -> 78
    //   422: new 145	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   429: ldc 206
    //   431: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 10
    //   436: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: ldc 208
    //   441: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: astore 34
    //   446: aload_0
    //   447: astore 35
    //   449: aload 34
    //   451: aload 35
    //   453: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   456: ldc 210
    //   458: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 12
    //   463: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: astore 36
    //   471: new 164	java/lang/IllegalArgumentException
    //   474: dup
    //   475: aload 36
    //   477: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   480: athrow
    //   481: aload 13
    //   483: ifnonnull +113 -> 596
    //   486: new 145	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   493: aload 14
    //   495: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: ldc 36
    //   500: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: astore 14
    //   508: ldc 212
    //   510: aload 10
    //   512: invokevirtual 216	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   515: ifeq +532 -> 1047
    //   518: new 145	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   525: ldc 218
    //   527: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: astore 37
    //   532: aload_3
    //   533: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   536: astore 38
    //   538: aload 37
    //   540: aload 38
    //   542: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: ldc 220
    //   547: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 10
    //   552: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   555: ldc 222
    //   557: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: astore 39
    //   562: ldc 224
    //   564: invokevirtual 227	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   567: astore 40
    //   569: aload 39
    //   571: aload 40
    //   573: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc 229
    //   578: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: astore 41
    //   586: new 82	java/sql/SQLException
    //   589: dup
    //   590: aload 41
    //   592: invokespecial 184	java/sql/SQLException:<init>	(Ljava/lang/String;)V
    //   595: athrow
    //   596: new 145	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   603: aload 14
    //   605: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: ldc 231
    //   610: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 13
    //   615: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: astore 14
    //   623: goto -115 -> 508
    //   626: aload 4
    //   628: invokevirtual 234	com/j256/ormlite/field/DatabaseFieldConfig:isForeignCollection	()Z
    //   631: ifeq +211 -> 842
    //   634: aload 10
    //   636: ldc 236
    //   638: if_acmpeq +81 -> 719
    //   641: ldc 212
    //   643: aload 10
    //   645: invokevirtual 216	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   648: ifne +71 -> 719
    //   651: new 145	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   658: ldc 238
    //   660: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: astore 42
    //   665: aload_3
    //   666: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   669: astore 43
    //   671: aload 42
    //   673: aload 43
    //   675: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: ldc 240
    //   680: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: astore 44
    //   685: ldc 212
    //   687: invokevirtual 227	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   690: astore 45
    //   692: aload 44
    //   694: aload 45
    //   696: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: ldc 242
    //   701: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: astore 46
    //   709: new 82	java/sql/SQLException
    //   712: dup
    //   713: aload 46
    //   715: invokespecial 184	java/sql/SQLException:<init>	(Ljava/lang/String;)V
    //   718: athrow
    //   719: aload_3
    //   720: invokevirtual 246	java/lang/reflect/Field:getGenericType	()Ljava/lang/reflect/Type;
    //   723: astore 47
    //   725: aload 47
    //   727: instanceof 248
    //   730: ifne +50 -> 780
    //   733: new 145	java/lang/StringBuilder
    //   736: dup
    //   737: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   740: ldc 238
    //   742: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: astore 48
    //   747: aload_3
    //   748: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   751: astore 49
    //   753: aload 48
    //   755: aload 49
    //   757: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: ldc 250
    //   762: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: astore 50
    //   770: new 82	java/sql/SQLException
    //   773: dup
    //   774: aload 50
    //   776: invokespecial 184	java/sql/SQLException:<init>	(Ljava/lang/String;)V
    //   779: athrow
    //   780: aload 47
    //   782: checkcast 248	java/lang/reflect/ParameterizedType
    //   785: invokeinterface 254 1 0
    //   790: arraylength
    //   791: ifne +256 -> 1047
    //   794: new 145	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   801: ldc 238
    //   803: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: astore 51
    //   808: aload_3
    //   809: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   812: astore 52
    //   814: aload 51
    //   816: aload 52
    //   818: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: ldc_w 256
    //   824: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: astore 53
    //   832: new 82	java/sql/SQLException
    //   835: dup
    //   836: aload 53
    //   838: invokespecial 184	java/sql/SQLException:<init>	(Ljava/lang/String;)V
    //   841: athrow
    //   842: aload 12
    //   844: ifnonnull +203 -> 1047
    //   847: aload 4
    //   849: invokevirtual 234	com/j256/ormlite/field/DatabaseFieldConfig:isForeignCollection	()Z
    //   852: ifne +195 -> 1047
    //   855: ldc_w 258
    //   858: aload 10
    //   860: invokevirtual 216	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   863: ifeq +63 -> 926
    //   866: new 145	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 260
    //   876: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 10
    //   881: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   884: ldc_w 262
    //   887: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: astore 54
    //   892: aload_3
    //   893: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   896: astore 55
    //   898: aload 54
    //   900: aload 55
    //   902: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: ldc_w 264
    //   908: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: astore 56
    //   916: new 82	java/sql/SQLException
    //   919: dup
    //   920: aload 56
    //   922: invokespecial 184	java/sql/SQLException:<init>	(Ljava/lang/String;)V
    //   925: athrow
    //   926: ldc_w 266
    //   929: aload 10
    //   931: invokevirtual 216	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   934: ifeq +63 -> 997
    //   937: new 145	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   944: ldc_w 260
    //   947: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: aload 10
    //   952: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   955: ldc_w 262
    //   958: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: astore 57
    //   963: aload_3
    //   964: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   967: astore 58
    //   969: aload 57
    //   971: aload 58
    //   973: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: ldc_w 268
    //   979: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: astore 59
    //   987: new 82	java/sql/SQLException
    //   990: dup
    //   991: aload 59
    //   993: invokespecial 184	java/sql/SQLException:<init>	(Ljava/lang/String;)V
    //   996: athrow
    //   997: new 145	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1004: ldc_w 270
    //   1007: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: aload 10
    //   1012: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1015: ldc 208
    //   1017: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: astore 60
    //   1022: aload_0
    //   1023: astore 61
    //   1025: aload 60
    //   1027: aload 61
    //   1029: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1032: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1035: astore 62
    //   1037: new 164	java/lang/IllegalArgumentException
    //   1040: dup
    //   1041: aload 62
    //   1043: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1046: athrow
    //   1047: aload 4
    //   1049: invokevirtual 273	com/j256/ormlite/field/DatabaseFieldConfig:getColumnName	()Ljava/lang/String;
    //   1052: ifnonnull +86 -> 1138
    //   1055: aload_0
    //   1056: aload 14
    //   1058: putfield 275	com/j256/ormlite/field/FieldType:columnName	Ljava/lang/String;
    //   1061: aload 4
    //   1063: astore 63
    //   1065: aload_0
    //   1066: aload 63
    //   1068: putfield 277	com/j256/ormlite/field/FieldType:fieldConfig	Lcom/j256/ormlite/field/DatabaseFieldConfig;
    //   1071: aload 4
    //   1073: invokevirtual 279	com/j256/ormlite/field/DatabaseFieldConfig:isId	()Z
    //   1076: ifeq +165 -> 1241
    //   1079: aload 4
    //   1081: invokevirtual 281	com/j256/ormlite/field/DatabaseFieldConfig:isGeneratedId	()Z
    //   1084: ifne +11 -> 1095
    //   1087: aload 4
    //   1089: invokevirtual 284	com/j256/ormlite/field/DatabaseFieldConfig:getGeneratedIdSequence	()Ljava/lang/String;
    //   1092: ifnull +62 -> 1154
    //   1095: new 145	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1102: ldc_w 286
    //   1105: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: astore 64
    //   1110: aload_3
    //   1111: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1114: astore 65
    //   1116: aload 64
    //   1118: aload 65
    //   1120: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1126: astore 66
    //   1128: new 164	java/lang/IllegalArgumentException
    //   1131: dup
    //   1132: aload 66
    //   1134: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1137: athrow
    //   1138: aload 4
    //   1140: invokevirtual 273	com/j256/ormlite/field/DatabaseFieldConfig:getColumnName	()Ljava/lang/String;
    //   1143: astore 67
    //   1145: aload_0
    //   1146: aload 67
    //   1148: putfield 275	com/j256/ormlite/field/FieldType:columnName	Ljava/lang/String;
    //   1151: goto -90 -> 1061
    //   1154: aload_0
    //   1155: iconst_1
    //   1156: putfield 288	com/j256/ormlite/field/FieldType:isId	Z
    //   1159: aload_0
    //   1160: iconst_0
    //   1161: putfield 290	com/j256/ormlite/field/FieldType:isGeneratedId	Z
    //   1164: aload_0
    //   1165: aconst_null
    //   1166: putfield 292	com/j256/ormlite/field/FieldType:generatedIdSequence	Ljava/lang/String;
    //   1169: aload_0
    //   1170: getfield 288	com/j256/ormlite/field/FieldType:isId	Z
    //   1173: ifeq +252 -> 1425
    //   1176: aload 4
    //   1178: invokevirtual 135	com/j256/ormlite/field/DatabaseFieldConfig:isForeign	()Z
    //   1181: ifne +11 -> 1192
    //   1184: aload 4
    //   1186: invokevirtual 138	com/j256/ormlite/field/DatabaseFieldConfig:isForeignAutoRefresh	()Z
    //   1189: ifeq +236 -> 1425
    //   1192: new 145	java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1199: ldc_w 294
    //   1202: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: astore 68
    //   1207: aload_3
    //   1208: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1211: astore 69
    //   1213: aload 68
    //   1215: aload 69
    //   1217: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: ldc_w 296
    //   1223: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: astore 70
    //   1231: new 164	java/lang/IllegalArgumentException
    //   1234: dup
    //   1235: aload 70
    //   1237: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1240: athrow
    //   1241: aload 4
    //   1243: invokevirtual 281	com/j256/ormlite/field/DatabaseFieldConfig:isGeneratedId	()Z
    //   1246: ifeq +110 -> 1356
    //   1249: aload 4
    //   1251: invokevirtual 284	com/j256/ormlite/field/DatabaseFieldConfig:getGeneratedIdSequence	()Ljava/lang/String;
    //   1254: ifnull +46 -> 1300
    //   1257: new 145	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1264: ldc_w 286
    //   1267: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: astore 71
    //   1272: aload_3
    //   1273: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1276: astore 72
    //   1278: aload 71
    //   1280: aload 72
    //   1282: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: astore 73
    //   1290: new 164	java/lang/IllegalArgumentException
    //   1293: dup
    //   1294: aload 73
    //   1296: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1299: athrow
    //   1300: aload_0
    //   1301: iconst_1
    //   1302: putfield 288	com/j256/ormlite/field/FieldType:isId	Z
    //   1305: aload_0
    //   1306: iconst_1
    //   1307: putfield 290	com/j256/ormlite/field/FieldType:isGeneratedId	Z
    //   1310: aload 8
    //   1312: invokeinterface 301 1 0
    //   1317: ifeq +31 -> 1348
    //   1320: aload_2
    //   1321: astore 74
    //   1323: aload_0
    //   1324: astore 75
    //   1326: aload 8
    //   1328: aload 74
    //   1330: aload 75
    //   1332: invokeinterface 305 3 0
    //   1337: astore 76
    //   1339: aload_0
    //   1340: aload 76
    //   1342: putfield 292	com/j256/ormlite/field/FieldType:generatedIdSequence	Ljava/lang/String;
    //   1345: goto -176 -> 1169
    //   1348: aload_0
    //   1349: aconst_null
    //   1350: putfield 292	com/j256/ormlite/field/FieldType:generatedIdSequence	Ljava/lang/String;
    //   1353: goto -184 -> 1169
    //   1356: aload 4
    //   1358: invokevirtual 284	com/j256/ormlite/field/DatabaseFieldConfig:getGeneratedIdSequence	()Ljava/lang/String;
    //   1361: ifnull +46 -> 1407
    //   1364: aload_0
    //   1365: iconst_1
    //   1366: putfield 288	com/j256/ormlite/field/FieldType:isId	Z
    //   1369: aload_0
    //   1370: iconst_1
    //   1371: putfield 290	com/j256/ormlite/field/FieldType:isGeneratedId	Z
    //   1374: aload 4
    //   1376: invokevirtual 284	com/j256/ormlite/field/DatabaseFieldConfig:getGeneratedIdSequence	()Ljava/lang/String;
    //   1379: astore 77
    //   1381: aload 8
    //   1383: invokeinterface 308 1 0
    //   1388: ifeq +10 -> 1398
    //   1391: aload 77
    //   1393: invokevirtual 313	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1396: astore 77
    //   1398: aload_0
    //   1399: aload 77
    //   1401: putfield 292	com/j256/ormlite/field/FieldType:generatedIdSequence	Ljava/lang/String;
    //   1404: goto -235 -> 1169
    //   1407: aload_0
    //   1408: iconst_0
    //   1409: putfield 288	com/j256/ormlite/field/FieldType:isId	Z
    //   1412: aload_0
    //   1413: iconst_0
    //   1414: putfield 290	com/j256/ormlite/field/FieldType:isGeneratedId	Z
    //   1417: aload_0
    //   1418: aconst_null
    //   1419: putfield 292	com/j256/ormlite/field/FieldType:generatedIdSequence	Ljava/lang/String;
    //   1422: goto -253 -> 1169
    //   1425: aload 4
    //   1427: invokevirtual 316	com/j256/ormlite/field/DatabaseFieldConfig:isUseGetSet	()Z
    //   1430: ifeq +93 -> 1523
    //   1433: aload_3
    //   1434: iconst_1
    //   1435: invokestatic 320	com/j256/ormlite/field/DatabaseFieldConfig:findGetMethod	(Ljava/lang/reflect/Field;Z)Ljava/lang/reflect/Method;
    //   1438: astore 78
    //   1440: aload_0
    //   1441: aload 78
    //   1443: putfield 322	com/j256/ormlite/field/FieldType:fieldGetMethod	Ljava/lang/reflect/Method;
    //   1446: aload_3
    //   1447: iconst_1
    //   1448: invokestatic 325	com/j256/ormlite/field/DatabaseFieldConfig:findSetMethod	(Ljava/lang/reflect/Field;Z)Ljava/lang/reflect/Method;
    //   1451: astore 79
    //   1453: aload_0
    //   1454: aload 79
    //   1456: putfield 327	com/j256/ormlite/field/FieldType:fieldSetMethod	Ljava/lang/reflect/Method;
    //   1459: aload 4
    //   1461: invokevirtual 330	com/j256/ormlite/field/DatabaseFieldConfig:isAllowGeneratedIdInsert	()Z
    //   1464: ifeq +138 -> 1602
    //   1467: aload 4
    //   1469: invokevirtual 281	com/j256/ormlite/field/DatabaseFieldConfig:isGeneratedId	()Z
    //   1472: ifne +130 -> 1602
    //   1475: new 145	java/lang/StringBuilder
    //   1478: dup
    //   1479: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1482: ldc 148
    //   1484: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: astore 80
    //   1489: aload_3
    //   1490: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1493: astore 81
    //   1495: aload 80
    //   1497: aload 81
    //   1499: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: ldc_w 332
    //   1505: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1511: astore 82
    //   1513: new 164	java/lang/IllegalArgumentException
    //   1516: dup
    //   1517: aload 82
    //   1519: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1522: athrow
    //   1523: aload_3
    //   1524: invokevirtual 335	java/lang/reflect/Field:isAccessible	()Z
    //   1527: ifne +11 -> 1538
    //   1530: aload_0
    //   1531: getfield 101	com/j256/ormlite/field/FieldType:field	Ljava/lang/reflect/Field;
    //   1534: iconst_1
    //   1535: invokevirtual 339	java/lang/reflect/Field:setAccessible	(Z)V
    //   1538: aload_0
    //   1539: aconst_null
    //   1540: putfield 322	com/j256/ormlite/field/FieldType:fieldGetMethod	Ljava/lang/reflect/Method;
    //   1543: aload_0
    //   1544: aconst_null
    //   1545: putfield 327	com/j256/ormlite/field/FieldType:fieldSetMethod	Ljava/lang/reflect/Method;
    //   1548: goto -89 -> 1459
    //   1551: astore 83
    //   1553: new 145	java/lang/StringBuilder
    //   1556: dup
    //   1557: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1560: ldc_w 341
    //   1563: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: astore 84
    //   1568: aload_3
    //   1569: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1572: astore 85
    //   1574: aload 84
    //   1576: aload 85
    //   1578: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1581: ldc_w 343
    //   1584: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1590: astore 86
    //   1592: new 164	java/lang/IllegalArgumentException
    //   1595: dup
    //   1596: aload 86
    //   1598: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1601: athrow
    //   1602: aload 4
    //   1604: invokevirtual 138	com/j256/ormlite/field/DatabaseFieldConfig:isForeignAutoRefresh	()Z
    //   1607: ifeq +59 -> 1666
    //   1610: aload 4
    //   1612: invokevirtual 135	com/j256/ormlite/field/DatabaseFieldConfig:isForeign	()Z
    //   1615: ifne +51 -> 1666
    //   1618: new 145	java/lang/StringBuilder
    //   1621: dup
    //   1622: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1625: ldc 148
    //   1627: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: astore 87
    //   1632: aload_3
    //   1633: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1636: astore 88
    //   1638: aload 87
    //   1640: aload 88
    //   1642: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: ldc_w 345
    //   1648: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1654: astore 89
    //   1656: new 164	java/lang/IllegalArgumentException
    //   1659: dup
    //   1660: aload 89
    //   1662: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1665: athrow
    //   1666: aload 4
    //   1668: invokevirtual 348	com/j256/ormlite/field/DatabaseFieldConfig:isForeignAutoCreate	()Z
    //   1671: ifeq +59 -> 1730
    //   1674: aload 4
    //   1676: invokevirtual 135	com/j256/ormlite/field/DatabaseFieldConfig:isForeign	()Z
    //   1679: ifne +51 -> 1730
    //   1682: new 145	java/lang/StringBuilder
    //   1685: dup
    //   1686: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1689: ldc 148
    //   1691: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: astore 90
    //   1696: aload_3
    //   1697: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1700: astore 91
    //   1702: aload 90
    //   1704: aload 91
    //   1706: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: ldc_w 350
    //   1712: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1718: astore 92
    //   1720: new 164	java/lang/IllegalArgumentException
    //   1723: dup
    //   1724: aload 92
    //   1726: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1729: athrow
    //   1730: aload 4
    //   1732: invokevirtual 128	com/j256/ormlite/field/DatabaseFieldConfig:getForeignColumnName	()Ljava/lang/String;
    //   1735: ifnull +59 -> 1794
    //   1738: aload 4
    //   1740: invokevirtual 135	com/j256/ormlite/field/DatabaseFieldConfig:isForeign	()Z
    //   1743: ifne +51 -> 1794
    //   1746: new 145	java/lang/StringBuilder
    //   1749: dup
    //   1750: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1753: ldc 148
    //   1755: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1758: astore 93
    //   1760: aload_3
    //   1761: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1764: astore 94
    //   1766: aload 93
    //   1768: aload 94
    //   1770: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1773: ldc_w 352
    //   1776: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1782: astore 95
    //   1784: new 164	java/lang/IllegalArgumentException
    //   1787: dup
    //   1788: aload 95
    //   1790: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1793: athrow
    //   1794: aload 4
    //   1796: invokevirtual 355	com/j256/ormlite/field/DatabaseFieldConfig:isVersion	()Z
    //   1799: ifeq +66 -> 1865
    //   1802: aload 12
    //   1804: ifnull +13 -> 1817
    //   1807: aload 12
    //   1809: invokeinterface 358 1 0
    //   1814: ifne +51 -> 1865
    //   1817: new 145	java/lang/StringBuilder
    //   1820: dup
    //   1821: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1824: ldc 148
    //   1826: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: astore 96
    //   1831: aload_3
    //   1832: invokevirtual 131	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   1835: astore 97
    //   1837: aload 96
    //   1839: aload 97
    //   1841: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: ldc_w 360
    //   1847: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1853: astore 98
    //   1855: new 164	java/lang/IllegalArgumentException
    //   1858: dup
    //   1859: aload 98
    //   1861: invokespecial 167	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1864: athrow
    //   1865: aload_0
    //   1866: aload 8
    //   1868: aload 12
    //   1870: invokespecial 364	com/j256/ormlite/field/FieldType:assignDataType	(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/field/DataPersister;)V
    //   1873: return
    //
    // Exception table:
    //   from	to	target	type
    //   181	198	267	java/lang/Exception
    //   208	226	295	java/lang/reflect/InvocationTargetException
    //   208	226	334	java/lang/Exception
    //   362	369	372	java/lang/Exception
    //   1530	1538	1551	java/lang/SecurityException
  }

  private void assignDataType(DatabaseType paramDatabaseType, DataPersister paramDataPersister)
    throws SQLException
  {
    this.dataPersister = paramDataPersister;
    if (paramDataPersister == null)
    {
      if (this.fieldConfig.isForeign())
        return;
      if (this.fieldConfig.isForeignCollection())
        return;
      String str1 = "Data persister for field " + this + " is null but the field is not a foreign or foreignCollection";
      throw new SQLException(str1);
    }
    FieldConverter localFieldConverter = paramDatabaseType.getFieldConverter(paramDataPersister);
    this.fieldConverter = localFieldConverter;
    if ((this.isGeneratedId) && (!paramDataPersister.isValidGeneratedType()))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("Generated-id field '");
      String str2 = this.field.getName();
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str2);
      StringBuilder localStringBuilder4 = localStringBuilder1.append("' in ");
      String str3 = this.field.getDeclaringClass().getSimpleName();
      StringBuilder localStringBuilder5 = localStringBuilder4.append(str3);
      StringBuilder localStringBuilder6 = localStringBuilder1.append(" can't be type ");
      SqlType localSqlType = this.dataPersister.getSqlType();
      StringBuilder localStringBuilder7 = localStringBuilder6.append(localSqlType);
      StringBuilder localStringBuilder8 = localStringBuilder1.append(".  Must be one of: ");
      DataType[] arrayOfDataType = DataType.values();
      int i = arrayOfDataType.length;
      int j = 0;
      while (j < i)
      {
        DataType localDataType = arrayOfDataType[j];
        DataPersister localDataPersister = localDataType.getDataPersister();
        if ((localDataPersister != null) && (localDataPersister.isValidGeneratedType()))
          StringBuilder localStringBuilder9 = localStringBuilder1.append(localDataType).append(' ');
        j += 1;
      }
      String str4 = localStringBuilder1.toString();
      throw new IllegalArgumentException(str4);
    }
    if ((this.fieldConfig.isThrowIfNull()) && (!paramDataPersister.isPrimitive()))
    {
      StringBuilder localStringBuilder10 = new StringBuilder().append("Field ");
      String str5 = this.field.getName();
      String str6 = str5 + " must be a primitive if set with throwIfNull";
      throw new SQLException(str6);
    }
    if ((this.isId) && (!paramDataPersister.isAppropriateId()))
    {
      StringBuilder localStringBuilder11 = new StringBuilder().append("Field '");
      String str7 = this.field.getName();
      String str8 = str7 + "' is of data type " + paramDataPersister + " which cannot be the ID field";
      throw new SQLException(str8);
    }
    Object localObject1 = paramDataPersister.makeConfigObject(this);
    this.dataTypeConfigObj = localObject1;
    String str9 = this.fieldConfig.getDefaultValue();
    if ((str9 == null) || (str9.equals("")))
    {
      this.defaultValue = null;
      return;
    }
    if (this.isGeneratedId)
    {
      StringBuilder localStringBuilder12 = new StringBuilder().append("Field '");
      String str10 = this.field.getName();
      String str11 = str10 + "' cannot be a generatedId and have a default value '" + str9 + "'";
      throw new SQLException(str11);
    }
    Object localObject2 = this.fieldConverter.parseDefaultString(this, str9);
    this.defaultValue = localObject2;
  }

  public static FieldType createFieldType(ConnectionSource paramConnectionSource, String paramString, Field paramField, Class<?> paramClass)
    throws SQLException
  {
    DatabaseFieldConfig localDatabaseFieldConfig = DatabaseFieldConfig.fromField(paramConnectionSource.getDatabaseType(), paramString, paramField);
    if (localDatabaseFieldConfig == null);
    ConnectionSource localConnectionSource;
    String str;
    Field localField;
    Class<?> localClass;
    for (FieldType localFieldType = null; ; localFieldType = new FieldType(localConnectionSource, str, localField, localDatabaseFieldConfig, localClass))
    {
      return localFieldType;
      localConnectionSource = paramConnectionSource;
      str = paramString;
      localField = paramField;
      localClass = paramClass;
    }
  }

  private FieldType findForeignFieldType(Class<?> paramClass1, Class<?> paramClass2, BaseDaoImpl<?, ?> paramBaseDaoImpl)
    throws SQLException
  {
    String str1 = this.fieldConfig.getForeignCollectionForeignFieldName();
    FieldType[] arrayOfFieldType = paramBaseDaoImpl.getTableInfo().getFieldTypes();
    int i = arrayOfFieldType.length;
    int j = 0;
    FieldType localFieldType;
    while (j < i)
    {
      localFieldType = arrayOfFieldType[j];
      if ((localFieldType.getType() == paramClass2) && ((str1 == null) || (localFieldType.getField().getName().equals(str1))))
      {
        if ((localFieldType.fieldConfig.isForeign()) || (localFieldType.fieldConfig.isForeignAutoRefresh()))
          break label308;
        StringBuilder localStringBuilder1 = new StringBuilder().append("Foreign collection object ").append(paramClass1).append(" for field '");
        String str2 = this.field.getName();
        String str3 = str2 + "' contains a field of class " + paramClass2 + " but it's not foreign";
        throw new SQLException(str3);
      }
      j += 1;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder3 = localStringBuilder2.append("Foreign collection class ");
    String str4 = paramClass1.getName();
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str4);
    StringBuilder localStringBuilder5 = localStringBuilder2.append(" for field '");
    String str5 = this.field.getName();
    StringBuilder localStringBuilder6 = localStringBuilder5.append(str5).append("' column-name does not contain a foreign field");
    if (str1 != null)
      StringBuilder localStringBuilder7 = localStringBuilder2.append(" named '").append(str1).append('\'');
    StringBuilder localStringBuilder8 = localStringBuilder2.append(" of class ");
    String str6 = paramClass2.getName();
    StringBuilder localStringBuilder9 = localStringBuilder8.append(str6);
    String str7 = localStringBuilder2.toString();
    throw new SQLException(str7);
    label308: return localFieldType;
  }

  private boolean isFieldValueDefault(Object paramObject)
  {
    if (paramObject == null);
    Object localObject;
    for (boolean bool = true; ; bool = paramObject.equals(localObject))
    {
      return bool;
      localObject = getJavaDefaultValueDefault();
    }
  }

  public void assignField(Object paramObject1, Object paramObject2, boolean paramBoolean, ObjectCache paramObjectCache)
    throws SQLException
  {
    LevelCounters localLevelCounters;
    Object localObject2;
    if ((this.foreignIdField != null) && (paramObject2 != null))
    {
      Object localObject1 = extractJavaFieldValue(paramObject1);
      if ((localObject1 != null) && (localObject1.equals(paramObject2)))
        return;
      if (!paramBoolean)
      {
        localLevelCounters = (LevelCounters)threadLevelCounters.get();
        if (this.mappedQueryForId != null)
        {
          int i = localLevelCounters.autoRefreshlevel;
          int j = this.fieldConfig.getMaxForeignAutoRefreshLevel();
          if (i < j)
            break label170;
        }
        Constructor localConstructor = this.foreignConstructor;
        Dao localDao = this.foreignDao;
        localObject2 = TableInfo.createObject(localConstructor, localDao);
        this.foreignIdField.assignField(localObject2, paramObject2, false, paramObjectCache);
      }
    }
    while (true)
    {
      paramObject2 = localObject2;
      if (this.fieldSetMethod == null)
        try
        {
          this.field.set(paramObject1, paramObject2);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw SqlExceptionUtil.create("Could not assign object '" + paramObject2 + "' to field " + this, localIllegalArgumentException);
          int k = localLevelCounters.autoRefreshlevel + 1;
          localLevelCounters.autoRefreshlevel = k;
          try
          {
            DatabaseConnection localDatabaseConnection1 = this.connectionSource.getReadOnlyConnection();
            localDatabaseConnection2 = localDatabaseConnection1;
          }
          finally
          {
            try
            {
              Object localObject3 = this.mappedQueryForId.execute(localDatabaseConnection2, paramObject2, paramObjectCache);
              localObject2 = localObject3;
              this.connectionSource.releaseConnection(localDatabaseConnection2);
              int m = localLevelCounters.autoRefreshlevel + -1;
              localLevelCounters.autoRefreshlevel = m;
            }
            finally
            {
              DatabaseConnection localDatabaseConnection2;
              this.connectionSource.releaseConnection(localDatabaseConnection2);
            }
            int n = localLevelCounters.autoRefreshlevel + -1;
            localLevelCounters.autoRefreshlevel = n;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          label170: throw SqlExceptionUtil.create("Could not assign object '" + paramObject2 + "' to field " + this, localIllegalAccessException);
        }
    }
    try
    {
      Method localMethod1 = this.fieldSetMethod;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramObject2;
      Object localObject6 = localMethod1.invoke(paramObject1, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Could not call ");
      Method localMethod2 = this.fieldSetMethod;
      throw SqlExceptionUtil.create(localMethod2 + " on object with '" + paramObject2 + "' for " + this, localException);
    }
  }

  public Object assignIdValue(Object paramObject, Number paramNumber, ObjectCache paramObjectCache)
    throws SQLException
  {
    Object localObject = this.dataPersister.convertIdNumber(paramNumber);
    if (localObject == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Invalid class ");
      DataPersister localDataPersister = this.dataPersister;
      String str = localDataPersister + " for sequence-id " + this;
      throw new SQLException(str);
    }
    assignField(paramObject, localObject, false, paramObjectCache);
    return localObject;
  }

  public <FT, FID> BaseForeignCollection<FT, FID> buildForeignCollection(FT paramFT, FID paramFID, boolean paramBoolean)
    throws SQLException
  {
    Object localObject1;
    if (this.foreignFieldType == null)
      localObject1 = null;
    while (true)
    {
      return localObject1;
      Dao localDao = this.foreignDao;
      if ((!this.fieldConfig.isForeignCollectionEager()) && (!paramBoolean))
      {
        String str1 = this.foreignFieldType.columnName;
        String str2 = this.fieldConfig.getForeignCollectionOrderColumnName();
        FT ? = paramFT;
        FID ? = paramFID;
        localObject1 = new LazyForeignCollection(localDao, ?, ?, str1, str2);
        continue;
      }
      LevelCounters localLevelCounters = (LevelCounters)threadLevelCounters.get();
      int i = localLevelCounters.foreignCollectionLevel;
      int j = this.fieldConfig.getForeignCollectionMaxEagerLevel();
      if (i >= j)
      {
        String str3 = this.foreignFieldType.columnName;
        String str4 = this.fieldConfig.getForeignCollectionOrderColumnName();
        FT ? = paramFT;
        FID ? = paramFID;
        localObject1 = new LazyForeignCollection(localDao, ?, ?, str3, str4);
        continue;
      }
      int k = localLevelCounters.foreignCollectionLevel + 1;
      localLevelCounters.foreignCollectionLevel = k;
      try
      {
        String str5 = this.foreignFieldType.columnName;
        String str6 = this.fieldConfig.getForeignCollectionOrderColumnName();
        FT ? = paramFT;
        FID ? = paramFID;
        localObject1 = new EagerForeignCollection(localDao, ?, ?, str5, str6);
        int m = localLevelCounters.foreignCollectionLevel + -1;
        localLevelCounters.foreignCollectionLevel = m;
      }
      finally
      {
        int n = localLevelCounters.foreignCollectionLevel + -1;
        localLevelCounters.foreignCollectionLevel = n;
      }
    }
  }

  public void configDaoInformation(ConnectionSource paramConnectionSource, Class<?> paramClass)
    throws SQLException
  {
    Class localClass1 = this.field.getType();
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    String str1 = this.fieldConfig.getForeignColumnName();
    DatabaseTableConfig localDatabaseTableConfig1;
    Object localObject;
    FieldType localFieldType1;
    label238: MappedQueryForId localMappedQueryForId;
    Constructor localConstructor;
    FieldType localFieldType2;
    if ((this.fieldConfig.isForeignAutoRefresh()) || (str1 != null))
    {
      localDatabaseTableConfig1 = this.fieldConfig.getForeignTableConfig();
      if (localDatabaseTableConfig1 == null)
        localObject = (BaseDaoImpl)DaoManager.createDao(paramConnectionSource, localClass1);
      for (TableInfo localTableInfo1 = ((BaseDaoImpl)localObject).getTableInfo(); str1 == null; localTableInfo1 = ((BaseDaoImpl)localObject).getTableInfo())
      {
        localFieldType1 = localTableInfo1.getIdField();
        if (localFieldType1 != null)
          break label238;
        String str2 = "Foreign field " + localClass1 + " does not have id field";
        throw new IllegalArgumentException(str2);
        DatabaseTableConfig localDatabaseTableConfig2 = localDatabaseTableConfig1;
        ConnectionSource localConnectionSource1 = paramConnectionSource;
        localDatabaseTableConfig2.extractFieldTypes(localConnectionSource1);
        ConnectionSource localConnectionSource2 = paramConnectionSource;
        DatabaseTableConfig localDatabaseTableConfig3 = localDatabaseTableConfig1;
        localObject = (BaseDaoImpl)DaoManager.createDao(localConnectionSource2, localDatabaseTableConfig3);
      }
      localFieldType1 = localTableInfo1.getFieldTypeByColumnName(str1);
      if (localFieldType1 == null)
      {
        String str3 = "Foreign field " + localClass1 + " does not have field named '" + str1 + "'";
        throw new IllegalArgumentException(str3);
      }
      localMappedQueryForId = MappedQueryForId.build(localDatabaseType, localTableInfo1, localFieldType1);
      localConstructor = localTableInfo1.getConstructor();
      localFieldType2 = null;
    }
    while (true)
    {
      this.mappedQueryForId = localMappedQueryForId;
      this.foreignConstructor = localConstructor;
      this.foreignFieldType = localFieldType2;
      this.foreignDao = ((Dao)localObject);
      this.foreignIdField = localFieldType1;
      if (this.foreignIdField == null)
        return;
      DataPersister localDataPersister1 = this.foreignIdField.getDataPersister();
      FieldType localFieldType3 = this;
      DataPersister localDataPersister2 = localDataPersister1;
      localFieldType3.assignDataType(localDatabaseType, localDataPersister2);
      return;
      if (this.fieldConfig.isForeign())
      {
        if ((this.dataPersister != null) && (this.dataPersister.isPrimitive()))
        {
          StringBuilder localStringBuilder1 = new StringBuilder().append("Field ");
          FieldType localFieldType4 = this;
          String str4 = localFieldType4 + " is a primitive class " + localClass1 + " but marked as foreign";
          throw new IllegalArgumentException(str4);
        }
        localDatabaseTableConfig1 = this.fieldConfig.getForeignTableConfig();
        ConnectionSource localConnectionSource4;
        DatabaseTableConfig localDatabaseTableConfig5;
        if (localDatabaseTableConfig1 != null)
        {
          DatabaseTableConfig localDatabaseTableConfig4 = localDatabaseTableConfig1;
          ConnectionSource localConnectionSource3 = paramConnectionSource;
          localDatabaseTableConfig4.extractFieldTypes(localConnectionSource3);
          localConnectionSource4 = paramConnectionSource;
          localDatabaseTableConfig5 = localDatabaseTableConfig1;
        }
        for (localObject = DaoManager.createDao(localConnectionSource4, localDatabaseTableConfig5); ; localObject = DaoManager.createDao(paramConnectionSource, localClass1))
        {
          TableInfo localTableInfo2 = ((BaseDaoImpl)localObject).getTableInfo();
          localFieldType1 = localTableInfo2.getIdField();
          localConstructor = localTableInfo2.getConstructor();
          if (localFieldType1 != null)
            break;
          String str5 = "Foreign field " + localClass1 + " does not have id field";
          throw new IllegalArgumentException(str5);
        }
        if ((isForeignAutoCreate()) && (!localFieldType1.isGeneratedId()))
        {
          StringBuilder localStringBuilder2 = new StringBuilder().append("Field ");
          String str6 = this.field.getName();
          StringBuilder localStringBuilder3 = localStringBuilder2.append(str6).append(", if foreignAutoCreate = true then class ");
          String str7 = localClass1.getSimpleName();
          String str8 = str7 + " must have id field with generatedId = true";
          throw new IllegalArgumentException(str8);
        }
        localFieldType2 = null;
        localMappedQueryForId = null;
      }
      else
      {
        if (this.fieldConfig.isForeignCollection())
        {
          Collection localCollection = Collection.class;
          if ((localClass1 != localCollection) && (!ForeignCollection.class.isAssignableFrom(localClass1)))
          {
            StringBuilder localStringBuilder4 = new StringBuilder().append("Field class for '");
            String str9 = this.field.getName();
            StringBuilder localStringBuilder5 = localStringBuilder4.append(str9).append("' must be of class ");
            String str10 = ForeignCollection.class.getSimpleName();
            String str11 = str10 + " or Collection.";
            throw new SQLException(str11);
          }
          Type localType = this.field.getGenericType();
          if (!(localType instanceof ParameterizedType))
          {
            StringBuilder localStringBuilder6 = new StringBuilder().append("Field class for '");
            String str12 = this.field.getName();
            String str13 = str12 + "' must be a parameterized Collection.";
            throw new SQLException(str13);
          }
          Type[] arrayOfType = ((ParameterizedType)localType).getActualTypeArguments();
          if (arrayOfType.length == 0)
          {
            StringBuilder localStringBuilder7 = new StringBuilder().append("Field class for '");
            String str14 = this.field.getName();
            String str15 = str14 + "' must be a parameterized Collection with at least 1 type.";
            throw new SQLException(str15);
          }
          Class localClass2 = (Class)arrayOfType[0];
          localDatabaseTableConfig1 = this.fieldConfig.getForeignTableConfig();
          if (localDatabaseTableConfig1 == null);
          ConnectionSource localConnectionSource5;
          DatabaseTableConfig localDatabaseTableConfig6;
          for (Dao localDao = DaoManager.createDao(paramConnectionSource, localClass2); ; localDao = DaoManager.createDao(localConnectionSource5, localDatabaseTableConfig6))
          {
            localObject = localDao;
            BaseDaoImpl localBaseDaoImpl = (BaseDaoImpl)localDao;
            FieldType localFieldType5 = this;
            Class<?> localClass = paramClass;
            localFieldType2 = localFieldType5.findForeignFieldType(localClass2, localClass, localBaseDaoImpl);
            localFieldType1 = null;
            localConstructor = null;
            localMappedQueryForId = null;
            break;
            localConnectionSource5 = paramConnectionSource;
            localDatabaseTableConfig6 = localDatabaseTableConfig1;
          }
        }
        localConstructor = null;
        localFieldType1 = null;
        localFieldType2 = null;
        localObject = null;
        localMappedQueryForId = null;
      }
    }
  }

  public Object convertJavaFieldToSqlArgValue(Object paramObject)
    throws SQLException
  {
    if (paramObject == null);
    for (Object localObject = null; ; localObject = this.fieldConverter.javaToSqlArg(this, paramObject))
      return localObject;
  }

  public <T> int createWithForeignDao(T paramT)
    throws SQLException
  {
    return this.foreignDao.create(paramT);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      Class localClass1 = paramObject.getClass();
      Class localClass2 = getClass();
      if (localClass1 == localClass2)
        break label25;
    }
    label25: Field localField1;
    Field localField2;
    for (boolean bool = false; ; bool = localField1.equals(localField2))
    {
      return bool;
      FieldType localFieldType = (FieldType)paramObject;
      localField1 = this.field;
      localField2 = localFieldType.field;
    }
  }

  public Object extractJavaFieldToSqlArgValue(Object paramObject)
    throws SQLException
  {
    Object localObject = extractJavaFieldValue(paramObject);
    return convertJavaFieldToSqlArgValue(localObject);
  }

  public Object extractJavaFieldValue(Object paramObject)
    throws SQLException
  {
    Object localObject = extractRawJavaFieldValue(paramObject);
    if ((this.foreignIdField != null) && (localObject != null))
      localObject = this.foreignIdField.extractRawJavaFieldValue(localObject);
    return localObject;
  }

  public <FV> FV extractRawJavaFieldValue(Object paramObject)
    throws SQLException
  {
    if (this.fieldGetMethod == null);
    while (true)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = this.field.get(paramObject);
        localObject2 = localObject1;
        return localObject2;
      }
      catch (Exception localException1)
      {
        throw SqlExceptionUtil.create("Could not get field value for " + this, localException1);
      }
      try
      {
        Method localMethod1 = this.fieldGetMethod;
        Object[] arrayOfObject = new Object[0];
        localObject1 = localMethod1.invoke(paramObject, arrayOfObject);
        localObject2 = localObject1;
      }
      catch (Exception localException2)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Could not call ");
        Method localMethod2 = this.fieldGetMethod;
        throw SqlExceptionUtil.create(localMethod2 + " for " + this, localException2);
      }
    }
  }

  public Object generateId()
  {
    return this.dataPersister.generateId();
  }

  public String getColumnDefinition()
  {
    return this.fieldConfig.getColumnDefinition();
  }

  public String getColumnName()
  {
    return this.columnName;
  }

  public DataPersister getDataPersister()
  {
    return this.dataPersister;
  }

  public Object getDataTypeConfigObj()
  {
    return this.dataTypeConfigObj;
  }

  public Object getDefaultValue()
  {
    return this.defaultValue;
  }

  public Field getField()
  {
    return this.field;
  }

  public String getFieldName()
  {
    return this.field.getName();
  }

  public <FV> FV getFieldValueIfNotDefault(Object paramObject)
    throws SQLException
  {
    Object localObject = extractJavaFieldValue(paramObject);
    if (isFieldValueDefault(localObject))
      localObject = null;
    return localObject;
  }

  public FieldType getForeignIdField()
  {
    return this.foreignIdField;
  }

  public String getFormat()
  {
    return this.fieldConfig.getFormat();
  }

  public String getGeneratedIdSequence()
  {
    return this.generatedIdSequence;
  }

  public String getIndexName()
  {
    DatabaseFieldConfig localDatabaseFieldConfig = this.fieldConfig;
    String str = this.tableName;
    return localDatabaseFieldConfig.getIndexName(str);
  }

  public Object getJavaDefaultValueDefault()
  {
    Class localClass1 = this.field.getType();
    Class localClass2 = Boolean.TYPE;
    Object localObject;
    if (localClass1 == localClass2)
      localObject = Boolean.valueOf(DEFAULT_VALUE_BOOLEAN);
    while (true)
    {
      return localObject;
      Class localClass3 = this.field.getType();
      Class localClass4 = Byte.TYPE;
      if ((localClass3 == localClass4) || (this.field.getType() == Byte.class))
      {
        localObject = Byte.valueOf(DEFAULT_VALUE_BYTE);
      }
      else
      {
        Class localClass5 = this.field.getType();
        Class localClass6 = Character.TYPE;
        if ((localClass5 == localClass6) || (this.field.getType() == Character.class))
        {
          localObject = Character.valueOf(DEFAULT_VALUE_CHAR);
        }
        else
        {
          Class localClass7 = this.field.getType();
          Class localClass8 = Short.TYPE;
          if ((localClass7 == localClass8) || (this.field.getType() == Short.class))
          {
            localObject = Short.valueOf(DEFAULT_VALUE_SHORT);
          }
          else
          {
            Class localClass9 = this.field.getType();
            Class localClass10 = Integer.TYPE;
            if ((localClass9 == localClass10) || (this.field.getType() == Integer.class))
            {
              localObject = Integer.valueOf(DEFAULT_VALUE_INT);
            }
            else
            {
              Class localClass11 = this.field.getType();
              Class localClass12 = Long.TYPE;
              if ((localClass11 == localClass12) || (this.field.getType() == Long.class))
              {
                localObject = Long.valueOf(DEFAULT_VALUE_LONG);
              }
              else
              {
                Class localClass13 = this.field.getType();
                Class localClass14 = Float.TYPE;
                if ((localClass13 == localClass14) || (this.field.getType() == Float.class))
                {
                  localObject = Float.valueOf(DEFAULT_VALUE_FLOAT);
                }
                else
                {
                  Class localClass15 = this.field.getType();
                  Class localClass16 = Double.TYPE;
                  if ((localClass15 == localClass16) || (this.field.getType() == Double.class))
                    localObject = Double.valueOf(DEFAULT_VALUE_DOUBLE);
                  else
                    localObject = null;
                }
              }
            }
          }
        }
      }
    }
  }

  public SqlType getSqlType()
  {
    return this.fieldConverter.getSqlType();
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public Class<?> getType()
  {
    return this.field.getType();
  }

  public String getUniqueIndexName()
  {
    DatabaseFieldConfig localDatabaseFieldConfig = this.fieldConfig;
    String str = this.tableName;
    return localDatabaseFieldConfig.getUniqueIndexName(str);
  }

  public Enum<?> getUnknownEnumVal()
  {
    return this.fieldConfig.getUnknownEnumValue();
  }

  public int getWidth()
  {
    return this.fieldConfig.getWidth();
  }

  public int hashCode()
  {
    return this.field.hashCode();
  }

  public boolean isAllowGeneratedIdInsert()
  {
    return this.fieldConfig.isAllowGeneratedIdInsert();
  }

  public boolean isArgumentHolderRequired()
  {
    return this.dataPersister.isArgumentHolderRequired();
  }

  public boolean isCanBeNull()
  {
    return this.fieldConfig.isCanBeNull();
  }

  public boolean isComparable()
    throws SQLException
  {
    if (this.fieldConfig.isForeignCollection());
    for (boolean bool = false; ; bool = this.dataPersister.isComparable())
    {
      return bool;
      if (this.dataPersister == null)
      {
        String str = "Internal error.  Data-persister is not configured for field.  Please post _full_ exception with associated data objects to mailing list: " + this;
        throw new SQLException(str);
      }
    }
  }

  public boolean isEscapedDefaultValue()
  {
    return this.dataPersister.isEscapedDefaultValue();
  }

  public boolean isEscapedValue()
  {
    return this.dataPersister.isEscapedValue();
  }

  public boolean isForeign()
  {
    return this.fieldConfig.isForeign();
  }

  public boolean isForeignAutoCreate()
  {
    return this.fieldConfig.isForeignAutoCreate();
  }

  public boolean isForeignCollection()
  {
    return this.fieldConfig.isForeignCollection();
  }

  public boolean isGeneratedId()
  {
    return this.isGeneratedId;
  }

  public boolean isGeneratedIdSequence()
  {
    if (this.generatedIdSequence != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isId()
  {
    return this.isId;
  }

  public boolean isObjectsFieldValueDefault(Object paramObject)
    throws SQLException
  {
    Object localObject = extractJavaFieldValue(paramObject);
    return isFieldValueDefault(localObject);
  }

  public boolean isSelfGeneratedId()
  {
    return this.dataPersister.isSelfGeneratedId();
  }

  public boolean isUnique()
  {
    return this.fieldConfig.isUnique();
  }

  public boolean isUniqueCombo()
  {
    return this.fieldConfig.isUniqueCombo();
  }

  public boolean isVersion()
  {
    return this.fieldConfig.isVersion();
  }

  public Object moveToNextValue(Object paramObject)
  {
    if (this.dataPersister == null);
    for (Object localObject = null; ; localObject = this.dataPersister.moveToNextValue(paramObject))
      return localObject;
  }

  public <T> T resultToJava(DatabaseResults paramDatabaseResults, Map<String, Integer> paramMap)
    throws SQLException
  {
    String str1 = this.columnName;
    Integer localInteger = (Integer)paramMap.get(str1);
    if (localInteger == null)
    {
      String str2 = this.columnName;
      localInteger = Integer.valueOf(paramDatabaseResults.findColumn(str2));
      String str3 = this.columnName;
      Object localObject1 = paramMap.put(str3, localInteger);
    }
    FieldConverter localFieldConverter = this.fieldConverter;
    int i = localInteger.intValue();
    Object localObject2 = localFieldConverter.resultToJava(this, paramDatabaseResults, i);
    if (this.fieldConfig.isForeign())
    {
      int j = localInteger.intValue();
      if (paramDatabaseResults.wasNull(j))
        localObject2 = null;
    }
    while (true)
    {
      return localObject2;
      if (this.dataPersister.isPrimitive())
      {
        if (this.fieldConfig.isThrowIfNull())
        {
          int k = localInteger.intValue();
          if (paramDatabaseResults.wasNull(k))
          {
            StringBuilder localStringBuilder = new StringBuilder().append("Results value for primitive field '");
            String str4 = this.field.getName();
            String str5 = str4 + "' was an invalid null value";
            throw new SQLException(str5);
          }
        }
      }
      else if (!this.fieldConverter.isStreamType())
      {
        int m = localInteger.intValue();
        if (paramDatabaseResults.wasNull(m))
          localObject2 = null;
      }
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = getClass().getSimpleName();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(":name=");
    String str2 = this.field.getName();
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(",class=");
    String str3 = this.field.getDeclaringClass().getSimpleName();
    return str3;
  }

  private static class LevelCounters
  {
    int autoRefreshlevel;
    int foreignCollectionLevel;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.FieldType
 * JD-Core Version:    0.6.2
 */