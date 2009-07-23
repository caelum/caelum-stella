package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.RetTransp.class)
public interface ICMSRetidoPeloTransporte<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("vServ")
    ICMSRetidoPeloTransporte<T> withValorDoServico(java.math.BigDecimal valorDoServico);

    @net.vidageek.fluid.annotations.FluidField("vbcRet")
    ICMSRetidoPeloTransporte<T> withValorDaBaseDeCalculoDeRetencaoDoICMS(java.math.BigDecimal valorDaBaseDeCalculoDeRetencaoDoICMS);

    @net.vidageek.fluid.annotations.FluidField("picmsRet")
    ICMSRetidoPeloTransporte<T> withAliquotaDaRetencaoDoICMS(java.math.BigDecimal aliquotaDaRetencaoDoICMS);

    @net.vidageek.fluid.annotations.FluidField("vicmsRet")
    ICMSRetidoPeloTransporte<T> withValorDoICMSRetido(java.math.BigDecimal valorDoICMSRetido);

    @net.vidageek.fluid.annotations.FluidField("cfop")
    ICMSRetidoPeloTransporte<T> withCodigoFiscalDeOperacoesEPrestacoes(java.lang.String codigoFiscalDeOperacoesEPrestacoes);

    @net.vidageek.fluid.annotations.FluidField("cMunFG")
    ICMSRetidoPeloTransporte<T> withCodigoDoMunicipio(java.lang.String codigoDoMunicipio);

}