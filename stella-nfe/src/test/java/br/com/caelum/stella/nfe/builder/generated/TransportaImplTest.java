package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class TransportaImplTest {
    @org.junit.Test
    public void testTransportaInterface() {
        Transportador transporta = new TransportadorImpl().withCNPJ(new CNPJ("abc")).withCPF(new CPF("abc")).withNome("abc")
                .withInscricaoEstadual("abc")
        .withEnderecoCompleto("abc").withNomeDoMunicipio("abc").withUF(UF.AC);
        assertModelWasFilled(transporta);
    }

    private void assertModelWasFilled(final Transportador transporta) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(transporta).assertModelWasFilled();
    }
}