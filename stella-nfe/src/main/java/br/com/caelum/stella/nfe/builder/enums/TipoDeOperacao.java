package br.com.caelum.stella.nfe.builder.enums;

public enum TipoDeOperacao {

    VENDA_CONCESSIONARIA("1"), FATURAMENTO_DIRETO("2"), VENDA_DIRETA("3"), OUTROS("0");

    private final String code;

    TipoDeOperacao(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
