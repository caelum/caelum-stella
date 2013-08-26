package br.com.caelum.stella.inwords;

import br.com.caelum.stella.annotations.GwtCompatible;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.resources.client.ClientBundle;

import java.util.ResourceBundle;

/**
 * Portabilidade da classe original para o GWT
 *
 * @author Danilo Reinert
 * @author Victor Santos
 *
 */
@GwtCompatible(emulated = true)
public final class Messages {

    private static final MessagesBundle RESOURCE_BUNDLE = GWT.create(MessagesBundle.class);

    private Messages() {
    }

    public static String getString(String key) {
        key = key.replace(".", "_").replace("+?","_op");
        return RESOURCE_BUNDLE.getString(key);
    }
}
