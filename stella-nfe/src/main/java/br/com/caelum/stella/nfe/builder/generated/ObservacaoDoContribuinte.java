package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface ObservacaoDoContribuinte<T> extends NFeBuilder<T> {
    public ObservacaoDoContribuinte<T> withTextoDeDescricao(String string);

    public ObservacaoDoContribuinte<T> withDescricaoDoCampo(String string);
}