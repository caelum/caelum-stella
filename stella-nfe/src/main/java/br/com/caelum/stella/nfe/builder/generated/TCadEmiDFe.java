package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TCadEmiDFe<T> extends NFeBuilder<T> {
    public TCadEmiDFe<T> withInfCadEmiDFe(InfCadEmiDFe<?> infCadEmiDFe);

    public TCadEmiDFe<T> withSignature(SignatureType signatureType);

    public TCadEmiDFe<T> withVersao(String string);
}