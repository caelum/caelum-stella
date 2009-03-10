package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public interface RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE {
    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withTipoDoAmbiente(TipoDoAmbiente tipoDoAmbiente);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withVersaoAplicativo(String string);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withCodigoDeStatus(String string);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withDescricaoDoStatus(String string);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withCodigoDaUF(String string);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withReciboDoLote(ReciboDoLote infRec);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE withVersaoDaNFE(String string);
}