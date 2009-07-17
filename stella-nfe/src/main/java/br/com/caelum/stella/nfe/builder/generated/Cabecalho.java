package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Cabecalho<T> extends NFeBuilder<T> {
    public Cabecalho<T> withVersaoDados(String string);

    public Cabecalho<T> withVersao(String string);
}