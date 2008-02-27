package br.com.caelum.stella.faces;

import java.util.Locale;
import java.util.ResourceBundle;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleValidationMessage;
import br.com.caelum.stella.ValidationMessage;

/**
 * The name property from Enum (lowercased) is used as key to retrieve the
 * actual message from MessageBundles.
 *
 * @Author Fabio Kung
 */
@SuppressWarnings("unchecked")
public class ResourceBundleMessageProducer<T extends Enum> implements MessageProducer<T> {
    private final ResourceBundle bundle;

    public ResourceBundleMessageProducer(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public ValidationMessage getMessage(T error) {
        Locale locale = bundle.getLocale();
        String simpleName = error.getClass().getSimpleName();
		String errorName = error.toString();
		String key = (simpleName + "." + errorName);
		String message = bundle.getString(key.toLowerCase(locale));
        return new SimpleValidationMessage(message);
    }
}
