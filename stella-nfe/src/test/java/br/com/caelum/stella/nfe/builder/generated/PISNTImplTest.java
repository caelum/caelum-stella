package br.com.caelum.stella.nfe.builder.generated;

public final class PISNTImplTest {
    @org.junit.Test
    public void testPISNTInterface() {
        PISNT pISNT = new PISNTImpl().withCST("abc");
        assertModelWasFilled(pISNT);
    }

    private void assertModelWasFilled(PISNT pISNT) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISNT).assertModelWasFilled();
    }
}