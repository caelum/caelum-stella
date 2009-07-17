package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.TUf;

public interface InfAtuCadEmiDFe<T> extends NFeBuilder<T> {
    public InfAtuCadEmiDFe<T> withUF(TUf tUf);

    public InfAtuCadEmiDFe<T> withInclui(TEmissor<?> tEmissor);

    public InfAtuCadEmiDFe<T> withExclui(Exclui<?> exclui);

    public InfAtuCadEmiDFe<T> withId(String string);
}