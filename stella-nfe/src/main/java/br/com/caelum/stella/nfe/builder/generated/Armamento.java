package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeArmamento;

public interface Armamento {
    public Armamento withTipo(TipoDeArmamento tipo);

    public Armamento withNumeroDeSerie(Integer integer);

    public Armamento withNumeroDeSerieDoCano(Integer integer);

    public Armamento withDescricao(String string);
}