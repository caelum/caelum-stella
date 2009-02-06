package br.com.caelum.stella.nfe.builder.generated;

public final class TranspImplTest {
    @org.junit.Test
    public void testTranspInterface() {
        Transp transp = new TranspImpl().withModFrete("abc").withTransporta(new TransportaImpl()).withRetTransp(
                new RetTranspImpl()).withVeicTransp(new TVeiculoImpl()).withReboque(new TVeiculoImpl()).withVol(
                new VolImpl());
        assertModelWasFilled(transp);
    }

    private void assertModelWasFilled(final Transp transp) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(transp).assertModelWasFilled();
    }
}