package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.UF;

public final class TEnderecoImplTest {
    @org.junit.Test
    public void testTEnderecoInterface() {
        Endereco<Object> tEndereco = new EnderecoImpl<Object>(new Object())
                                                                           .withLogradouro("abc")
                                                                           .withNumero("abc")
                                                                           .withComplemento("abc")
                                                                           .withBairro("abc")
                                                                           .withCodigoDoMunicipio("abc")
                                                                           .withNomeDoMunicipio("abc")
                                                                           .withUF(UF.AC)
                                                                           .withCEP("abc")
                                                                           .withCodigoDoPais("abc")
                                                                           .withNomeDoPais("abc")
                                                                           .withTelefone("abc");
        BuilderTestHelper.assertModelWasFilled(tEndereco);
    }

}