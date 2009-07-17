package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TRetCancNFe<T> extends NFeBuilder<T> {
    public TRetCancNFe<T> withInfCanc(InfCanc<?> infCanc);

    public TRetCancNFe<T> withSignature(SignatureType signatureType);

    public TRetCancNFe<T> withVersao(String string);
}