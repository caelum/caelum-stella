package br.com.caelum.stella.nfe.builder.enums;

public enum TipoDoAmbiente {
    PRODUCAO("1"), HOMOLOGACAO("2");

    private final String code;

    private TipoDoAmbiente(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
