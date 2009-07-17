package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface TConsSitNFe<T> extends NFeBuilder<T> {
    public TConsSitNFe<T> withTpAmb(String string);

    public TConsSitNFe<T> withXServ(String string);

    public TConsSitNFe<T> withChNFe(String string);

    public TConsSitNFe<T> withVersao(String string);
}