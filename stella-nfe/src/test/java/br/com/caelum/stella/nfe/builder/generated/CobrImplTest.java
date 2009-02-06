package br.com.caelum.stella.nfe.builder.generated;

public final class CobrImplTest {
    @org.junit.Test
    public void testCobrInterface() {
        Cobr cobr = new CobrImpl().withFat(new FatImpl()).withDup(new DupImpl());
        assertModelWasFilled(cobr);
    }

    private void assertModelWasFilled(final Cobr cobr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cobr).assertModelWasFilled();
    }
}