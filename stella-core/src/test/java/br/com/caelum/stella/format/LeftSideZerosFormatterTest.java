package br.com.caelum.stella.format;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeftSideZerosFormatterTest {

    @Test
    public void testFormat() {
        Formatter formatter = new LeftSideZerosFormatter(14);
        String actual = formatter.format("1234567890");
        assertEquals("00001234567890", actual);
    }

    @Test
    public void testUnformat() {
        Formatter formatter = new LeftSideZerosFormatter(14);
        String actual = formatter.unformat("000567890");
        assertEquals("567890", actual);
    }

}
