package br.com.caelum.stella.nfe.fluid.converter;

import java.util.Calendar;

import net.vidageek.fluid.proxy.converter.DataConverter;

/**
 * @author jonasabreu
 * 
 */
final public class CalendarToStringConverter implements DataConverter<Calendar, String> {

    public String convert(final Calendar object) {
        return object.toString();
    }

}
