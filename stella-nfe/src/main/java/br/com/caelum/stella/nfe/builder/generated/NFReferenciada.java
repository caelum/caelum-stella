package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.tinytype.CNPJ;

public interface NFReferenciada<T> extends NFeBuilder<T> {
    public NFReferenciada<T> withCodigoUF(String string);

    public NFReferenciada<T> withAAMM(String string);

    public NFReferenciada<T> withCNPJ(CNPJ cnpj);

    public NFReferenciada<T> withSerie(String string);

    public NFReferenciada<T> withNumero(String string);
}