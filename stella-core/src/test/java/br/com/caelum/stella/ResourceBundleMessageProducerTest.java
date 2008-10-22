package br.com.caelum.stella;

import static org.junit.Assert.assertEquals;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.junit.Test;

import br.com.caelum.stella.validation.InvalidValue;

/**
 * @author Fabio Kung
 */
public class ResourceBundleMessageProducerTest {
    enum Errors implements InvalidValue {
        ANY, OTHER, WITH_COMPOSITE_NAME;
    }

    @Test
    public void shouldUseEnumNameLowerCasedAsKey() {
        final String errorMessage = "message for ANY error";
        ResourceBundle bundleMock = new ResourceBundle() {
            protected Object handleGetObject(final String s) {
                String errorKey = (MessageFormat.format("{0}.{1}", Errors.class.getSimpleName(),
                        Errors.WITH_COMPOSITE_NAME.name())).toLowerCase();
                if (s.equals(errorKey)) {
                    return errorMessage;
                }
                return null;
            }

            public Enumeration<String> getKeys() {
                return null;
            }

            public Locale getLocale() {
                return Locale.getDefault();
            }
        };

        ResourceBundleMessageProducer producer = new ResourceBundleMessageProducer(bundleMock);
        ValidationMessage validationMessage = producer.getMessage(Errors.WITH_COMPOSITE_NAME);
        assertEquals(errorMessage, validationMessage.getMessage());
    }

    @Test
    public void shouldReturnMessageWhenKeyIsMissingInResourceBundle() {

        ResourceBundle bundleMock = new ResourceBundle() {
            protected Object handleGetObject(String s) {
                throw new MissingResourceException(null, null, null);
            }

            public Enumeration<String> getKeys() {
                return null;
            }

            public Locale getLocale() {
                return Locale.getDefault();
            }
        };

        ResourceBundleMessageProducer producer = new ResourceBundleMessageProducer(bundleMock);
        ValidationMessage validationMessage = producer.getMessage(Errors.WITH_COMPOSITE_NAME);
        assertEquals("errors : with composite name", validationMessage.getMessage());

    }

}
