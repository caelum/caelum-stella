package br.com.caelum.stella.nfe.builder.generated;

public final class CobrImplTest {
    @org.junit.Test
    public void testCobrInterface() {
        Cobranca cobr = new CobrancaImpl().withFatura(new FaturaImpl()).withDuplicatas(new DuplicataImpl());
        assertModelWasFilled(cobr);
    }

    private void assertModelWasFilled(final Cobranca cobr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cobr).assertModelWasFilled();
    }
}