package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }

	 @Test
	public void test02() throws Throwable {
		int startHour=1;
		int startMinute=1;
		int startDay=1;
		int startMonth=1;
		int startYear=1;
		String title="";
		String description="";
		//test all edges of variable limits
		Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		appt = new Appt(-1,startMinute,startDay,startMonth,startYear,title,description);
		appt = new Appt(startHour,-1,startDay,startMonth,startYear,title,description);
		appt = new Appt(startHour,startMinute,-1,startMonth,startYear,title,description);
		appt = new Appt(startHour,startMinute,startDay,-1,startYear,title,description);
		appt = new Appt(startHour,startMinute,startDay,startMonth,-1,title,description);
		appt = new Appt(24,startMinute,startDay,startMonth,startYear,title,description);
		appt = new Appt(startHour,60,startDay,startMonth,startYear,title,description);
		appt = new Appt(startHour,startMinute,33,startMonth,startYear,title,description);
		appt = new Appt(startHour,startMinute,startDay, 13,startYear,title,description);
		appt = new Appt(startHour,startMinute,startDay,startMonth,-101212,title,description);
		// test all set functions
		appt.setStartMinute(10);
		appt.setStartHour(10);
		appt.setStartDay(10);
		appt.setStartMonth(10);
		appt.setStartYear(10);
		appt.setTitle("ABC");
		appt.setDescription("ABC");
		assertEquals(10, appt.getStartHour());
		assertEquals(10, appt.getStartMinute());
		assertEquals(10, appt.getStartDay());
		assertEquals(10, appt.getStartMonth());
		assertEquals(10, appt.getStartYear());
		assertEquals("ABC", appt.getTitle());
		assertEquals("ABC", appt.getDescription());
		//test null strings
		appt.setTitle(null);
		appt.setDescription(null);
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
	}
	@Test
	public void test03() throws Throwable
	{
		// test tostring functions
		Appt appt = new Appt(1,1,1,1,1,"a","b");
		assertEquals("\t1/1/1 at 1:1am ,a, b\n", appt.toString());
		//test invalid
		appt = new Appt(-1,1,1,1,1,"a","b");
		assertEquals(null, appt.toString());
	
	}
}
