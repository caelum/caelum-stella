package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TConsStatServImplTest {
    @org.junit.Test
    public void testTConsStatServInterface() {
        TConsStatServ<Object> tConsStatServ = new TConsStatServImpl<Object>(new Object()).withTpAmb("abc").withCUF(
                "abc").withXServ("abc").withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tConsStatServ);
    }
}