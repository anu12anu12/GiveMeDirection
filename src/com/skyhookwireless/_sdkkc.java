package com.skyhookwireless;

class _sdkkc
  implements Runnable
{
  private static final String z;
  final _sdkec _sdka;
  final _sdkfd _sdkb;

  static
  {
    Object localObject1 = "y��\032Bc=\034\020Day\032\037I`=\n\035Mfq\n[\005$|\t\007Iv=".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    Object localObject3;
    int n;
    label31: int i1;
    int i2;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      int m = i;
      localObject3 = localObject1;
      n = m;
      i1 = localObject3[j];
      switch (k % 5)
      {
      default:
        i2 = 4;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      int i3 = (char)(i2 ^ i1);
      localObject3[j] = i3;
      j = k + 1;
      if (n == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = n;
        break label31;
      }
      i = n;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i2 = 29;
      continue;
      i2 = 111;
      continue;
      i2 = 115;
      continue;
      i2 = 44;
    }
  }

  _sdkkc(_sdkfd param_sdkfd)
  {
    _sdkec local_sdkec = _sdkec._sdkd();
    this._sdka = local_sdkec;
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/skyhookwireless/_sdkkc:_sdkb	Lcom/skyhookwireless/_sdkfd;
    //   4: invokestatic 51	com/skyhookwireless/_sdkfd:_sdka	(Lcom/skyhookwireless/_sdkfd;)Lcom/skyhookwireless/_sdkhb;
    //   7: invokevirtual 56	com/skyhookwireless/_sdkhb:_sdkb	()Z
    //   10: ifeq +57 -> 67
    //   13: aload_0
    //   14: getfield 35	com/skyhookwireless/_sdkkc:_sdkb	Lcom/skyhookwireless/_sdkfd;
    //   17: invokestatic 51	com/skyhookwireless/_sdkfd:_sdka	(Lcom/skyhookwireless/_sdkfd;)Lcom/skyhookwireless/_sdkhb;
    //   20: astore_1
    //   21: new 58	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   28: astore_2
    //   29: getstatic 32	com/skyhookwireless/_sdkkc:z	Ljava/lang/String;
    //   32: astore_3
    //   33: aload_2
    //   34: aload_3
    //   35: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: astore 4
    //   40: aload_0
    //   41: getfield 45	com/skyhookwireless/_sdkkc:_sdka	Lcom/skyhookwireless/_sdkec;
    //   44: invokevirtual 66	com/skyhookwireless/_sdkec:_sdka	()J
    //   47: lstore 5
    //   49: aload 4
    //   51: lload 5
    //   53: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   56: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 7
    //   61: aload_1
    //   62: aload 7
    //   64: invokevirtual 75	com/skyhookwireless/_sdkhb:_sdkb	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 35	com/skyhookwireless/_sdkkc:_sdkb	Lcom/skyhookwireless/_sdkfd;
    //   71: astore 8
    //   73: aload 8
    //   75: monitorenter
    //   76: aload_0
    //   77: getfield 35	com/skyhookwireless/_sdkkc:_sdkb	Lcom/skyhookwireless/_sdkfd;
    //   80: invokestatic 77	com/skyhookwireless/_sdkfd:_sdkb	(Lcom/skyhookwireless/_sdkfd;)V
    //   83: aload_0
    //   84: getfield 35	com/skyhookwireless/_sdkkc:_sdkb	Lcom/skyhookwireless/_sdkfd;
    //   87: aconst_null
    //   88: invokestatic 80	com/skyhookwireless/_sdkfd:_sdka	(Lcom/skyhookwireless/_sdkfd;Ljava/util/concurrent/FutureTask;)Ljava/util/concurrent/FutureTask;
    //   91: astore 9
    //   93: aload 8
    //   95: monitorexit
    //   96: return
    //   97: astore 10
    //   99: aload_0
    //   100: getfield 35	com/skyhookwireless/_sdkkc:_sdkb	Lcom/skyhookwireless/_sdkfd;
    //   103: aconst_null
    //   104: invokestatic 80	com/skyhookwireless/_sdkfd:_sdka	(Lcom/skyhookwireless/_sdkfd;Ljava/util/concurrent/FutureTask;)Ljava/util/concurrent/FutureTask;
    //   107: astore 11
    //   109: aload 10
    //   111: athrow
    //   112: astore 12
    //   114: aload 8
    //   116: monitorexit
    //   117: aload 12
    //   119: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   76	83	97	finally
    //   83	112	112	finally
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkkc
 * JD-Core Version:    0.6.2
 */