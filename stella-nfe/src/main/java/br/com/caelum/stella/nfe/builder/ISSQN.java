package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

public interface ISSQN {

    ISSQN withValorBaseCalculo(BigDecimal valor);

    ISSQN withAliquota(BigDecimal aliquota);

    ISSQN withValor(BigDecimal valor);

    ISSQN withCodigoMunicipio(int codigoMunicipio);

    ISSQN withCodigoListaServicos(int codigoListaServicos);

}
