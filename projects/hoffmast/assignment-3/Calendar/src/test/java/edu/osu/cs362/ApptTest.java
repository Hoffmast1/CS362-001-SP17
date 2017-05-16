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
	@Test
	public void test04() throws Throwable
	{
		// test tostring functions
		Appt appt = new Appt(1,1,1,1,1,"a","b");
		assertEquals("\t1/1/1 at 1:1am ,a, b\n", appt.toString());
		//test invalid
		appt = new Appt(-1,1,1,1,1,"a","b");
		assertEquals(null, appt.toString());
		appt = new Appt(25,-1,1,1,1,"a","b");
		assertEquals(null, appt.toString());
		appt = new Appt(22,1,1,1,1,"a","b");
		appt.setStartMinute(61);
		assertEquals(61, appt.getStartMinute());
		appt.setStartHour(13);
		appt.setStartDay(32);
		appt.setStartMonth(13);
		appt.setStartYear(200000);
		appt.setStartMinute(-1);
		appt.setStartHour(-1);
		appt.setStartDay(-1);
		appt.setStartMonth(-1);
		appt.setStartYear(-1);
	assertEquals(null, appt.toString());
	}
	@Test
	public void test05()  throws Throwable  {
			Appt appt0 = new Appt(10, 10, 10, 10, 10, (String) null, "_=DOv.TYJ}h}8d{MhYC");
			String string0 = appt0.toString();
			assertNotNull(string0);
			assertEquals("\t10/10/10 at 10:10am ,, _=DOv.TYJ}h}8d{MhYC\n", string0);
	}

	@Test
	public void test06()  throws Throwable  {
			Appt appt0 = new Appt(6, 6, 31, 6, 6, "", "");
			assertEquals(31, appt0.getStartDay());
			assertEquals(6, appt0.getStartYear());
			assertEquals(6, appt0.getStartHour());
			assertTrue(appt0.getValid());
			assertEquals(6, appt0.getStartMinute());
			assertEquals(6, appt0.getStartMonth());
	}

	@Test
	public void test07()  throws Throwable  {
			Appt appt0 = new Appt(0, 4346, 0, 0, 1, "", "");
			appt0.setStartMinute(59);
			assertEquals(59, appt0.getStartMinute());
	}

	@Test
	public void test08()  throws Throwable  {
			Appt appt0 = new Appt(1, 1, 1, 1, 1, "|gf\"", "&w&Ox=r)'dB.p");
			boolean boolean0 = appt0.getValid();
			assertTrue(boolean0);
			assertEquals(1, appt0.getStartDay());
			assertEquals(1, appt0.getStartMinute());
			assertEquals(1, appt0.getStartHour());
			assertEquals("|gf\"", appt0.getTitle());
			assertEquals(1, appt0.getStartYear());
			assertEquals("&w&Ox=r)'dB.p", appt0.getDescription());
			assertEquals(1, appt0.getStartMonth());
	}

	@Test
	public void test09()  throws Throwable  {
			Appt appt0 = new Appt(304, 304, 0, (-813), 0, "O to[p%CfX-P;nzuV", "O to[p%CfX-P;nzuV");
			String string0 = appt0.getTitle();
			assertEquals("O to[p%CfX-P;nzuV", appt0.getDescription());
			assertEquals(-813, appt0.getStartMonth());
			assertEquals(304, appt0.getStartMinute());
			assertEquals("O to[p%CfX-P;nzuV", string0);
			assertEquals(0, appt0.getStartDay());
			assertEquals(304, appt0.getStartHour());
			assertEquals(0, appt0.getStartYear());
			assertFalse(appt0.getValid());
	}

	@Test
	public void test10()  throws Throwable  {
			Appt appt0 = new Appt(0, 0, 0, 0, 634, (String) null, " A");
			int int0 = appt0.getStartYear();
			assertEquals("", appt0.getTitle());
			assertFalse(appt0.getValid());
			assertEquals(0, appt0.getStartHour());
			assertEquals(" A", appt0.getDescription());
			assertEquals(634, int0);
			assertEquals(0, appt0.getStartMinute());
			assertEquals(0, appt0.getStartMonth());
			assertEquals(0, appt0.getStartDay());
	}

	@Test
	public void test11()  throws Throwable  {
			Appt appt0 = new Appt(716, 716, 716, 716, (-1), " at ", "Ch;");
			int int0 = appt0.getStartYear();
			assertEquals(716, appt0.getStartMinute());
			assertEquals(716, appt0.getStartMonth());
			assertEquals(716, appt0.getStartDay());
			assertEquals("Ch;", appt0.getDescription());
			assertEquals(" at ", appt0.getTitle());
			assertFalse(appt0.getValid());
			assertEquals((-1), int0);
			assertEquals(716, appt0.getStartHour());
	}

	@Test
	public void test12()  throws Throwable  {
			Appt appt0 = new Appt(0, 0, 0, 0, 0, "2e\u0006Ue", "");
			int int0 = appt0.getStartMonth();
			assertEquals("2e\u0006Ue", appt0.getTitle());
			assertEquals(0, appt0.getStartDay());
			assertEquals(0, appt0.getStartMinute());
			assertEquals("", appt0.getDescription());
			assertEquals(0, int0);
			assertEquals(0, appt0.getStartYear());
			assertFalse(appt0.getValid());
			assertEquals(0, appt0.getStartHour());
	}
	@Test
	public void test13()  throws Throwable  {
			Appt appt0 = new Appt(12, 12, 12, 12, 12, "", "");
			appt0.setStartMonth((-13));
			int int0 = appt0.getStartMonth();
			assertEquals((-13), int0);
	}


	@Test
	public void test14()  throws Throwable  {
			Appt appt0 = new Appt(0, 0, 0, 0, 0, "2e\u0006Ue", "");
			int int0 = appt0.getStartMinute();
			assertEquals(0, appt0.getStartDay());
			assertFalse(appt0.getValid());
			assertEquals("", appt0.getDescription());
			assertEquals(0, appt0.getStartHour());
			assertEquals("2e\u0006Ue", appt0.getTitle());
			assertEquals(0, int0);
			assertEquals(0, appt0.getStartYear());
			assertEquals(0, appt0.getStartMonth());
	}

	@Test
	public void test15()  throws Throwable  {
			Appt appt0 = new Appt(0, 4346, 0, 0, 1, "", "");
			int int0 = appt0.getStartMinute();
			assertEquals(0, appt0.getStartMonth());
			assertEquals(1, appt0.getStartYear());
			assertFalse(appt0.getValid());
			assertEquals(0, appt0.getStartHour());
			assertEquals(4346, int0);
			assertEquals(0, appt0.getStartDay());
	}

	@Test
	public void test16()  throws Throwable  {
			Appt appt0 = new Appt(0, 0, 0, 0, 0, (String) null, "");
			int int0 = appt0.getStartHour();
			assertEquals(0, appt0.getStartMinute());
			assertEquals(0, appt0.getStartDay());
			assertEquals(0, appt0.getStartMonth());
			assertEquals(0, appt0.getStartYear());
			assertFalse(appt0.getValid());
			assertEquals(0, int0);
	}

	@Test
	public void test17()  throws Throwable  {
			Appt appt0 = new Appt(0, 23, 0, 0, 23, "", "");
			int int0 = appt0.getStartDay();
			assertEquals(0, appt0.getStartMonth());
			assertEquals(0, appt0.getStartHour());
			assertFalse(appt0.getValid());
			assertEquals(23, appt0.getStartMinute());
			assertEquals(0, int0);
			assertEquals(23, appt0.getStartYear());
	}



	@Test
	public void test18()  throws Throwable  {
			Appt appt0 = new Appt(12, 12, 12, 12, 12, "", "");
			appt0.setDescription("e3(");
			appt0.getDescription();
			assertEquals("e3(", appt0.getDescription());
	}

	@Test
	public void test19()  throws Throwable  {
			Appt appt0 = new Appt((-1237), (-1237), 2736, 2736, 2736, "Vn05?3m:o", "Vn05?3m:o");
			appt0.setDescription("Vn05?3m:o");
			assertEquals(2736, appt0.getStartYear());
			assertFalse(appt0.getValid());
			assertEquals(2736, appt0.getStartDay());
			assertEquals("Vn05?3m:o", appt0.getDescription());
			assertEquals(-1237, appt0.getStartHour());
			assertEquals(-1237, appt0.getStartMinute());
			assertEquals(2736, appt0.getStartMonth());
			assertEquals("Vn05?3m:o", appt0.getTitle());
	}

	@Test
	public void test20()  throws Throwable  {
			Appt appt0 = new Appt((-1237), (-1237), 2736, 2736, 2736, "Vn05?3m:o", "Vn05?3m:o");
			appt0.setTitle("{");
			assertEquals("{", appt0.getTitle());
	}


	@Test
	public void test21()  throws Throwable  {
			Appt appt0 = new Appt(0, 1, 1, 1, (-1166), "pm", "pm");
			assertEquals("pm", appt0.getTitle());

			appt0.setTitle((String) null);
			assertTrue(appt0.getValid());
	}
	@Test
	public void test22()  throws Throwable  {
			Appt appt0 = new Appt(0, 4346, 0, 0, 1, "", "");
			appt0.getTitle();
			assertEquals(0, appt0.getStartDay());
			assertEquals(1, appt0.getStartYear());
			assertEquals(4346, appt0.getStartMinute());
			assertEquals(0, appt0.getStartMonth());
			assertFalse(appt0.getValid());
			assertEquals(0, appt0.getStartHour());
	}

	@Test
	public void test23()  throws Throwable  {
			Appt appt0 = new Appt((-1237), (-1237), 2736, 2736, 2736, "Vn05?3m:o", "Vn05?3m:o");
			int int0 = appt0.getStartDay();
			assertEquals(2736, appt0.getStartMonth());
			assertEquals(2736, appt0.getStartYear());
			assertEquals("Vn05?3m:o", appt0.getDescription());
			assertFalse(appt0.getValid());
			assertEquals(-1237, appt0.getStartMinute());
			assertEquals("Vn05?3m:o", appt0.getTitle());
			assertEquals(2736, int0);
			assertEquals(-1237, appt0.getStartHour());
	}

	@Test
	public void test24()  throws Throwable  {
			Appt appt0 = new Appt((-1228), (-1228), (-1228), (-1228), (-23), "", "Xhx");
			boolean boolean0 = appt0.getValid();
			assertEquals(-1228, appt0.getStartDay());
			assertEquals("", appt0.getTitle());
			assertEquals(-1228, appt0.getStartHour());
			assertFalse(boolean0);
			assertEquals(-1228, appt0.getStartMinute());
			assertEquals(-23, appt0.getStartYear());
			assertEquals("Xhx", appt0.getDescription());
			assertEquals(-1228, appt0.getStartMonth());
	}


	@Test
	public void test25()  throws Throwable  {
			Appt appt0 = new Appt((-1228), (-1228), (-1228), (-1228), (-23), "", "Xhx");
			int int0 = appt0.getStartHour();
			assertEquals(-23, appt0.getStartYear());
			assertEquals("Xhx", appt0.getDescription());
			assertEquals((-1228), int0);
			assertEquals("", appt0.getTitle());
			assertEquals(-1228, appt0.getStartMinute());
			assertEquals(-1228, appt0.getStartMonth());
			assertFalse(appt0.getValid());
			assertEquals(-1228, appt0.getStartDay());
	}

	@Test
	public void test26()  throws Throwable  {
			Appt appt0 = new Appt(0, 0, 0, 0, 0, "2e\u0006Ue", "");
			int int0 = appt0.getStartYear();
			assertEquals(0, appt0.getStartMinute());
			assertEquals(0, appt0.getStartMonth());
			assertFalse(appt0.getValid());
			assertEquals(0, appt0.getStartHour());
			assertEquals(0, int0);
			assertEquals(0, appt0.getStartDay());
			assertEquals("2e\u0006Ue", appt0.getTitle());
			assertEquals("", appt0.getDescription());
	}

	@Test
	public void test27()  throws Throwable  {
			Appt appt0 = new Appt((-1237), (-1237), 2736, 2736, 2736, "Vn05?3m:o", "Vn05?3m:o");
			int int0 = appt0.getStartMinute();
			assertEquals(2736, appt0.getStartDay());
			assertEquals(2736, appt0.getStartMonth());
			assertEquals("Vn05?3m:o", appt0.getDescription());
			assertEquals((-1237), int0);
			assertEquals(-1237, appt0.getStartHour());
			assertEquals("Vn05?3m:o", appt0.getTitle());
			assertFalse(appt0.getValid());
			assertEquals(2736, appt0.getStartYear());
	}


	@Test
	public void test28()  throws Throwable  {
			Appt appt0 = new Appt(12, 12, 12, 12, 12, "", "");
			appt0.getDescription();
			assertEquals(12, appt0.getStartDay());
			assertEquals(12, appt0.getStartMinute());
			assertEquals(12, appt0.getStartMonth());
			assertTrue(appt0.getValid());
			assertEquals(12, appt0.getStartYear());
			assertEquals(12, appt0.getStartHour());
	}


	@Test
	public void test29()  throws Throwable  {
			Appt appt0 = new Appt(1, 1, 1, 1, 1, "|gf\"", "&w&Ox=r)'dB.p");
			int int0 = appt0.getStartMonth();
			assertEquals(1, int0);
			assertEquals("|gf\"", appt0.getTitle());
			assertEquals(1, appt0.getStartHour());
			assertEquals(1, appt0.getStartYear());
			assertEquals("&w&Ox=r)'dB.p", appt0.getDescription());
			assertEquals(1, appt0.getStartMinute());
			assertTrue(appt0.getValid());
			assertEquals(1, appt0.getStartDay());
	}



	@Test
	public void test30()  throws Throwable  {
			Appt appt0 = new Appt(59, 59, 2896, 2896, 59, "", (String) null);
			int int0 = appt0.getStartHour();
			assertEquals(2896, appt0.getStartMonth());
			assertEquals(59, int0);
			assertFalse(appt0.getValid());
			assertEquals(59, appt0.getStartMinute());
			assertEquals(59, appt0.getStartYear());
			assertEquals(2896, appt0.getStartDay());
	}


	@Test
	public void test31()  throws Throwable  {
			Appt appt0 = new Appt(12, 12, 12, 12, 12, "", "");
			appt0.setStartMonth(2206);
			assertEquals(2206, appt0.getStartMonth());
	}

	@Test
	public void test32()  throws Throwable  {
			Appt appt0 = new Appt(23, 23, 23, 0, 0, (String) null, "Vf2 >.>>x=HY(GHg");
			assertEquals("", appt0.getTitle());
			assertFalse(appt0.getValid());
			assertEquals(0, appt0.getStartMonth());
			assertEquals("Vf2 >.>>x=HY(GHg", appt0.getDescription());
			assertEquals(23, appt0.getStartHour());
			assertEquals(23, appt0.getStartDay());
			assertEquals(23, appt0.getStartMinute());
			assertEquals(0, appt0.getStartYear());
	}

	@Test
	public void test33()  throws Throwable  {
			Appt appt0 = new Appt(0, 0, 1126, 0, 0, "R~#[[)R%+(+C", "R~#[[)R%+(+C");
			assertEquals("R~#[[)R%+(+C", appt0.getDescription());

			appt0.setDescription((String) null);
			assertEquals(1126, appt0.getStartDay());
	}

	@Test
	public void test34()  throws Throwable  {
			Appt appt0 = new Appt(12, 12, 12, 12, 12, "", "");
			appt0.setStartMinute((-2667));
			appt0.toString();
			assertEquals(-2667, appt0.getStartMinute());
	}

	@Test
	public void test35()  throws Throwable  {
			Appt appt0 = new Appt(0, 4346, 0, 0, 1, "", "");
			appt0.setStartHour(3918);
			assertEquals(3918, appt0.getStartHour());
	}


	@Test
	public void test36()  throws Throwable  {
			Appt appt0 = new Appt((-1847), (-1847), (-1288), 0, 825, "", "am");
			int int0 = appt0.getStartDay();
			assertEquals(0, appt0.getStartMonth());
			assertEquals("", appt0.getTitle());
			assertFalse(appt0.getValid());
			assertEquals("am", appt0.getDescription());
			assertEquals(-1847, appt0.getStartMinute());
			assertEquals((-1288), int0);
			assertEquals(825, appt0.getStartYear());
			assertEquals(-1847, appt0.getStartHour());
	}

	@Test
	public void test37()  throws Throwable  {
			Appt appt0 = new Appt(12, 12, 12, 12, 12, "", "");
			appt0.setStartYear(12);
			assertEquals(12, appt0.getStartYear());
			assertEquals(12, appt0.getStartHour());
			assertTrue(appt0.getValid());
			assertEquals(12, appt0.getStartMonth());
			assertEquals(12, appt0.getStartDay());
			assertEquals(12, appt0.getStartMinute());
	}

	@Test
	public void test38()  throws Throwable  {
			Appt appt0 = new Appt(12, 12, 12, 12, 12, "", "");
			assertEquals(12, appt0.getStartDay());

			appt0.setStartDay(11);
			assertTrue(appt0.getValid());
	}

	@Test
	public void test39()  throws Throwable  {
			Appt appt0 = new Appt(12, 12, 12, 12, 12, "", "");
			assertEquals(12, appt0.getStartHour());

			appt0.setStartHour(11);
			appt0.toString();
			assertEquals(11, appt0.getStartHour());
	}

	@Test
	public void test40()  throws Throwable  {
			Appt appt0 = new Appt(12, 12, 12, 12, 12, "", "");
			String string0 = appt0.toString();
			assertEquals("\t12/12/12 at 12:12pm ,, \n", string0);
			assertNotNull(string0);
	}
}
