package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class DFeImplTest {
    @org.junit.Test
    public void testDFeInterface() {
        DFe<Object> dFe = new DFeImpl<Object>(new Object()).withMod("abc").withSit("abc");
        BuilderTestHelper.assertModelWasFilled(dFe);
    }
}