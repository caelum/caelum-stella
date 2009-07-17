package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class LacresImplTest {
    @org.junit.Test
    public void testLacresInterface() {
        Lacres<Object> lacres = new LacresImpl<Object>(new Object()).withNumeroDosLacres("abc");
        BuilderTestHelper.assertModelWasFilled(lacres);
    }

}