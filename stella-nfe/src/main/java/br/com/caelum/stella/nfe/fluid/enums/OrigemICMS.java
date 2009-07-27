package br.com.caelum.stella.nfe.fluid.enums;

public enum OrigemICMS {
    NACIONAL("0"), ESTRANGEIRA_IMPORTACAO("1"), ESTRANGEIRA_MERCADO_INTERNO("2");

    private final String value;

    private OrigemICMS(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
