package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISQtdeImplTest {
    @org.junit.Test
    public void testPISQtdeInterface() {
        PISQtde pISQtde = new PISQtdeImpl().withCodigoSituacaoTributaria("abc")
                .withQuantidadeVendida(new BigDecimal(1)).withAliquota(new BigDecimal(1)).withVPIS(new BigDecimal(1));
        assertModelWasFilled(pISQtde);
    }

    private void assertModelWasFilled(final PISQtde pISQtde) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISQtde).assertModelWasFilled();
    }
}