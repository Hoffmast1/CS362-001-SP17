package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
			//test defualt
			CalDay cd = new CalDay();
			assertFalse(cd.isValid());
			//test GregorianCalendar
			GregorianCalendar  gc = new GregorianCalendar(1,1,1);
			cd = new CalDay(gc);
			assertTrue(cd.isValid());
	 }
	 @Test
	 public void test02() throws Throwable
	 {
		 //test add appointment function
		 Appt appt = new Appt(2,1,1,1,1,"a","b");
		 Appt apptTwo = new Appt(1,1,1,1,1,"a","b");
		 Appt apptThree = new Appt(3,1,1,1,1,"a","b");
		 Appt apptInvalid = new Appt(-1,1,1,1,1,"a","b");
		 GregorianCalendar  gc = new GregorianCalendar(1,1,1);
		 CalDay cd = new CalDay(gc);
		 cd.addAppt(appt);
		 cd.addAppt(appt);
		 cd.addAppt(apptTwo);
		 cd.addAppt(apptThree);
		 cd.addAppt(apptInvalid);
		 assertEquals(4, cd.getSizeAppts());
	 }
	 @Test
	 public void test03() throws Throwable
	{
		GregorianCalendar  gc = new GregorianCalendar(1,1,1);
		CalDay cd = new CalDay(gc);
		//test gets dates
		assertEquals(1, cd.getDay());
		assertEquals(1, cd.getMonth());
		assertEquals(1, cd.getYear());
		cd.iterator();
	}
	@Test
	public void test04() throws Throwable{
		//test iterator null
		CalDay testNull = new CalDay();
		assertEquals(null, testNull.iterator());
		//test full iterator
		Appt appt = new Appt(2,1,1,1,1,"a","b");
		Appt apptTwo = new Appt(1,1,1,1,1,"a","b");
		Appt apptThree = new Appt(3,1,1,1,1,"a","b");
		GregorianCalendar  gc = new GregorianCalendar(1,1,1);
		CalDay cd = new CalDay(gc);
		cd.addAppt(appt);
		cd.addAppt(apptTwo);
		cd.addAppt(apptThree);
		Iterator<?> arrayAppts = cd.iterator();
		assertEquals(apptTwo, arrayAppts.next());
	}
	@Test
	public void test05() throws Throwable{
		//test to string function null
		CalDay testNull = new CalDay();
    assertEquals("", testNull.toString());
		GregorianCalendar  gc = new GregorianCalendar(1,1,1);
		CalDay cd = new CalDay(gc);
		Appt appt = new Appt(1,1,1,1,1,"a","b");
		cd.addAppt(appt);
		cd.toString();
		assertEquals(
				"\t --- 1/1/1 --- \n --- -------- Appointments ------------ --- \n\t1/1/1 at 1:1am ,a, b\n \n",
				cd.toString());
	}

  @Test
  public void test06()  throws Throwable  {
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2014, 1, 14);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      Appt appt0 = new Appt(3, 3, 3, 3, 3, "", "");
      Appt appt1 = new Appt(0, 3, 3, 3, 0, "\t --- 1/14/2014 --- \n --- -------- Appointments ------------ --- \n\t3/3/3 at 3:3am ,, \n \n", "\t --- 1/14/2014 --- \n --- -------- Appointments ------------ --- \n\t3/3/3 at 3:3am ,, \n \n");
      calDay0.addAppt(appt1);
      calDay0.addAppt(appt0);
      assertEquals(14, calDay0.getDay());
      assertEquals(2014, calDay0.getYear());
      assertEquals(1, calDay0.getMonth());
      assertTrue(calDay0.isValid());
  }

  @Test
  public void test07()  throws Throwable  {
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2014,1,14);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      Iterator<?> iterator0 = calDay0.iterator();
      assertEquals(1, calDay0.getMonth());
      assertEquals(2014, calDay0.getYear());
      assertEquals(14, calDay0.getDay());
      assertNotNull(iterator0);
  }

  @Test
  public void test08()  throws Throwable  {
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(0, 0, 0);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      boolean boolean0 = calDay0.isValid();
      assertEquals(2, calDay0.getYear());
      assertTrue(boolean0);
      assertEquals(31, calDay0.getDay());
      assertEquals(11, calDay0.getMonth());
  }


  @Test
  public void test09()  throws Throwable  {
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(0, 0, 0, 0, 0);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      int int0 = calDay0.getYear();
      assertEquals(2, int0);
      assertEquals(31, calDay0.getDay());
      assertTrue(calDay0.isValid());
      assertEquals(11, calDay0.getMonth());
  }


  @Test
  public void test10()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.year = (-2781);
      int int0 = calDay0.getYear();
      assertEquals((-2781), int0);
  }


  @Test
  public void test11()  throws Throwable  {

      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2014, 1, 14);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      LinkedList<Appt> linkedList0 = calDay0.getAppts();
      Appt appt0 = new Appt(656, 656, 656, 656, 656, " ,", " ,");
      linkedList0.add(0, appt0);
      calDay0.getSizeAppts();
      assertEquals(14, calDay0.getDay());
      assertTrue(calDay0.isValid());
      assertEquals(1, calDay0.getMonth());
      assertEquals(2014, calDay0.getYear());
  }

  @Test
  public void test12()  throws Throwable  {

      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2014,1,14);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      int int0 = calDay0.getMonth();
      assertEquals(1, int0);
      assertEquals(2014, calDay0.getYear());
      assertTrue(calDay0.isValid());
      assertEquals(14, calDay0.getDay());
  }

  @Test
  public void test13()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.month = (-1242);
      int int0 = calDay0.getMonth();
      assertEquals((-1242), int0);
  }

  @Test
  public void test14()  throws Throwable  {
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(11, 11, 11);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      int int0 = calDay0.getDay();
      assertEquals(11, int0);
      assertTrue(calDay0.isValid());
      assertEquals(11, calDay0.getMonth());
      assertEquals(11, calDay0.getYear());
  }


  @Test
  public void test15()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.day = (-2997);
      int int0 = calDay0.getDay();
      assertEquals((-2997), int0);
  }



  @Test
  public void test16()  throws Throwable  {

      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2014,1,14);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      LinkedList<Appt> linkedList0 = calDay0.getAppts();
      Appt appt0 = new Appt(656, 656, 656, 656, 656, " ,", " ,");
      linkedList0.add(0, appt0);
      calDay0.getAppts();
      assertEquals(1, calDay0.getMonth());
      assertEquals(2014, calDay0.getYear());
      assertEquals(14, calDay0.getDay());
      assertTrue(calDay0.isValid());
  }

  @Test
  public void test17()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      // Undeclared exception!
      try {
        calDay0.getSizeAppts();
        fail("Expecting exception: NullPointerException");

      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }

  @Test
  public void test18()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      // Undeclared exception!
      try {
        calDay0.addAppt((Appt) null);
        fail("Expecting exception: NullPointerException");

      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }


  @Test
  public void test19()  throws Throwable  {
      CalDay calDay0 = null;
      try {
        calDay0 = new CalDay((GregorianCalendar) null);
        fail("Expecting exception: NullPointerException");

      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }


  @Test
  public void test20()  throws Throwable  {
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(445, 23, 23);
      mockGregorianCalendar0.setLenient(false);
      CalDay calDay0 = null;
      try {
        calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
        fail("Expecting exception: IllegalArgumentException");

      } catch(IllegalArgumentException e) {
         //
         // MONTH
         //
         //assertThrownBy("java.util.GregorianCalendar", e);
      }
  }


  @Test
  public void test21()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      int int0 = calDay0.getYear();
      assertEquals(0, int0);
  }


  @Test
  public void test22()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      int int0 = calDay0.getDay();
      assertEquals(0, int0);
  }

  @Test
  public void test23()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      int int0 = calDay0.getMonth();
      assertEquals(0, int0);
  }


  @Test
  public void test24()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      boolean boolean0 = calDay0.isValid();
      assertFalse(boolean0);
  }



  @Test
  public void test25()  throws Throwable  {

      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2014,1,14);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      LinkedList<Appt> linkedList0 = calDay0.getAppts();
      Appt appt0 = new Appt(656, 656, 656, 656, 656, " ,", " ,");
      linkedList0.add(0, appt0);
      String string0 = calDay0.toString();
      assertEquals("\t --- 1/14/2014 --- \n --- -------- Appointments ------------ --- \nnull \n", string0);
  }


  @Test
  public void test26()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.valid = true;
      // Undeclared exception!
      try {
        calDay0.iterator();
        fail("Expecting exception: NullPointerException");

      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }

  @Test
  public void test27()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      Iterator<?> iterator0 = calDay0.iterator();
      assertNull(iterator0);
  }

  @Test
  public void test28()  throws Throwable  {
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2014,1,14);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      LinkedList<Appt> linkedList0 = calDay0.appts;
      Appt appt0 = new Appt(3, 3, 3, 3, 3, "", "");
      linkedList0.add(0, appt0);
      calDay0.addAppt(appt0);
      assertEquals(1, calDay0.getMonth());
      assertEquals(2014, calDay0.getYear());
      assertEquals(14, calDay0.getDay());
      assertTrue(calDay0.isValid());
  }

  @Test
  public void test29()  throws Throwable  {

      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2014,1,14);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      LinkedList<Appt> linkedList0 = calDay0.getAppts();
      Appt appt0 = new Appt(656, 656, 656, 656, 656, " ,", " ,");
      linkedList0.add(0, appt0);
      Appt appt1 = new Appt(23, 1, 1, 1, 23, "\t --- 1/14/2014 --- \n --- -------- Appointments ------------ --- \nnull \n", "\t --- 1/14/2014 --- \n --- -------- Appointments ------------ --- \nnull \n");
      calDay0.addAppt(appt1);
      assertEquals(2014, calDay0.getYear());
      assertTrue(calDay0.isValid());
      assertEquals(1, calDay0.getMonth());
      assertEquals(14, calDay0.getDay());
  }

  @Test
  public void test30()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      Appt appt0 = new Appt(3180, 0, 0, 3180, 3180, "", "");
      calDay0.addAppt(appt0);
      assertEquals("", appt0.getDescription());
  }

  @Test
  public void test31()  throws Throwable  {
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2014,1,14);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      calDay0.getSizeAppts();
      assertEquals(2014, calDay0.getYear());
      assertTrue(calDay0.isValid());
      assertEquals(14, calDay0.getDay());
      assertEquals(1, calDay0.getMonth());
  }

  @Test
  public void test32()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.valid = true;
      // Undeclared exception!
      try {
        calDay0.toString();
        fail("Expecting exception: NullPointerException");

      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }
  @Test
  public void test33()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      String string0 = calDay0.toString();
      assertEquals("", string0);
  }
}
