package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
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
         assertEquals(apptList, calDay1.getAppts());

	 }
//add more unit tests as you needed	
}
