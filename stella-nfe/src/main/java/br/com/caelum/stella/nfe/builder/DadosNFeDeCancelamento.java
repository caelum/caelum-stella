package br.com.caelum.stella.nfe.builder;

final public class DadosNFeDeCancelamento implements NFeBuilder<NFeDeCancelamento> {

    private final NFeDeCancelamento parent;

    public DadosNFeDeCancelamento(final NFeDeCancelamento parent) {
        this.parent = parent;
    }

    public NFeDeCancelamento build() {
        return parent;
    }

}
