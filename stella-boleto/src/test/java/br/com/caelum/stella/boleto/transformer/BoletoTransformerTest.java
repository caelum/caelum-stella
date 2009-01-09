package br.com.caelum.stella.boleto.transformer;

import java.awt.image.BufferedImage;
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
        this.datas = Datas.newDatas().withDocumento(4, 5, 2008)
                .withProcessamento(4, 5, 2008).withVencimento(2, 5, 2008);

        this.emissor = Emissor.newEmissor().withCedente("Caue").withAgencia(
                1824).withDvAgencia('4').withContaCorrente(76000)
                .withNumConvenio(1207113).withDvContaCorrente('5')
                .withCarteira(18).withNossoNumero(9000206);

        this.sacado = Sacado.newSacado().withNome("Fulano da Silva").withCpf(
                "111.222.333-12").withEndereco("Av dos testes, 111 apto 333")
                .withBairro("Bairro Teste").withCep("01234-111").withCidade(
                        "São Paulo").withUf("SP");

        String[] descricoes = { "descricao 1", "descricao 2", "descricao 3",
                "descricao 4", "descricao 5" };

        String[] locaisDePagamento = { "local 1", "local 2" };

        String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3",
                "instrucao 4", "instrucao 5" };

        this.banco = new BancoDoBrasil();

        this.boleto = Boleto.newBoleto().withBanco(this.banco).withDatas(
                this.datas).withDescricoes(descricoes)
                .withEmissor(this.emissor).withSacado(this.sacado)
                .withValorBoleto("40.00").withNoDocumento("4323")
                .withInstrucoes(instrucoes).withLocaisDePagamento(
                        locaisDePagamento);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumDateForVencimento() {
        this.banco = new BancoDoBrasil();
        Datas datas = Datas.newDatas().withDocumento(4, 5, 2008)
                .withProcessamento(4, 5, 2008).withVencimento(31, 12, 1979);
        this.boleto.withDatas(datas);
        this.boleto = this.boleto.withBanco(this.banco);
        transforma();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumDateForDocumento() {
        this.banco = new BancoDoBrasil();
        Datas datas = Datas.newDatas().withDocumento(31, 12, 1979)
                .withProcessamento(4, 5, 2008).withVencimento(25, 8, 2008);
        this.boleto.withDatas(datas);
        this.boleto = this.boleto.withBanco(this.banco);
        transforma();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumDateForProcessamento() {
        this.banco = new BancoDoBrasil();
        Datas datas = Datas.newDatas().withDocumento(4, 5, 2008)
                .withProcessamento(31, 12, 1979).withVencimento(25, 8, 2008);
        this.boleto.withDatas(datas);
        this.boleto = this.boleto.withBanco(this.banco);
        transforma();
    }

    @Test(expected = NullPointerException.class)
    public void testCriacaoDeBoletoSemDescricoes() {
        this.boleto.withDescricoes((String[]) null);

        transforma();
    }

    @Test(expected = NullPointerException.class)
    public void testCriacaoDeBoletoSemInstrucoes() {
        this.boleto.withInstrucoes((String[]) null);

        transforma();
    }

    @Test(expected = NullPointerException.class)
    public void testCriacaoDeBoletoSemLocaisDePagamento() {
        this.boleto.withLocaisDePagamento((String[]) null);

        transforma();
    }

    public void transforma() {

        class BoletoWriterMock implements BoletoWriter {

            public void write(final float x, final float y, final String text) {
                Assert.assertNotNull(text);
            }

            public void writeBold(final float x, final float y,
                    final String text) {
                Assert.assertNotNull(text);
            }

            public void writeImage(final float x, final float y,
                    final BufferedImage image, final float width,
                    final float height) {
                Assert.assertNotNull(image);
            }

            public InputStream toInputStream() {
                return null;
            }

            public boolean newPage() {
                return false;
            }
        }

        BoletoTransformer transformer = new BoletoTransformer(
                new BoletoWriterMock());
        transformer.transform(this.boleto);
    }
}
