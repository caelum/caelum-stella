package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface ICMSRetidoPeloTransporte {
    public ICMSRetidoPeloTransporte withValorDoServico(BigDecimal string);

    public ICMSRetidoPeloTransporte withValorDaBaseDeCalculoDeRetencaoDoICMS(BigDecimal string);

    public ICMSRetidoPeloTransporte withAliquotaDaRetencaoDoICMS(BigDecimal aliquota);

    public ICMSRetidoPeloTransporte withValorDoICMSRetido(BigDecimal string);

    public ICMSRetidoPeloTransporte withCodigoFiscalDeOperacoesEPrestacoes(String string);

    public ICMSRetidoPeloTransporte withCodigoDoMunicipio(String string);
}