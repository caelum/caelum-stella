package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface Combustivel {
    public Combustivel withCodigoDoProdutoNaANP(Integer string);

    public Combustivel withCodigoDeAutorizacaoOuRegistroDoCODIF(BigInteger string);

    public Combustivel withQuantidadeDeCombustivelFaturadaNaTemperaturaAmbiente(BigDecimal string);

    public Combustivel withCIDE(CIDESobreCombustiveis cIDE);

    public Combustivel withICMS(ICMSSobreCombustiveis iCMSComb);

    public Combustivel withICMSSobreOperacoesInterestaduais(ICMSSobreOperacoesInterestaduais iCMSInter);

    public Combustivel withICMSSobreConsumo(ICMSSobreConsumo iCMSCons);
}