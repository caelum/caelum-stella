package br.com.caelum.stella.nfe.builder.generated;

public final class TotalImplTest {
    @org.junit.Test
    public void testTotalInterface() {
        TotalNFE total = new TotalNFEImpl().withICMSTotal(new ICMSTotalImpl()).withISSQNTotal(new ISSQNtotImpl()).withRetencaoDeTributosFederais(
                new RetencaoDeTributosFederaisImpl());
        assertModelWasFilled(total);
    }

    private void assertModelWasFilled(final TotalNFE total) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(total).assertModelWasFilled();
    }
}