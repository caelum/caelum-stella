package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

public interface ISS<T> extends NFeBuilder<T> {

    ISS<T> withValorDaBaseDeCalculo(BigDecimal valor);

    ISS<T> withAliquota(BigDecimal aliquota);

    ISS<T> withValor(BigDecimal valor);

    ISS<T> withCodigoMunicipio(int codigoMunicipio);

    ISS<T> withCodigoListaServicos(int codigoListaServicos);

}
