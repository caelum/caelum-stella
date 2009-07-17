package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface ICMSRetidoPeloTransporte<T> extends NFeBuilder<T> {
    public ICMSRetidoPeloTransporte<T> withValorDoServico(BigDecimal string);

    public ICMSRetidoPeloTransporte<T> withValorDaBaseDeCalculoDeRetencaoDoICMS(BigDecimal string);

    public ICMSRetidoPeloTransporte<T> withAliquotaDaRetencaoDoICMS(BigDecimal aliquota);

    public ICMSRetidoPeloTransporte<T> withValorDoICMSRetido(BigDecimal string);

    public ICMSRetidoPeloTransporte<T> withCodigoFiscalDeOperacoesEPrestacoes(String string);

    public ICMSRetidoPeloTransporte<T> withCodigoDoMunicipio(String string);
}