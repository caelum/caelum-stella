package br.com.caelum.stella.faces.validation;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.caelum.stella.ResourceBundleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.TituloEleitoralValidator;

/**
 * Caso ocorra algum erro de validação, todas as mensagens serão enfileiradas no
 * FacesContext e associadas ao elemento inválido.
 * 
 * @author Leonardo Bessa
 */
@FacesValidator(StellaTituloEleitoralValidator.VALIDATOR_ID)
public class StellaTituloEleitoralValidator implements Validator, StateHolder {

    /**
     * Identificador do Validador JSF.
     */
    public static final String VALIDATOR_ID = "StellaTituloEleitoralValidator";

    private final ResourceBundleFinder resourceBundleFinder = new ResourceBundleFinder();

    private boolean transientValue = false;

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        ResourceBundle bundle = resourceBundleFinder.getForCurrentLocale(facesContext);
        ResourceBundleMessageProducer producer = new ResourceBundleMessageProducer(bundle);
        TituloEleitoralValidator validator = new TituloEleitoralValidator(producer);

        try {
            validator.assertValid(value.toString());
        } catch (InvalidStateException e) {
            List<ValidationMessage> messages = e.getInvalidMessages();
            String firstErrorMessage = messages.remove(0).getMessage();
            registerAllMessages(facesContext, uiComponent, messages);
            throw new ValidatorException(new FacesMessage(firstErrorMessage));
        }
    }

    private void registerAllMessages(FacesContext facesContext, UIComponent uiComponent,
            List<ValidationMessage> messages) {
        for (ValidationMessage message : messages) {
            String componentId = uiComponent.getClientId(facesContext);
            facesContext.addMessage(componentId, new FacesMessage(message.getMessage()));
        }
    }

    public void restoreState(FacesContext ctx, Object state) {
    }

    public Object saveState(FacesContext ctx) {
        return null;
    }

    public boolean isTransient() {
        return transientValue;
    }

    public void setTransient(boolean transientValue) {
        this.transientValue = transientValue;
    }
}
