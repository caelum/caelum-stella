package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;

public final class AvulsaImplTest {

    @org.junit.Test
    public void testAvulsaInterface() {
        Avulsa avulsa = new AvulsaImpl().withCnpj(new CNPJ("abc")).withXOrgao("abc").withMatr("abc").withXAgente("abc").withFone(
                "abc").withUf(TUf.AC).withNdar("abc").withDEmi(Calendar.getInstance()).withVdar("abc")
                .withRepEmi("abc").withDPag(Calendar.getInstance());
        assertModelWasFilled(avulsa);
    }

    private void assertModelWasFilled(final Avulsa avulsa) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(avulsa).assertModelWasFilled();
    }
}