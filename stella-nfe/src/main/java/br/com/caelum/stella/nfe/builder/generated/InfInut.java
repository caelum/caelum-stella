package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface InfInut<T> extends NFeBuilder<T> {
    public InfInut<T> withTpAmb(String string);

    public InfInut<T> withVerAplic(String string);

    public InfInut<T> withCStat(String string);

    public InfInut<T> withXMotivo(String string);

    public InfInut<T> withCUF(String string);

    public InfInut<T> withAno(String string);

    public InfInut<T> withCNPJ(String string);

    public InfInut<T> withMod(String string);

    public InfInut<T> withSerie(String string);

    public InfInut<T> withNNFIni(String string);

    public InfInut<T> withNNFFin(String string);

    public InfInut<T> withDhRecbto(Calendar calendar);

    public InfInut<T> withNProt(String string);

    public InfInut<T> withId(String string);
}