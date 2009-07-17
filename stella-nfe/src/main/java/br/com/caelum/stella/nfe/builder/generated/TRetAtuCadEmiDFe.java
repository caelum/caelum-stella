package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TRetAtuCadEmiDFe<T> extends NFeBuilder<T> {
    public TRetAtuCadEmiDFe<T> withInfRetAtuCadEmiDFe(InfRetAtuCadEmiDFe<?> infRetAtuCadEmiDFe);

    public TRetAtuCadEmiDFe<T> withSignature(SignatureType signatureType);

    public TRetAtuCadEmiDFe<T> withVersao(String string);
}