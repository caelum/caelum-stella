package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public interface RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> extends NFeBuilder<T> {
    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withTipoDoAmbiente(TipoDoAmbiente tipoDoAmbiente);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withVersaoAplicativo(String string);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withCodigoDeStatus(String string);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withDescricaoDoStatus(String string);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withCodigoDaUF(String string);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withReciboDoLote(ReciboDoLote<?> infRec);

    public RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withVersaoDaNFE(String string);
}