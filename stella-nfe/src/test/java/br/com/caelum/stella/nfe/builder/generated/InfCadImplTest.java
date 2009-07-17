package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.TEndereco;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfCadImplTest {
    @org.junit.Test
    public void testInfCadInterface() {
        InfCad<Object> infCad = new InfCadImpl<Object>(new Object())
                                                                    .withIE("abc")
                                                                    .withCNPJ("abc")
                                                                    .withCPF("abc")
                                                                    .withUF(TUf.AC)
                                                                    .withCSit("abc")
                                                                    .withXNome("abc")
                                                                    .withXFant("abc")
                                                                    .withXRegApur("abc")
                                                                    .withCNAE("abc")
                                                                    .withDIniAtiv(Calendar.getInstance())
                                                                    .withDUltSit(Calendar.getInstance())
                                                                    .withDBaixa(Calendar.getInstance())
                                                                    .withIEUnica("abc")
                                                                    .withIEAtual("abc")
                                                                    .withEnder(new TEndereco());
        BuilderTestHelper.assertModelWasFilled(infCad);
    }

}