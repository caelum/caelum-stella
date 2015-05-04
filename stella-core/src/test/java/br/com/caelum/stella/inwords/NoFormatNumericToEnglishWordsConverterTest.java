package br.com.caelum.stella.inwords;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

/**
 * <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class NoFormatNumericToEnglishWordsConverterTest {

    private final NumericToWordsConverter converter = new NumericToWordsConverter(new InteiroSemFormato(), Locale.ENGLISH);

    @Test(expected = IllegalArgumentException.class)
    public void shouldTransformNegativXeLong() {
        long negative = -1;
        converter.toWords(negative);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotTransformNegativeDouble() {
        double negative = -1;
        converter.toWords(negative);
    }

    @Test
    public void shouldTransformMaxLong() {
        long max = Long.MAX_VALUE;
        String actual = converter.toWords(max);
        assertEquals("nine quintillion, two hundred and twenty-three quadrillion,"
                + " three hundred and seventy-two trillion, thirty-six billion,"
                + " eight hundred and fifty-four million, seven hundred and seventy-five thousand and"
                + " eight hundred and seven", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotTransformAMissingResource() {
        double max = Double.MAX_VALUE;
        converter.toWords(max);
    }

    @Test
    public void shouldTransform0InWords() {
        double zero = 0;
        String actual = converter.toWords(zero);
        assertEquals("zero", actual);
    }

    @Test
    public void shouldTransform1InWords() {
        double one = 1;
        String actual = converter.toWords(one);
        assertEquals("one", actual);
    }

    @Test
    public void shouldTransform2InWords() {
        double two = 2;
        String actual = converter.toWords(two);
        assertEquals("two", actual);
    }

    @Test
    public void shouldTransform14InWords() {
        double fourteen = 14;
        String actual = converter.toWords(fourteen);
        assertEquals("fourteen", actual);
    }

    @Test
    public void shouldTransform53InWordsUsingAnd() {
        double fiftyThree = 53;
        String actual = converter.toWords(fiftyThree);
        assertEquals("fifty-three", actual);
    }

    @Test
    public void shouldTransform99InWordsUsingAnd() {
        double ninetyNine = 99;
        String actual = converter.toWords(ninetyNine);
        assertEquals("ninety-nine", actual);
    }

    @Test
    public void shouldTransformOneHundredInWords() {
        double oneHundred = 100;
        String actual = converter.toWords(oneHundred);
        assertEquals("one hundred", actual);
    }

    @Test
    public void shouldTransform101InWordsUsingAnd() {
        double oneHundredAndOne = 101;
        String actual = converter.toWords(oneHundredAndOne);
        assertEquals("one hundred and one", actual);
    }

    @Test
    public void shouldTransform199InWordsUsingAnd() {
        double oneHundredAndNinetyNine = 199;
        String actual = converter.toWords(oneHundredAndNinetyNine);
        assertEquals("one hundred and ninety-nine", actual);
    }

    @Test
    public void shouldTransform200InWords() {
        double twoHundred = 200;
        String actual = converter.toWords(twoHundred);
        assertEquals("two hundred", actual);
    }

    @Test
    public void shouldTransform201InWords() {
        double twoHundredAndOne = 201;
        String actual = converter.toWords(twoHundredAndOne);
        assertEquals("two hundred and one", actual);
    }

    @Test
    public void shouldTransform999InWords() {
        double nineHundredNinetyNine = 999;
        String actual = converter.toWords(nineHundredNinetyNine);
        assertEquals("nine hundred and ninety-nine", actual);
    }

    @Test
    public void shouldTransformThousandInWords() {
        double thousand = 1000;
        String actual = converter.toWords(thousand);
        assertEquals("one thousand", actual);
    }

    @Test
    public void shouldTransform1001InWords() {
        double oneThousandAndOne = 1001;
        String actual = converter.toWords(oneThousandAndOne);
        assertEquals("one thousand and one", actual);
    }

    @Test
    public void shouldTransformThousandInWordsUsingAnd() {
        double thousand = 1031;
        String actual = converter.toWords(thousand);
        assertEquals("one thousand and thirty-one", actual);
    }

    @Test
    public void shouldTransformAMillionIntoNumberInWordsUsingSingular() {
        double oneMillion = 1000000;
        String actual = converter.toWords(oneMillion);
        assertEquals("one million", actual);
    }

    @Test
    public void shouldTransformAMillionIntoNumberInWordsUsingAnd() {
        double twoHundred = 1000150.99;
        String actual = converter.toWords(twoHundred);
        assertEquals("one million and one hundred and fifty-one", actual);
    }

    @Test
    public void shouldTransformAMillionAndThousandIntoNumberInWordsUsingAnd() {
        double twoHundred = 1023850;
        String actual = converter.toWords(twoHundred);
        assertEquals("one million, twenty-three thousand and eight hundred and fifty", actual);
    }

    @Test
    public void shouldTransformTwoMillionUsingPlural() {
        double twoHundred = 2e6;
        String actual = converter.toWords(twoHundred);
        assertEquals("two million", actual);
    }

    @Test
    public void shouldTransformANumberInWordsUsingFraction() {
        double twoHundred = 222;
        String actual = converter.toWords(twoHundred);
        assertEquals("two hundred and twenty-two", actual);
    }

    @Test
    public void shouldTransform1E21() {
        double number = 1E21;
        String actual = converter.toWords(number);
        assertEquals("one sextillion", actual);
    }

    @Test
    public void shouldTransform2E21() {
        double number = 2E21;
        String actual = converter.toWords(number);
        assertEquals("two sextillion", actual);
    }

    @Test
    public void shouldTransform1E24() {
        double number = 1E24;
        String actual = converter.toWords(number);
        assertEquals("one septillion", actual);
    }

    @Test
    public void shouldTransform2E24() {
        double number = 2E24;
        String actual = converter.toWords(number);
        assertEquals("two septillion", actual);
    }

    @Test
    public void shouldTransform1E27() {
        double number = 1E27;
        String actual = converter.toWords(number);
        assertEquals("one octillion", actual);
    }

    @Test
    public void shouldTransform2E27() {
        double number = 2E27;
        String actual = converter.toWords(number);
        assertEquals("two octillion", actual);
    }

    @Test
    public void shouldTransform1E30() {
        double number = 1E30;
        String actual = converter.toWords(number);
        assertEquals("one nonillion", actual);
    }

    @Test
    public void shouldTransform2E30() {
        double number = 2E30;
        String actual = converter.toWords(number);
        assertEquals("two nonillion", actual);
    }

    @Test
    public void shouldTransform1E33() {
        double number = 1E33;
        String actual = converter.toWords(number);
        assertEquals("one decillion", actual);
    }

    @Test
    public void shouldTransform2E33() {
        double number = 2E33;
        String actual = converter.toWords(number);
        assertEquals("two decillion", actual);
    }

    @Test
    public void shouldTransform1E36() {
        double number = 1E36;
        String actual = converter.toWords(number);
        assertEquals("one undecillion", actual);
    }

    @Test
    public void shouldTransform2E36() {
        double number = 2E36;
        String actual = converter.toWords(number);
        assertEquals("two undecillion", actual);
    }

    @Test
    public void shouldTransform1E39() {
        double number = 1E39;
        String actual = converter.toWords(number);
        assertEquals("one duodecillion", actual);
    }

    @Test
    public void shouldTransform2E39() {
        double number = 2E39;
        String actual = converter.toWords(number);
        assertEquals("two duodecillion", actual);
    }

    @Test
    public void shouldTransform1E42() {
        double number = 1E42;
        String actual = converter.toWords(number);
        assertEquals("one tredecillion", actual);
    }

    @Test
    public void shouldTransform2E42() {
        double number = 2E42;
        String actual = converter.toWords(number);
        assertEquals("two tredecillion", actual);
    }
}
