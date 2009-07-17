package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class InfProtImplTest {
    @org.junit.Test
    public void testInfProtInterface() {
        Protocolo<Object> infProt = new ProtocoloImpl<Object>(new Object())
                                                                           .withTipoDoAmbiente(
                                                                                   TipoDoAmbiente.HOMOLOGACAO)
                                                                           .withVersaoDoAplicativo("abc")
                                                                           .withChaveDeAcessoDaNFE("abc")
                                                                           .withDataEHoraDoProcessamento(
                                                                                   Calendar.getInstance())
                                                                           .withNumeroDoProtocoloDeStatusDaNFE("abc")
                                                                           .withDigestValue("abc".getBytes())
                                                                           .withCodigoDeStatus("abc")
                                                                           .withDescricaoDoMotivo("abc")
                                                                           .withId("abc");
        BuilderTestHelper.assertModelWasFilled(infProt);
    }

}