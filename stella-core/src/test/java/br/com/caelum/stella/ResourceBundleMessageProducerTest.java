package br.com.caelum.stella;

import br.com.caelum.stella.ResourceBundleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.text.MessageFormat;

/**
 * @author Fabio Kung
 */
public class ResourceBundleMessageProducerTest {
    enum Errors {
        ANY, OTHER, WITH_COMPOSITE_NAME;
    }

    @Test
    public void shouldUseEnumNameLowerCasedAsKey() {
        final String errorMessage = "message for ANY error";
        ResourceBundle bundleMock = new ResourceBundle() {
            protected Object handleGetObject(String s) {
                String errorKey = (MessageFormat.format("{0}.{1}",
                        Errors.class.getSimpleName(),
                        Errors.WITH_COMPOSITE_NAME.name()))
                            .toLowerCase();
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

        ResourceBundleMessageProducer<Errors> producer = new ResourceBundleMessageProducer<Errors>(bundleMock);
        ValidationMessage validationMessage = producer.getMessage(Errors.WITH_COMPOSITE_NAME);
        assertEquals(errorMessage, validationMessage.getMessage());
    }
    
    @Test
    public void shouldReturnMessageWhenKeyIsMissingInResourceBundle() {
    	
        ResourceBundle bundleMock = new ResourceBundle() {
            protected Object handleGetObject(String s) {
               throw new MissingResourceException(null,null,null);
            }

            public Enumeration<String> getKeys() {
                return null;
            }

            public Locale getLocale() {
                return Locale.getDefault();
            }
        };
        
        ResourceBundleMessageProducer<Errors> producer = new ResourceBundleMessageProducer<Errors>(bundleMock);
        ValidationMessage validationMessage = producer.getMessage(Errors.WITH_COMPOSITE_NAME);
        assertEquals("errors : with composite name", validationMessage.getMessage());
        
    }

}
