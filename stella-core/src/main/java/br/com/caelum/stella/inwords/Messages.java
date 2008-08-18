package br.com.caelum.stella.inwords;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Victor Santos
 * 
 */
public final class Messages {
    private static final String BUNDLE_NAME = "br.com.caelum.stella.inwords.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(BUNDLE_NAME);

    private Messages() {
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
