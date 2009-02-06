package br.com.caelum.stella.nfe.builder.generated;

public final class ArmaImplTest {
    @org.junit.Test
    public void testArmaInterface() {
        Arma arma = new ArmaImpl().withTpArma("abc").withNSerie("abc").withNCano("abc").withDescr("abc");
        assertModelWasFilled(arma);
    }

    private void assertModelWasFilled(Arma arma) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(arma).assertModelWasFilled();
    }
}