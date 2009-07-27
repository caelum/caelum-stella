/**
 * 
 */
package br.com.caelum.stella.nfe.fluid.enums;

/**
 * @author jonasabreu
 * 
 */
public enum ModalidadeST {
    PRECO_TABELADO_MAXIMO("0"), LISTA_NEGATIVA("1"), LISTA_POSITIVA("2"), LISTA_NEUTRA("3"), MARGEM_VALOR_AGREGADO("4"), PAUTA(
            "5");

    private String value;

    private ModalidadeST(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
