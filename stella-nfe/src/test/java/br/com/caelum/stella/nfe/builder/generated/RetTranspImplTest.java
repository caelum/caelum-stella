package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class RetTranspImplTest {
    @org.junit.Test
    public void testRetTranspInterface() {
        ICMSRetidoPeloTransporte<Object> retTransp = new ICMSRetidoPeloTransporteImpl<Object>(new Object())
                                                                                                           .withValorDoServico(
                                                                                                                   new BigDecimal(
                                                                                                                           1))
                                                                                                           .withValorDaBaseDeCalculoDeRetencaoDoICMS(
                                                                                                                   new BigDecimal(
                                                                                                                           1))
                                                                                                           .withAliquotaDaRetencaoDoICMS(
                                                                                                                   new BigDecimal(
                                                                                                                           1))
                                                                                                           .withValorDoICMSRetido(
                                                                                                                   new BigDecimal(
                                                                                                                           1))
                                                                                                           .withCodigoFiscalDeOperacoesEPrestacoes(
                                                                                                                   "abc")
                                                                                                           .withCodigoDoMunicipio(
                                                                                                                   "abc");
        BuilderTestHelper.assertModelWasFilled(retTransp);
    }

}