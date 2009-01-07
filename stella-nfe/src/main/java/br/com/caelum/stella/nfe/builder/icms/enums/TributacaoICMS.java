package br.com.caelum.stella.nfe.builder.icms.enums;

public enum TributacaoICMS {
    ISENTO("40"), NAO_TRIBUTADA("41"), SUSPENSAO("50");

    private String tributacao;

    private TributacaoICMS(String tributacao) {
        this.tributacao = tributacao;
    }

    public String getTributacao() {
        return tributacao;
    }

}
