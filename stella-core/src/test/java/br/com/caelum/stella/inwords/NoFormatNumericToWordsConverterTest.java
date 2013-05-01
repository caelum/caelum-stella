package br.com.caelum.stella.inwords;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 */
public class NoFormatNumericToWordsConverterTest {

    private final NumericToWordsConverter converter = new NumericToWordsConverter(new InteiroSemFormato());

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
        assertEquals("nove quintilhões, duzentos e vinte e três quatrilhões,"
                + " trezentos e setenta e dois trilhões, trinta e seis bilhões,"
                + " oitocentos e cinquenta e quatro milhões, setecentos e setenta"
                + " e cinco mil e oitocentos e sete", actual);
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
        assertEquals("um", actual);
    }

    @Test
    public void shouldTransform2InWords() {
        double two = 2;
        String actual = converter.toWords(two);
        assertEquals("dois", actual);
    }

    @Test
    public void shouldTransform14InWords() {
        double fourteen = 14;
        String actual = converter.toWords(fourteen);
        assertEquals("quatorze", actual);
    }

    @Test
    public void shouldTransform53InWordsUsingAnd() {
        double fiftyThree = 53;
        String actual = converter.toWords(fiftyThree);
        assertEquals("cinquenta e três", actual);
    }

    @Test
    public void shouldTransform99InWordsUsingAnd() {
        double ninetyNine = 99;
        String actual = converter.toWords(ninetyNine);
        assertEquals("noventa e nove", actual);
    }

    @Test
    public void shouldTransformOneHundredInWords() {
        double oneHundred = 100;
        String actual = converter.toWords(oneHundred);
        assertEquals("cem", actual);
    }

    @Test
    public void shouldTransform101InWordsUsingAnd() {
        double oneHundredAndOne = 101;
        String actual = converter.toWords(oneHundredAndOne);
        assertEquals("cento e um", actual);
    }

    @Test
    public void shouldTransform199InWordsUsingAnd() {
        double oneHundredAndNinetyNine = 199;
        String actual = converter.toWords(oneHundredAndNinetyNine);
        assertEquals("cento e noventa e nove", actual);
    }

    @Test
    public void shouldTransform200InWords() {
        double twoHundred = 200;
        String actual = converter.toWords(twoHundred);
        assertEquals("duzentos", actual);
    }

    @Test
    public void shouldTransform201InWords() {
        double twoHundredAndOne = 201;
        String actual = converter.toWords(twoHundredAndOne);
        assertEquals("duzentos e um", actual);
    }

    @Test
    public void shouldTransform999InWords() {
        double nineHundredNinetyNine = 999;
        String actual = converter.toWords(nineHundredNinetyNine);
        assertEquals("novecentos e noventa e nove", actual);
    }

    @Test
    public void shouldTransformThousandInWords() {
        double thousand = 1000;
        String actual = converter.toWords(thousand);
        assertEquals("um mil", actual);
    }

    @Test
    public void shouldTransform1001InWords() {
        double oneThousandAndOne = 1001;
        String actual = converter.toWords(oneThousandAndOne);
        assertEquals("um mil e um", actual);
    }

    @Test
    public void shouldTransformThousandInWordsUsingAnd() {
        double thousand = 1031;
        String actual = converter.toWords(thousand);
        assertEquals("um mil e trinta e um", actual);
    }

    @Test
    public void shouldTransformAMillionIntoNumberInWordsUsingSingular() {
        double oneMillion = 1000000;
        String actual = converter.toWords(oneMillion);
        assertEquals("um milhão", actual);
    }

    @Test
    public void shouldTransformAMillionIntoNumberInWordsUsingAnd() {
        double twoHundred = 1000150.99;
        String actual = converter.toWords(twoHundred);
        assertEquals("um milhão e cento e cinquenta e um", actual);
    }

    @Test
    public void shouldTransformAMillionAndThousandIntoNumberInWordsUsingAnd() {
        double twoHundred = 1023850;
        String actual = converter.toWords(twoHundred);
        assertEquals("um milhão, vinte e três mil e oitocentos e cinquenta", actual);
    }

    @Test
    public void shouldTransformTwoMillionUsingPlural() {
        double twoHundred = 2e6;
        String actual = converter.toWords(twoHundred);
        assertEquals("dois milhões", actual);
    }

    @Test
    public void shouldTransformANumberInWordsUsingFraction() {
        double twoHundred = 222;
        String actual = converter.toWords(twoHundred);
        assertEquals("duzentos e vinte e dois", actual);
    }

    @Test
    public void shouldTransform1E21() {
        double number = 1E21;
        String actual = converter.toWords(number);
        assertEquals("um sextilhão", actual);
    }

    @Test
    public void shouldTransform2E21() {
        double number = 2E21;
        String actual = converter.toWords(number);
        assertEquals("dois sextilhões", actual);
    }

    @Test
    public void shouldTransform1E24() {
        double number = 1E24;
        String actual = converter.toWords(number);
        assertEquals("um septilhão", actual);
    }

    @Test
    public void shouldTransform2E24() {
        double number = 2E24;
        String actual = converter.toWords(number);
        assertEquals("dois septilhões", actual);
    }

    @Test
    public void shouldTransform1E27() {
        double number = 1E27;
        String actual = converter.toWords(number);
        assertEquals("um octilhão", actual);
    }

    @Test
    public void shouldTransform2E27() {
        double number = 2E27;
        String actual = converter.toWords(number);
        assertEquals("dois octilhões", actual);
    }

    @Test
    public void shouldTransform1E30() {
        double number = 1E30;
        String actual = converter.toWords(number);
        assertEquals("um nonilhão", actual);
    }

    @Test
    public void shouldTransform2E30() {
        double number = 2E30;
        String actual = converter.toWords(number);
        assertEquals("dois nonilhões", actual);
    }

    @Test
    public void shouldTransform1E33() {
        double number = 1E33;
        String actual = converter.toWords(number);
        assertEquals("um decilhão", actual);
    }

    @Test
    public void shouldTransform2E33() {
        double number = 2E33;
        String actual = converter.toWords(number);
        assertEquals("dois decilhões", actual);
    }

    @Test
    public void shouldTransform1E36() {
        double number = 1E36;
        String actual = converter.toWords(number);
        assertEquals("um undecilhão", actual);
    }

    @Test
    public void shouldTransform2E36() {
        double number = 2E36;
        String actual = converter.toWords(number);
        assertEquals("dois undecilhões", actual);
    }

    @Test
    public void shouldTransform1E39() {
        double number = 1E39;
        String actual = converter.toWords(number);
        assertEquals("um doudecilhão", actual);
    }

    @Test
    public void shouldTransform2E39() {
        double number = 2E39;
        String actual = converter.toWords(number);
        assertEquals("dois doudecilhões", actual);
    }

    @Test
    public void shouldTransform1E42() {
        double number = 1E42;
        String actual = converter.toWords(number);
        assertEquals("um tredecilhão", actual);
    }

    @Test
    public void shouldTransform2E42() {
        double number = 2E42;
        String actual = converter.toWords(number);
        assertEquals("dois tredecilhões", actual);
    }
}
