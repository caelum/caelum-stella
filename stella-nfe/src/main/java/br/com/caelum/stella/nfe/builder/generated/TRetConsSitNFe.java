package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.InfProt;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TRetConsSitNFe<T> extends NFeBuilder<T> {
    public TRetConsSitNFe<T> withInfProt(InfProt infProt);

    public TRetConsSitNFe<T> withSignature(SignatureType signatureType);

    public TRetConsSitNFe<T> withVersao(String string);
}