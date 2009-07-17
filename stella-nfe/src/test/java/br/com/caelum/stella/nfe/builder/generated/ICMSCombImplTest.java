package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class ICMSCombImplTest {
    @org.junit.Test
    public void testICMSCombInterface() {
        ICMSSobreCombustiveis<Object> iCMSComb = new ICMSSobreCombustiveisImpl<Object>(new Object())
                                                                                                    .withValorDaBaseDeCalculo(
                                                                                                            new BigDecimal(
                                                                                                                    "1"))
                                                                                                    .withValor(
                                                                                                            new BigDecimal(
                                                                                                                    "1"))
                                                                                                    .withValorDaBaseDeCalculoDaSubstituicaoTributaria(
                                                                                                            new BigDecimal(
                                                                                                                    "1"))
                                                                                                    .withValorDoICMSDaSubstituicaoTributaria(
                                                                                                            new BigDecimal(
                                                                                                                    "1"));
        BuilderTestHelper.assertModelWasFilled(iCMSComb);
    }

}