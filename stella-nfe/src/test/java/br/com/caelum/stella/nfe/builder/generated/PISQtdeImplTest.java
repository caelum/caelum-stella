package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISQtdeImplTest {
    @org.junit.Test
    public void testPISQtdeInterface() {
        PISPorQuantidade pISQtde = new PISPorQuantidadeImpl().withQuantidadeVendida(new BigDecimal(1)).withAliquota(new BigDecimal(1))
                .withValorDoPIS(new BigDecimal(1));
        assertModelWasFilled(pISQtde);
    }

    private void assertModelWasFilled(final PISPorQuantidade pISQtde) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISQtde).assertModelWasFilled();
    }
}