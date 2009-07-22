package br.com.caelum.stella.nfe.builder.enums;

public enum FormatoDeImpressao {

    RETRATO("1"), PAISAGEM("2");

    private final String code;

    private FormatoDeImpressao(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
