package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TRetConsCadImplTest {
    @org.junit.Test
    public void testTRetConsCadInterface() {
        TRetConsCad<Object> tRetConsCad = new TRetConsCadImpl<Object>(new Object()).withInfCons(
                new InfConsImpl<Object>(new Object())).withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tRetConsCad);
    }

}