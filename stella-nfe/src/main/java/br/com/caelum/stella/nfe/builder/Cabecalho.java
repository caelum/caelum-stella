package br.com.caelum.stella.nfe.builder;

final public class Cabecalho<T> implements NFeBuilder<T> {

    private final T parent;

    public Cabecalho(final T parent) {
        this.parent = parent;
    }

    public T build() {
        return parent;
    }

}
