package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class TEnderecoImplTest {
    @org.junit.Test
    public void testTEnderecoInterface() {
        Endereco tEndereco = new EnderecoImpl().withLogradouro("abc").withNumero("abc").withComplemento("abc").withBairro("abc")
                .withCodigoDoMunicipio("abc").withNomeDoMunicipio("abc").withUF(UF.AC).withCEP("abc").withCodigoDoPais("abc").withNomeDoPais("abc")
                .withTelefone("abc");
        assertModelWasFilled(tEndereco);
    }

    private void assertModelWasFilled(final Endereco tEndereco) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tEndereco).assertModelWasFilled();
    }
}