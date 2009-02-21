package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.Impostos;

public final class DetImplTest {
    @org.junit.Test
    public void testDetInterface() {
        Det det = new DetImpl().withProd(new ProdImpl()).withImposto(new Impostos()).withInfAdProd("abc").withNItem(
                "abc");
        assertModelWasFilled(det);
    }

    private void assertModelWasFilled(final Det det) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(det).assertModelWasFilled();
    }
}