package br.com.caelum.stella.inwords;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author leobessa
 *
 */
public class DimensionlessNumericToWordsConverterTest {

    NumericCardinalToWordsConverter converter = new DimensionlessNumericToWordsConverter();
    
    @Test
    public void shouldTransformZeroInWords() {
        double zero = 0;
        String actual = converter.toWords(zero);;
        assertEquals("zero", actual);
    }
    
    @Test
    public void shouldTransformOneInWords() {
        double one = 1;
        String actual = converter.toWords(one);;
        assertEquals("um", actual);
    }
    
    @Test
    public void shouldTransformTwoInWords() {
        double two = 2;
        String actual = converter.toWords(two);;
        assertEquals("dois", actual);
    }
    
    @Test
    public void shouldTransformThousandInWords() {
        double thousand = 1000;
        String actual = converter.toWords(thousand);;
        assertEquals("mil", actual);
    }
    
    @Test
    public void shouldTransformTwoHundredInWords() {
        double twoHundred = 200;
        String actual = converter.toWords(twoHundred);;
        assertEquals("duzentos", actual);
    }
    
    @Test
    public void shouldTransformBigNumberInWords() {
        double twoHundred = 1000150.99;
        String actual = converter.toWords(twoHundred);;
        assertEquals("um milhão e cento e cinquenta e novecentos e noventa milésimos", actual);
    }
}
