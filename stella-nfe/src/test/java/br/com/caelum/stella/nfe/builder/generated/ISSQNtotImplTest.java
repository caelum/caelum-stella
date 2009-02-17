package br.com.caelum.stella.nfe.builder.generated;

public final class ISSQNtotImplTest {
    @org.junit.Test
    public void testISSQNtotInterface() {
        ISSQNtot iSSQNtot = new ISSQNtotImpl().withVServ("abc").withVBC("abc").withVISS("abc").withVPIS("abc")
                .withValor("abc");
        assertModelWasFilled(iSSQNtot);
    }

    private void assertModelWasFilled(ISSQNtot iSSQNtot) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iSSQNtot).assertModelWasFilled();
    }
}