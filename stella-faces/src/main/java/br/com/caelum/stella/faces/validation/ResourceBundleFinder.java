package br.com.caelum.stella.faces.validation;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Busca o arquivo de mensagens configurado no faces-config.xml:
 * <p/>
 * <code><pre>
 * &lt;application&gt;
 *   &lt;message-bundle&gt;messages&lt;/message-bundle&gt;
 * &lt;/application&gt;
 * </pre></code>
 * <p/>
 * <p>
 * Caso não haja nenhum arquivo de mensagens configurado no faces-config.xml,
 * será usado o arquivo padrão de mensagens contido no stella-faces
 * (StellaMessages.properties), com mensagens padrão.
 * </p>
 *
 * @author Fabio Kung
 */
public class ResourceBundleFinder {
    private static ResourceBundle STELLA_MESSAGES;

    public ResourceBundle getForCurrentLocale(FacesContext facesContext) {
        Application application = facesContext.getApplication();
        String bundleName = application.getMessageBundle();
        Locale locale = facesContext.getViewRoot().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);

        if (bundle == null) {
            bundle = defaultStellaBundle();
        }

        return bundle;
    }

    private ResourceBundle defaultStellaBundle() {
        if (STELLA_MESSAGES == null) {
            STELLA_MESSAGES = ResourceBundle.getBundle("StellaMessages", new Locale("pt", "BR"));
        }
        return STELLA_MESSAGES;
    }
}
