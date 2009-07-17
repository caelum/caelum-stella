package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class TransportaImplTest {
    @org.junit.Test
    public void testTransportaInterface() {
        Transportador<Object> transporta = new TransportadorImpl<Object>(new Object())
                                                                                      .withCNPJ(new CNPJ("abc"))
                                                                                      .withCPF(new CPF("abc"))
                                                                                      .withNome("abc")
                                                                                      .withInscricaoEstadual("abc")
                                                                                      .withEnderecoCompleto("abc")
                                                                                      .withNomeDoMunicipio("abc")
                                                                                      .withUF(UF.AC);
        BuilderTestHelper.assertModelWasFilled(transporta);
    }

}