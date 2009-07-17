package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class InfInutImplTest {
    @org.junit.Test
    public void testInfInutInterface() {
        InfInut<Object> infInut = new InfInutImpl<Object>(new Object())
                                                                       .withTpAmb("abc")
                                                                       .withVerAplic("abc")
                                                                       .withCStat("abc")
                                                                       .withXMotivo("abc")
                                                                       .withCUF("abc")
                                                                       .withAno("abc")
                                                                       .withCNPJ("abc")
                                                                       .withMod("abc")
                                                                       .withSerie("abc")
                                                                       .withNNFIni("abc")
                                                                       .withNNFFin("abc")
                                                                       .withDhRecbto(Calendar.getInstance())
                                                                       .withNProt("abc")
                                                                       .withId("abc");
        BuilderTestHelper.assertModelWasFilled(infInut);
    }
}