package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TConsSitNFeImplTest {
    @org.junit.Test
    public void testTConsSitNFeInterface() {
        TConsSitNFe<Object> tConsSitNFe = new TConsSitNFeImpl<Object>(new Object())
                                                                                   .withTpAmb("abc")
                                                                                   .withXServ("abc")
                                                                                   .withChNFe("abc")
                                                                                   .withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tConsSitNFe);
    }
}