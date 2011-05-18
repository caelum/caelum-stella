package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertNotNull;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import br.com.caelum.stella.ResourceBundleMessageProducer;
import br.com.caelum.stella.validation.InvalidValue;
import br.com.caelum.stella.validation.error.CNPJError;
import br.com.caelum.stella.validation.error.CPFError;
import br.com.caelum.stella.validation.error.IEError;
import br.com.caelum.stella.validation.error.NITError;

/**
 * @author Fabio Kung
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class StellaMessagesTest {
	private static final Class[] ERROR_CLASSES = { CNPJError.class, CPFError.class, IEError.class, NITError.class };

    @Test
    public void deveConterMensagensPadraoParaTodosOsErrosPossiveis() throws Exception {
        Locale locale = new Locale("pt", "BR");
        ResourceBundle messages = ResourceBundle.getBundle("StellaMessages", locale);
        ResourceBundleMessageProducer producer = new ResourceBundleMessageProducer(messages);
        
        for (Class c : ERROR_CLASSES) {
			InvalidValue[] errors = (InvalidValue[]) c.getMethod("values").invoke(null);
            for (InvalidValue error : errors) {
                String errorKey = producer.messageKeyFor(locale, c, error);
                assertNotNull(messages.getString(errorKey));
            }
        }
    }
}
