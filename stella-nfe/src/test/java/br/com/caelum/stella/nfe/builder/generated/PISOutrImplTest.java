package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class PISOutrImplTest {
    @org.junit.Test
    public void testPISOutrInterface() {
        PISOutrasOperacoes<Object> pISOutr = new PISOutrasOperacoesImpl<Object>(new Object())
                                                                                             .withValorDaBaseDeCalculo(
                                                                                                     new BigDecimal(1))
                                                                                             .withAliquota(
                                                                                                     new BigDecimal(1))
                                                                                             .withQuantidadeVendida(
                                                                                                     new BigDecimal(1))
                                                                                             .withAliquotaDoProduto(
                                                                                                     new BigDecimal(1))
                                                                                             .withValor(
                                                                                                     new BigDecimal(1));
        BuilderTestHelper.assertModelWasFilled(pISOutr);
    }

}