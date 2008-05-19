package br.com.caelum.stella.integration.boleto.transformer;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;

/**
 * Teste de INTEGRACAO apesar de estar no de unidade FIXME
 * 
 */
public class BoletoTransformerTest {

	private Boleto boleto;

	@Before
	public void setUp() {
		Datas datas = Datas.newDatas().withDocumento(4, 5, 2008)
				.withProcessamento(4, 5, 2008).withVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor().withCedente("Caue").withAgencia(
				"1824").withDvAgencia("4").withContaCorrente("76000")
				.withNumConvenio("1207113").withDvContaCorrete("5")
				.withCarteira("18").withNossoNumero("9000206");

		Sacado sacado = Sacado.newSacado().withNome("Fulano da Silva").withCpf(
				"111.222.333-12").withEndereco("Av dos testes, 111 apto 333")
				.withBairro("Bairro Teste").withCep("01234-111").withCidade(
						"São Paulo").withUf("SP");

		String[] descricoes = { "descricao 1", "descricao 2", "descricao 3",
				"descricao 4", "descricao 5" };

		String[] locaisDePagamento = { "local 1", "local 2" };

		String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3",
				"instrucao 4", "instrucao 5" };

		Banco banco = new BancoDoBrasil();

		this.boleto = Boleto.newBoleto().withBanco(banco).withDatas(datas)
				.withDescricoes(descricoes).withEmissor(emissor).withSacado(
						sacado).withValorBoleto("40.00")
				.withNoDocumento("4323").withInstrucoes(instrucoes)
				.withLocaisDePagamento(locaisDePagamento);
	}

	@Test
	public void testPDFWrite() {
		BoletoGenerator generator = new BoletoGenerator(this.boleto);

		generator.toPDF("arquivo.pdf");
		// TODO: check se ele foi gravado e tem mesmo tamanho que o InputStream
		// gerado
	}

	@Test
	public void testPNGWrite() {
		BoletoGenerator generator = new BoletoGenerator(this.boleto);

		generator.toPNG("arquivo.png");
		// TODO: check se ele foi gravado e tem mesmo tamanho que o InputStream
		// gerado
	}
}
