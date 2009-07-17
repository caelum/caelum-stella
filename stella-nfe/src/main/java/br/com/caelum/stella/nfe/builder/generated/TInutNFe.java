package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TInutNFe<T> extends NFeBuilder<T> {
    public TInutNFe<T> withInfInut(InfInut<?> infInut);

    public TInutNFe<T> withSignature(SignatureType signatureType);

    public TInutNFe<T> withVersao(String string);
}