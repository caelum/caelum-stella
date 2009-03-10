package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;

public final class TLocalImplTest {
    @org.junit.Test
    public void testTLocalInterface() {
        DadosDoLocal tLocal = new DadosDoLocalImpl().withCNPJ(new CNPJ("abc")).withLogradouro("abc").withNumero("abc").withComplemento("abc").withBairro(
                "abc").withCodigoDoMunicipio("abc").withNomeDoMunicipio("abc").withUF(UF.AC);
        assertModelWasFilled(tLocal);
    }

    private void assertModelWasFilled(final DadosDoLocal tLocal) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tLocal).assertModelWasFilled();
    }
}