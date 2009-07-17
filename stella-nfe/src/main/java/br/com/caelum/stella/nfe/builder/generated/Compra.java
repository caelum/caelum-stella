package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Compra<T> extends NFeBuilder<T> {
    public Compra<T> withInformacoesDaNotaDeEmpenhoDeComprasPublicas(String string);

    public Compra<T> withInformacaoDoPedido(String string);

    public Compra<T> withInformacaoDoContrato(String string);
}