package br.com.caelum.stella.nfe.builder.generated;

public final class TRetConsCadImplTest {
    @org.junit.Test
    public void testTRetConsCadInterface() {
        TRetConsCad tRetConsCad = new TRetConsCadImpl().withInfCons(new InfConsImpl()).withVersao("abc");
        assertModelWasFilled(tRetConsCad);
    }

    private void assertModelWasFilled(final TRetConsCad tRetConsCad) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tRetConsCad).assertModelWasFilled();
    }
}