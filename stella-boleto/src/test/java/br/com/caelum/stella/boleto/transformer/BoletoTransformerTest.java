package br.com.caelum.stella.boleto.transformer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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

	@Before
	public void setUp() {
		Datas datas = Datas.newDatas().comDocumento(4, 5, 2008)
				.comProcessamento(4, 5, 2008).comVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor().comCedente("Caue").comAgencia(
				"1824").comDvAgencia("4").comContaCorrente("76000")
				.comNumConvenio("1207113").comDvContaCorrete("5").comCarteira(
						"18").comNossoNumero("0009000206");

		Sacado sacado = Sacado.newSacado().comNome("Fulano da Silva").comCpf(
				"111.222.333-12").comEndereco("Av dos testes, 111 apto 333")
				.comBairro("Bairro Teste").comCep("01234-111").comCidade(
						"São Paulo").comUf("SP");

		String[] descricoes = { "descricao 1", "descricao 2", "descricao 3",
				"descricao 4", "descricao 5" };

		String[] locaisDePagamento = { "local 1", "local 2" };

		String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3",
				"instrucao 4", "instrucao 5" };

		Banco banco = new BancoDoBrasil();

		this.boleto = Boleto.newBoleto().comBanco(banco).comDatas(datas)
				.comDescricoes(descricoes).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("40.00").comNoDocumento(
						"4323").comInstrucoes(instrucoes).comLocaisDePagamento(
						locaisDePagamento);
	}

	@Test
	public void testPDFWrite() throws IOException {
		PDFBoletoWriter writer = new PDFBoletoWriter();

		BoletoTransformer transformer = new BoletoTransformer(writer);

		InputStream is = transformer.transform(this.boleto);

		File arquivo = new File("arquivo.pdf");
		FileOutputStream fos = new FileOutputStream(arquivo);

		byte[] b = new byte[is.available()];
		is.read(b);

		fos.write(b);
		fos.close();
	}

	@Test
	public void testPNGWrite() throws IOException {
		PNGBoletoWriter writer = new PNGBoletoWriter();

		BoletoTransformer transformer = new BoletoTransformer(writer);

		InputStream is = transformer.transform(this.boleto);

		File arquivo = new File("arquivo.png");
		FileOutputStream fos = new FileOutputStream(arquivo);

		byte[] b = new byte[is.available()];
		is.read(b);

		fos.write(b);
		fos.close();
	}
}
