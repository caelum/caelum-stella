package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TRetInutNFe<T> extends NFeBuilder<T> {
    public TRetInutNFe<T> withInfInut(InfInut<?> infInut);

    public TRetInutNFe<T> withSignature(SignatureType signatureType);

    public TRetInutNFe<T> withVersao(String string);
}