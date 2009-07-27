package br.com.caelum.stella.nfe.fluid.enums;

public enum FinalidadeDaEmissao {

    NFE_NORMAL("1"), NFE_COMPLEMENTAR("2"), NFE_AJUSTE("3");

    private final String code;

    private FinalidadeDaEmissao(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
