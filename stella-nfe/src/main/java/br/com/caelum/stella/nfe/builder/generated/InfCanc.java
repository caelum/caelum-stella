package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface InfCanc<T> extends NFeBuilder<T> {
    public InfCanc<T> withTpAmb(String string);

    public InfCanc<T> withXServ(String string);

    public InfCanc<T> withChNFe(String string);

    public InfCanc<T> withNProt(String string);

    public InfCanc<T> withXJust(String string);

    public InfCanc<T> withId(String string);
}