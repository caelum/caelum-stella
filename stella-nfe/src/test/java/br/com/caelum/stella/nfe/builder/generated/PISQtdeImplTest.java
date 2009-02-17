package br.com.caelum.stella.nfe.builder.generated;

public final class PISQtdeImplTest {
    @org.junit.Test
    public void testPISQtdeInterface() {
        PISQtde pISQtde = new PISQtdeImpl().withCodigoSituacaoTributaria("abc").withQuantidadeVendida("abc").withAliquota("abc").withVPIS("abc");
        assertModelWasFilled(pISQtde);
    }

    private void assertModelWasFilled(PISQtde pISQtde) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISQtde).assertModelWasFilled();
    }
}