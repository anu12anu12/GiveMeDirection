package com.j256.ormlite.field;

public enum SqlType
{
  static
  {
    LONG_STRING = new SqlType("LONG_STRING", 1);
    DATE = new SqlType("DATE", 2);
    BOOLEAN = new SqlType("BOOLEAN", 3);
    CHAR = new SqlType("CHAR", 4);
    BYTE = new SqlType("BYTE", 5);
    BYTE_ARRAY = new SqlType("BYTE_ARRAY", 6);
    SHORT = new SqlType("SHORT", 7);
    INTEGER = new SqlType("INTEGER", 8);
    LONG = new SqlType("LONG", 9);
    FLOAT = new SqlType("FLOAT", 10);
    DOUBLE = new SqlType("DOUBLE", 11);
    SERIALIZABLE = new SqlType("SERIALIZABLE", 12);
    BLOB = new SqlType("BLOB", 13);
    BIG_DECIMAL = new SqlType("BIG_DECIMAL", 14);
    UNKNOWN = new SqlType("UNKNOWN", 15);
    SqlType[] arrayOfSqlType = new SqlType[16];
    SqlType localSqlType1 = STRING;
    arrayOfSqlType[0] = localSqlType1;
    SqlType localSqlType2 = LONG_STRING;
    arrayOfSqlType[1] = localSqlType2;
    SqlType localSqlType3 = DATE;
    arrayOfSqlType[2] = localSqlType3;
    SqlType localSqlType4 = BOOLEAN;
    arrayOfSqlType[3] = localSqlType4;
    SqlType localSqlType5 = CHAR;
    arrayOfSqlType[4] = localSqlType5;
    SqlType localSqlType6 = BYTE;
    arrayOfSqlType[5] = localSqlType6;
    SqlType localSqlType7 = BYTE_ARRAY;
    arrayOfSqlType[6] = localSqlType7;
    SqlType localSqlType8 = SHORT;
    arrayOfSqlType[7] = localSqlType8;
    SqlType localSqlType9 = INTEGER;
    arrayOfSqlType[8] = localSqlType9;
    SqlType localSqlType10 = LONG;
    arrayOfSqlType[9] = localSqlType10;
    SqlType localSqlType11 = FLOAT;
    arrayOfSqlType[10] = localSqlType11;
    SqlType localSqlType12 = DOUBLE;
    arrayOfSqlType[11] = localSqlType12;
    SqlType localSqlType13 = SERIALIZABLE;
    arrayOfSqlType[12] = localSqlType13;
    SqlType localSqlType14 = BLOB;
    arrayOfSqlType[13] = localSqlType14;
    SqlType localSqlType15 = BIG_DECIMAL;
    arrayOfSqlType[14] = localSqlType15;
    SqlType localSqlType16 = UNKNOWN;
    arrayOfSqlType[15] = localSqlType16;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.SqlType
 * JD-Core Version:    0.6.2
 */