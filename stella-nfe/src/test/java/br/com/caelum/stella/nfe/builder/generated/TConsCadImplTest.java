package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TConsCadImplTest {
    @org.junit.Test
    public void testTConsCadInterface() {
        TConsCad<Object> tConsCad = new TConsCadImpl<Object>(new Object()).withInfCons(
                new InfConsImpl<Object>(new Object())).withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tConsCad);
    }

}