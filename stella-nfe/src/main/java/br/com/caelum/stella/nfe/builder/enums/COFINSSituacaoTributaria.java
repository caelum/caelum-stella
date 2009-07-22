package br.com.caelum.stella.nfe.builder.enums;

public enum COFINSSituacaoTributaria {
    ALIQUOTA_NORMAL("01"), ALIQUOTA_DIFERENCIADA("02"), QUANTIDADE_VENDIDA_VERSUS_ALIQUOTA_POR_UNIDADE_DE_PRODUTO("03"), TRIBUTACAO_MONOFASTICA(
            "04"), ALIQUOTA_ZERO("06"), OPERACAO_ISENTA_DE_CONTRIBUICAO("07"), OPERACAO_SEM_INCIDENCIA_DE_CONTRIBUICAO(
            "08"), OPERACAO_COM_SUSPENSAO_DE_CONTRIBUICAO("09"), OUTRAS_OPERACOES("99");

    private String codigo;

    private COFINSSituacaoTributaria(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
