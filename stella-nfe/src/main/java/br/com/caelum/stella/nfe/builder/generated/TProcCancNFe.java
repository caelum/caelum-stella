package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface TProcCancNFe<T> extends NFeBuilder<T> {
    public TProcCancNFe<T> withCancNFe(TCancNFe<?> tCancNFe);

    public TProcCancNFe<T> withRetCancNFe(TRetCancNFe<?> tRetCancNFe);

    public TProcCancNFe<T> withVersao(String string);
}