package br.com.caelum.stella.faces.validation;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.faces.ResourceBundleMessageProducer;
import br.com.caelum.stella.validation.NITError;
import br.com.caelum.stella.validation.NITValidator;

/**
 * Valida o NIT atraves do método validate, retornando uma mensagem de erro ou
 * nenhuma mensagem em caso de valido.
 * 
 * @author Caires V.
 * 
 */
public class StellaNITValidator implements Validator, StateHolder {

	public static final String VALIDATOR_ID = "StellaNITValidator";
	private boolean formatted;
	private boolean transientValue = false;
	

	public void validate(FacesContext facesContext, UIComponent component,
			Object value) throws ValidatorException {
		Application application = facesContext.getApplication();
		String bundleName = application.getMessageBundle();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);

		ResourceBundleMessageProducer<NITError> producer = new ResourceBundleMessageProducer<NITError>(
				bundle);
		NITValidator validator = new NITValidator(producer, formatted);

		if (!validator.validate(value.toString())) {
			List<ValidationMessage> messages = validator
					.getLastValidationMessages();
			String firstErrorMessage = messages.remove(0).getMessage();
			registerAllMessages(facesContext, component, messages);
			throw new ValidatorException(new FacesMessage(firstErrorMessage));
		}
	}

	private void registerAllMessages(FacesContext facesContext,
			UIComponent uiComponent, List<ValidationMessage> messages) {
		for (ValidationMessage message : messages) {
			String componentId = uiComponent.getClientId(facesContext);
			facesContext.addMessage(componentId, new FacesMessage(message
					.getMessage()));
		}
	}

	public boolean isTransientValue() {
		return transientValue;
	}

	public void setTransientValue(boolean transientValue) {
		this.transientValue = transientValue;
	}

	public boolean isTransient() {
		return transientValue;
	}

	public void restoreState(FacesContext ctx, Object state) {
		this.formatted = (Boolean) state;
	}

	public Object saveState(FacesContext arg0) {
		return formatted;
	}

	public void setTransient(boolean transientValue) {
		this.transientValue = transientValue;
	}

	public void setFormatted(boolean formatted) {
		this.formatted = formatted;
	}

}
