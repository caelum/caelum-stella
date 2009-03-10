package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class InfProtImplTest {
    @org.junit.Test
    public void testInfProtInterface() {
        DadosDoProtocolo infProt = new InfProtImpl().withTpAmb("abc").withVerAplic("abc").withChNFe("abc").withDhRecbto(
                Calendar.getInstance()).withNProt("abc").withDigVal("abc".getBytes()).withCodigoDeStatus("abc")
                .withXMotivo(
                "abc").withId("abc");
        assertModelWasFilled(infProt);
    }

    private void assertModelWasFilled(final DadosDoProtocolo infProt) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infProt).assertModelWasFilled();
    }
}