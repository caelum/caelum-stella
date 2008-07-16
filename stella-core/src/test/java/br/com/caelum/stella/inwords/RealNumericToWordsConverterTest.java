package br.com.caelum.stella.inwords;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 *
 */
public class RealNumericToWordsConverterTest {

    private NumericToWordsConverter converter = new NumericToWordsConverter(
            new FormatoDeReal());

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
        assertEquals("um real", actual);
    }

    @Test
    public void shouldTransform2InWords() {
        double two = 2;
        String actual = converter.toWords(two);
        ;
        assertEquals("dois reais", actual);
    }

    @Test
    public void shouldTransform14InWords() {
        double fourteen = 14;
        String actual = converter.toWords(fourteen);
        ;
        assertEquals("quatorze reais", actual);
    }

    @Test
    public void shouldTransform53InWordsUsingAnd() {
        double fiftyThree = 53;
        String actual = converter.toWords(fiftyThree);
        ;
        assertEquals("cinquenta e três reais", actual);
    }

    @Test
    public void shouldTransformOneHundredInWords() {
        double oneHundred = 100;
        String actual = converter.toWords(oneHundred);
        ;
        assertEquals("cem reais", actual);
    }

    @Test
    public void shouldTransformOneHundredInWordsUsingAnd() {
        double oneHundredAndNine = 109;
        String actual = converter.toWords(oneHundredAndNine);
        assertEquals("cento e nove reais", actual);
    }

    @Test
    public void shouldTransformTwoHundredInWords() {
        double twoHundred = 200;
        String actual = converter.toWords(twoHundred);
        ;
        assertEquals("duzentos reais", actual);
    }

    @Test
    public void shouldTransformThousandInWords() {
        double thousand = 1000;
        String actual = converter.toWords(thousand);
        ;
        assertEquals("mil reais", actual);
    }

    @Test
    public void shouldTransformThousandInWordsUsingAnd() {
        double thousand = 1031;
        String actual = converter.toWords(thousand);
        ;
        assertEquals("mil e trinta e um reais", actual);
    }

    @Test
    public void shouldTransformAMillionIntoNumberInWords() {
        double oneMillion = 1000000;
        String actual = converter.toWords(oneMillion);
        ;
        assertEquals("um milhão de reais", actual);
    }

    @Test
    public void shouldTransformAMillionIntoNumberInWordsUsingAnd() {
        double twoHundred = 1000150.99;
        String actual = converter.toWords(twoHundred);
        assertEquals(
                "um milhão e cento e cinquenta reais e noventa e nove centavos",
                actual);
    }

    @Test
    public void shouldTransformAMillionAndThousandIntoNumberInWordsUsingAnd() {
        double twoHundred = 1023850;
        String actual = converter.toWords(twoHundred);
        ;
        assertEquals(
                "um milhão, vinte e três mil e oitocentos e cinquenta reais",
                actual);
    }

    @Test
    public void shouldTransformANumberInWordsUsingFraction() {
        double twoHundred = 0.22;
        String actual = converter.toWords(twoHundred);
        assertEquals("vinte e dois centavos", actual);
    }

    @Test
    public void shouldTransformOneDecimalWords() {
        double oneDecimal = 0.1;
        String actual = converter.toWords(oneDecimal);
        assertEquals("dez centavos", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldTruncAndTransformANumberInWordsUsingFraction() {
        double twoHundred = 0.229;
        converter.toWords(twoHundred);
    }
    
    @Test()
    public void shouldTransformAThousandAndOne() {
        double number = 1001;
        String words = converter.toWords(number);
        assertEquals("mil e um reais", words);
    }
    
    @Test()
    public void shouldTransformAMillionAndOne() {
        double number = 1000001;
        String words = converter.toWords(number);
        assertEquals("um milhão e um reais", words);
    }

}
