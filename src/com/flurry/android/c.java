package com.flurry.android;

import java.io.DataInput;
import java.io.DataOutput;

final class c extends ak
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private int T;
  private int U;
  private int V;
  private int W;
  private int X;
  private int Y;
  private int Z;
  byte a;
  private int aa;
  private int ab;
  private int ac;
  private int ad;
  private int ae;
  private int af;
  private boolean ag;
  String b;
  long c;
  String d;
  int e;
  int f;
  String g;
  int h;
  int i;
  String j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  private long r;
  private String s;
  private int t;
  private int u;
  private String v;
  private int w;
  private int x;
  private String y;
  private int z;

  c()
  {
  }

  c(DataInput paramDataInput)
  {
    c(paramDataInput);
  }

  private void c(DataInput paramDataInput)
  {
    byte b1 = paramDataInput.readByte();
    this.a = b1;
    String str1 = paramDataInput.readUTF();
    this.b = str1;
    long l1 = paramDataInput.readLong();
    this.c = l1;
    long l2 = paramDataInput.readLong();
    this.r = l2;
    String str2 = paramDataInput.readUTF();
    this.d = str2;
    int i1 = paramDataInput.readUnsignedShort();
    this.e = i1;
    int i2 = paramDataInput.readInt();
    this.f = i2;
    String str3 = paramDataInput.readUTF();
    this.g = str3;
    int i3 = paramDataInput.readUnsignedShort();
    this.h = i3;
    int i4 = paramDataInput.readInt();
    this.i = i4;
    String str4 = paramDataInput.readUTF();
    this.j = str4;
    int i5 = paramDataInput.readUnsignedShort();
    this.k = i5;
    int i6 = paramDataInput.readInt();
    this.l = i6;
  }

  final void a(DataInput paramDataInput)
  {
    String str1 = paramDataInput.readUTF();
    this.s = str1;
    int i1 = paramDataInput.readUnsignedShort();
    this.t = i1;
    int i2 = paramDataInput.readInt();
    this.u = i2;
    String str2 = paramDataInput.readUTF();
    this.v = str2;
    int i3 = paramDataInput.readUnsignedShort();
    this.w = i3;
    int i4 = paramDataInput.readInt();
    this.x = i4;
    String str3 = paramDataInput.readUTF();
    this.y = str3;
    int i5 = paramDataInput.readUnsignedShort();
    this.z = i5;
    int i6 = paramDataInput.readInt();
    this.A = i6;
    int i7 = paramDataInput.readInt();
    this.B = i7;
    int i8 = paramDataInput.readInt();
    this.C = i8;
    int i9 = paramDataInput.readInt();
    this.m = i9;
    int i10 = paramDataInput.readInt();
    this.n = i10;
    int i11 = paramDataInput.readInt();
    this.o = i11;
    int i12 = paramDataInput.readInt();
    this.p = i12;
    int i13 = paramDataInput.readInt();
    this.D = i13;
    int i14 = paramDataInput.readInt();
    this.E = i14;
    int i15 = paramDataInput.readInt();
    this.F = i15;
    int i16 = paramDataInput.readInt();
    this.G = i16;
    int i17 = paramDataInput.readInt();
    this.H = i17;
    int i18 = paramDataInput.readInt();
    this.I = i18;
    int i19 = paramDataInput.readInt();
    this.J = i19;
    int i20 = paramDataInput.readInt();
    this.K = i20;
    int i21 = paramDataInput.readInt();
    this.q = i21;
    int i22 = paramDataInput.readInt();
    this.L = i22;
    int i23 = paramDataInput.readInt();
    this.M = i23;
    int i24 = paramDataInput.readInt();
    this.N = i24;
    int i25 = paramDataInput.readInt();
    this.O = i25;
    int i26 = paramDataInput.readInt();
    this.P = i26;
    int i27 = paramDataInput.readInt();
    this.Q = i27;
    int i28 = paramDataInput.readInt();
    this.R = i28;
    int i29 = paramDataInput.readInt();
    this.S = i29;
    int i30 = paramDataInput.readInt();
    this.T = i30;
    int i31 = paramDataInput.readInt();
    this.U = i31;
    int i32 = paramDataInput.readInt();
    this.V = i32;
    int i33 = paramDataInput.readInt();
    this.W = i33;
    int i34 = paramDataInput.readInt();
    this.X = i34;
    int i35 = paramDataInput.readInt();
    this.Y = i35;
    int i36 = paramDataInput.readInt();
    this.Z = i36;
    int i37 = paramDataInput.readInt();
    this.aa = i37;
    int i38 = paramDataInput.readInt();
    this.ab = i38;
    int i39 = paramDataInput.readInt();
    this.ac = i39;
    int i40 = paramDataInput.readInt();
    this.ad = i40;
    int i41 = paramDataInput.readInt();
    this.ae = i41;
    int i42 = paramDataInput.readInt();
    this.af = i42;
    this.ag = true;
  }

  final void a(DataOutput paramDataOutput)
  {
    int i1 = this.a;
    paramDataOutput.writeByte(i1);
    String str1 = this.b;
    paramDataOutput.writeUTF(str1);
    long l1 = this.c;
    paramDataOutput.writeLong(l1);
    long l2 = this.r;
    paramDataOutput.writeLong(l2);
    String str2 = this.d;
    paramDataOutput.writeUTF(str2);
    int i2 = this.e;
    paramDataOutput.writeShort(i2);
    int i3 = this.f;
    paramDataOutput.writeInt(i3);
    String str3 = this.g;
    paramDataOutput.writeUTF(str3);
    int i4 = this.h;
    paramDataOutput.writeShort(i4);
    int i5 = this.i;
    paramDataOutput.writeInt(i5);
    String str4 = this.j;
    paramDataOutput.writeUTF(str4);
    int i6 = this.k;
    paramDataOutput.writeShort(i6);
    int i7 = this.l;
    paramDataOutput.writeInt(i7);
    boolean bool = this.ag;
    paramDataOutput.writeBoolean(bool);
    if (!this.ag)
      return;
    String str5 = this.s;
    paramDataOutput.writeUTF(str5);
    int i8 = this.t;
    paramDataOutput.writeShort(i8);
    int i9 = this.u;
    paramDataOutput.writeInt(i9);
    String str6 = this.v;
    paramDataOutput.writeUTF(str6);
    int i10 = this.w;
    paramDataOutput.writeShort(i10);
    int i11 = this.x;
    paramDataOutput.writeInt(i11);
    String str7 = this.y;
    paramDataOutput.writeUTF(str7);
    int i12 = this.z;
    paramDataOutput.writeShort(i12);
    int i13 = this.A;
    paramDataOutput.writeInt(i13);
    int i14 = this.B;
    paramDataOutput.writeInt(i14);
    int i15 = this.C;
    paramDataOutput.writeInt(i15);
    int i16 = this.m;
    paramDataOutput.writeInt(i16);
    int i17 = this.n;
    paramDataOutput.writeInt(i17);
    int i18 = this.o;
    paramDataOutput.writeInt(i18);
    int i19 = this.p;
    paramDataOutput.writeInt(i19);
    int i20 = this.D;
    paramDataOutput.writeInt(i20);
    int i21 = this.E;
    paramDataOutput.writeInt(i21);
    int i22 = this.F;
    paramDataOutput.writeInt(i22);
    int i23 = this.G;
    paramDataOutput.writeInt(i23);
    int i24 = this.H;
    paramDataOutput.writeInt(i24);
    int i25 = this.I;
    paramDataOutput.writeInt(i25);
    int i26 = this.J;
    paramDataOutput.writeInt(i26);
    int i27 = this.K;
    paramDataOutput.writeInt(i27);
    int i28 = this.q;
    paramDataOutput.writeInt(i28);
    int i29 = this.L;
    paramDataOutput.writeInt(i29);
    int i30 = this.M;
    paramDataOutput.writeInt(i30);
    int i31 = this.N;
    paramDataOutput.writeInt(i31);
    int i32 = this.O;
    paramDataOutput.writeInt(i32);
    int i33 = this.P;
    paramDataOutput.writeInt(i33);
    int i34 = this.Q;
    paramDataOutput.writeInt(i34);
    int i35 = this.R;
    paramDataOutput.writeInt(i35);
    int i36 = this.S;
    paramDataOutput.writeInt(i36);
    int i37 = this.T;
    paramDataOutput.writeInt(i37);
    int i38 = this.U;
    paramDataOutput.writeInt(i38);
    int i39 = this.V;
    paramDataOutput.writeInt(i39);
    int i40 = this.W;
    paramDataOutput.writeInt(i40);
    int i41 = this.X;
    paramDataOutput.writeInt(i41);
    int i42 = this.Y;
    paramDataOutput.writeInt(i42);
    int i43 = this.Z;
    paramDataOutput.writeInt(i43);
    int i44 = this.aa;
    paramDataOutput.writeInt(i44);
    int i45 = this.ab;
    paramDataOutput.writeInt(i45);
    int i46 = this.ac;
    paramDataOutput.writeInt(i46);
    int i47 = this.ad;
    paramDataOutput.writeInt(i47);
    int i48 = this.ae;
    paramDataOutput.writeInt(i48);
    int i49 = this.af;
    paramDataOutput.writeInt(i49);
  }

  final void b(DataInput paramDataInput)
  {
    c(paramDataInput);
    boolean bool = paramDataInput.readBoolean();
    this.ag = bool;
    if (!this.ag)
      return;
    a(paramDataInput);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.c
 * JD-Core Version:    0.6.2
 */