package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

//TODO inline. Como esse tipo tem apenas um setter, deve ser um m�todo do objeto que quer settar um CONFINSNT
public interface COFINSNaoTributado<T> extends NFeBuilder<T> {
    public COFINSNaoTributado<T> withCodigoSituacaoTributaria(String string);
}