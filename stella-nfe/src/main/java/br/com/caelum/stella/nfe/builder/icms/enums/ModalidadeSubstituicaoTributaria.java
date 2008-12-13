/**
 * 
 */
package br.com.caelum.stella.nfe.builder.icms.enums;

/**
 * @author jonasabreu
 * 
 */
public enum ModalidadeSubstituicaoTributaria {
    PRECO_TABELADO_MAXIMO("0"), LISTA_NEGATIVA("1"), LISTA_POSITIVA("2"), LISTA_NEUTRA("3"), MARGEM_VALOR_AGREGADO("4"), PAUTA(
            "5");

    private String value;

    private ModalidadeSubstituicaoTributaria(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
