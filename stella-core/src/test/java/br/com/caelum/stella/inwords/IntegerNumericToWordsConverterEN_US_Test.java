package br.com.caelum.stella.inwords;

import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
public class IntegerNumericToWordsConverterEN_US_Test extends IntegerNumericToWordsConverterTest {

    private static Locale defaultLocale;

    @BeforeClass
    public static void setEN_US_Locale() {
        defaultLocale = Locale.getDefault();
        Locale.setDefault(new Locale("EN", "US"));
    }

    @AfterClass
    public static void setDefaultLocale() {
        Locale.setDefault(defaultLocale);
    }

}
