package br.com.caelum.stella.inwords;

import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
public class IntegerNumericToWordsConverterPT_BR_Test extends IntegerNumericToWordsConverterTest {

    private static Locale defaultLocale;

    @BeforeClass
    public static void setPT_BR_Locale() {
        defaultLocale = Locale.getDefault();
        Locale.setDefault(new Locale("PT", "br"));
    }

    @AfterClass
    public static void setDefaultLocale() {
        Locale.setDefault(defaultLocale);
    }

}
