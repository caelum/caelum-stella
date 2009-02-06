package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TProtNFe {
    public TProtNFe withInfProt(InfProt infProt);

    public TProtNFe withSignature(SignatureType signatureType);

    public TProtNFe withVersao(String string);
}