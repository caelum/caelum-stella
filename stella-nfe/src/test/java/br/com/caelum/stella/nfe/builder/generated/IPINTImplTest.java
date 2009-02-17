package br.com.caelum.stella.nfe.builder.generated;

public final class IPINTImplTest {
    @org.junit.Test
    public void testIPINTInterface() {
        IPINT iPINT = new IPINTImpl().withCodigoSituacaoTributaria("abc");
        assertModelWasFilled(iPINT);
    }

    private void assertModelWasFilled(IPINT iPINT) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iPINT).assertModelWasFilled();
    }
}