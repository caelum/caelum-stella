package br.com.caelum.stella.faces.validation;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.faces.ResourceBundleMessageProducer;
import br.com.caelum.stella.validator.CPFError;
import br.com.caelum.stella.validator.CPFValidator;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Caso ocorra algum erro de validação, todas as mensagens serão enfileiradas no
 * FacesContext e associadas ao elemento inválido.
 *
 * @Author Fabio Kung
 */
public class StellaCPFValidator implements javax.faces.validator.Validator {

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Application application = facesContext.getApplication();
        String bundleName = application.getMessageBundle();
        ResourceBundle bundle = application.getResourceBundle(facesContext, bundleName);

        ResourceBundleMessageProducer<CPFError> producer = new ResourceBundleMessageProducer<CPFError>(bundle);
        CPFValidator validator = new CPFValidator(producer, false);

        if (!validator.validate(value.toString())) {
            List<ValidationMessage> messages = validator.getLastValidationMessages();
            registerAllMessages(facesContext, uiComponent, messages);

            String firstErrorMessage = messages.get(0).getMessage();
            throw new ValidatorException(new FacesMessage(firstErrorMessage));
        }
    }

    private void registerAllMessages(FacesContext facesContext, UIComponent uiComponent, List<ValidationMessage> messages) {
        for (ValidationMessage message : messages) {
            String componentId = uiComponent.getClientId(facesContext);
            facesContext.addMessage(componentId, new FacesMessage(message.getMessage()));
        }
    }
}
