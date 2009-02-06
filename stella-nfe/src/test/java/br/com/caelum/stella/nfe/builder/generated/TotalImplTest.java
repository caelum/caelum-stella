package br.com.caelum.stella.nfe.builder.generated;

public final class TotalImplTest {
    @org.junit.Test
    public void testTotalInterface() {
        Total total = new TotalImpl().withICMSTot(new ICMSTotImpl()).withISSQNtot(new ISSQNtotImpl()).withRetTrib(
                new RetTribImpl());
        assertModelWasFilled(total);
    }

    private void assertModelWasFilled(final Total total) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(total).assertModelWasFilled();
    }
}