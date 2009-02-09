package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class TransportaImplTest {
    @org.junit.Test
    public void testTransportaInterface() {
        Transporta transporta = new TransportaImpl().withCNPJ(new CNPJ("abc")).withCPF(new CPF("abc")).withXNome("abc")
                .withIE("abc")
        .withXEnder("abc").withXMun("abc").withUF(TUf.AC);
        assertModelWasFilled(transporta);
    }

    private void assertModelWasFilled(final Transporta transporta) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(transporta).assertModelWasFilled();
    }
}