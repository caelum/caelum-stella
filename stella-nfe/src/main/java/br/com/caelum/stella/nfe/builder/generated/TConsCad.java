package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface TConsCad<T> extends NFeBuilder<T> {
    public TConsCad<T> withInfCons(InfCons<?> infCons);

    public TConsCad<T> withVersao(String string);
}