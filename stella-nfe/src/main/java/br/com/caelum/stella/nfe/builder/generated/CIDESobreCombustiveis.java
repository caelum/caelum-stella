package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface CIDESobreCombustiveis<T> extends NFeBuilder<T> {
    public CIDESobreCombustiveis<T> withBaseDeCalculo(BigDecimal string);

    public CIDESobreCombustiveis<T> withAliquota(BigDecimal string);

    public CIDESobreCombustiveis<T> withValor(BigDecimal string);
}