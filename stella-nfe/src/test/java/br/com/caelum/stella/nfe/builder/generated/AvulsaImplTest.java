package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;

public final class AvulsaImplTest {

    private Avulsa avulsa;

    @Before
    public void fillAvulsaInterface() {
        avulsa = new AvulsaImpl()
        .withCnpj(new CNPJ("abc"))
        .withOrgaoEmitente("abc")
        .withMatriculaDoAgente("abc")
        .withNomeDoAgente("abc")
        .withTelefone(1234567890L)
        .withUf(UF.AC)
        .withNumeroDeArrecadacaoDaReceita("abc")
        .withDataDeEmissao(Calendar.getInstance())
        .withValorDoDocumentoDeArrecadacao(new BigDecimal(1))
        .withReparticaoFiscalEmitente("abc")
        .withDataDePagamento(Calendar.getInstance());
    }

    @Test
    public void assertTelefoneIsFilledWithoutL() {
        br.com.caelum.stella.nfe.modelo.Avulsa instance = ((AvulsaImpl) avulsa).getInstance();
        String fone = instance.getFone();
        boolean contains = fone.contains("L");
        String message = String.format("O telefone %s não deve conter o caracter L.", fone);
        Assert.assertFalse(message, contains);
    }

    @org.junit.Test
    public void assertModelWasFilled() {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(avulsa).assertModelWasFilled();
    }
}