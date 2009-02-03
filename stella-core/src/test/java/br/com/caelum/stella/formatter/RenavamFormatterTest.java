package br.com.caelum.stella.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.stella.format.RenavamFormatter;

public class RenavamFormatterTest {

    private RenavamFormatter formatter = new RenavamFormatter();

    @Test
    public void shouldFormatAnUnformattedRenavam() {
        String formattedRenavam = formatter.format("736407677");
        assertEquals("73.640767-7", formattedRenavam);
    }

    @Test
    public void shouldUnformatAFormattedRenavam() {
        String unformattedRenavam = formatter.unformat("73.640767-7");
        assertEquals("736407677", unformattedRenavam);
    }
}
