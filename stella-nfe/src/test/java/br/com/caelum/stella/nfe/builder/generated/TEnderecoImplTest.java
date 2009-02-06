package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class TEnderecoImplTest {
    @org.junit.Test
    public void testTEnderecoInterface() {
        TEndereco tEndereco = new TEnderecoImpl().withXLgr("abc").withNro("abc").withXCpl("abc").withXBairro("abc")
                .withCMun("abc").withXMun("abc").withUF(TUf.AC).withCEP("abc").withCPais("abc").withXPais("abc")
                .withFone("abc");
        assertModelWasFilled(tEndereco);
    }

    private void assertModelWasFilled(final TEndereco tEndereco) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tEndereco).assertModelWasFilled();
    }
}