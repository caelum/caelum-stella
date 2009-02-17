package br.com.caelum.stella.nfe.builder.generated;

public final class CobrImplTest {
    @org.junit.Test
    public void testCobrInterface() {
        Cobr cobr = new CobrImpl().withFatura(new FatImpl()).withDuplicata(new DupImpl());
        assertModelWasFilled(cobr);
    }

    private void assertModelWasFilled(final Cobr cobr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cobr).assertModelWasFilled();
    }
}