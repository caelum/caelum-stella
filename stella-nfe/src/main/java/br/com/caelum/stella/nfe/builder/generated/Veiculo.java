package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.UF;

public interface Veiculo<T> extends NFeBuilder<T> {
    public Veiculo<T> withPlaca(String string);

    public Veiculo<T> withUF(UF tUf);

    public Veiculo<T> withRegistroNacionalDoTransportadorDeCarga(String string);
}