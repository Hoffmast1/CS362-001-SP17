package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import org.junit.Test;

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

}
