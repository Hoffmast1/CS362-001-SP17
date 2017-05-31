package edu.osu.cs362;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Random;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest extends ValuesGenerator{
	private static final long TestTimeout = 60 * 20 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
		public static String RandomSelectMethod(Random random){
				String[] methodArray = new String[] {"addAppt"};// The list of the of methods to be tested in the Appt class

			int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

				return methodArray[n] ; // return the method name
		}
	 /**
		 * Generate Random Tests that tests CalDay Class.
	 */
	 @Test
		public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");
		 GregorianCalendar  gc = new GregorianCalendar(0,0,0);
		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			 long randomseed =10;//System.currentTimeMillis();
 		 	//System.out.println(" Seed:"+randomseed );
			 Random random = new Random(randomseed);
			 CalDay calDay = new CalDay(gc);

			 int appointmentCount = getRandomIntBetween(random, 1, 100);
			 int validCounter= 0;
			 //creates random appointments
			 for(int i = 0; i < appointmentCount; i++)
			 {
				 Appt appt = new Appt(
				 	getRandomIntBetween(random, 1, 23),
				 	getRandomIntBetween(random, 1, 59),
				 	getRandomIntBetween(random, 1, 11),
					getRandomIntBetween(random, 1, 30),
				 	getRandomIntBetween(random, 2, 2000),
				 	(String) ValuesGenerator.getString(random),
				 	(String) ValuesGenerator.getString(random)
				 );
				 if(appt.getValid())
				 {calDay.addAppt(appt); validCounter++;}
			 }
			 assertEquals(validCounter, calDay.getSizeAppts());

			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
						if((iteration%10000)==0 && iteration!=0 )
									System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
		 }

		 System.out.println("Done testing...");
	 }


}
