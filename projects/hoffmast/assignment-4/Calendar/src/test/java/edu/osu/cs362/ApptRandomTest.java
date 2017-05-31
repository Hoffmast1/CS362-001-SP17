package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

	public class ApptRandomTest extends ValuesGenerator{
	private static final long TestTimeout = 60 * 20 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }

    /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");


			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =10;//System.currentTimeMillis();
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

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
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
							 if(newTitle == null)
							 {
								  assertEquals("", appt.getTitle());
							 }
							 else assertEquals(newTitle, appt.getTitle());
						}
						if (methodName.equals("setDescription")){
							String newDes=(String) ValuesGenerator.getString(random);
							appt.setDescription(newDes);
							if(newDes == null)
							{
								assertEquals("", appt.getDescription());
							}
							else assertEquals(newDes, appt.getDescription());
							//test is valid parameters
							int tempNum = getRandomIntBetween( random, -1, 24);
							appt.setStartHour( tempNum );
							assertEquals(tempNum, appt.getStartHour());
							tempNum = getRandomIntBetween( random, -2, 61);
							appt.setStartMinute( tempNum );
							assertEquals(tempNum, appt.getStartMinute());
							tempNum = getRandomIntBetween( random, -2, 33);
							appt.setStartDay( tempNum );
							assertEquals(tempNum, appt.getStartDay());
							tempNum = getRandomIntBetween( random, -2, 14);
							appt.setStartMonth( tempNum );
							assertEquals(tempNum, appt.getStartMonth());
					 }


				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}


		 System.out.println("Done testing...");
	 }



}
