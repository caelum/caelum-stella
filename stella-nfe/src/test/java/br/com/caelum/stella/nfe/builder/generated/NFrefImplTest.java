package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class NFrefImplTest {
    @org.junit.Test
    public void testNFrefInterface() {
        InformacaoDaNFReferenciada<Object> nFref = new InformacoesDaNFReferenciadaImpl<Object>(new Object())
                                                                                                            .withChaveDeAcessoDaNFReferenciada(
                                                                                                                    "abc")
                                                                                                            .withNFReferenciada(
                                                                                                                    new NFReferenciadaImpl<Object>(
                                                                                                                            new Object()));
        BuilderTestHelper.assertModelWasFilled(nFref);
    }

}