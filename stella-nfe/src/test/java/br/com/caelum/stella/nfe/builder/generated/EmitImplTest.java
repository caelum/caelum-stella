package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class EmitImplTest {
    @org.junit.Test
    public void testEmitInterface() {
        Emitente emit = new EmitenteImpl().withCNPJ(new CNPJ("abc")).withCPF(new CPF("abc")).withRazaoSocial("abc").withNomeFantasia("abc")
                .withEnderecoDoEmitente(
                new EnderecoImpl()).withInscricaoEstadual("abc").withInscricaoEstadualDoSubstitutoTributario("abc").withInscricaoMunicipal("abc").withCNAEFiscal("abc");
        assertModelWasFilled(emit);
    }

    private void assertModelWasFilled(final Emitente emit) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(emit).assertModelWasFilled();
    }
}