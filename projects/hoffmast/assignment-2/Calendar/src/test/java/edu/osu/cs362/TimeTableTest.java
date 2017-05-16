package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


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
}
