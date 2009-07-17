package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface InformacaoDaNFReferenciada<T> extends NFeBuilder<T> {
    public InformacaoDaNFReferenciada<T> withChaveDeAcessoDaNFReferenciada(String string);

    public InformacaoDaNFReferenciada<T> withNFReferenciada(NFReferenciada<?> refNF);
}