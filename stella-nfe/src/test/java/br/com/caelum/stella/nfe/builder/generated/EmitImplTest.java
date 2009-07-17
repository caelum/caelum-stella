package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class EmitImplTest {
    @org.junit.Test
    public void testEmitInterface() {
        Emitente<Object> emit = new EmitenteImpl<Object>(new Object())
                                                                      .withCNPJ(new CNPJ("abc"))
                                                                      .withCPF(new CPF("abc"))
                                                                      .withRazaoSocial("abc")
                                                                      .withNomeFantasia("abc")
                                                                      .withEnderecoDoEmitente(
                                                                              new EnderecoImpl<Object>(new Object()))
                                                                      .withInscricaoEstadual("abc")
                                                                      .withInscricaoEstadualDoSubstitutoTributario(
                                                                              "abc")
                                                                      .withInscricaoMunicipal("abc")
                                                                      .withCNAEFiscal("abc");
        BuilderTestHelper.assertModelWasFilled(emit);
    }

}