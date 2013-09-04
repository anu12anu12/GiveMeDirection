package com.j256.ormlite.misc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class JavaxPersistence
{
  // ERROR //
  public static com.j256.ormlite.field.DatabaseFieldConfig createFieldConfig(com.j256.ormlite.db.DatabaseType paramDatabaseType, java.lang.reflect.Field paramField)
    throws java.sql.SQLException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 6
    //   13: aconst_null
    //   14: astore 7
    //   16: aconst_null
    //   17: astore 8
    //   19: aconst_null
    //   20: astore 9
    //   22: aload_1
    //   23: invokevirtual 21	java/lang/reflect/Field:getAnnotations	()[Ljava/lang/annotation/Annotation;
    //   26: astore 10
    //   28: aload 10
    //   30: arraylength
    //   31: istore 11
    //   33: iconst_0
    //   34: istore 12
    //   36: iload 12
    //   38: iload 11
    //   40: if_icmpge +162 -> 202
    //   43: aload 10
    //   45: iload 12
    //   47: aaload
    //   48: astore 13
    //   50: aload 13
    //   52: invokeinterface 27 1 0
    //   57: astore 14
    //   59: aload 14
    //   61: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   64: ldc 35
    //   66: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +6 -> 75
    //   72: aload 13
    //   74: astore_2
    //   75: aload 14
    //   77: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   80: ldc 43
    //   82: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +6 -> 91
    //   88: aload 13
    //   90: astore_3
    //   91: aload 14
    //   93: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   96: ldc 45
    //   98: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifeq +7 -> 108
    //   104: aload 13
    //   106: astore 4
    //   108: aload 14
    //   110: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   113: ldc 47
    //   115: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifeq +7 -> 125
    //   121: aload 13
    //   123: astore 5
    //   125: aload 14
    //   127: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   130: ldc 49
    //   132: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +7 -> 142
    //   138: aload 13
    //   140: astore 6
    //   142: aload 14
    //   144: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   147: ldc 51
    //   149: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: ifeq +7 -> 159
    //   155: aload 13
    //   157: astore 7
    //   159: aload 14
    //   161: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   164: ldc 53
    //   166: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +7 -> 176
    //   172: aload 13
    //   174: astore 8
    //   176: aload 14
    //   178: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   181: ldc 55
    //   183: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +7 -> 193
    //   189: aload 13
    //   191: astore 9
    //   193: iload 12
    //   195: iconst_1
    //   196: iadd
    //   197: istore 12
    //   199: goto -163 -> 36
    //   202: aload_2
    //   203: ifnonnull +33 -> 236
    //   206: aload_3
    //   207: ifnonnull +29 -> 236
    //   210: aload 5
    //   212: ifnonnull +24 -> 236
    //   215: aload 6
    //   217: ifnonnull +19 -> 236
    //   220: aload 8
    //   222: ifnonnull +14 -> 236
    //   225: aload 9
    //   227: ifnonnull +9 -> 236
    //   230: aconst_null
    //   231: astore 15
    //   233: aload 15
    //   235: areturn
    //   236: new 57	com/j256/ormlite/field/DatabaseFieldConfig
    //   239: dup
    //   240: invokespecial 58	com/j256/ormlite/field/DatabaseFieldConfig:<init>	()V
    //   243: astore 15
    //   245: aload_1
    //   246: invokevirtual 59	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   249: astore 16
    //   251: aload_0
    //   252: invokeinterface 65 1 0
    //   257: ifeq +10 -> 267
    //   260: aload 16
    //   262: invokevirtual 68	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   265: astore 16
    //   267: aload 15
    //   269: aload 16
    //   271: invokevirtual 72	com/j256/ormlite/field/DatabaseFieldConfig:setFieldName	(Ljava/lang/String;)V
    //   274: aload_2
    //   275: ifnull +345 -> 620
    //   278: aload_2
    //   279: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   282: astore 17
    //   284: iconst_0
    //   285: anewarray 29	java/lang/Class
    //   288: astore 18
    //   290: aload 17
    //   292: ldc 77
    //   294: aload 18
    //   296: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   299: astore 19
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: astore 20
    //   307: aload 19
    //   309: astore 21
    //   311: aload 20
    //   313: astore 22
    //   315: aload 21
    //   317: aload_2
    //   318: aload 22
    //   320: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   323: checkcast 37	java/lang/String
    //   326: astore 23
    //   328: aload 23
    //   330: ifnull +22 -> 352
    //   333: aload 23
    //   335: invokevirtual 91	java/lang/String:length	()I
    //   338: ifle +14 -> 352
    //   341: aload 23
    //   343: astore 24
    //   345: aload 15
    //   347: aload 24
    //   349: invokevirtual 94	com/j256/ormlite/field/DatabaseFieldConfig:setColumnName	(Ljava/lang/String;)V
    //   352: aload_2
    //   353: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   356: astore 25
    //   358: iconst_0
    //   359: anewarray 29	java/lang/Class
    //   362: astore 26
    //   364: aload 25
    //   366: ldc 96
    //   368: aload 26
    //   370: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   373: astore 27
    //   375: iconst_0
    //   376: anewarray 4	java/lang/Object
    //   379: astore 28
    //   381: aload 27
    //   383: astore 29
    //   385: aload 28
    //   387: astore 30
    //   389: aload 29
    //   391: aload_2
    //   392: aload 30
    //   394: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   397: checkcast 37	java/lang/String
    //   400: astore 31
    //   402: aload 31
    //   404: ifnull +18 -> 422
    //   407: aload 31
    //   409: invokevirtual 91	java/lang/String:length	()I
    //   412: ifle +10 -> 422
    //   415: aload 15
    //   417: aload 31
    //   419: invokevirtual 99	com/j256/ormlite/field/DatabaseFieldConfig:setColumnDefinition	(Ljava/lang/String;)V
    //   422: aload_2
    //   423: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   426: astore 32
    //   428: iconst_0
    //   429: anewarray 29	java/lang/Class
    //   432: astore 33
    //   434: aload 32
    //   436: ldc 100
    //   438: aload 33
    //   440: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   443: astore 34
    //   445: iconst_0
    //   446: anewarray 4	java/lang/Object
    //   449: astore 35
    //   451: aload 34
    //   453: astore 36
    //   455: aload 35
    //   457: astore 37
    //   459: aload 36
    //   461: aload_2
    //   462: aload 37
    //   464: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   467: checkcast 102	java/lang/Integer
    //   470: invokevirtual 105	java/lang/Integer:intValue	()I
    //   473: istore 38
    //   475: aload 15
    //   477: iload 38
    //   479: invokevirtual 109	com/j256/ormlite/field/DatabaseFieldConfig:setWidth	(I)V
    //   482: aload_2
    //   483: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   486: astore 39
    //   488: iconst_0
    //   489: anewarray 29	java/lang/Class
    //   492: astore 40
    //   494: aload 39
    //   496: ldc 111
    //   498: aload 40
    //   500: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   503: astore 41
    //   505: iconst_0
    //   506: anewarray 4	java/lang/Object
    //   509: astore 42
    //   511: aload 41
    //   513: astore 43
    //   515: aload 42
    //   517: astore 44
    //   519: aload 43
    //   521: aload_2
    //   522: aload 44
    //   524: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   527: checkcast 113	java/lang/Boolean
    //   530: astore 45
    //   532: aload 45
    //   534: ifnull +17 -> 551
    //   537: aload 45
    //   539: invokevirtual 116	java/lang/Boolean:booleanValue	()Z
    //   542: istore 46
    //   544: aload 15
    //   546: iload 46
    //   548: invokevirtual 120	com/j256/ormlite/field/DatabaseFieldConfig:setCanBeNull	(Z)V
    //   551: aload_2
    //   552: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   555: astore 47
    //   557: iconst_0
    //   558: anewarray 29	java/lang/Class
    //   561: astore 48
    //   563: aload 47
    //   565: ldc 122
    //   567: aload 48
    //   569: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   572: astore 49
    //   574: iconst_0
    //   575: anewarray 4	java/lang/Object
    //   578: astore 50
    //   580: aload 49
    //   582: astore 51
    //   584: aload 50
    //   586: astore 52
    //   588: aload 51
    //   590: aload_2
    //   591: aload 52
    //   593: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   596: checkcast 113	java/lang/Boolean
    //   599: astore 53
    //   601: aload 53
    //   603: ifnull +17 -> 620
    //   606: aload 53
    //   608: invokevirtual 116	java/lang/Boolean:booleanValue	()Z
    //   611: istore 54
    //   613: aload 15
    //   615: iload 54
    //   617: invokevirtual 125	com/j256/ormlite/field/DatabaseFieldConfig:setUnique	(Z)V
    //   620: aload_3
    //   621: ifnull +18 -> 639
    //   624: aload 4
    //   626: ifnonnull +460 -> 1086
    //   629: iconst_1
    //   630: istore 55
    //   632: aload 15
    //   634: iload 55
    //   636: invokevirtual 128	com/j256/ormlite/field/DatabaseFieldConfig:setId	(Z)V
    //   639: aload 5
    //   641: ifnonnull +8 -> 649
    //   644: aload 6
    //   646: ifnull +236 -> 882
    //   649: iconst_1
    //   650: istore 56
    //   652: aload 15
    //   654: iload 56
    //   656: invokevirtual 131	com/j256/ormlite/field/DatabaseFieldConfig:setForeign	(Z)V
    //   659: aload 7
    //   661: ifnull +221 -> 882
    //   664: aload 7
    //   666: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   669: astore 57
    //   671: iconst_0
    //   672: anewarray 29	java/lang/Class
    //   675: astore 58
    //   677: aload 57
    //   679: ldc 77
    //   681: aload 58
    //   683: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   686: astore 59
    //   688: iconst_0
    //   689: anewarray 4	java/lang/Object
    //   692: astore 60
    //   694: aload 59
    //   696: astore 61
    //   698: aload 60
    //   700: astore 62
    //   702: aload 61
    //   704: aload 7
    //   706: aload 62
    //   708: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   711: checkcast 37	java/lang/String
    //   714: astore 23
    //   716: aload 23
    //   718: ifnull +22 -> 740
    //   721: aload 23
    //   723: invokevirtual 91	java/lang/String:length	()I
    //   726: ifle +14 -> 740
    //   729: aload 23
    //   731: astore 63
    //   733: aload 15
    //   735: aload 63
    //   737: invokevirtual 94	com/j256/ormlite/field/DatabaseFieldConfig:setColumnName	(Ljava/lang/String;)V
    //   740: aload 7
    //   742: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   745: astore 64
    //   747: iconst_0
    //   748: anewarray 29	java/lang/Class
    //   751: astore 65
    //   753: aload 64
    //   755: ldc 111
    //   757: aload 65
    //   759: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   762: astore 66
    //   764: iconst_0
    //   765: anewarray 4	java/lang/Object
    //   768: astore 67
    //   770: aload 66
    //   772: astore 68
    //   774: aload 67
    //   776: astore 69
    //   778: aload 68
    //   780: aload 7
    //   782: aload 69
    //   784: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   787: checkcast 113	java/lang/Boolean
    //   790: astore 45
    //   792: aload 45
    //   794: ifnull +17 -> 811
    //   797: aload 45
    //   799: invokevirtual 116	java/lang/Boolean:booleanValue	()Z
    //   802: istore 70
    //   804: aload 15
    //   806: iload 70
    //   808: invokevirtual 120	com/j256/ormlite/field/DatabaseFieldConfig:setCanBeNull	(Z)V
    //   811: aload 7
    //   813: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   816: astore 71
    //   818: iconst_0
    //   819: anewarray 29	java/lang/Class
    //   822: astore 72
    //   824: aload 71
    //   826: ldc 122
    //   828: aload 72
    //   830: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   833: astore 73
    //   835: iconst_0
    //   836: anewarray 4	java/lang/Object
    //   839: astore 74
    //   841: aload 73
    //   843: astore 75
    //   845: aload 74
    //   847: astore 76
    //   849: aload 75
    //   851: aload 7
    //   853: aload 76
    //   855: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   858: checkcast 113	java/lang/Boolean
    //   861: astore 53
    //   863: aload 53
    //   865: ifnull +17 -> 882
    //   868: aload 53
    //   870: invokevirtual 116	java/lang/Boolean:booleanValue	()Z
    //   873: istore 77
    //   875: aload 15
    //   877: iload 77
    //   879: invokevirtual 125	com/j256/ormlite/field/DatabaseFieldConfig:setUnique	(Z)V
    //   882: aload 8
    //   884: ifnull +82 -> 966
    //   887: aload 8
    //   889: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   892: astore 78
    //   894: iconst_0
    //   895: anewarray 29	java/lang/Class
    //   898: astore 79
    //   900: aload 78
    //   902: ldc 133
    //   904: aload 79
    //   906: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   909: astore 80
    //   911: iconst_0
    //   912: anewarray 4	java/lang/Object
    //   915: astore 81
    //   917: aload 80
    //   919: astore 82
    //   921: aload 81
    //   923: astore 83
    //   925: aload 82
    //   927: aload 8
    //   929: aload 83
    //   931: invokevirtual 87	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   934: astore 84
    //   936: aload 84
    //   938: ifnull +196 -> 1134
    //   941: aload 84
    //   943: invokevirtual 136	java/lang/Object:toString	()Ljava/lang/String;
    //   946: ldc 138
    //   948: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   951: ifeq +183 -> 1134
    //   954: getstatic 144	com/j256/ormlite/field/DataType:ENUM_STRING	Lcom/j256/ormlite/field/DataType;
    //   957: astore 85
    //   959: aload 15
    //   961: aload 85
    //   963: invokevirtual 148	com/j256/ormlite/field/DatabaseFieldConfig:setDataType	(Lcom/j256/ormlite/field/DataType;)V
    //   966: aload 9
    //   968: ifnull +13 -> 981
    //   971: iconst_1
    //   972: istore 86
    //   974: aload 15
    //   976: iload 86
    //   978: invokevirtual 151	com/j256/ormlite/field/DatabaseFieldConfig:setVersion	(Z)V
    //   981: aload 15
    //   983: invokevirtual 155	com/j256/ormlite/field/DatabaseFieldConfig:getDataPersister	()Lcom/j256/ormlite/field/DataPersister;
    //   986: ifnonnull +16 -> 1002
    //   989: aload_1
    //   990: invokestatic 161	com/j256/ormlite/field/DataPersisterManager:lookupForField	(Ljava/lang/reflect/Field;)Lcom/j256/ormlite/field/DataPersister;
    //   993: astore 87
    //   995: aload 15
    //   997: aload 87
    //   999: invokevirtual 165	com/j256/ormlite/field/DatabaseFieldConfig:setDataPersister	(Lcom/j256/ormlite/field/DataPersister;)V
    //   1002: aload_1
    //   1003: astore 88
    //   1005: iconst_0
    //   1006: istore 89
    //   1008: aload 88
    //   1010: iload 89
    //   1012: invokestatic 169	com/j256/ormlite/field/DatabaseFieldConfig:findGetMethod	(Ljava/lang/reflect/Field;Z)Ljava/lang/reflect/Method;
    //   1015: ifnull +169 -> 1184
    //   1018: aload_1
    //   1019: astore 90
    //   1021: iconst_0
    //   1022: istore 91
    //   1024: aload 90
    //   1026: iload 91
    //   1028: invokestatic 172	com/j256/ormlite/field/DatabaseFieldConfig:findSetMethod	(Ljava/lang/reflect/Field;Z)Ljava/lang/reflect/Method;
    //   1031: ifnull +153 -> 1184
    //   1034: iconst_1
    //   1035: istore 92
    //   1037: iload 92
    //   1039: istore 93
    //   1041: aload 15
    //   1043: iload 93
    //   1045: invokevirtual 175	com/j256/ormlite/field/DatabaseFieldConfig:setUseGetSet	(Z)V
    //   1048: goto -815 -> 233
    //   1051: astore 94
    //   1053: new 177	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1060: ldc 180
    //   1062: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: astore 95
    //   1067: aload_1
    //   1068: astore 96
    //   1070: aload 95
    //   1072: aload 96
    //   1074: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: aload 94
    //   1082: invokestatic 194	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   1085: athrow
    //   1086: iconst_1
    //   1087: istore 97
    //   1089: aload 15
    //   1091: iload 97
    //   1093: invokevirtual 197	com/j256/ormlite/field/DatabaseFieldConfig:setGeneratedId	(Z)V
    //   1096: goto -457 -> 639
    //   1099: astore 98
    //   1101: new 177	java/lang/StringBuilder
    //   1104: dup
    //   1105: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1108: ldc 199
    //   1110: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: astore 99
    //   1115: aload_1
    //   1116: astore 100
    //   1118: aload 99
    //   1120: aload 100
    //   1122: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1125: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1128: aload 98
    //   1130: invokestatic 194	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   1133: athrow
    //   1134: getstatic 202	com/j256/ormlite/field/DataType:ENUM_INTEGER	Lcom/j256/ormlite/field/DataType;
    //   1137: astore 101
    //   1139: aload 15
    //   1141: aload 101
    //   1143: invokevirtual 148	com/j256/ormlite/field/DatabaseFieldConfig:setDataType	(Lcom/j256/ormlite/field/DataType;)V
    //   1146: goto -180 -> 966
    //   1149: astore 102
    //   1151: new 177	java/lang/StringBuilder
    //   1154: dup
    //   1155: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1158: ldc 204
    //   1160: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: astore 103
    //   1165: aload_1
    //   1166: astore 104
    //   1168: aload 103
    //   1170: aload 104
    //   1172: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: aload 102
    //   1180: invokestatic 194	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   1183: athrow
    //   1184: iconst_0
    //   1185: istore 92
    //   1187: goto -150 -> 1037
    //
    // Exception table:
    //   from	to	target	type
    //   278	620	1051	java/lang/Exception
    //   664	882	1099	java/lang/Exception
    //   887	966	1149	java/lang/Exception
    //   1134	1146	1149	java/lang/Exception
  }

  public static String getEntityName(Class<?> paramClass)
  {
    Object localObject = null;
    Annotation[] arrayOfAnnotation = paramClass.getAnnotations();
    int i = arrayOfAnnotation.length;
    int j = 0;
    while (j < i)
    {
      Annotation localAnnotation = arrayOfAnnotation[j];
      if (localAnnotation.annotationType().getName().equals("javax.persistence.Entity"))
        localObject = localAnnotation;
      j += 1;
    }
    String str1;
    if (localObject == null)
      str1 = null;
    while (true)
    {
      return str1;
      try
      {
        Class localClass = localObject.getClass();
        Class[] arrayOfClass = new Class[0];
        Method localMethod = localClass.getMethod("name", arrayOfClass);
        Object[] arrayOfObject = new Object[0];
        str1 = (String)localMethod.invoke(localObject, arrayOfObject);
        if (str1 != null)
        {
          int k = str1.length();
          if (k > 0)
            continue;
        }
        str1 = null;
      }
      catch (Exception localException)
      {
        String str2 = "Could not get entity name from class " + paramClass;
        throw new IllegalStateException(str2, localException);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.misc.JavaxPersistence
 * JD-Core Version:    0.6.2
 */