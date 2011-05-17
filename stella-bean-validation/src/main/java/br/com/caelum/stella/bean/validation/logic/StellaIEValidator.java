package br.com.caelum.stella.bean.validation.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.vidageek.mirror.dsl.Mirror;
import br.com.caelum.stella.bean.validation.IE;
import br.com.caelum.stella.type.Estado;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de Inscricao Estadual, no estado
 * epecificado.
 * 
 * @author Leonardo Bessa
 */
public class StellaIEValidator implements ConstraintValidator<IE, Object> {

	private br.com.caelum.stella.validation.Validator<String> stellaValidator;

	private IE ie;	

	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value != null) {
			String ieValue = getIEValue(value);
			String estadoValue = getEstadoValue(value);
			final AnnotationMessageProducer annotationMessageProducer = new AnnotationMessageProducer(
					ie);
			if (ieValue.trim().length() == 0) {
				return true;
			} else {
				try {
					final Estado estado = Estado.valueOf(estadoValue);
					stellaValidator = estado.getIEValidator(
							annotationMessageProducer, ie.formatted());
				} catch (IllegalArgumentException e) {
					return false;
				}
				return stellaValidator.invalidMessagesFor(ieValue).isEmpty();
			}
		} else {
			return true;
		}
	}

	public void initialize(IE ie) {
		this.ie = ie;
	}

	private String getEstadoValue(final Object obj) {
		return new Mirror().on(obj).invoke()
				.method(camelCaseGetFieldName(ie.estadoField())).withoutArgs()
				.toString();
	}

	private String getIEValue(final Object obj) {
		return new Mirror().on(obj).invoke()
				.method(camelCaseGetFieldName(ie.ieField())).withoutArgs()
				.toString();
	}

	private String camelCaseGetFieldName(final String fieldName) {
		return "get" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);
	}

}
