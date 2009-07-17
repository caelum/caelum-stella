package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class RetTribImplTest {
    @org.junit.Test
    public void testRetTribInterface() {
        RetencaoDeTributosFederais<Object> retTrib = new RetencaoDeTributosFederaisImpl<Object>(new Object())
                                                                                                             .withVRetPIS(
                                                                                                                     new BigDecimal(
                                                                                                                             1))
                                                                                                             .withVRetCOFINS(
                                                                                                                     new BigDecimal(
                                                                                                                             1))
                                                                                                             .withVRetCSLL(
                                                                                                                     new BigDecimal(
                                                                                                                             1))
                                                                                                             .withVBCIRRF(
                                                                                                                     new BigDecimal(
                                                                                                                             1))
                                                                                                             .withVIRRF(
                                                                                                                     new BigDecimal(
                                                                                                                             1))
                                                                                                             .withVBCRetPrev(
                                                                                                                     new BigDecimal(
                                                                                                                             1))
                                                                                                             .withVRetPrev(
                                                                                                                     new BigDecimal(
                                                                                                                             1));
        BuilderTestHelper.assertModelWasFilled(retTrib);
    }

}