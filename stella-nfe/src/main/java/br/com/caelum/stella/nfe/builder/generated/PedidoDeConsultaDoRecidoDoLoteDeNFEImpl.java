package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class PedidoDeConsultaDoRecidoDoLoteDeNFEImpl<T> implements PedidoDeConsultaDoRecidoDoLoteDeNFE<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TConsReciNFe tConsReciNFe;
    private final T parent;

    public PedidoDeConsultaDoRecidoDoLoteDeNFEImpl(final T parent) {
        this.parent = parent;
        tConsReciNFe = new br.com.caelum.stella.nfe.modelo.TConsReciNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tConsReciNFe;
    }

    public PedidoDeConsultaDoRecidoDoLoteDeNFE<T> withTipoDoAmbiente(final TipoDoAmbiente tipoDoAmbiente) {
        tConsReciNFe.setTpAmb(tipoDoAmbiente.getCode());
        return this;
    }

    public PedidoDeConsultaDoRecidoDoLoteDeNFE<T> withNumeroDoRecibo(final String string) {
        tConsReciNFe.setNRec(string);
        return this;
    }

    public PedidoDeConsultaDoRecidoDoLoteDeNFE<T> withVersao(final String string) {
        tConsReciNFe.setVersao(string);
        return this;
    }
}