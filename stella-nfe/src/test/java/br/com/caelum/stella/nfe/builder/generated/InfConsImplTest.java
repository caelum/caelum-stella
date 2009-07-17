package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.TUfCons;

public final class InfConsImplTest {
    @org.junit.Test
    public void testInfConsInterface() {
        InfCons<Object> infCons = new InfConsImpl<Object>(new Object())
                                                                       .withVerAplic("abc")
                                                                       .withCStat("abc")
                                                                       .withXMotivo("abc")
                                                                       .withUF(TUfCons.AC)
                                                                       .withIE("abc")
                                                                       .withCNPJ("abc")
                                                                       .withCPF("abc")
                                                                       .withDhCons(Calendar.getInstance())
                                                                       .withCUF("abc")
                                                                       .withInfCad(new ArrayList<InfCad<?>>());
        BuilderTestHelper.assertModelWasFilled(infCons);
    }

}