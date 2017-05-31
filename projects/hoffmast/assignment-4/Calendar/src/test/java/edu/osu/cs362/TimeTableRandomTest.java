package edu.osu.cs362;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import java.util.LinkedList;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest extends ValuesGenerator{
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
			 long randomseed = System.currentTimeMillis();
 		 	//System.out.println(" Seed:"+randomseed );
			 Random random = new Random(randomseed);
			 CalDay calDay = new CalDay(gc);
			 TimeTable tT = new TimeTable();
			 int appointmentCount = getRandomIntBetween(random, -1, 100);
			 int validCounter= 0;
			 LinkedList<Appt> apptList= new LinkedList();
			 //creates random appointments

			 for(int i = 0; i < appointmentCount; i++)
			 {
			 	int percent = getRandomIntBetween(random, 0, 100);
				 if(percent >= 50)
				{
					 		Appt appt = new Appt(
							getRandomIntBetween(random, 1, 24),
					 		getRandomIntBetween(random, 1, 59),
					 		getRandomIntBetween(random, 1, 12),
							getRandomIntBetween(random, 1, 31),
					 		getRandomIntBetween(random, 2, 2000),
					 		(String) ValuesGenerator.getString(random),
					 		(String) ValuesGenerator.getString(random)
					 );
					 if(percent < 10){appt.setStartDay(100);}
					apptList.addLast(appt);
					validCounter++;
			 	}
				else{
				}
			 }
			 int deleteAmount = getRandomIntBetween(random, 1, validCounter);
			 int startSize = apptList.size();
 		 	assertEquals(startSize, apptList.size());
			 for(int i = 0; i < deleteAmount; i++)
			 {
				 tT.deleteAppt(apptList, apptList.peekFirst());
				 tT.deleteAppt(apptList, null);
				 tT.deleteAppt(null, null);
				 tT.deleteAppt(null, apptList.peekFirst());
		 	}
			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
						if((iteration%10000)==0 && iteration!=0 ){
							System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
						}

		 }
		 System.out.println("Done testing...");
	 }
}
