package br.com.caelum.stella.faces.example;

import javax.faces.event.ValueChangeEvent;

import br.com.caelum.stella.faces.validation.StellaIEValidator;

/**
 * @author Fabio Kung
 */
public class EmpresaBean {

    private StellaIEValidator ieValidator;

    private String ie;

    private String ieFormatado;

    public void atualizaEstadoNoValidador(ValueChangeEvent event) {
        this.ieValidator.setEstado(event.getNewValue().toString());
    }

    public StellaIEValidator getIeValidator() {
        return ieValidator;
    }

    public void setIeValidator(StellaIEValidator ieValidator) {
        this.ieValidator = ieValidator;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIeFormatado() {
        return ieFormatado;
    }

    public void setIeFormatado(String ieFormatado) {
        this.ieFormatado = ieFormatado;
    }

}
