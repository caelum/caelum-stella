package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class DestImplTest {
    @org.junit.Test
    public void testDestInterface() {
        Destinatario dest = new DestinatarioImpl().withCNPJ(new CNPJ("abc")).withCPF(new CPF("abc")).withRazaoSocial("abc").withEndererecoDoDestinatario(
                new EnderecoImpl())
        .withInscricaoEstadual("abc").withInscricaoNaSUFRAMA("abc");
        assertModelWasFilled(dest);
    }

    private void assertModelWasFilled(final Destinatario dest) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(dest).assertModelWasFilled();
    }
}