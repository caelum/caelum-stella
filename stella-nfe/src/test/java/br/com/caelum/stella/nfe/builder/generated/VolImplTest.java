package br.com.caelum.stella.nfe.builder.generated;

public final class VolImplTest {
    @org.junit.Test
    public void testVolInterface() {
        Vol vol = new VolImpl().withQVol(1l).withEsp("abc").withMarca("abc").withNVol("abc").withPesoL("abc")
                .withPesoB("abc").withLacres(new LacresImpl());
        assertModelWasFilled(vol);
    }

    private void assertModelWasFilled(final Vol vol) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(vol).assertModelWasFilled();
    }
}