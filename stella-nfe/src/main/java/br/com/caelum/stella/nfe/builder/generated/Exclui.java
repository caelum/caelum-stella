package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.TUf;

public interface Exclui<T> extends NFeBuilder<T> {
    public Exclui<T> withUF(TUf tUf);

    public Exclui<T> withCNPJ(Object object);
}