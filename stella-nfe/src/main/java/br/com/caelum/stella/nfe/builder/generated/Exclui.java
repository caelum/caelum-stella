package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;

public interface Exclui<T> extends NFeBuilder<T> {
    public Exclui<T> withUF(TUf tUf);

    public Exclui<T> withCNPJ(CNPJ object);
}