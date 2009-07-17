package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface TotalNFE<T> extends NFeBuilder<T> {
    public TotalNFE<T> withICMSTotal(ICMSTotal<?> iCMSTot);

    public TotalNFE<T> withISSQNTotal(ISSQNTotal<?> iSSQNtot);

    public TotalNFE<T> withRetencaoDeTributosFederais(RetencaoDeTributosFederais<?> retTrib);
}