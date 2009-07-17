package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.math.BigInteger;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Combustivel<T> extends NFeBuilder<T> {
    public Combustivel<T> withCodigoDoProdutoNaANP(Integer string);

    public Combustivel<T> withCodigoDeAutorizacaoOuRegistroDoCODIF(BigInteger string);

    public Combustivel<T> withQuantidadeDeCombustivelFaturadaNaTemperaturaAmbiente(BigDecimal string);

    public Combustivel<T> withCIDE(CIDESobreCombustiveis<?> cIDE);

    public Combustivel<T> withICMS(ICMSSobreCombustiveis<?> iCMSComb);

    public Combustivel<T> withICMSSobreOperacoesInterestaduais(ICMSSobreOperacoesInterestaduais<?> iCMSInter);

    public Combustivel<T> withICMSSobreConsumo(ICMSSobreConsumo<?> iCMSCons);
}