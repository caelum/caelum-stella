package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFEImpl implements
        RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetEnviNFe tRetEnviNFe;

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFEImpl() {
        tRetEnviNFe = new br.com.caelum.stella.nfe.modelo.TRetEnviNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TRetEnviNFe getInstance() {
        return tRetEnviNFe;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withTipoDoAmbiente(final TipoDoAmbiente string) {
        tRetEnviNFe.setTpAmb(string.getCode());
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withVersaoAplicativo(final String string) {
        tRetEnviNFe.setVerAplic(string);
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withCodigoDeStatus(final String string) {
        tRetEnviNFe.setCStat(string);
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withDescricaoDoStatus(final String string) {
        tRetEnviNFe.setXMotivo(string);
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withCodigoDaUF(final String string) {
        tRetEnviNFe.setCUF(string);
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withReciboDoLote(final ReciboDoLote infRec) {
        tRetEnviNFe.setInfRec((br.com.caelum.stella.nfe.modelo.InfRec) ((ObjectCreator) infRec).getInstance());
        return this;
    }

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withVersaoDaNFE(final String string) {
        tRetEnviNFe.setVersao(string);
        return this;
    }
}