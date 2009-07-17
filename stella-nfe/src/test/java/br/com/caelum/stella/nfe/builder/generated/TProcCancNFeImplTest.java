package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TProcCancNFeImplTest {
    @org.junit.Test
    public void testTProcCancNFeInterface() {
        TProcCancNFe<Object> tProcCancNFe = new TProcCancNFeImpl<Object>(new Object())
                                                                                      .withCancNFe(
                                                                                              new TCancNFeImpl<Object>(
                                                                                                      new Object()))
                                                                                      .withRetCancNFe(
                                                                                              new TRetCancNFeImpl<Object>(
                                                                                                      new Object()))
                                                                                      .withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tProcCancNFe);
    }

}