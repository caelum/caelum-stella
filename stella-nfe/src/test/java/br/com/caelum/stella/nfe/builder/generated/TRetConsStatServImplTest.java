package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TRetConsStatServImplTest {
    @org.junit.Test
    public void testTRetConsStatServInterface() {
        TRetConsStatServ<Object> tRetConsStatServ = new TRetConsStatServImpl<Object>(new Object())
                                                                                                  .withTpAmb("abc")
                                                                                                  .withVerAplic("abc")
                                                                                                  .withCStat("abc")
                                                                                                  .withXMotivo("abc")
                                                                                                  .withCUF("abc")
                                                                                                  .withDhRecbto(
                                                                                                          Calendar
                                                                                                                  .getInstance())
                                                                                                  .withTMed("abc")
                                                                                                  .withDhRetorno(
                                                                                                          Calendar
                                                                                                                  .getInstance())
                                                                                                  .withXObs("abc")
                                                                                                  .withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tRetConsStatServ);
    }

}