package br.com.caelum.stella.nfe.builder.generated;

public final class DetImplTest {
    @org.junit.Test
    public void testDetInterface() {
        Det det = new DetImpl().withProd(new ProdImpl()).withImposto(new ImpostoImpl()).withInfAdProd("abc").withNItem(
                "abc");
        assertModelWasFilled(det);
    }

    private void assertModelWasFilled(final Det det) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(det).assertModelWasFilled();
    }
}