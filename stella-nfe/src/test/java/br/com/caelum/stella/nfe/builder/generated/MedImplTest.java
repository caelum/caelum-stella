package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class MedImplTest {
    @org.junit.Test
    public void testMedInterface() {
        Medicamento<Object> med = new MedicamentoImpl<Object>(new Object())
                                                                           .withNumeroDoLote("abc")
                                                                           .withQuantidadeDoLote("abc")
                                                                           .withDataDeFabricacao(Calendar.getInstance())
                                                                           .withDataDeValidade(Calendar.getInstance())
                                                                           .withPrecoMaximoAoConsumidor(
                                                                                   new BigDecimal(1));
        BuilderTestHelper.assertModelWasFilled(med);
    }

}