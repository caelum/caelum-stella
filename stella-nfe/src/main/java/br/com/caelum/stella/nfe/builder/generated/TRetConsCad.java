package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface TRetConsCad<T> extends NFeBuilder<T> {
    public TRetConsCad<T> withInfCons(InfCons<?> infCons);

    public TRetConsCad<T> withVersao(String string);
}