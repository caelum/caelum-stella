package br.com.caelum.stella.faces.validator;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.faces.ResourceBundleMessageProducer;
import br.com.caelum.stella.validator.CPFError;
import br.com.caelum.stella.validator.CPFValidator;

public class StellaCPFValidador implements Validator {

	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {
		CPFValidator validator = getCoreValidator(ctx);
		String cpf = value.toString();
		boolean valid = validator.validate(cpf);
		if (!valid) {
			((UIInput) component).setValid(false);
			List<ValidationMessage> lastValidationMessages = validator
					.getLastValidationMessages();
			for (ValidationMessage validationMessage : lastValidationMessages) {
				FacesMessage facesMessage = new FacesMessage(validationMessage
						.getMessage());
				ctx.addMessage(component.getClientId(ctx), facesMessage);
			}
		}
	}

	private CPFValidator getCoreValidator(FacesContext ctx) {
		String messageBundle = ctx.getApplication().getMessageBundle();
		Locale locale = ctx.getViewRoot().getLocale();
		ResourceBundle resourceBundle = ResourceBundle.getBundle(messageBundle,	locale);
		ResourceBundleMessageProducer<CPFError> messageProducer = new ResourceBundleMessageProducer<CPFError>(
				resourceBundle);
		CPFValidator validator = new CPFValidator(messageProducer, false);
		return validator;
	}

}
