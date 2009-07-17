package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface ICMSSobreCombustiveis<T> extends NFeBuilder<T> {
    public ICMSSobreCombustiveis<T> withValorDaBaseDeCalculo(BigDecimal string);

    public ICMSSobreCombustiveis<T> withValor(BigDecimal string);

    public ICMSSobreCombustiveis<T> withValorDaBaseDeCalculoDaSubstituicaoTributaria(BigDecimal string);

    public ICMSSobreCombustiveis<T> withValorDoICMSDaSubstituicaoTributaria(BigDecimal string);
}