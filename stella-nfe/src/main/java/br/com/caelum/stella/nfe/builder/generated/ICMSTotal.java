package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface ICMSTotal {
    public ICMSTotal withValorDaBaseDeCalculo(BigDecimal string);

    public ICMSTotal withValorTotal(BigDecimal string);

    public ICMSTotal withValorDaBaseDeCalculoDoICMSSubstituicaoTributaria(BigDecimal string);

    public ICMSTotal withValorTotalDoICMSSubstituicaoTributaria(BigDecimal string);

    public ICMSTotal withValorTotalDosProdutosEServicos(BigDecimal string);

    public ICMSTotal withValorTotalDoFrete(BigDecimal string);

    public ICMSTotal withValorTotalDoSeguro(BigDecimal string);

    public ICMSTotal withValorTotalDeDesconto(BigDecimal string);

    public ICMSTotal withValorTotalDoII(BigDecimal string);

    public ICMSTotal withValorTotalDoIPI(BigDecimal string);

    public ICMSTotal withValorTotalDoPIS(BigDecimal string);

    public ICMSTotal withValor(BigDecimal string);

    public ICMSTotal withValorTotalDeOutrasDespesas(BigDecimal string);

    public ICMSTotal withValorTotalDaNF(BigDecimal string);
}