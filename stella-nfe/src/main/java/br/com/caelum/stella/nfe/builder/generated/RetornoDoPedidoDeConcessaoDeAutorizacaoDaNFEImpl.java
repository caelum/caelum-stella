package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFEImpl<T> implements
        RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetEnviNFe tRetEnviNFe;
    private final T parent;

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFEImpl(final T parent) {
        this.parent = parent;
        tRetEnviNFe = new br.com.caelum.stella.nfe.modelo.TRetEnviNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tRetEnviNFe;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withTipoDoAmbiente(final TipoDoAmbiente string) {
        tRetEnviNFe.setTpAmb(string.getCode());
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withVersaoAplicativo(final String string) {
        tRetEnviNFe.setVerAplic(string);
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withCodigoDeStatus(final String string) {
        tRetEnviNFe.setCStat(string);
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withDescricaoDoStatus(final String string) {
        tRetEnviNFe.setXMotivo(string);
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withCodigoDaUF(final String string) {
        tRetEnviNFe.setCUF(string);
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withReciboDoLote(final ReciboDoLote<?> infRec) {
        tRetEnviNFe.setInfRec((br.com.caelum.stella.nfe.modelo.InfRec) ((ObjectCreator) infRec).getInstance());
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withVersaoDaNFE(final String string) {
        tRetEnviNFe.setVersao(string);
        return this;
    }
}