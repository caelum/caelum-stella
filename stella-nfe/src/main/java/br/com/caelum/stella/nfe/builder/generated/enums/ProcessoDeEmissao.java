package br.com.caelum.stella.nfe.builder.generated.enums;

public enum ProcessoDeEmissao {

    APLICATIVO_CONTRIBUINTE("0"), AVULSA_FISCO("1"), SITE_FISCO("2"), APLICATIVO_FISCO("3");

    private final String code;

    private ProcessoDeEmissao(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
