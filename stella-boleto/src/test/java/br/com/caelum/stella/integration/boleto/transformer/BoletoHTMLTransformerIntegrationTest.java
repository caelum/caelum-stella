package br.com.caelum.stella.integration.boleto.transformer;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.BoletoTransformer;
import br.com.caelum.stella.boleto.transformer.HTMLBoletoWriter;

/**
 * Test para testar o boleto html, deixei em um teste separado pois ainda não
 * foi colocado no BoletoGenerator.
 * 
 * @author Alberto
 * 
 */
public class BoletoHTMLTransformerIntegrationTest {

	@Before
	public void setUp() throws Exception {

		Locale.setDefault(new Locale("pt", "br"));

		Boleto boleto;
		Datas datas = Datas.novasDatas().comDocumento(4, 5, 2008).comProcessamento(4, 5, 2008)
				.comVencimento(2, 5, 2008);
		Emissor emissor = Emissor.novoEmissor().comCedente("Caue").comAgencia(1824).comDigitoAgencia('4')
				.comContaCorrente(76000).comNumeroConvenio(1207113).comDigitoContaCorrente('5').comCarteira(18)
				.comNossoNumero(9000206);

		Sacado sacado = Sacado.novoSacado().comNome("Fulano da Silva").comCpf("111.222.333-12")
				.comEndereco("Av dos testes, 111 apto 333").comBairro("Bairro Teste").comCep("01234-111")
				.comCidade("São Paulo").comUf("SP");

		String[] descricoes = { "descricao 1", "descricao 2", "descricao 3", "descricao 4", "descricao 5" };

		String[] locaisDePagamento = { "local 1", "local 2" };

		String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5" };

		Banco banco = new BancoDoBrasil();

		boleto = Boleto.novoBoleto().comBanco(banco).comDatas(datas).comDescricoes(descricoes).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("40.00").comNumeroDoDocumento("4323").comInstrucoes(instrucoes)
				.comLocaisDePagamento(locaisDePagamento);

		BoletoTransformer transformer = new BoletoTransformer(new HTMLBoletoWriter(
				"http://localhost:8080/caelum-stella-boleto/stella-boleto/"));
		InputStream is = transformer.transform(boleto);
		@SuppressWarnings("resource")
		FileOutputStream arquivo = new FileOutputStream("arquivo.html");
		byte[] bytes = new byte[is.available()];
		is.read(bytes);
		arquivo.write(bytes);

	}

	@Test
	public void testHTMLWriterGeneration() {
		assertTrue(new File("arquivo.html").exists());
	}

	@Test
	public void testHTMLWriterEscreveValorCorreto() {
		System.out.println(lerArquivo());
		assertTrue(lerArquivo().contains("40,00"));
	}

	@Test
	public void testHTMLWriterEscreveLinhaDigitavelCorreta() {
		assertTrue(lerArquivo().contains("00190.00009  01207.113000  09000.206186  5  38600000004000"));
	}

	private String lerArquivo() {
		try {
			@SuppressWarnings("resource")
			FileInputStream fileInputStream = new FileInputStream(new File("arquivo.html"));
			int c = 0;
			StringBuffer boleto = new StringBuffer();
			while ((c = fileInputStream.read()) != -1) {
				boleto.append((char) c);
			}
			return boleto.toString();
		} catch (FileNotFoundException fileNotFoundException) {
			throw new RuntimeException(fileNotFoundException);
		} catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

}
