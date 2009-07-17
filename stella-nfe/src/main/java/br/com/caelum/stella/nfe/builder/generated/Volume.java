package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Volume<T> extends NFeBuilder<T> {
    public Volume<T> withQuantidade(Long string);

    public Volume<T> withEspecie(String string);

    public Volume<T> withMarca(String string);

    public Volume<T> withNumeracao(String string);

    public Volume<T> withPesoLiquido(String string);

    public Volume<T> withPesoBruto(String string);

    public Volume<T> withLacres(Lacres<?>... lacres);
}