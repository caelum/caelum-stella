package br.com.caelum.stella.faces.validation;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

/**
 * Associa um TLD (Descritor de Biblioteca de Tag) a um validador de CNPJ
 * (StellaCNPJValidator).
 * 
 * @author Leonardo Bessa
 */
@SuppressWarnings("serial")
public class StellaCNPJValidatorTag extends ValidatorELTag {
    private boolean formatted;

    public StellaCNPJValidatorTag() {
        super.setId(StellaCNPJValidator.VALIDATOR_ID);
    }

    /**
     * @return StellaCNPJValidator
     */
    @Override
    protected Validator createValidator() throws JspException {
        StellaCNPJValidator validator = new StellaCNPJValidator();
        validator.setFormatted(this.formatted);
        return validator;
    }

    /**
     * Atribui se a regra de validação deve considerar, ou não, a cadeia no formato do documento.
     * 
     * @param formatted caso seja true o validador considera que a cadeia está formatada; 
     * caso contrário, considera que a cadeia contém apenas dígitos numéricos.
     * 
     * @see StellaCNPJValidator#setFormatted(boolean)
     * 
     */
    public void setFormatted(ValueExpression formatted) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        this.formatted = (Boolean) formatted.getValue(elContext);
    }

    @Override
    public void release() {
        super.release();
        this.formatted = false;
    }
}
