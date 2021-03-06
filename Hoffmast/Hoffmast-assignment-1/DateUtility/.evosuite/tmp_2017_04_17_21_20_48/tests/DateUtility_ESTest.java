/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 18 04:22:00 GMT 2017
 */


import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.System;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class DateUtility_ESTest extends DateUtility_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      boolean boolean0 = DateUtility.isLeapYear((-2700));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      System.setCurrentTimeMillis(0L);
      DateUtility.daysBetween2Dates();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      boolean boolean0 = DateUtility.isLeapYear((-32));
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      DateUtility.compare2Dates();
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      DateUtility.daysInMonth();
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      boolean boolean0 = DateUtility.isLeapYear(0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      boolean boolean0 = DateUtility.isLeapYear(100);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      DateUtility.main((String[]) null);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      DateUtility.addToDate();
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      DateUtility dateUtility0 = new DateUtility();
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      DateUtility.validateAGivenDate();
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      DateUtility.getDayofTheDate();
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      DateUtility.subToDate();
  }
}
