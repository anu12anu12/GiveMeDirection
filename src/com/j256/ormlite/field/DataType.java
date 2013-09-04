package com.j256.ormlite.field;

import com.j256.ormlite.field.types.BigDecimalNumericType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import com.j256.ormlite.field.types.BigIntegerType;
import com.j256.ormlite.field.types.BooleanObjectType;
import com.j256.ormlite.field.types.BooleanType;
import com.j256.ormlite.field.types.ByteArrayType;
import com.j256.ormlite.field.types.ByteObjectType;
import com.j256.ormlite.field.types.ByteType;
import com.j256.ormlite.field.types.CharType;
import com.j256.ormlite.field.types.CharacterObjectType;
import com.j256.ormlite.field.types.DateLongType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.field.types.DateTimeType;
import com.j256.ormlite.field.types.DateType;
import com.j256.ormlite.field.types.DoubleObjectType;
import com.j256.ormlite.field.types.DoubleType;
import com.j256.ormlite.field.types.EnumIntegerType;
import com.j256.ormlite.field.types.EnumStringType;
import com.j256.ormlite.field.types.FloatObjectType;
import com.j256.ormlite.field.types.FloatType;
import com.j256.ormlite.field.types.IntType;
import com.j256.ormlite.field.types.IntegerObjectType;
import com.j256.ormlite.field.types.LongObjectType;
import com.j256.ormlite.field.types.LongStringType;
import com.j256.ormlite.field.types.LongType;
import com.j256.ormlite.field.types.SerializableType;
import com.j256.ormlite.field.types.ShortObjectType;
import com.j256.ormlite.field.types.ShortType;
import com.j256.ormlite.field.types.StringBytesType;
import com.j256.ormlite.field.types.StringType;
import com.j256.ormlite.field.types.UuidType;

public enum DataType
{
  private final DataPersister dataPersister;

