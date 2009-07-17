package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface TConsStatServ<T> extends NFeBuilder<T> {
    public TConsStatServ<T> withTpAmb(String string);

    public TConsStatServ<T> withCUF(String string);

    public TConsStatServ<T> withXServ(String string);

    public TConsStatServ<T> withVersao(String string);
}