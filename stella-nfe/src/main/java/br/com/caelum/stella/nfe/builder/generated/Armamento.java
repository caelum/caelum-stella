package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeArmamento;

public interface Armamento<T> extends NFeBuilder<T> {
    public Armamento<T> withTipo(TipoDeArmamento tipo);

    public Armamento<T> withNumeroDeSerie(Integer integer);

    public Armamento<T> withNumeroDeSerieDoCano(Integer integer);

    public Armamento<T> withDescricao(String string);
}