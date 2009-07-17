package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface NFEProcessada<T> extends NFeBuilder<T> {
    public NFEProcessada<T> withNFE(NFE<?> tNFe);

    public NFEProcessada<T> withProtocoloDoResultadoDeProcessamento(ProtocoloDoResultadoDeProcessamento<?> tProtNFe);

    public NFEProcessada<T> withVersao(String string);
}