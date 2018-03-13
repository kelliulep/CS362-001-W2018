package calendar;
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

	//test getApptRange
	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable timeTable = new TimeTable();
		 //Create a linked list of calendar days to return
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		 LinkedList<Appt> apptList = new LinkedList<Appt>();
		 int startHour=14;
		 int startMinute=30;
		 int startDay=16;
		 int startMonth=2;
		 int startYear=2018;
		 String title="Class";
		 String description="Rescheduled class.";
		 //Construct a new Appointment object with the initial data
		 Appt appt1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 apptList.add(appt1);       //add to list

		 startDay = 18; //change start day

		 //construct new appointment
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 apptList.add(appt2);

		 //parameters for getApptRange
		 GregorianCalendar day1 = new GregorianCalendar(2018, 2, 14);
		 GregorianCalendar day2 = new GregorianCalendar(2018, 2, 16);

		 //expected days to return
		 LinkedList<CalDay> expectedDays = new LinkedList<CalDay>();
		 expectedDays.add(new CalDay(new GregorianCalendar(2018, 2,14)));
		 expectedDays.add(new CalDay(new GregorianCalendar(2018, 2,15)));

//		 assertEquals(expectedDays, timeTable.getApptRange(apptList, day1, day2));

	 }

	 //testing deleteAppt
	 @Test
	  public void test02()  throws Throwable  {
		 TimeTable timeTable = new TimeTable();
		 //Create a linked list of calendar days to return
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		 LinkedList<Appt> apptList = new LinkedList<Appt>();
		 int startHour=14;
		 int startMinute=30;
		 int startDay=16;
		 int startMonth=2;
		 int startYear=2018;
		 String title="Class";
		 String description="Rescheduled class.";
		 //Construct a new Appointment object with the initial data
		 Appt appt1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 apptList.add(appt1);       //add to list

		 startDay = 18; //change start day

		 //construct new appointment
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 apptList.add(appt2);

		 assertEquals(2, apptList.size());
		 timeTable.deleteAppt(apptList, appt2);
		 assertEquals(1, apptList.size());
	 }
//add more unit tests as you needed

	@Test
	public void testDelete2()  throws Throwable  {
		TimeTable timeTable = new TimeTable();
		//Create a linked list of calendar days to return
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		LinkedList<Appt> apptList = new LinkedList<Appt>();
		int startHour=14;
		int startMinute=30;
		int startDay=16;
		int startMonth=2;
		int startYear=2018;
		String title="Class";
		String description="Rescheduled class.";
		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		apptList.add(appt1);       //add to list

		startDay = 18; //change start day

		//construct new appointment
		Appt appt2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		apptList.add(appt2);

		Appt apptNull = null;

		assertEquals(2, apptList.size());
		timeTable.deleteAppt(apptList, appt2);
		assertEquals(1, apptList.size());
		timeTable.deleteAppt(apptList, appt1);
		//assertEquals(0, apptList.size());

		assertEquals(null, timeTable.deleteAppt(apptList,apptNull));
	}


	//test getNextApptOccurance
	@Test
	public void test03() throws Throwable{
		TimeTable timeTable = new TimeTable();
		LinkedList<Appt> apptList = new LinkedList<Appt>();


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
		assertEquals(appt.getRecurNumber(), Appt.RECUR_NUMBER_FOREVER);

		apptList.add(appt);

		//parameters for getApptRange
		GregorianCalendar day1 = new GregorianCalendar(2018, 2, 14);
		GregorianCalendar day2 = new GregorianCalendar(2018, 2, 16);

		//expected days to return
		LinkedList<CalDay> expectedDays = new LinkedList<CalDay>();
		expectedDays.add(new CalDay(new GregorianCalendar(2018, 2,14)));
		expectedDays.add(new CalDay(new GregorianCalendar(2018, 2,15)));

		timeTable.getApptRange(apptList, day1, day2);
//		assertEquals(expectedDays, timeTable.getApptRange(apptList, day1, day2));

	}

	//test getNextApptOccurance
	@Test
	public void test04() throws Throwable{
		TimeTable timeTable = new TimeTable();
		LinkedList<Appt> apptList = new LinkedList<Appt>();


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
		appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		assertTrue(appt.getValid());
		assertTrue(appt.isRecurring());
		assertEquals(appt.getRecurNumber(), Appt.RECUR_NUMBER_FOREVER);

		apptList.add(appt);

		//parameters for getApptRange
		GregorianCalendar day1 = new GregorianCalendar(2018, 2, 14);
		GregorianCalendar day2 = new GregorianCalendar(2018, 2, 25);

		//expected days to return
		LinkedList<CalDay> expectedDays = new LinkedList<CalDay>();
		expectedDays.add(new CalDay(new GregorianCalendar(2018, 2,14)));
		expectedDays.add(new CalDay(new GregorianCalendar(2018, 2,15)));

		timeTable.getApptRange(apptList, day1, day2);
		//assertEquals(expectedDays, timeTable.getApptRange(apptList, day1, day2));

	}

	@Test
	public void testPermute() {
		TimeTable timeTable = new TimeTable();
		LinkedList<Appt> apptList = new LinkedList<Appt>();

		LinkedList<Appt> expectedApptList = new LinkedList<Appt>();


		int startHour=12;
		int startMinute=30;
		int startDay=17;
		int startMonth=02;
		int startYear=2018;
		String title="Meeting";
		String description="Recurring event";
		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
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

		apptList.add(appt1);
		apptList.add(appt2);

		int[] pv = new int[]{1,0};

		timeTable.permute(apptList, pv);

		expectedApptList.add(appt1);
		expectedApptList.add(appt2);

		assertEquals(expectedApptList, apptList);

	}

	//test getNextApptOccurance
	@Test
	public void testGetNxtAppOccur() throws Throwable{
		TimeTable timeTable = new TimeTable();
		LinkedList<Appt> apptList = new LinkedList<Appt>();


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
		int[] recurDaysArr={};
		appt.setRecurrence(recurDaysArr, 0, 0, Appt.RECUR_NUMBER_NEVER);
		assertTrue(appt.getValid());
		assertFalse(appt.isRecurring());
		assertEquals(appt.getRecurNumber(), Appt.RECUR_NUMBER_NEVER);

		apptList.add(appt);

		//parameters for getApptRange
		GregorianCalendar day1 = new GregorianCalendar(2018, 2, 14);
		GregorianCalendar day2 = new GregorianCalendar(2018, 2, 25);

		//expected days to return
		LinkedList<CalDay> expectedDays = new LinkedList<CalDay>();
		expectedDays.add(new CalDay(new GregorianCalendar(2018, 2,14)));
		expectedDays.add(new CalDay(new GregorianCalendar(2018, 2,15)));

		timeTable.getApptRange(apptList, day1, day2);
		//assertEquals(expectedDays, timeTable.getApptRange(apptList, day1, day2));
		//timeTable.getApptRange(apptList, day2, day1);

	}
}
