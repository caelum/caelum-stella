package br.com.caelum.stella.nfe.builder.generated.enums;

public enum FormaDeEmissao {

    NORMAL("1"), CONTINGENCIA("2");

    private final String code;

    private FormaDeEmissao(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
