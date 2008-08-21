package br.com.caelum.stella.faces.validation;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

@SuppressWarnings("serial")
public class StellaIEValidatorTag extends ValidatorELTag {
    private ValueExpression formatted;
    private ValueExpression estado;
    private ValueExpression estadoComponentId;
    private ValueExpression binding;

    public StellaIEValidatorTag() {
        super.setId(StellaIEValidator.VALIDATOR_ID);
    }

    @Override
    protected Validator createValidator() throws JspException {
        ELContext elContext = getELContext();
        StellaIEValidator validator = getBoundValidator(elContext);

        if (binding != null) {
            validator.setBinding(binding);
        }
        if (estado != null) {
            String estadoValue = estado.getValue(elContext).toString();
            validator.setEstado(estadoValue);
        }
        if (estadoComponentId != null) {
            String componentId = estadoComponentId.getValue(elContext).toString();
            validator.setEstadoComponentId(componentId);
        }
        if (formatted != null) {
            Boolean formattedValue = (Boolean) formatted.getValue(elContext);
            validator.setFormatted(formattedValue);
        }

        return validator;
    }

    protected ELContext getELContext() {
        FacesContext context = FacesContext.getCurrentInstance();
        ELContext elContext = context.getELContext();
        return elContext;
    }

    private StellaIEValidator getBoundValidator(ELContext elContext) {
        StellaIEValidator validator = null;
        if (binding != null) {
            validator = (StellaIEValidator) binding.getValue(elContext);
        }
        if (validator == null) {
            validator = new StellaIEValidator();
            if (binding != null) {
                binding.setValue(elContext, validator);
            }
        }
        return validator;
    }

    public void setFormatted(ValueExpression formatted) {
        this.formatted = formatted;
    }

    public void setEstado(ValueExpression estado) {
        this.estado = estado;
    }

    public void setEstadoComponentId(ValueExpression estadoComponentId) {
        this.estadoComponentId = estadoComponentId;
    }

    public void setBinding(ValueExpression binding) {
        this.binding = binding;
    }

    public ValueExpression getBinding() {
        return binding;
    }

    public void release() {
        super.release();
        this.formatted = null;
        this.estado = null;
        this.estadoComponentId = null;
    }
}
