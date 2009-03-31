package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSQtdeImplTest {
    @org.junit.Test
    public void testCOFINSQtdeInterface() {
        COFINSTributadoPelaQuantidade cOFINSQtde = new COFINSTributadoPelaQuantidadeImpl().withCodigoSituacaoTributaria("abc").withQuantidadeVendida(
                new BigDecimal("1")).withAliquota(new BigDecimal("1")).withValor(new BigDecimal("1"));
        assertModelWasFilled(cOFINSQtde);
    }

    private void assertModelWasFilled(final COFINSTributadoPelaQuantidade cOFINSQtde) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSQtde).assertModelWasFilled();
    }
}