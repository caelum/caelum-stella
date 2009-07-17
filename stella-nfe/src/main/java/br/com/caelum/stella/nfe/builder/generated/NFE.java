package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface NFE<T> extends NFeBuilder<T> {
    public NFE<T> withInformacoesDaNFE(InformacoesDaNFE<?> infNFe);

    public NFE<T> withSignature(SignatureType signatureType);
}