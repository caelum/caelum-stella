package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSNTImplTest {
    @org.junit.Test
    public void testCOFINSNTInterface() {
        COFINSNaoTributado cOFINSNT = new COFINSNaoTributadoImpl().withCodigoSituacaoTributaria("abc");
        assertModelWasFilled(cOFINSNT);
    }

    private void assertModelWasFilled(COFINSNaoTributado cOFINSNT) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSNT).assertModelWasFilled();
    }
}