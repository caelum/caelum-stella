package br.com.caelum.stella.nfe.builder.generated;

public final class TConsCadImplTest {
    @org.junit.Test
    public void testTConsCadInterface() {
        TConsCad tConsCad = new TConsCadImpl().withInfCons(new InfConsImpl()).withVersao("abc");
        assertModelWasFilled(tConsCad);
    }

    private void assertModelWasFilled(final TConsCad tConsCad) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tConsCad).assertModelWasFilled();
    }
}