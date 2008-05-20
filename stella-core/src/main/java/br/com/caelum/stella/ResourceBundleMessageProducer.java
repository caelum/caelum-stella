package br.com.caelum.stella;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import br.com.caelum.stella.validation.InvalidValue;

/**
 * <p>
 * ResourceBlundeMessageProducer é responsável pela geração de mensagens de
 * erro. Estas mensagens são procuradas em um ResourceBlundle, através de uma
 * chave associada a cada erro.
 * </p>
 * <p>
 * A chave de um erro é composta do seguinte modo:
 * </p>
 * <code>
 * String key = (simpleName + "." + errorName);
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
 * cpferror.invalid_digits .
 * </p>
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 * 
 */
@SuppressWarnings("unchecked")
public class ResourceBundleMessageProducer implements MessageProducer {

	private final ResourceBundle bundle;

	/**
	 * @param bundle
	 *            ResourceBlunde que contém o mapa que associa erros as
	 *            mensagens.
	 */
	public ResourceBundleMessageProducer(final ResourceBundle bundle) {
		this.bundle = bundle;
	}

	/**
	 * @see br.com.caelum.stella.MessageProducer#getMessage(java.lang.Enum)
	 */
	public ValidationMessage getMessage(InvalidValue error) {
		Locale locale = bundle.getLocale();
		if (locale == null) {
			locale = Locale.getDefault();
		}
		String simpleName = error.getClass().getSimpleName();
		String errorName = error.name();
		String key = (simpleName + "." + errorName);
		String message;
		try {
			message = bundle.getString(key.toLowerCase(locale));
		} catch (MissingResourceException ex) {
			message = key.toLowerCase(locale).replaceFirst("[.]", " : ")
					.replaceAll("_", " ");
		}
		return new SimpleValidationMessage(message);
	}
}
