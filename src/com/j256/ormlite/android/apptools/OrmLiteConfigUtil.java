package com.j256.ormlite.android.apptools;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrmLiteConfigUtil
{
  protected static final String RAW_DIR_NAME = "raw";
  protected static final String RESOURCE_DIR_NAME = "res";
  private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
  protected static int maxFindSourceLevel = 20;

  private static boolean classHasAnnotations(Class<?> paramClass)
  {
    boolean bool = true;
    if (paramClass != null)
      if (paramClass.getAnnotation(DatabaseTable.class) == null);
    while (true)
    {
      while (true)
      {
        return bool;
        Object localObject1;
        try
        {
          localObject1 = paramClass.getDeclaredFields();
          Object localObject2 = localObject1;
          int i = localObject2.length;
          int j = 0;
          while (true)
          {
            if (j >= i)
              break label147;
            Object localObject3 = localObject2[j];
            if ((localObject3.getAnnotation(DatabaseField.class) != null) || (localObject3.getAnnotation(ForeignCollectionField.class) != null))
              break;
            j += 1;
          }
        }
        catch (Throwable localThrowable1)
        {
          PrintStream localPrintStream1 = System.err;
          String str1 = "Could not load get delcared fields from: " + paramClass;
          localPrintStream1.println(str1);
          PrintStream localPrintStream2 = System.err;
          String str2 = "     " + localThrowable1;
          localPrintStream2.println(str2);
          bool = false;
        }
        continue;
        try
        {
          label147: localObject1 = paramClass.getSuperclass();
          paramClass = (Class<?>)localObject1;
        }
        catch (Throwable localThrowable2)
        {
          PrintStream localPrintStream3 = System.err;
          String str3 = "Could not get super class for: " + paramClass;
          localPrintStream3.println(str3);
          PrintStream localPrintStream4 = System.err;
          String str4 = "     " + localThrowable2;
          localPrintStream4.println(str4);
          bool = false;
        }
      }
      continue;
      bool = false;
    }
  }

  private static void findAnnotatedClasses(BufferedWriter paramBufferedWriter, File paramFile, int paramInt)
    throws SQLException, IOException
  {
    File[] arrayOfFile = paramFile.listFiles();
    int i = arrayOfFile.length;
    int j = 0;
    if (j >= i)
      return;
    File localFile = arrayOfFile[j];
    if (localFile.isDirectory())
    {
      int k = maxFindSourceLevel;
      if (paramInt < k)
      {
        int m = paramInt + 1;
        findAnnotatedClasses(paramBufferedWriter, localFile, m);
      }
    }
    while (true)
    {
      j += 1;
      break;
      if (localFile.getName().endsWith(".java"))
      {
        String str1 = getPackageOfClass(localFile);
        if (str1 == null)
        {
          PrintStream localPrintStream1 = System.err;
          String str2 = "Could not find package name for: " + localFile;
          localPrintStream1.println(str2);
        }
        else
        {
          String str3 = localFile.getName();
          int n = str3.length();
          int i1 = ".java".length();
          int i2 = n - i1;
          String str4 = str3.substring(0, i2);
          String str5 = str1 + "." + str4;
          try
          {
            Class localClass1 = Class.forName(str5);
            Class localClass2 = localClass1;
            if (classHasAnnotations(localClass2))
              writeConfigForTable(paramBufferedWriter, localClass2);
          }
          catch (Throwable localThrowable)
          {
            PrintStream localPrintStream2 = System.err;
            String str6 = "Could not load class file for: " + localFile;
            localPrintStream2.println(str6);
            PrintStream localPrintStream3 = System.err;
            String str7 = "     " + localThrowable;
            localPrintStream3.println(str7);
          }
        }
      }
    }
  }

  protected static File findRawDir(File paramFile)
  {
    int i = 0;
    File localFile;
    if ((paramFile != null) && (i < 20))
    {
      localFile = findResRawDir(paramFile);
      if (localFile == null);
    }
    while (true)
    {
      return localFile;
      paramFile = paramFile.getParentFile();
      i += 1;
      break;
      localFile = null;
    }
  }

  private static File findResRawDir(File paramFile)
  {
    File[] arrayOfFile1 = paramFile.listFiles();
    int i = arrayOfFile1.length;
    int j = 0;
    File[] arrayOfFile2;
    if (j < i)
    {
      File localFile1 = arrayOfFile1[j];
      if ((localFile1.getName().equals("res")) && (localFile1.isDirectory()))
      {
        FileFilter local1 = new FileFilter()
        {
          public boolean accept(File paramAnonymousFile)
          {
            if ((paramAnonymousFile.getName().equals("raw")) && (paramAnonymousFile.isDirectory()));
            for (boolean bool = true; ; bool = false)
              return bool;
          }
        };
        arrayOfFile2 = localFile1.listFiles(local1);
        if (arrayOfFile2.length != 1);
      }
    }
    for (File localFile2 = arrayOfFile2[0]; ; localFile2 = null)
    {
      return localFile2;
      j += 1;
      break;
    }
  }

  private static String getPackageOfClass(File paramFile)
    throws IOException
  {
    FileReader localFileReader = new FileReader(paramFile);
    BufferedReader localBufferedReader = new BufferedReader(localFileReader);
    try
    {
      String str1 = localBufferedReader.readLine();
      String str2 = str1;
      String str3;
      if (str2 == null)
        str3 = null;
      while (true)
      {
        return str3;
        if (!str2.contains("package"))
          break;
        String[] arrayOfString = str2.split("[ \t;]");
        if ((arrayOfString.length <= 1) || (!arrayOfString[0].equals("package")))
          break;
        str3 = arrayOfString[1];
        localBufferedReader.close();
      }
    }
    finally
    {
      localBufferedReader.close();
    }
  }

  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    if (paramArrayOfString.length != 1)
      throw new IllegalArgumentException("Main can take a single file-name argument.");
    writeConfigFile(paramArrayOfString[0]);
  }

  public static void writeConfigFile(File paramFile)
    throws SQLException, IOException
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder().append("Writing configurations to ");
    String str1 = paramFile.getAbsolutePath();
    String str2 = str1;
    localPrintStream.println(str2);
    FileWriter localFileWriter = new FileWriter(paramFile);
    BufferedWriter localBufferedWriter = new BufferedWriter(localFileWriter, 4096);
    try
    {
      writeHeader(localBufferedWriter);
      File localFile = new File(".");
      findAnnotatedClasses(localBufferedWriter, localFile, 0);
      System.out.println("Done.");
      return;
    }
    finally
    {
      localBufferedWriter.close();
    }
  }

  public static void writeConfigFile(File paramFile, Class<?>[] paramArrayOfClass)
    throws SQLException, IOException
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder().append("Writing configurations to ");
    String str1 = paramFile.getAbsolutePath();
    String str2 = str1;
    localPrintStream.println(str2);
    writeConfigFile(new FileOutputStream(paramFile), paramArrayOfClass);
  }

  public static void writeConfigFile(OutputStream paramOutputStream, Class<?>[] paramArrayOfClass)
    throws SQLException, IOException
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream);
    BufferedWriter localBufferedWriter = new BufferedWriter(localOutputStreamWriter, 4096);
    try
    {
      writeHeader(localBufferedWriter);
      Class<?>[] arrayOfClass = paramArrayOfClass;
      int i = arrayOfClass.length;
      int j = 0;
      while (j < i)
      {
        Class<?> localClass = arrayOfClass[j];
        writeConfigForTable(localBufferedWriter, localClass);
        j += 1;
      }
      System.out.println("Done.");
      return;
    }
    finally
    {
      localBufferedWriter.close();
    }
  }

  public static void writeConfigFile(String paramString)
    throws SQLException, IOException
  {
    File localFile = findRawDir(new File("."));
    if (localFile == null)
    {
      System.err.println("Could not find raw directory");
      return;
    }
    writeConfigFile(new File(localFile, paramString));
  }

  public static void writeConfigFile(String paramString, Class<?>[] paramArrayOfClass)
    throws SQLException, IOException
  {
    File localFile = findRawDir(new File("."));
    if (localFile == null)
    {
      System.err.println("Could not find raw directory");
      return;
    }
    writeConfigFile(new File(localFile, paramString), paramArrayOfClass);
  }

  private static void writeConfigForTable(BufferedWriter paramBufferedWriter, Class<?> paramClass)
    throws SQLException, IOException
  {
    String str1 = DatabaseTableConfig.extractTableName(paramClass);
    ArrayList localArrayList = new ArrayList();
    for (Object localObject = paramClass; localObject != null; localObject = ((Class)localObject).getSuperclass())
    {
      Field[] arrayOfField = ((Class)localObject).getDeclaredFields();
      int i = arrayOfField.length;
      int j = 0;
      while (j < i)
      {
        Field localField = arrayOfField[j];
        DatabaseFieldConfig localDatabaseFieldConfig = DatabaseFieldConfig.fromField(databaseType, str1, localField);
        if (localDatabaseFieldConfig != null)
          boolean bool = localArrayList.add(localDatabaseFieldConfig);
        j += 1;
      }
    }
    if (localArrayList.isEmpty())
    {
      PrintStream localPrintStream1 = System.out;
      String str2 = "Skipping " + paramClass + " because no annotated fields found";
      localPrintStream1.println(str2);
      return;
    }
    DatabaseTableConfig localDatabaseTableConfig = new DatabaseTableConfig(paramClass, str1, localArrayList);
    DatabaseTableConfigLoader.write(paramBufferedWriter, localDatabaseTableConfig);
    Writer localWriter = paramBufferedWriter.append("#################################");
    paramBufferedWriter.newLine();
    PrintStream localPrintStream2 = System.out;
    String str3 = "Wrote config for " + paramClass;
    localPrintStream2.println(str3);
  }

  private static void writeHeader(BufferedWriter paramBufferedWriter)
    throws IOException
  {
    Writer localWriter1 = paramBufferedWriter.append('#');
    paramBufferedWriter.newLine();
    Writer localWriter2 = paramBufferedWriter.append("# generated on ");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    Date localDate = new Date();
    String str = localSimpleDateFormat.format(localDate);
    Writer localWriter3 = localWriter2.append(str);
    paramBufferedWriter.newLine();
    Writer localWriter4 = paramBufferedWriter.append('#');
    paramBufferedWriter.newLine();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.android.apptools.OrmLiteConfigUtil
 * JD-Core Version:    0.6.2
 */