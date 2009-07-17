package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TotalImplTest {
    @org.junit.Test
    public void testTotalInterface() {
        TotalNFE<Object> total = new TotalNFEImpl<Object>(new Object())
                                                                       .withICMSTotal(
                                                                               new ICMSTotalImpl<Object>(new Object()))
                                                                       .withISSQNTotal(
                                                                               new ISSQNtotImpl<Object>(new Object()))
                                                                       .withRetencaoDeTributosFederais(
                                                                               new RetencaoDeTributosFederaisImpl<Object>(
                                                                                       new Object()));
        BuilderTestHelper.assertModelWasFilled(total);
    }

}