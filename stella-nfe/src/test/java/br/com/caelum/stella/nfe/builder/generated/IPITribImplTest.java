package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class IPITribImplTest {
    @org.junit.Test
    public void testIPITribInterface() {
        IPITrib iPITrib = new IPITribImpl().withCodigoSituacaoTributaria("abc").withValorDaBaseDeCalculo(
                new BigDecimal(1)).withAliquota(new BigDecimal(1)).withQuantidade("abc").withValorPorUnidade(
                "abc").withValor("abc");
        assertModelWasFilled(iPITrib);
    }

    private void assertModelWasFilled(IPITrib iPITrib) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iPITrib).assertModelWasFilled();
    }
}