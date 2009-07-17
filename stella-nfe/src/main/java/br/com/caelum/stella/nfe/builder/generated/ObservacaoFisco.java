package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface ObservacaoFisco<T> extends NFeBuilder<T> {
    public ObservacaoFisco<T> withDescricaoDoTexto(String string);

    public ObservacaoFisco<T> withDescricaoDoCampo(String string);
}