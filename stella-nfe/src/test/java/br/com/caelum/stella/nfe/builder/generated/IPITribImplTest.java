package br.com.caelum.stella.nfe.builder.generated;

public final class IPITribImplTest {
    @org.junit.Test
    public void testIPITribInterface() {
        IPITrib iPITrib = new IPITribImpl().withCodigoSituacaoTributaria("abc").withValorDaBaseDeCalculo("abc").withAliquota("abc").withQuantidade("abc").withValorPorUnidade(
                "abc").withValor("abc");
        assertModelWasFilled(iPITrib);
    }

    private void assertModelWasFilled(IPITrib iPITrib) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iPITrib).assertModelWasFilled();
    }
}