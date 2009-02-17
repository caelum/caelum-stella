package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSOutrImplTest {
    @org.junit.Test
    public void testCOFINSOutrInterface() {
        COFINSOutr cOFINSOutr = new COFINSOutrImpl().withCodigoSituacaoTributaria("abc").withValorDaBaseDeCalculo("abc").withAliquotaEmPercentual("abc")
                .withQuantidadeVendida("abc").withAliquota("abc").withValor("abc");
        assertModelWasFilled(cOFINSOutr);
    }

    private void assertModelWasFilled(COFINSOutr cOFINSOutr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSOutr).assertModelWasFilled();
    }
}