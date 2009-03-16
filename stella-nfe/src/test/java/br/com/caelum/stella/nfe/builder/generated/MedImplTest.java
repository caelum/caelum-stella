package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

public final class MedImplTest {
    @org.junit.Test
    public void testMedInterface() {
        Medicamento med = new MedicamentoImpl().withNumeroDoLote("abc").withQuantidadeDoLote("abc").withDataDeFabricacao(Calendar.getInstance()).withDataDeValidade(
                Calendar.getInstance()).withPrecoMaximoAoConsumidor(new BigDecimal(1));
        assertModelWasFilled(med);
    }

    private void assertModelWasFilled(final Medicamento med) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(med).assertModelWasFilled();
    }
}