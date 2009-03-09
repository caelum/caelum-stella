package br.com.caelum.stella.nfe.builder.generated.enums;

public enum FormaDePagamento {

    A_VISTA("0"), A_PRAZO("1"), OUTROS("2");

    private final String code;

    private FormaDePagamento(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
