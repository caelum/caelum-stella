package br.com.caelum.stella.faces.validation;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

/**
 * <p>Busca o arquivo de mensagens configurado no faces-config.xml: </p>
 * <pre>
 * &lt;application&gt;
 *   &lt;message-bundle&gt;messages&lt;/message-bundle&gt;
 * &lt;/application&gt;
 * </pre>
 * 
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

    /**
     * Encontra o ResourceBundle para o Locale da &aacute;rvore de componentes
     * (UIViewRoot) atual.
     * 
     * @param facesContext FacesContext atual.
     * @return {@link ResourceBundle} atual.
     */
    public ResourceBundle getForCurrentLocale(FacesContext facesContext) {
        Application application = facesContext.getApplication();
        String bundleName = application.getMessageBundle();
        if (bundleName == null) {
            return defaultStellaBundle();
        }
        Locale locale = facesContext.getViewRoot().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
        return bundle;
    }

    private ResourceBundle defaultStellaBundle() {
        if (STELLA_MESSAGES == null) {
            STELLA_MESSAGES = ResourceBundle.getBundle("StellaMessages", new Locale("pt", "BR"));
        }
        return STELLA_MESSAGES;
    }
}
