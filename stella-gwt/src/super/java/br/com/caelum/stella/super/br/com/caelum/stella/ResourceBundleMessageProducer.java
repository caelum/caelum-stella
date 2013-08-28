package br.com.caelum.stella;

import br.com.caelum.stella.annotations.GwtCompatible;
import br.com.caelum.stella.validation.InvalidValue;
import com.google.gwt.i18n.client.ConstantsWithLookup;

import java.util.MissingResourceException;

/**
 *
 * <p>
 * ResourceBlundeMessageProducer é responsável pela geração de mensagens de
 * erro. Estas mensagens são procuradas em um ConstantsWithLookup, através de uma
 * chave associada a cada erro.
 * </p>
 * <p>
 * A chave de um erro é composta do seguinte modo:
 * </p>
 * <code>
 * String key = simpleName + "_" + errorName;
 * </code>
 * <p>
 * Onde simpleName é o atributo simpleName do Enum e o errorName é o nome da
 * constante enum. Além disso, a chave é convertida em letras minúsculas.
 * </p>
 * <p>
 * Veja o exemplo:
 * </p>
 * <p>
 * A chave do erro representado por CPFError.INVALID_DIGITS é
 * cpferror_invalid_digits.
 * </p>
 *
 * <p>Portabilidade da classe original para o GWT</p>
 *
 * @author Danilo Reinert
 *
 * <p>Classe original</p>
 *
 * @author Fabio Kung
 * @author Leonardo Bessa
 * 
 */
@GwtCompatible(emulated = true)
public class ResourceBundleMessageProducer implements MessageProducer {

    private final ConstantsWithLookup bundle;

    /**
     * @param bundle
     *            ResourceBlunde que contém o mapa que associa erros as
     *            mensagens.
     */
    public ResourceBundleMessageProducer(final ConstantsWithLookup bundle) {
        this.bundle = bundle;
    }

    public ValidationMessage getMessage(InvalidValue error) {
        String key = messageKeyFor(error.getClass(), error);
        String message;
        try {
            message = bundle.getString(key);
        } catch (MissingResourceException ex) {
            message = key.replaceFirst("[.]", " : ").replaceAll("_", " ");
        }
        return new SimpleValidationMessage(message);
    }

    /**
     * A chave padrao é gerada com base no nome da classe do erro e do nome do
     * erro, sempre minúscula.
     * 
     * <p>
     * Ex.:
     * <ul>
     * <li>classe do erro: CPFError</li>
     * <li>nome do erro: INVALID_DIGITS</li>
     * </ul>
     * 
     * Chave gerada: <b>cpferror_invalid_digits</b>.
     * </p>
     * 
     * @param errorClass
     * @param error
     * @return chave que representa o erro a ser usada para recuperar sua
     *         mensagem associada
     */
    public String messageKeyFor(Class<? extends InvalidValue> errorClass, InvalidValue error) {
        final String errorClassName = errorClass.getName();
        String simpleName = errorClassName.substring(errorClassName.lastIndexOf(".")+1);
        String errorName = error.name();
        String key = simpleName + "_" + errorName;
        return key.toLowerCase();
    }
}
