package com.crashlytics.android;

public enum IdManager$DeviceIdentifierType
{
  public final int protobufIndex;

  static
  {
    BLUETOOTH_MAC_ADDRESS = new DeviceIdentifierType("BLUETOOTH_MAC_ADDRESS", 1, 2);
    ANDROID_ID = new DeviceIdentifierType("ANDROID_ID", 2, 100);
    ANDROID_DEVICE_ID = new DeviceIdentifierType("ANDROID_DEVICE_ID", 3, 101);
    ANDROID_SERIAL = new DeviceIdentifierType("ANDROID_SERIAL", 4, 102);
    DeviceIdentifierType[] arrayOfDeviceIdentifierType = new DeviceIdentifierType[5];
    DeviceIdentifierType localDeviceIdentifierType1 = WIFI_MAC_ADDRESS;
    arrayOfDeviceIdentifierType[0] = localDeviceIdentifierType1;
    DeviceIdentifierType localDeviceIdentifierType2 = BLUETOOTH_MAC_ADDRESS;
    arrayOfDeviceIdentifierType[1] = localDeviceIdentifierType2;
    DeviceIdentifierType localDeviceIdentifierType3 = ANDROID_ID;
    arrayOfDeviceIdentifierType[2] = localDeviceIdentifierType3;
    DeviceIdentifierType localDeviceIdentifierType4 = ANDROID_DEVICE_ID;
    arrayOfDeviceIdentifierType[3] = localDeviceIdentifierType4;
    DeviceIdentifierType localDeviceIdentifierType5 = ANDROID_SERIAL;
    arrayOfDeviceIdentifierType[4] = localDeviceIdentifierType5;
  }

  private IdManager$DeviceIdentifierType(int paramInt)
  {
    this.protobufIndex = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.IdManager.DeviceIdentifierType
 * JD-Core Version:    0.6.2
 */