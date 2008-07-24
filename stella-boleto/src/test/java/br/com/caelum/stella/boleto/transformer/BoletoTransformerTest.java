package br.com.caelum.stella.boleto.transformer;

import java.awt.image.BufferedImage;
import java.io.IOException;
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
	datas = Datas.newDatas().withDocumento(4, 5, 2008).withProcessamento(4,
		5, 2008).withVencimento(2, 5, 2008);

	emissor = Emissor.newEmissor().withCedente("Caue").withAgencia(1824)
		.withDvAgencia("4").withContaCorrente(76000).withNumConvenio(
			1207113).withDvContaCorrete("5").withCarteira(18)
		.withNossoNumero(9000206);

	sacado = Sacado.newSacado().withNome("Fulano da Silva").withCpf(
		"111.222.333-12").withEndereco("Av dos testes, 111 apto 333")
		.withBairro("Bairro Teste").withCep("01234-111").withCidade(
			"São Paulo").withUf("SP");

	String[] descricoes = { "descricao 1", "descricao 2", "descricao 3",
		"descricao 4", "descricao 5" };

	String[] locaisDePagamento = { "local 1", "local 2" };

	String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3",
		"instrucao 4", "instrucao 5" };

	banco = new BancoDoBrasil();

	boleto = Boleto.newBoleto().withBanco(banco).withDatas(datas)
		.withDescricoes(descricoes).withEmissor(emissor).withSacado(
			sacado).withValorBoleto("40.00")
		.withNoDocumento("4323").withInstrucoes(instrucoes)
		.withLocaisDePagamento(locaisDePagamento);
    }

    @Test(expected = NullPointerException.class)
    public void testCriacaoDeBoletoSemDescricoes() {
	boleto.withDescricoes(null);

	transforma();
    }

    @Test(expected = NullPointerException.class)
    public void testCriacaoDeBoletoSemInstrucoes() {
	boleto.withInstrucoes(null);

	transforma();
    }

    @Test(expected = NullPointerException.class)
    public void testCriacaoDeBoletoSemLocaisDePagamento() {
	boleto.withLocaisDePagamento(null);

	transforma();
    }

    public void transforma() {

	class BoletoWriterMock implements BoletoWriter {

	    public void write(float x, float y, String text) {
		Assert.assertNotNull(text);
	    }

	    public void writeBold(float x, float y, String text) {
		Assert.assertNotNull(text);
	    }

	    public void writeImage(float x, float y, BufferedImage image,
		    float width, float height) throws IOException {
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
	transformer.transform(boleto);
    }
}
