package br.com.caelum.stella.faces.validation;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.caelum.stella.ResourceBundleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.type.Estado;
import br.com.caelum.stella.validation.InvalidStateException;

/**
 * Caso ocorra algum erro de validação, todas as mensagens serão enfileiradas no
 * FacesContext e associadas ao elemento inválido.
 *
 * @author Leonardo Bessa
 */
public class StellaIEValidator implements Validator, StateHolder {
    /**
     * Identificador do Validador JSF.
     */
    public static final String VALIDATOR_ID = "StellaIEValidator";

    private final ResourceBundleFinder resourceBundleFinder = new ResourceBundleFinder();

    private boolean formatted;

    private Estado estado;

    private boolean transientValue = false;

    /**
     * Atribui se a regra de validação deve considerar, ou não, a cadeia no
     * formato do documento.
     *
     * @param formatted caso seja <code>true</code> o validador considera que a
     *                  cadeia está formatada; caso contrário, considera que a cadeia
     *                  contém apenas dígitos numéricos.
     */
    public void setFormatted(boolean formatted) {
        this.formatted = formatted;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void validate(FacesContext facesContext, UIComponent uiComponent,
            Object value) throws ValidatorException {
        ResourceBundle bundle = resourceBundleFinder
                .getForCurrentLocale(facesContext);
        ResourceBundleMessageProducer producer = new ResourceBundleMessageProducer(
                bundle);
        br.com.caelum.stella.validation.Validator<String> validator = estado
                .getIEValidator(producer, formatted);

        try {
            validator.assertValid(value.toString());
        } catch (InvalidStateException e) {
            List<ValidationMessage> messages = e.getInvalidMessages();
            String firstErrorMessage = messages.get(0).getMessage();
            registerAllMessages(facesContext, uiComponent, messages.subList(1,
                    messages.size()));
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

    public Object saveState(FacesContext context) {
        Object values[] = new Object[2];
        values[0] = estado;
        values[1] = formatted;
        return ((Object) (values));
    }

    public void restoreState(FacesContext context, Object state) {
        Object values[] = (Object[]) state;
        estado = (Estado) values[0];
        formatted = (Boolean) values[1];
    }

    public boolean isTransient() {
        return transientValue;
    }

    public void setTransient(boolean transientValue) {
        this.transientValue = transientValue;
    }

}
