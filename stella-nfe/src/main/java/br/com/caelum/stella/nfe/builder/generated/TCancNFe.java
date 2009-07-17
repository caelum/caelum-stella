package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TCancNFe<T> extends NFeBuilder<T> {
    public TCancNFe<T> withInfCanc(InfCanc<?> infCanc);

    public TCancNFe<T> withSignature(SignatureType signatureType);

    public TCancNFe<T> withVersao(String string);
}