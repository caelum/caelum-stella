package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface NFE {
    public NFE withInformacoesDaNFE(InformacoesDaNFE infNFe);

    public NFE withSignature(SignatureType signatureType);
}