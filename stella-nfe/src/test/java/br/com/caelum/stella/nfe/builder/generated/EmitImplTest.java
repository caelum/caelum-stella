package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class EmitImplTest {
    @org.junit.Test
    public void testEmitInterface() {
        Emit emit = new EmitImpl().withCNPJ(new CNPJ("abc")).withCPF(new CPF("abc")).withXNome("abc").withXFant("abc")
                .withEnderEmit(
                new EnderecoImpl()).withIE("abc").withIEST("abc").withIM("abc").withCNAE("abc");
        assertModelWasFilled(emit);
    }

    private void assertModelWasFilled(final Emit emit) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(emit).assertModelWasFilled();
    }
}