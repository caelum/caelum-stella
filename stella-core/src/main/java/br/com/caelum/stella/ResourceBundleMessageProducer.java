package br.com.caelum.stella;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * The name property from Enum (lowercased) is used as key to retrieve the
 * actual message from MessageBundles.
 *
 * @author Fabio Kung
 */
@SuppressWarnings("unchecked")
public class ResourceBundleMessageProducer<T extends Enum> implements MessageProducer<T> {
    private final ResourceBundle bundle;

    public ResourceBundleMessageProducer(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public ValidationMessage getMessage(T error) {
        Locale locale = bundle.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String simpleName = error.getClass().getSimpleName();
        String errorName = error.toString();
        String key = (simpleName + "." + errorName);
        String message;
        try {
            message = bundle.getString(key.toLowerCase(locale));
        } catch (MissingResourceException ex) {
            message = key.toLowerCase(locale).replaceFirst("[.]", " : ").replaceAll("_", " ");
        }
        return new SimpleValidationMessage(message);
    }
}
