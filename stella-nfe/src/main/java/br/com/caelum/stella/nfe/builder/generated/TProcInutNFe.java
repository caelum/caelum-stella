package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface TProcInutNFe<T> extends NFeBuilder<T> {
    public TProcInutNFe<T> withInutNFe(TInutNFe<?> tInutNFe);

    public TProcInutNFe<T> withRetInutNFe(TRetInutNFe<?> tRetInutNFe);

    public TProcInutNFe<T> withVersao(String string);
}