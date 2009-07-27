package br.com.caelum.stella.nfe.fluid.enums;

public enum CondicaoDoVeiculo {

    ACABADO("1"), INACABADO("2"), SEMI_ACABADO("3");

    private final String code;

    private CondicaoDoVeiculo(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
