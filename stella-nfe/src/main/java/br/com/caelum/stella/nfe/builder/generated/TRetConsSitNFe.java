package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.InfProt;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TRetConsSitNFe {
    public TRetConsSitNFe withInfProt(InfProt infProt);

    public TRetConsSitNFe withSignature(SignatureType signatureType);

    public TRetConsSitNFe withVersao(String string);
}