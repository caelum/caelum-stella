package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class DestImplTest {
    @org.junit.Test
    public void testDestInterface() {
        Dest dest = new DestImpl().withCNPJ(new CNPJ("abc")).withCPF(new CPF("abc")).withXNome("abc").withEnderDest(
                new TEnderecoImpl())
        .withIE("abc").withISUF("abc");
        assertModelWasFilled(dest);
    }

    private void assertModelWasFilled(final Dest dest) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(dest).assertModelWasFilled();
    }
}