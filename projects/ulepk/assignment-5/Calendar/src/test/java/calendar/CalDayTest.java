package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		GregorianCalendar day1 = new GregorianCalendar(2018, 2, 14);
		CalDay calDay1 = new CalDay(day1);
		assertTrue(calDay1.isValid());
		assertEquals(14, calDay1.getDay());
		assertEquals(14, calDay1.getDay());
		assertEquals(2, calDay1.getMonth());
        assertEquals(2018, calDay1.getYear());

     }
	 @Test
	  public void test02()  throws Throwable  {
         GregorianCalendar day1 = new GregorianCalendar(2018, 2, 14);
         CalDay calDay1 = new CalDay(day1);
         assertTrue(calDay1.isValid());

         LinkedList<Appt> apptList = new LinkedList<Appt>();
         int startHour=14;
         int startMinute=30;
         int startDay=12;
         int startMonth=12;
         int startYear=2018;
         String title="Class";
         String description="Rescheduled class.";
         //Construct a new Appointment object with the initial data
         Appt appt = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                 description);

         apptList.add(appt);        //add to list
         calDay1.addAppt(appt);
         CalDay calday2 = new CalDay();

         assertEquals(apptList, calDay1.getAppts());

	 }
//add more unit tests as you needed

    @Test
    public void testToString() {
        GregorianCalendar day1 = new GregorianCalendar(2018, 2, 14);
        CalDay calDay1 = new CalDay(day1);
        assertTrue(calDay1.isValid());

        LinkedList<Appt> apptList = new LinkedList<Appt>();
        int startHour=14;
        int startMinute=30;
        int startDay=02;
        int startMonth=12;
        int startYear=2018;
        String title="Class";
        String description="Rescheduled class.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        apptList.add(appt);        //add to list

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

        startHour = 2;
        startMinute = 1;
        startDay = 02;
        startMonth = 12;
        startYear = 2018;
        title = "Event3";
        description = "This is the description";
        //Construct a new Appointment object with the initial data
        Appt appt3 = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        apptList.add(appt2);
        apptList.add(appt3);

        calDay1.addAppt(appt);
        calDay1.addAppt(appt);

        Iterator<?> itr = calDay1.iterator();

        calDay1.addAppt(appt2);
        calDay1.addAppt(appt3);
    }

    @Test
    public void testToString2() {
        GregorianCalendar day1 = new GregorianCalendar(2018, 2, 14);
        CalDay calDay1 = new CalDay(day1);
        assertTrue(calDay1.isValid());

        LinkedList<Appt> apptList = new LinkedList<Appt>();
        int startHour=14;
        int startMinute=30;
        int startDay=02;
        int startMonth=12;
        int startYear=2018;
        String title="Class";
        String description="Rescheduled class.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        apptList.add(appt);
        calDay1.addAppt(appt);
        String stringified = calDay1.toString();
        assertEquals(1,calDay1.getSizeAppts());
        assertEquals("\t --- 2/14/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t12/2/2018 at 2:30pm ,Class, Rescheduled class.\n" +
                " \n",stringified);

    }
}
