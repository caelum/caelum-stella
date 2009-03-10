package br.com.caelum.stella.nfe.builder.generated.enums;

public enum OrigemDoProcesso {
    SEFAZ("0"), JUSTICA_FEDERAL("1"), JUSTICA_ESTADUAL("2"), SECEX_RFB("3"), OUTROS("9");

    private final String code;

    private OrigemDoProcesso(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
