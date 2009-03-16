package br.com.caelum.stella.nfe.builder.generated;

public final class LacresImplTest {
    @org.junit.Test
    public void testLacresInterface() {
        Lacres lacres = new LacresImpl().withNumeroDosLacres("abc");
        assertModelWasFilled(lacres);
    }

    private void assertModelWasFilled(Lacres lacres) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(lacres).assertModelWasFilled();
    }
}