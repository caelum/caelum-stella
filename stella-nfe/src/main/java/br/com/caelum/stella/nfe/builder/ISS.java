package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

public interface ISS {

    ISS withValorDaBaseDeCalculo(BigDecimal valor);

    ISS withAliquota(BigDecimal aliquota);

    ISS withValor(BigDecimal valor);

    ISS withCodigoMunicipio(int codigoMunicipio);

    ISS withCodigoListaServicos(int codigoListaServicos);

}
