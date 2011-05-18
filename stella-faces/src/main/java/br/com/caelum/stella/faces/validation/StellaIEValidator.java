package br.com.caelum.stella.faces.validation;

import java.util.List;
import java.util.ResourceBundle;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.caelum.stella.ResourceBundleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.type.Estado;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.RejectAllValidator;
import br.com.caelum.stella.validation.error.IEError;

/**
 * Caso ocorra algum erro de validação, todas as mensagens serão enfileiradas no
 * FacesContext e associadas ao elemento inválido.
 * 
 * @author Leonardo Bessa
 */
@FacesValidator(StellaIEValidator.VALIDATOR_ID)
public class StellaIEValidator implements Validator, StateHolder {

    /**
     * Identificador do Validador JSF.
     */
    public static final String VALIDATOR_ID = "StellaIEValidator";

    private final ResourceBundleFinder resourceBundleFinder = new ResourceBundleFinder();

    private boolean formatted = false;

    private String estadoComponentId;

    private String estado;

    private boolean transientValue = false;

    private ValueExpression binding;

    public void validate(final FacesContext facesContext, final UIComponent uiComponent, final Object value)
            throws ValidatorException {

        ResourceBundle bundle = resourceBundleFinder.getForCurrentLocale(facesContext);
        ResourceBundleMessageProducer producer = new ResourceBundleMessageProducer(bundle);
        try {
            br.com.caelum.stella.validation.Validator<String> validator;
            try {
                String estadoValue;
                if (estado == null) {
                    ValueHolder estadoValueHolder = (ValueHolder) facesContext.getViewRoot().findComponent(
                            estadoComponentId);
                    estadoValue = estadoValueHolder.getValue().toString();
                } else {
                    estadoValue = estado;
                }

                validator = Estado.valueOf(estadoValue).getIEValidator(producer, formatted);
            } catch (Exception ex) {
                validator = new RejectAllValidator<String>(producer, IEError.UNDEFINED_STATE);
            }
            validator.assertValid(value.toString());
        } catch (InvalidStateException e) {
            List<ValidationMessage> messages = e.getInvalidMessages();
            String firstErrorMessage = messages.get(0).getMessage();
            registerAllMessages(facesContext, uiComponent, messages.subList(1, messages.size()));
            throw new ValidatorException(new FacesMessage(firstErrorMessage));
        }
    }

    private void registerAllMessages(final FacesContext facesContext, final UIComponent uiComponent,
            final List<ValidationMessage> messages) {
        for (ValidationMessage message : messages) {
            String componentId = uiComponent.getClientId(facesContext);
            facesContext.addMessage(componentId, new FacesMessage(message.getMessage()));
        }
    }

    /**
     * Atribui se a regra de validação deve considerar, ou não, a cadeia no
     * formato do documento.
     * 
     * @param formatted
     *            caso seja <code>true</code> o validador considera que a cadeia
     *            está formatada; caso contrário, considera que a cadeia contém
     *            apenas dígitos numéricos.
     */
    public void setFormatted(final boolean formatted) {
        this.formatted = formatted;
    }

    public void setEstadoComponentId(final String estadoComponentId) {
        this.estadoComponentId = estadoComponentId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(final String estado) {
        this.estado = estado;
    }

    public Object saveState(final FacesContext context) {
        Object values[] = new Object[4];
        values[0] = estadoComponentId;
        values[1] = formatted;
        values[2] = estado;
        values[3] = binding;
        return values;
    }

    public void restoreState(final FacesContext context, final Object state) {
        Object values[] = (Object[]) state;
        estadoComponentId = (String) values[0];
        formatted = (Boolean) values[1];
        estado = (String) values[2];
        binding = (ValueExpression) values[3];
        if (binding != null) {
            binding.setValue(context.getELContext(), this);
        }
    }

    public boolean isTransient() {
        return transientValue;
    }

    public void setTransient(final boolean transientValue) {
        this.transientValue = transientValue;
    }

    public void setBinding(final ValueExpression binding) {
        this.binding = binding;
    }
}
