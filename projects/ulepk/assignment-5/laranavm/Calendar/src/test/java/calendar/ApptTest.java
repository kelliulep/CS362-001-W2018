package calendar;
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
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 //Testing recurrence
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=12;
		 int startMinute=30;
		 int startDay=17;
		 int startMonth=02;
		 int startYear=2018;
		 String title="Meeting";
		 String description="Recurring event";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 int[] recurDaysArr={2,3,4};
		 appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 assertTrue(appt.getValid());
		 assertTrue(appt.isRecurring());
		 assertEquals(appt.getRecurNumber(),Appt.RECUR_NUMBER_FOREVER);
	 }
//add more unit tests as you needed
	@Test
	public void test3() {
		int startHour = 8;
		int startMinute = 1;
		int startDay = 01;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Event";
		String description = "This is the description";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		//assertEquals("  1/1/2018 at 8:01am ,Event, This is the description", appt.toString());
	}

	@Test
	public void testValid() {
		int startHour = 8;
		int startMinute = 1;
		int startDay = 01;
		int startMonth = 12;
		int startYear = 2018;
		String title = "Event";
		String description = "This is the description";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		assertTrue(appt.getValid());
	}

	@Test
	public void testCompare() {
		int startHour = 8;
		int startMinute = 1;
		int startDay = 01;
		int startMonth = 12;
		int startYear = 2018;
		String title = "Event";
		String description = "This is the description";
		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		startHour = 8;
		startMinute = 1;
		startDay = 02;
		startMonth = 12;
		startYear = 2018;
		title = "Event";
		description = "This is the description";
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		assertEquals(-1, appt1.compareTo(appt2));

		appt1.setStartDay(04);
		appt2.setStartDay(05);
		appt1.setStartMinute(04);
		appt2.setStartMinute(05);
		appt1.setStartMonth(04);
		appt2.setStartMonth(05);

		assertEquals(-3, appt1.compareTo(appt2));

		appt2.setStartYear(2019);

		assertEquals(-4, appt1.compareTo(appt2));


	}

	@Test
	public void testToString() {
		int startHour = 8;
		int startMinute = 21;
		int startDay = 01;
		int startMonth = 12;
		int startYear = 2018;
		String title = "Event";
		String description = "This is the description";
		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear,
				title, description);
		String stringified = appt1.toString();
		assertEquals("\t12/1/2018 at 8:21am ,Event, This is the description\n", stringified);
	}


}
