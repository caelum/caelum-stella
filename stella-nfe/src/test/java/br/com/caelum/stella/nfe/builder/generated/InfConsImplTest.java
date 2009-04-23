package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TUfCons;

public final class InfConsImplTest {
    @org.junit.Test
    public void testInfConsInterface() {
        InfCons infCons = new InfConsImpl()
                                           .withVerAplic("abc")
                                           .withCStat("abc")
                                           .withXMotivo("abc")
                                           .withUF(TUfCons.AC)
                                           .withIE("abc")
                                           .withCNPJ("abc")
                                           .withCPF("abc")
                                           .withDhCons(Calendar.getInstance())
                                           .withCUF("abc")
                                           .withInfCad(new ArrayList<InfCad>());
        assertModelWasFilled(infCons);
    }

    private void assertModelWasFilled(final InfCons infCons) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infCons).assertModelWasFilled();
    }
}