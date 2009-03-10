package br.com.caelum.stella.nfe.builder.generated;

public final class PISNTImplTest {
    @org.junit.Test
    public void testPISNTInterface() {
        PISNaoTributado pISNT = new PISNaoTributadoImpl().withCodigoSituacaoTributaria("abc");
        assertModelWasFilled(pISNT);
    }

    private void assertModelWasFilled(PISNaoTributado pISNT) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISNT).assertModelWasFilled();
    }
}