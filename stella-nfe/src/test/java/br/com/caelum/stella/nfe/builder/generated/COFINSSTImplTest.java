package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSSTImplTest {
    @org.junit.Test
    public void testCOFINSSTInterface() {
        COFINSST cOFINSST = new COFINSSTImpl().withValorDaBaseDeCalculo(new BigDecimal(1)).withAliquotaEmPercentual(
                new BigDecimal(1)).withQuantidadeVendida(new BigDecimal("1")).withAliquota(new BigDecimal("1"))
                .withValor(new BigDecimal("1"));
        assertModelWasFilled(cOFINSST);
    }

    private void assertModelWasFilled(final COFINSST cOFINSST) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSST).assertModelWasFilled();
    }
}