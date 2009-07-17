package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface COFINS<T> extends NFeBuilder<T> {
    public COFINS<T> withTributacaoPelaAliquota(COFINSTributadoPelaAliquota<?> cOFINSAliq);

    public COFINS<T> withTributacaoPelaQuantidade(COFINSTributadoPelaQuantidade<?> cOFINSQtde);

    public COFINS<T> withNaoTributado(COFINSNaoTributado<?> cOFINSNT);

    public COFINS<T> withTributacaoDeOutrasOperacoes(COFINSOutrasOperacoes<?> cOFINSOutr);
}