package br.com.caelum.stella.inwords;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class DolarNumericToWordsConverterTest {
    private final NumericToWordsConverter converter = new NumericToWordsConverter(new FormatoDeDolar(), Locale.ENGLISH);

    @Test
    public void shouldTransform0InWords() {
        double zero = 0;
        String actual = converter.toWords(zero);
        assertEquals("zero", actual);
    }

    @Test
    public void shouldTransformLongZeroInWords() {
        long zero = 0;
        String actual = converter.toWords(zero);
        assertEquals("zero", actual);
    }

    @Test
    public void shouldTransform1InWords() {
        double one = 1.0;
        String actual = converter.toWords(one);
        assertEquals("one dollar", actual);
    }

    @Test
    public void shouldTransformLongOneInWords() {
        long one = 1L;
        String actual = converter.toWords(one);
        assertEquals("one dollar", actual);
    }

    @Test
    public void shouldTransformOneCentInWords() {
        double val = 0.01;
        String actual = converter.toWords(val);
        assertEquals("one cent", actual);
    }

    @Test
    public void shouldTransformDoubleOneWithCentsInWords() {
        double val = 1.65;
        String actual = converter.toWords(val);
        assertEquals("one dollar and sixty-five cents", actual);
    }

    @Test
    public void shouldTransform2InWords() {
        double two = 2;
        String actual = converter.toWords(two);
        assertEquals("two dollars", actual);
    }

    @Test
    public void shouldTransform14InWords() {
        double fourteen = 14;
        String actual = converter.toWords(fourteen);
        assertEquals("fourteen dollars", actual);
    }

    @Test
    public void shouldTransform53InWordsUsingAnd() {
        double fiftyThree = 53;
        String actual = converter.toWords(fiftyThree);
        assertEquals("fifty-three dollars", actual);
    }

    @Test
    public void shouldTransformOneHundredInWords() {
        double oneHundred = 100;
        String actual = converter.toWords(oneHundred);
        assertEquals("one hundred dollars", actual);
    }

    @Test
    public void shouldTransformOneHundredInWordsUsingAnd() {
        double oneHundredAndNine = 109;
        String actual = converter.toWords(oneHundredAndNine);
        assertEquals("one hundred and nine dollars", actual);
    }

    @Test
    public void shouldTransformTwoHundredInWords() {
        double twoHundred = 200;
        String actual = converter.toWords(twoHundred);
        assertEquals("two hundred dollars", actual);
    }

    @Test
    public void shouldTransformThousandInWords() {
        double thousand = 1000;
        String actual = converter.toWords(thousand);
        assertEquals("one thousand dollars", actual);
    }

    @Test
    public void shouldTransformThousandInWordsUsingAnd() {
        double thousand = 1031;
        String actual = converter.toWords(thousand);
        assertEquals("one thousand and thirty-one dollars", actual);
    }

    @Test
    public void shouldTransformAMillionIntoNumberInWords() {
        double oneMillion = 1000000;
        String actual = converter.toWords(oneMillion);
        assertEquals("one million dollars", actual);
    }

    @Test
    public void shouldTransformAMillionIntoNumberInWordsUsingAnd() {
        double twoHundred = 1000150.99;
        String actual = converter.toWords(twoHundred);
        assertEquals("one million and one hundred and fifty dollars and ninety-nine cents", actual);
    }

    @Test
    public void shouldTransformAMillionAndThousandIntoNumberInWordsUsingAnd() {
        double twoHundred = 1023850;
        String actual = converter.toWords(twoHundred);
        assertEquals("one million, twenty-three thousand and eight hundred and fifty dollars", actual);
    }

    @Test
    public void shouldTransformANumberInWordsUsingFraction() {
        double twoHundred = 0.22;
        String actual = converter.toWords(twoHundred);
        assertEquals("twenty-two cents", actual);
    }

    @Test
    public void shouldTransformOneDecimalWords() {
        double oneDecimal = 0.1;
        String actual = converter.toWords(oneDecimal);
        assertEquals("ten cents", actual);
    }

    @Test
    public void shouldRoundAndTransformANumberInWordsUsingFraction() {
        double twoHundred = 0.229;
        String words = converter.toWords(twoHundred);
        assertEquals("twenty-three cents", words);
    }

    @Test
    public void shouldTransformAThousandAndOne() {
        double number = 1001;
        String words = converter.toWords(number);
        assertEquals("one thousand and one dollars", words);
    }

    @Test
    public void shouldTransformAMillionAndOne() {
        double number = 1000001;
        String words = converter.toWords(number);
        assertEquals("one million and one dollars", words);
    }

    @Test
    public void shouldTransformABillion() {
        double number = 1E9;
        String words = converter.toWords(number);
        assertEquals("one billion dollars", words);
    }

    @Test
    public void shouldTransform1000000000000000001AsLong() {
        long number = (1000000000000000001L);
        String words = converter.toWords(number);
        assertEquals("one quintillion and one dollars", words);
    }

    @Test
    public void shouldTransform999999999999999L() {
        long number = 999999999999999L;
        String words = converter.toWords(number);
        assertEquals("nine hundred and ninety-nine trillion, " + "nine hundred and ninety-nine billion, "
                + "nine hundred and ninety-nine million, " + "nine hundred and ninety-nine thousand and "
                + "nine hundred and ninety-nine dollars", words);
    }

}
