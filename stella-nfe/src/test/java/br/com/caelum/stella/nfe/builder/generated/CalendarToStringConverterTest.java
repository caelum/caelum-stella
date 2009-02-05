package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;


public class CalendarToStringConverterTest {

    @Test
    public void shouldReturnDateFormattedString() {
        CalendarToStringConverter converter = new CalendarToStringConverter();
        String actual = converter.convertDateToString(new GregorianCalendar(1984, Calendar.NOVEMBER, 29));
        String expected = "1984-11-29";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDateTimeFormattedString() {
        CalendarToStringConverter converter = new CalendarToStringConverter();
        GregorianCalendar calendar = new GregorianCalendar(1984, Calendar.NOVEMBER, 29);
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 42);
        String actual = converter.convertDateTimeToString(calendar);
        String expected = "1984-11-29T15:30:42";
        Assert.assertEquals(expected, actual);
    }

}
