package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface ICMSTotal<T> extends NFeBuilder<T> {
    public ICMSTotal<T> withValorDaBaseDeCalculo(BigDecimal string);

    public ICMSTotal<T> withValorTotal(BigDecimal string);

    public ICMSTotal<T> withValorDaBaseDeCalculoDoICMSSubstituicaoTributaria(BigDecimal string);

    public ICMSTotal<T> withValorTotalDoICMSSubstituicaoTributaria(BigDecimal string);

    public ICMSTotal<T> withValorTotalDosProdutosEServicos(BigDecimal string);

    public ICMSTotal<T> withValorTotalDoFrete(BigDecimal string);

    public ICMSTotal<T> withValorTotalDoSeguro(BigDecimal string);

    public ICMSTotal<T> withValorTotalDeDesconto(BigDecimal string);

    public ICMSTotal<T> withValorTotalDoII(BigDecimal string);

    public ICMSTotal<T> withValorTotalDoIPI(BigDecimal string);

    public ICMSTotal<T> withValorTotalDoPIS(BigDecimal string);

    public ICMSTotal<T> withValor(BigDecimal string);

    public ICMSTotal<T> withValorTotalDeOutrasDespesas(BigDecimal string);

    public ICMSTotal<T> withValorTotalDaNF(BigDecimal string);
}