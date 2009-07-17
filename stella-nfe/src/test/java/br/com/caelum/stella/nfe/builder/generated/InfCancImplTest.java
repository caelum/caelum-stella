package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class InfCancImplTest {
    @org.junit.Test
    public void testInfCancInterface() {
        InfCanc<Object> infCanc = new InfCancImpl<Object>(new Object()).withTpAmb("abc").withXServ("abc").withChNFe(
                "abc").withNProt("abc").withXJust("abc").withId("abc");
        BuilderTestHelper.assertModelWasFilled(infCanc);
    }
}