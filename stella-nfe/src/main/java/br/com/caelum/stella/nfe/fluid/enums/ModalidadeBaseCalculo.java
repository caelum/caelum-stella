package br.com.caelum.stella.nfe.fluid.enums;

public enum ModalidadeBaseCalculo {
    MARGEM_VALOR_AGREGADO("0"), PAUTA("1"), PRECO_TABELADO_MAXIMO("2"), VALOR_OPERACAO("3");

    private String value;

    private ModalidadeBaseCalculo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
