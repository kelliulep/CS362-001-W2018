//package calendar;
//
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.LinkedList;
//import java.util.Random;
//
//import org.junit.Test;
//
//
//import static org.junit.Assert.*;
//
//
//
///**
// * Random Test Generator  for TimeTable class.
// */
//
//public class TimeTableRandomTest {
//	private static final long TestTimeout = 120 * 500 * 1; /* Timeout at 30 seconds */
//	private static final int NUM_TESTS=100;
//
//    /**
//     * Generate Random Tests that tests TimeTable Class.
//     */
//	 @Test
//	  public void radnomtest()  throws Throwable  {
//
//
//
//	 }
//
//	 @Test
//	public void testDeleteAppt() throws Throwable {
//
//		 long startTime = Calendar.getInstance().getTimeInMillis();
//		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
//
//		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
//			 long randomseed = System.currentTimeMillis(); //10
//			 //			System.out.println(" Seed:"+randomseed );
//			 Random random = new Random(randomseed);
//
//			 TimeTable timeTable = new TimeTable();
//			 LinkedList<Appt> apptList = new LinkedList<Appt>();
//
//
//			 //generate random appts
//			 boolean chance = ValuesGenerator.getBoolean(.5f, random);
//			 int MAX_APPTS = 0;
//			 if (chance)
//				 MAX_APPTS = ValuesGenerator.getRandomIntBetween(random, 0, 50);
//
//
//			 //adds a random amount of appointments to the list
//			 for (int i = 0; i < MAX_APPTS; i++) {
//				 int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
//				 //int startDay = ValuesGenerator.getRandomIntBetween(random, -31, 47);
//				 int startDay = ValuesGenerator.RandInt(random);
//				 int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
//				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 0, 12);
//				 int startYear = ValuesGenerator.RandInt(random);
//
//				 String title = "Birthday Party";
//				 String description = "This is my birthday party.";
//				 //Construct a new Appointment object with the initial data
//				 Appt appt = new Appt(startHour,
//						 startMinute,
//						 startDay,
//						 startMonth,
//						 startYear,
//						 title,
//						 description);
//
//				 apptList.add(appt);
//			 }
//
//			 //delete random app
//			 boolean chanceAppt = ValuesGenerator.getBoolean(.5f, random);
//			 int indexToDelete;
//
//			 int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
//			 int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
//			 int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
//			 int startMonth = ValuesGenerator.getRandomIntBetween(random, 0, 11);
//			 int startYear = ValuesGenerator.RandInt(random);
//
//			 String title = "Birthday Party";
//			 String description = "This is my birthday party.";
//
//			 Appt apptToDelete = new Appt(startHour, startMinute, startDay, startMonth, startYear,
//					 title, description);
//			 //valid appt
//			 if (chanceAppt)
//				 indexToDelete = ValuesGenerator.getRandomIntBetween(random, 0, MAX_APPTS - 1);
//				 //invalid appt
//			 else {
//				 indexToDelete = -1;
//				 apptToDelete.setStartDay(45);    //make invalid appt
//				 assertFalse(apptToDelete.getValid());
//			 }
//
//			 if (apptList.size() > 0 && apptList != null && indexToDelete != -1)
//				 apptToDelete = apptList.get(indexToDelete);
//			 System.out.println("indexToDelete: " + indexToDelete);
//			 timeTable.deleteAppt(apptList, apptToDelete);
//
//
//			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
//			 if ((iteration % 1000) == 0 && iteration != 0)
//				 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
//
//		 }
//	 }
//
//		 @Test
//		 public void testGetApptRange() throws Throwable {
//
//			 long startTime = Calendar.getInstance().getTimeInMillis();
//			 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
//
//			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
//				 long randomseed = System.currentTimeMillis(); //10
//				 //			System.out.println(" Seed:"+randomseed );
//				 Random random = new Random(randomseed);
//
//				 TimeTable timeTable = new TimeTable();
//				 LinkedList<Appt> apptList = new LinkedList<Appt>();
//
//
//				 //generate random appts
//				 boolean chance = ValuesGenerator.getBoolean(.5f, random);
//				 int MAX_APPTS =  ValuesGenerator.getRandomIntBetween(random, 1,50);
//
//
//				 //adds a random amount of appointments to the list
//				 for(int i = 0; i < MAX_APPTS; i++) {
//					 int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
//					 int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 27);
//					 int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
//					 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 4);
//					 int startYear = 2018;
//
//					 String title = "Birthday Party";
//					 String description = "This is my birthday party.";
//					 //Construct a new Appointment object with the initial data
//					 Appt appt = new Appt(startHour,
//							 startMinute,
//							 startDay,
//							 startMonth,
//							 startYear,
//							 title,
//							 description);
//
//					 int [] recurDaysArr = new int[MAX_APPTS];
//
//					 for(int j=0; j < ValuesGenerator.getRandomIntBetween(random, 1, MAX_APPTS); j++) {
//						 int randomNum = ValuesGenerator.getRandomIntBetween(random, 0, 28);
//						 recurDaysArr[j] = randomNum;
//					 }
//					 if(chance) {
//						 appt.setStartMinute(10000);    //invalid check
//						 appt.setStartHour(400);
//					 }
//					 int recurInc = ValuesGenerator.getRandomIntBetween(random, 0, 10);
//					appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_MONTHLY, recurInc, Appt.RECUR_NUMBER_FOREVER);
//					 apptList.add(appt);
//				 }
//
//				 //parameters for getApptRange
//				 GregorianCalendar day1 = new GregorianCalendar(2018, 2, 1);
//				 GregorianCalendar day2 = new GregorianCalendar(2018, 2, 27);
//
//				 timeTable.getApptRange(apptList, day1, day2);
//
//
//				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
//				 if((iteration%1000)==0 && iteration!=0 )
//					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
//
//			 }
//
//	 }
//
//
//
//}
