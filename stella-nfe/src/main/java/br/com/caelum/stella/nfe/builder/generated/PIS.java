package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface PIS<T> extends NFeBuilder<T> {
    public PIS<T> withPISTributadoPelaAliquota(PISTributadoPelaAliquota<?> pISAliq);

    public PIS<T> withPISTributadoPorQuantidade(PISTributadoPorQuantidade<?> pISQtde);

    public PIS<T> withPISNaoTributado(PISNaoTributado<?> pISNT);

    public PIS<T> withPISOutrasOperacoes(PISOutrasOperacoes<?> pISOutr);
}