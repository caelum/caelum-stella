package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;

public final class TLocalImplTest {
    @org.junit.Test
    public void testTLocalInterface() {
        DadosDoLocal<Object> tLocal = new DadosDoLocalImpl<Object>(new Object())
                                                                                .withCNPJ(new CNPJ("abc"))
                                                                                .withLogradouro("abc")
                                                                                .withNumero("abc")
                                                                                .withComplemento("abc")
                                                                                .withBairro("abc")
                                                                                .withCodigoDoMunicipio("abc")
                                                                                .withNomeDoMunicipio("abc")
                                                                                .withUF(UF.AC);
        BuilderTestHelper.assertModelWasFilled(tLocal);
    }

}