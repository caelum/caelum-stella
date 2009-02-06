package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class TransportaImplTest {
    @org.junit.Test
    public void testTransportaInterface() {
        Transporta transporta = new TransportaImpl().withCNPJ("abc").withCPF("abc").withXNome("abc").withIE("abc")
                .withXEnder("abc").withXMun("abc").withUF(TUf.AC);
        assertModelWasFilled(transporta);
    }

    private void assertModelWasFilled(final Transporta transporta) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(transporta).assertModelWasFilled();
    }
}