package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSQtdeImplTest {
    @org.junit.Test
    public void testCOFINSQtdeInterface() {
        COFINSQtde cOFINSQtde = new COFINSQtdeImpl().withCodigoSituacaoTributaria("abc").withQuantidadeVendida("abc").withAliquota("abc")
                .withValor("abc");
        assertModelWasFilled(cOFINSQtde);
    }

    private void assertModelWasFilled(COFINSQtde cOFINSQtde) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSQtde).assertModelWasFilled();
    }
}