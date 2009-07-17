package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface PedidoDeAutorizacaoDaNFE<T> extends NFeBuilder<T> {
    public PedidoDeAutorizacaoDaNFE<T> withIdDoLote(String string);

    public PedidoDeAutorizacaoDaNFE<T> withNFE(NFE<?>... nfes);

    public PedidoDeAutorizacaoDaNFE<T> withVersao(String string);
}