package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01(){
			//defualt check
			TimeTable tt = new TimeTable();
			GregorianCalendar dayOne = new GregorianCalendar(1,1,1);
			GregorianCalendar dayTwo = new GregorianCalendar(1,1,3);
			Appt apptOne = new Appt(1,1,1,1,1,"a","b");
			Appt apptTwo = new Appt(2,1,1,1,1,"c","d");
			LinkedList<Appt> apptLL = new LinkedList<Appt>();
			apptLL.add(apptOne);
			apptLL.add(apptTwo);
			LinkedList<CalDay> cdLL = tt.getApptRange(apptLL, dayOne, dayTwo);
			assertEquals(2, cdLL.size());
	 }
	 @Test
	 public void test02() throws Throwable{
		//test bad date
		TimeTable tt = new TimeTable();
		GregorianCalendar dayOne = new GregorianCalendar(1,1,1);
		GregorianCalendar dayTwo = new GregorianCalendar(1,1,2);
		Appt apptOne = new Appt(1,1,1,1,1,"a","b");
		Appt apptTwo = new Appt(3,1,1,1,1,"c","d");
		LinkedList<Appt> apptLL = new LinkedList<Appt>();
		apptLL.add(apptOne);
		apptLL.add(apptTwo);
		LinkedList<CalDay> cdLL = tt.getApptRange(apptLL, dayOne, dayTwo);
		assertEquals(1, cdLL.size());
 	}
	 @Test
	 public void test03() throws Throwable{
		//test bad appt time
		TimeTable tt = new TimeTable();
		GregorianCalendar dayOne = new GregorianCalendar(1,1,1);
		GregorianCalendar dayTwo = new GregorianCalendar(1,1,3);
		Appt apptOne = new Appt(1,1,1,1,1,"a","b");
		Appt apptTwo = new Appt(1,-1,-1,-1,1,"c","d");
		LinkedList<Appt> apptLL = new LinkedList<Appt>();
		apptLL.add(apptOne);
		apptLL.add(apptTwo);
		LinkedList<CalDay> cdLL = tt.getApptRange(apptLL, dayOne, dayTwo);
		assertEquals(2, cdLL.size());
		//test bad appt delete
		assertEquals(null,tt.deleteAppt(apptLL, apptTwo));
		//test null appt delete
		assertEquals(null,tt.deleteAppt(apptLL, null));
		// null linkedList appts delete
		assertEquals(null,tt.deleteAppt(null, null));
		//null delete real appt
		apptLL = tt.deleteAppt(apptLL, apptOne);
		assertEquals(1, apptLL.size());
	}
	@Test
	public void test04() throws Throwable{
	 //test appt dates outside out scope before
	 TimeTable tt = new TimeTable();
	 GregorianCalendar dayOne = new GregorianCalendar(1,1,2);
	 GregorianCalendar dayTwo = new GregorianCalendar(1,1,3);
	 Appt apptOne = new Appt(1,1,1,1,1,"a","b");
	 Appt apptTwo = new Appt(5,1,1,1,1,"c","d");
	 LinkedList<Appt> apptLL = new LinkedList<Appt>();
	 apptLL.add(apptOne);
	 apptLL.add(apptTwo);
	 LinkedList<CalDay> cdLL = tt.getApptRange(apptLL, dayOne, dayTwo);
	 assertEquals(1, cdLL.size());
	 CalDay temp = cdLL.removeFirst();
	 assertEquals(0, temp.getSizeAppts()); // Appointments added where none
 }
 @Test
 public void test05() throws Throwable{
	//test appt dates outside out scope before
	TimeTable tt = new TimeTable();
	GregorianCalendar dayOne = new GregorianCalendar(1,1,2);
	GregorianCalendar dayTwo = new GregorianCalendar(1,1,25);
	Appt apptOne = new Appt(1,1,1,1,1,"a","b");
	Appt apptTwo = new Appt(24,1,1,1,1,"c","d");
	LinkedList<Appt> apptLL = new LinkedList<Appt>();
	apptLL.add(apptOne);
	apptLL.add(apptTwo);
	LinkedList<CalDay> cdLL = tt.getApptRange(apptLL, dayOne, dayTwo);
	assertEquals(23, cdLL.size());
	CalDay temp = cdLL.removeFirst();
	assertEquals(0, temp.getSizeAppts()); // Appointments added where none
 }

 @Test
 public void test06()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 Appt appt0 = new Appt(2954, 2954, 31, 1, 0, "Second date specified is not before the first date specified.", "Second date specified is not before the first date specified.");
		 GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(1, 1, 31, 31, 1, 0);
		 CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		 LinkedList<Appt> linkedList0 = calDay0.getAppts();
		 Appt appt1 = new Appt(0, 1, 1, 1, 0, "", "");
		 linkedList0.add(appt0);
		 calDay0.addAppt(appt1);
		 timeTable0.deleteAppt(linkedList0, appt1);
		 assertEquals(1, linkedList0.size());
		 assertEquals(1, calDay0.getSizeAppts());
 }

 @Test
 public void test07()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
		 // Undeclared exception!
		 try {
			 timeTable0.getApptRange(linkedList0, (GregorianCalendar) null, (GregorianCalendar) null);
			 fail("Expecting exception: NullPointerException");

		 } catch(NullPointerException e) {
				//
				// no message in exception (getMessage() returned null)
				//
				//assertThrownBy("edu.osu.cs362.TimeTable", e);
		 }
 }

 @Test
 public void test08()  throws Throwable  {
		 LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
		 Appt appt0 = new Appt(11, 11, 11, 11, 5, "", "");
		 TimeTable timeTable0 = new TimeTable();
		 linkedList0.add((Appt) null);
		 // Undeclared exception!
		 try {
			 timeTable0.deleteAppt(linkedList0, appt0);
			 fail("Expecting exception: NullPointerException");

		 } catch(NullPointerException e) {
				//
				// no message in exception (getMessage() returned null)
				//
			 // assertThrownBy("edu.osu.cs362.TimeTable", e);
		 }
 }

 @Test
 public void test09()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(1, 1, 31, 31, 1, 0);
		 CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		 LinkedList<Appt> linkedList0 = calDay0.getAppts();
		 Appt appt0 = new Appt(0, 1, 1, 1, 0, "", "");
		 calDay0.addAppt(appt0);
		 timeTable0.deleteAppt(linkedList0, appt0);
		 assertEquals(0, calDay0.getSizeAppts());
 }

 @Test
 public void test10()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 Appt appt0 = new Appt(2954, 2954, 31, 1, 0, "Second date specified is not before the first date specified.", "Second date specified is not before the first date specified.");
		 GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(1, 1, 31, 31, 1, 0);
		 CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		 LinkedList<Appt> linkedList0 = calDay0.getAppts();
		 Appt appt1 = new Appt(0, 1, 1, 1, 0, "", "");
		 linkedList0.add(appt0);
		 timeTable0.deleteAppt(linkedList0, appt1);
		 assertEquals(1, linkedList0.size());
		 assertEquals(1, calDay0.getSizeAppts());
 }

 @Test
 public void test11()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(0, 0, 0, 0, 0, 0);
		 CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		 LinkedList<Appt> linkedList0 = calDay0.getAppts();
		 LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, (Appt) null);
		 assertNull(linkedList1);
 }

 @Test
 public void test12()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 Appt appt0 = new Appt(2954, 2954, 31, 1, 0, "Second date specified is not before the first date specified.", "Second date specified is not before the first date specified.");
		 GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(1, 1, 31, 31, 1, 0);
		 CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		 LinkedList<Appt> linkedList0 = calDay0.getAppts();
		 LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, appt0);
		 assertNull(linkedList1);
 }

 @Test
 public void test13()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 Appt appt0 = new Appt(1, 1, 1, (-19), 0, "Second date specified is not before the first date specified.", "Second date specified is not before the first date specified.");
		 LinkedList<Appt> linkedList0 = timeTable0.deleteAppt((LinkedList<Appt>) null, appt0);
		 assertNull(linkedList0);
 }


 @Test
 public void test14()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
		 Appt appt0 = new Appt(23, (-1646), 23, 1568, 2, "!01", "");
		 linkedList0.add(appt0);
		 GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2015,5,20);
		 GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar(2016,5,15);
		 LinkedList<CalDay> linkedList1 = timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar1);
		 assertEquals(361, linkedList1.size());

 }


 @Test
 public void test15()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
		 GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2621, 23, 23, 3214, 3214, 2621);
		 // Undeclared exception!
		 try {
			 timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar0);
			 fail("Expecting exception: IllegalArgumentException");

		 } catch(IllegalArgumentException e) {
				//
				// Second date specified is not before the first date specified.
				//
				//assertThrownBy("edu.osu.cs362.TimeTable", e);
		 }
 }


 @Test
 public void test16()  throws Throwable  {
		 TimeTable timeTable0 = new TimeTable();
		 GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(1, 1, 31, 31, 1, 0);
		 CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		 LinkedList<Appt> linkedList0 = calDay0.getAppts();
		 GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar();

	 }
}
