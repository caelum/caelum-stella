package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;
import java.util.GregorianCalendar;

class CalendarToStringConverter {

    public String convertDateToString(final Calendar calendar) {
        String format = "%tF";
        return String.format(format, calendar);
    }

    public String convertDateTimeToString(final GregorianCalendar calendar) {
        String format = "%tFT%1$tT";
        return String.format(format, calendar);
    }

}
