package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface TAtuCadEmiDFe<T> extends NFeBuilder<T> {
    public TAtuCadEmiDFe<T> withInfAtuCadEmiDFe(InfAtuCadEmiDFe<?> infAtuCadEmiDFe);

    public TAtuCadEmiDFe<T> withSignature(SignatureType signatureType);

    public TAtuCadEmiDFe<T> withVersao(String string);
}