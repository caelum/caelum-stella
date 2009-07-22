package br.com.caelum.stella.nfe.builder.enums;

public enum TipoDocumentoFiscal {

    ENTRADA("0"), SAIDA("1");

    private final String code;

    private TipoDocumentoFiscal(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
