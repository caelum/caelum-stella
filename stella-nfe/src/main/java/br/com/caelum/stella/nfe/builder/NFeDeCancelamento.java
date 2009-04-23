package br.com.caelum.stella.nfe.builder;

final public class NFeDeCancelamento implements NFeBuilder<NFeDeCancelamento> {

    public Cabecalho<NFeDeCancelamento> withCabecalho() {
        return new Cabecalho<NFeDeCancelamento>(this);
    }

    public DadosNFeDeCancelamento withDados() {
        return new DadosNFeDeCancelamento(this);
    }

    public NFeDeCancelamento build() {
        return null;

    }

}
