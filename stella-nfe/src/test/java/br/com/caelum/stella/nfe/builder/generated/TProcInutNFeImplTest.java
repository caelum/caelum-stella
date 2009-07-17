package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TProcInutNFeImplTest {
    @org.junit.Test
    public void testTProcInutNFeInterface() {
        TProcInutNFe<Object> tProcInutNFe = new TProcInutNFeImpl<Object>(new Object())
                                                                                      .withInutNFe(
                                                                                              new TInutNFeImpl<Object>(
                                                                                                      new Object()))
                                                                                      .withRetInutNFe(
                                                                                              new TRetInutNFeImpl<Object>(
                                                                                                      new Object()))
                                                                                      .withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tProcInutNFe);
    }

}