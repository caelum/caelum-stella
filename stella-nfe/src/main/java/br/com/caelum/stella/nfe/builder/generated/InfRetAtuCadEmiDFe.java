package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.TUf;

public interface InfRetAtuCadEmiDFe<T> extends NFeBuilder<T> {
    public InfRetAtuCadEmiDFe<T> withUF(TUf tUf);

    public InfRetAtuCadEmiDFe<T> withCNPJ(Object object);

    public InfRetAtuCadEmiDFe<T> withOpe(String string);

    public InfRetAtuCadEmiDFe<T> withResOpe(String string);

    public InfRetAtuCadEmiDFe<T> withId(String string);
}