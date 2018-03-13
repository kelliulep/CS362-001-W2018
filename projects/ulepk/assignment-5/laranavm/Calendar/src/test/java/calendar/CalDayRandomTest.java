package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {



	 }

	 @Test
     public void testAddAppt() throws Throwable {

         long startTime = Calendar.getInstance().getTimeInMillis();
         long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

         for (int iteration = 0; elapsed < TestTimeout; iteration++) {
             long randomseed = System.currentTimeMillis(); //10
             //			System.out.println(" Seed:"+randomseed );
             Random random = new Random(randomseed);

             int year = ValuesGenerator.RandInt(random);
             int month = ValuesGenerator.getRandomIntBetween(random, 0, 12);
             int day = ValuesGenerator.getRandomIntBetween(random, 0, 30);
             GregorianCalendar day1 = new GregorianCalendar(year, month, day);

             CalDay calDay1 = new CalDay(day1);


             //generate random appts
             boolean chance = ValuesGenerator.getBoolean(.5f, random);
             int MAX_APPTS = 0;
             if(chance)
                MAX_APPTS = ValuesGenerator.getRandomIntBetween(random, 5,50);
             for(int i = 0; i < MAX_APPTS; i++) {
                 int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
                 //int startDay = ValuesGenerator.getRandomIntBetween(random, -31, 47);
                 int startDay = ValuesGenerator.RandInt(random);
                 int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
                 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                 int startYear = ValuesGenerator.RandInt(random);

                 String title = "Birthday Party";
                 String description = "This is my birthday party.";
                 //Construct a new Appointment object with the initial data
                 Appt appt = new Appt(startHour,
                         startMinute,
                         startDay,
                         startMonth,
                         startYear,
                         title,
                         description);

                 calDay1.addAppt(appt);
             }

            assertEquals(MAX_APPTS, calDay1.getSizeAppts());


             elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
             if((iteration%1000)==0 && iteration!=0 )
                 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

         }
     }



}
