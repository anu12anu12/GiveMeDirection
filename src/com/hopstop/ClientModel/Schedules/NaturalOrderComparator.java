package com.hopstop.ClientModel.Schedules;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NaturalOrderComparator
  implements Comparator<Group>
{
  static char charAt(String paramString, int paramInt)
  {
    int i = paramString.length();
    if (paramInt >= i);
    for (char c = '\000'; ; c = paramString.charAt(paramInt))
      return c;
  }

  public static void main(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[29];
    arrayOfString[0] = "1-2";
    arrayOfString[1] = "1-02";
    arrayOfString[2] = "1-20";
    arrayOfString[3] = "10-20";
    arrayOfString[4] = "fred";
    arrayOfString[5] = "jane";
    arrayOfString[6] = "pic01";
    arrayOfString[7] = "pic2";
    arrayOfString[8] = "pic02";
    arrayOfString[9] = "pic02a";
    arrayOfString[10] = "pic3";
    arrayOfString[11] = "pic4";
    arrayOfString[12] = "pic 4 else";
    arrayOfString[13] = "pic 5";
    arrayOfString[14] = "pic05";
    arrayOfString[15] = "pic 5";
    arrayOfString[16] = "pic 5 something";
    arrayOfString[17] = "pic 6";
    arrayOfString[18] = "pic   7";
    arrayOfString[19] = "pic100";
    arrayOfString[20] = "pic100a";
    arrayOfString[21] = "pic120";
    arrayOfString[22] = "pic121";
    arrayOfString[23] = "pic02000";
    arrayOfString[24] = "tom";
    arrayOfString[25] = "x2-g8";
    arrayOfString[26] = "x2-y7";
    arrayOfString[27] = "x2-y08";
    arrayOfString[28] = "x8-y8";
    List localList1 = Arrays.asList(arrayOfString);
    PrintStream localPrintStream1 = System.out;
    String str1 = "Original: " + localList1;
    localPrintStream1.println(str1);
    List localList2 = Arrays.asList(arrayOfString);
    Collections.shuffle(localList2);
    PrintStream localPrintStream2 = System.out;
    String str2 = "Scrambled: " + localList2;
    localPrintStream2.println(str2);
    NaturalOrderComparator localNaturalOrderComparator = new NaturalOrderComparator();
    Collections.sort(localList2, localNaturalOrderComparator);
    PrintStream localPrintStream3 = System.out;
    String str3 = "Sorted: " + localList2;
    localPrintStream3.println(str3);
  }

  public int compare(Group paramGroup1, Group paramGroup2)
  {
    String str1 = paramGroup1.getCategory();
    String str2 = paramGroup2.getCategory();
    String str3;
    String str4;
    int i;
    int j;
    if (str1.equals(str2))
    {
      str3 = paramGroup1.getName().toLowerCase();
      str4 = paramGroup2.getName().toLowerCase();
      i = 0;
      j = 0;
    }
    while (true)
    {
      int k = 0;
      int m = k;
      char c1 = charAt(str3, i);
      char c2 = charAt(str4, j);
      int n;
      if ((!Character.isSpaceChar(c1)) && (c1 != '0'))
      {
        if ((Character.isSpaceChar(c2)) || (c2 == '0'))
          break label218;
        if ((!Character.isDigit(c1)) || (!Character.isDigit(c2)))
          break label255;
        String str5 = str3.substring(i);
        String str6 = str4.substring(j);
        n = compareRight(str5, str6);
        if (n == 0)
          break label255;
      }
      while (true)
      {
        return n;
        String str7 = paramGroup1.getCategory().toLowerCase();
        String str8 = paramGroup2.getCategory().toLowerCase();
        n = str7.compareTo(str8);
        continue;
        if (c1 == '0')
          m += 1;
        while (true)
        {
          i += 1;
          c1 = charAt(str3, i);
          break;
          m = 0;
        }
        label218: if (c2 == '0')
          k += 1;
        while (true)
        {
          j += 1;
          c2 = charAt(str4, j);
          break;
          k = 0;
        }
        label255: if ((c1 == null) && (c2 == null))
        {
          n = m - k;
        }
        else if (c1 < c2)
        {
          n = -1;
        }
        else
        {
          if (c1 <= c2)
            break label302;
          n = 1;
        }
      }
      label302: i += 1;
      j += 1;
    }
  }

  // ERROR //
  int compareRight(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore 5
    //   8: aload_1
    //   9: iload 4
    //   11: invokestatic 147	com/hopstop/ClientModel/Schedules/NaturalOrderComparator:charAt	(Ljava/lang/String;I)C
    //   14: istore 6
    //   16: aload_2
    //   17: iload 5
    //   19: invokestatic 147	com/hopstop/ClientModel/Schedules/NaturalOrderComparator:charAt	(Ljava/lang/String;I)C
    //   22: istore 7
    //   24: iload 6
    //   26: invokestatic 156	java/lang/Character:isDigit	(C)Z
    //   29: ifne +13 -> 42
    //   32: iload 7
    //   34: invokestatic 156	java/lang/Character:isDigit	(C)Z
    //   37: ifne +5 -> 42
    //   40: iload_3
    //   41: ireturn
    //   42: iload 6
    //   44: invokestatic 156	java/lang/Character:isDigit	(C)Z
    //   47: ifne +9 -> 56
    //   50: bipush 255
    //   52: istore_3
    //   53: goto -13 -> 40
    //   56: iload 7
    //   58: invokestatic 156	java/lang/Character:isDigit	(C)Z
    //   61: ifne +8 -> 69
    //   64: iconst_1
    //   65: istore_3
    //   66: goto -26 -> 40
    //   69: iload 6
    //   71: iload 7
    //   73: if_icmpge +22 -> 95
    //   76: iconst_0
    //   77: ifne +3 -> 80
    //   80: iload 4
    //   82: iconst_1
    //   83: iadd
    //   84: istore 4
    //   86: iload 5
    //   88: iconst_1
    //   89: iadd
    //   90: istore 5
    //   92: goto -84 -> 8
    //   95: iload 6
    //   97: iload 7
    //   99: if_icmple +10 -> 109
    //   102: iconst_0
    //   103: ifne -23 -> 80
    //   106: goto -26 -> 80
    //   109: iload 6
    //   111: ifnonnull -31 -> 80
    //   114: iload 7
    //   116: ifnonnull -36 -> 80
    //   119: goto -79 -> 40
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.NaturalOrderComparator
 * JD-Core Version:    0.6.2
 */