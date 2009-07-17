package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class DestImplTest {
    @org.junit.Test
    public void testDestInterface() {
        Destinatario<Object> dest = new DestinatarioImpl<Object>(new Object()).withCNPJ(new CNPJ("abc")).withCPF(
                new CPF("abc")).withRazaoSocial("abc").withEndererecoDoDestinatario(
                new EnderecoImpl<Object>(new Object())).withInscricaoEstadual("abc").withInscricaoNaSUFRAMA("abc");
        BuilderTestHelper.assertModelWasFilled(dest);
    }

}