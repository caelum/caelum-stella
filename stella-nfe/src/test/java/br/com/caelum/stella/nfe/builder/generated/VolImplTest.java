package br.com.caelum.stella.nfe.builder.generated;

public final class VolImplTest {
    @org.junit.Test
    public void testVolInterface() {
        Volume vol = new VolumeImpl().withQuantidade(1l).withEspecie("abc").withMarca("abc").withNumeracao("abc").withPesoLiquido("abc")
                .withPesoBruto("abc").withLacres(new LacresImpl());
        assertModelWasFilled(vol);
    }

    private void assertModelWasFilled(final Volume vol) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(vol).assertModelWasFilled();
    }
}