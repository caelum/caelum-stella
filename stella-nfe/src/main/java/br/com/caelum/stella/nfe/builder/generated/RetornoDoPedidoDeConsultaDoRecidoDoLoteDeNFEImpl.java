package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFEImpl<T> implements
        RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetConsReciNFe tRetConsReciNFe;
    private final T parent;

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFEImpl(final T parent) {
        this.parent = parent;
        tRetConsReciNFe = new br.com.caelum.stella.nfe.modelo.TRetConsReciNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tRetConsReciNFe;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withTipoDeAmbiente(final TipoDoAmbiente tipoDoAmbiente) {
        tRetConsReciNFe.setTpAmb(tipoDoAmbiente.getCode());
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withVersaoDaAplicativo(final String string) {
        tRetConsReciNFe.setVerAplic(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withNumeroDoReciboConsultado(final String string) {
        tRetConsReciNFe.setNRec(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withCodigoDeStatus(final String string) {
        tRetConsReciNFe.setCStat(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withDescricaoDoStatus(final String string) {
        tRetConsReciNFe.setXMotivo(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withCodigoDaUF(final String string) {
        tRetConsReciNFe.setCUF(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withProtocoloDoResultadoDeProcessamento(
            final ProtocoloDoResultadoDeProcessamento<?>... protNFe) {
        List<br.com.caelum.stella.nfe.modelo.TProtNFe> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TProtNFe>();
        for (ProtocoloDoResultadoDeProcessamento<?> p : protNFe) {
            list.add((br.com.caelum.stella.nfe.modelo.TProtNFe) ((ObjectCreator) p).getInstance());
        }
        tRetConsReciNFe.setProtNFe(list);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withVersaoNFE(final String string) {
        tRetConsReciNFe.setVersao(string);
        return this;
    }
}