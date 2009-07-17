package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.builder.generated.Cabecalho;
import br.com.caelum.stella.nfe.builder.generated.CabecalhoImpl;

final public class NFeDeCancelamento implements NFeBuilder<NFeDeCancelamento> {

    public Cabecalho<NFeDeCancelamento> withCabecalho() {
        return new CabecalhoImpl<NFeDeCancelamento>(this);
    }

    public DadosNFeDeCancelamento withDados() {
        return new DadosNFeDeCancelamento(this);
    }

    public NFeDeCancelamento build() {
        return this;

    }

}