  static
  {
    StringType localStringType = StringType.getSingleton();
    STRING = new DataType("STRING", 0, localStringType);
    LongStringType localLongStringType = LongStringType.getSingleton();
    LONG_STRING = new DataType("LONG_STRING", 1, localLongStringType);
    StringBytesType localStringBytesType = StringBytesType.getSingleton();
    STRING_BYTES = new DataType("STRING_BYTES", 2, localStringBytesType);
    BooleanType localBooleanType = BooleanType.getSingleton();
    BOOLEAN = new DataType("BOOLEAN", 3, localBooleanType);
    BooleanObjectType localBooleanObjectType = BooleanObjectType.getSingleton();
    BOOLEAN_OBJ = new DataType("BOOLEAN_OBJ", 4, localBooleanObjectType);
    DateType localDateType = DateType.getSingleton();
    DATE = new DataType("DATE", 5, localDateType);
    DateLongType localDateLongType = DateLongType.getSingleton();
    DATE_LONG = new DataType("DATE_LONG", 6, localDateLongType);
    DateStringType localDateStringType = DateStringType.getSingleton();
    DATE_STRING = new DataType("DATE_STRING", 7, localDateStringType);
    CharType localCharType = CharType.getSingleton();
    CHAR = new DataType("CHAR", 8, localCharType);
    CharacterObjectType localCharacterObjectType = CharacterObjectType.getSingleton();
    CHAR_OBJ = new DataType("CHAR_OBJ", 9, localCharacterObjectType);
    ByteType localByteType = ByteType.getSingleton();
    BYTE = new DataType("BYTE", 10, localByteType);
    ByteArrayType localByteArrayType = ByteArrayType.getSingleton();
    BYTE_ARRAY = new DataType("BYTE_ARRAY", 11, localByteArrayType);
    ByteObjectType localByteObjectType = ByteObjectType.getSingleton();
    BYTE_OBJ = new DataType("BYTE_OBJ", 12, localByteObjectType);
    ShortType localShortType = ShortType.getSingleton();
    SHORT = new DataType("SHORT", 13, localShortType);
    ShortObjectType localShortObjectType = ShortObjectType.getSingleton();
    SHORT_OBJ = new DataType("SHORT_OBJ", 14, localShortObjectType);
    IntType localIntType = IntType.getSingleton();
    INTEGER = new DataType("INTEGER", 15, localIntType);
    IntegerObjectType localIntegerObjectType = IntegerObjectType.getSingleton();
    INTEGER_OBJ = new DataType("INTEGER_OBJ", 16, localIntegerObjectType);
    LongType localLongType = LongType.getSingleton();
    LONG = new DataType("LONG", 17, localLongType);
    LongObjectType localLongObjectType = LongObjectType.getSingleton();
    LONG_OBJ = new DataType("LONG_OBJ", 18, localLongObjectType);
    FloatType localFloatType = FloatType.getSingleton();
    FLOAT = new DataType("FLOAT", 19, localFloatType);
    FloatObjectType localFloatObjectType = FloatObjectType.getSingleton();
    FLOAT_OBJ = new DataType("FLOAT_OBJ", 20, localFloatObjectType);
    DoubleType localDoubleType = DoubleType.getSingleton();
    DOUBLE = new DataType("DOUBLE", 21, localDoubleType);
    DoubleObjectType localDoubleObjectType = DoubleObjectType.getSingleton();
    DOUBLE_OBJ = new DataType("DOUBLE_OBJ", 22, localDoubleObjectType);
    SerializableType localSerializableType = SerializableType.getSingleton();
    SERIALIZABLE = new DataType("SERIALIZABLE", 23, localSerializableType);
    EnumStringType localEnumStringType = EnumStringType.getSingleton();
    ENUM_STRING = new DataType("ENUM_STRING", 24, localEnumStringType);
    EnumIntegerType localEnumIntegerType = EnumIntegerType.getSingleton();
    ENUM_INTEGER = new DataType("ENUM_INTEGER", 25, localEnumIntegerType);
    UuidType localUuidType = UuidType.getSingleton();
    UUID = new DataType("UUID", 26, localUuidType);
    BigIntegerType localBigIntegerType = BigIntegerType.getSingleton();
    BIG_INTEGER = new DataType("BIG_INTEGER", 27, localBigIntegerType);
    BigDecimalStringType localBigDecimalStringType = BigDecimalStringType.getSingleton();
    BIG_DECIMAL = new DataType("BIG_DECIMAL", 28, localBigDecimalStringType);
    BigDecimalNumericType localBigDecimalNumericType = BigDecimalNumericType.getSingleton();
    BIG_DECIMAL_NUMERIC = new DataType("BIG_DECIMAL_NUMERIC", 29, localBigDecimalNumericType);
    DateTimeType localDateTimeType = DateTimeType.getSingleton();
    DATE_TIME = new DataType("DATE_TIME", 30, localDateTimeType);
    UNKNOWN = new DataType("UNKNOWN", 31, null);
    DataType[] arrayOfDataType = new DataType[32];
    DataType localDataType1 = STRING;
    arrayOfDataType[0] = localDataType1;
    DataType localDataType2 = LONG_STRING;
    arrayOfDataType[1] = localDataType2;
    DataType localDataType3 = STRING_BYTES;
    arrayOfDataType[2] = localDataType3;
    DataType localDataType4 = BOOLEAN;
    arrayOfDataType[3] = localDataType4;
    DataType localDataType5 = BOOLEAN_OBJ;
    arrayOfDataType[4] = localDataType5;
    DataType localDataType6 = DATE;
    arrayOfDataType[5] = localDataType6;
    DataType localDataType7 = DATE_LONG;
    arrayOfDataType[6] = localDataType7;
    DataType localDataType8 = DATE_STRING;
    arrayOfDataType[7] = localDataType8;
    DataType localDataType9 = CHAR;
    arrayOfDataType[8] = localDataType9;
    DataType localDataType10 = CHAR_OBJ;
    arrayOfDataType[9] = localDataType10;
    DataType localDataType11 = BYTE;
    arrayOfDataType[10] = localDataType11;
    DataType localDataType12 = BYTE_ARRAY;
    arrayOfDataType[11] = localDataType12;
    DataType localDataType13 = BYTE_OBJ;
    arrayOfDataType[12] = localDataType13;
    DataType localDataType14 = SHORT;
    arrayOfDataType[13] = localDataType14;
    DataType localDataType15 = SHORT_OBJ;
    arrayOfDataType[14] = localDataType15;
    DataType localDataType16 = INTEGER;
    arrayOfDataType[15] = localDataType16;
    DataType localDataType17 = INTEGER_OBJ;
    arrayOfDataType[16] = localDataType17;
    DataType localDataType18 = LONG;
    arrayOfDataType[17] = localDataType18;
    DataType localDataType19 = LONG_OBJ;
    arrayOfDataType[18] = localDataType19;
    DataType localDataType20 = FLOAT;
    arrayOfDataType[19] = localDataType20;
    DataType localDataType21 = FLOAT_OBJ;
    arrayOfDataType[20] = localDataType21;
    DataType localDataType22 = DOUBLE;
    arrayOfDataType[21] = localDataType22;
    DataType localDataType23 = DOUBLE_OBJ;
    arrayOfDataType[22] = localDataType23;
    DataType localDataType24 = SERIALIZABLE;
    arrayOfDataType[23] = localDataType24;
    DataType localDataType25 = ENUM_STRING;
    arrayOfDataType[24] = localDataType25;
    DataType localDataType26 = ENUM_INTEGER;
    arrayOfDataType[25] = localDataType26;
    DataType localDataType27 = UUID;
    arrayOfDataType[26] = localDataType27;
    DataType localDataType28 = BIG_INTEGER;
    arrayOfDataType[27] = localDataType28;
    DataType localDataType29 = BIG_DECIMAL;
    arrayOfDataType[28] = localDataType29;
    DataType localDataType30 = BIG_DECIMAL_NUMERIC;
    arrayOfDataType[29] = localDataType30;
    DataType localDataType31 = DATE_TIME;
    arrayOfDataType[30] = localDataType31;
    DataType localDataType32 = UNKNOWN;
    arrayOfDataType[31] = localDataType32;
  }

  private DataType(DataPersister paramDataPersister)
  {
    this.dataPersister = paramDataPersister;
  }

  public DataPersister getDataPersister()
  {
    return this.dataPersister;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.DataType
 * JD-Core Version:    0.6.2
 */