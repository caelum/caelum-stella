package br.com.caelum.stella.boleto.transformer;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;

public class BoletoTransformerTest {

    private Boleto boleto;
    private Datas datas;
    private Emissor emissor;
    private Sacado sacado;
    private Banco banco;

    @Before
    public void setUp() {
        datas = Datas.newDatas().withDocumento(4, 5, 2008).withProcessamento(4, 5, 2008).withVencimento(2, 5, 2008);

        emissor = Emissor
                         .newEmissor()
                         .withCedente("Caue")
                         .withAgencia(1824)
                         .withDigitoAgencia('4')
                         .withContaCorrente(76000)
                         .withNumeroConvenio(1207113)
                         .withDigitoContaCorrente('5')
                         .withCarteira(18)
                         .withNossoNumero(9000206).withDigitoNossoNumero("7");

        sacado = Sacado
                       .newSacado()
                       .withNome("Fulano da Silva")
                       .withCpf("111.222.333-12")
                       .withEndereco("Av dos testes, 111 apto 333")
                       .withBairro("Bairro Teste")
                       .withCep("01234-111")
                       .withCidade("São Paulo")
                       .withUf("SP");

        String[] descricoes = { "descricao 1", "descricao 2", "descricao 3", "descricao 4", "descricao 5" };

        String[] locaisDePagamento = { "local 1", "local 2" };

        String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5" };

        banco = new BancoDoBrasil();

        boleto = Boleto
                       .newBoleto()
                       .withBanco(banco)
                       .withDatas(datas)
                       .withDescricoes(descricoes)
                       .withEmissor(emissor)
                       .withSacado(sacado)
                       .withValorBoleto("40.00")
                       .withNumeroDoDocumento("4323")
                       .withInstrucoes(instrucoes)
                       .withLocaisDePagamento(locaisDePagamento);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumDateForVencimento() {
        banco = new BancoDoBrasil();
        Datas datas = Datas.newDatas().withDocumento(4, 5, 2008).withProcessamento(4, 5, 2008).withVencimento(31, 12,
                1979);
        boleto.withDatas(datas);
        boleto = boleto.withBanco(banco);
        transforma();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumDateForDocumento() {
        banco = new BancoDoBrasil();
        Datas datas = Datas.newDatas().withDocumento(31, 12, 1979).withProcessamento(4, 5, 2008).withVencimento(25, 8,
                2008);
        boleto.withDatas(datas);
        boleto = boleto.withBanco(banco);
        transforma();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumDateForProcessamento() {
        banco = new BancoDoBrasil();
        Datas datas = Datas.newDatas().withDocumento(4, 5, 2008).withProcessamento(31, 12, 1979).withVencimento(25, 8,
                2008);
        boleto.withDatas(datas);
        boleto = boleto.withBanco(banco);
        transforma();
    }

    @Test(expected = NullPointerException.class)
    public void testCriacaoDeBoletoSemDescricoes() {
        boleto.withDescricoes((String[]) null);

        transforma();
    }

    @Test(expected = NullPointerException.class)
    public void testCriacaoDeBoletoSemInstrucoes() {
        boleto.withInstrucoes((String[]) null);

        transforma();
    }

    @Test(expected = NullPointerException.class)
    public void testCriacaoDeBoletoSemLocaisDePagamento() {
        boleto.withLocaisDePagamento((String[]) null);

        transforma();
    }

    public void transforma() {

        class BoletoWriterMock implements BoletoWriter {

            public InputStream toInputStream() {
                return null;
            }

            public boolean newPage() {
                return false;
            }

            public void write(final Boleto boleto) {
                Assert.assertNotNull(boleto);
            }
        }

        BoletoTransformer transformer = new BoletoTransformer(new BoletoWriterMock());
        transformer.transform(boleto);
    }
}
