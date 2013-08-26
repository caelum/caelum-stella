package br.com.caelum.stella.inwords;

import br.com.caelum.stella.annotations.GwtCompatible;

import java.util.ResourceBundle;

/**
 * @author Victor Santos
 * 
 */
@GwtCompatible(emulated = true)
public final class Messages {
    private static final String BUNDLE_NAME = "br.com.caelum.stella.inwords.messages";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private Messages() {
    }

    public static String getString(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
