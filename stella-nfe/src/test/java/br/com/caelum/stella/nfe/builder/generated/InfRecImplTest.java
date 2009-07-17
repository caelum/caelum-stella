package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class InfRecImplTest {
    @org.junit.Test
    public void testInfRecInterface() {
        ReciboDoLote<Object> infRec = new ReciboDoLoteImpl<Object>(new Object())
                                                                                .withNumeroDoRecibo("abc")
                                                                                .withDataEHoraDoRecebimento(
                                                                                        Calendar.getInstance())
                                                                                .withTempoMedioDeResposta("abc");
        BuilderTestHelper.assertModelWasFilled(infRec);
    }

}