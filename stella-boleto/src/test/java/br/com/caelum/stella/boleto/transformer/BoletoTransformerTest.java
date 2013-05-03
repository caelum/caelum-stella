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
		datas = Datas.novasDatas().comDocumento(4, 5, 2008).comProcessamento(4, 5, 2008).comVencimento(2, 5, 2008);

		emissor = Emissor.novoEmissor().comCedente("Caue").comAgencia(1824).comDigitoAgencia('4')
				.comContaCorrente(76000).comNumeroConvenio(1207113).comDigitoContaCorrente('5').comCarteira(18)
				.comNossoNumero(9000206).comDigitoNossoNumero("7");

		sacado = Sacado.novoSacado().comNome("Fulano da Silva").comCpf("111.222.333-12")
				.comEndereco("Av dos testes, 111 apto 333").comBairro("Bairro Teste").comCep("01234-111")
				.comCidade("São Paulo").comUf("SP");

		String[] descricoes = { "descricao 1", "descricao 2", "descricao 3", "descricao 4", "descricao 5" };

		String[] locaisDePagamento = { "local 1", "local 2" };

		String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5" };

		banco = new BancoDoBrasil();

		boleto = Boleto.novoBoleto().comBanco(banco).comDatas(datas).comDescricoes(descricoes).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("40.00").comNumeroDoDocumento("4323").comInstrucoes(instrucoes)
				.comLocaisDePagamento(locaisDePagamento);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinimumDateForVencimento() {
		banco = new BancoDoBrasil();
		Datas datas = Datas.novasDatas().comDocumento(4, 5, 2008).comProcessamento(4, 5, 2008)
				.comVencimento(31, 12, 1979);
		boleto.comDatas(datas);
		boleto = boleto.comBanco(banco);
		transforma();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinimumDateForDocumento() {
		banco = new BancoDoBrasil();
		Datas datas = Datas.novasDatas().comDocumento(31, 12, 1979).comProcessamento(4, 5, 2008)
				.comVencimento(25, 8, 2008);
		boleto.comDatas(datas);
		boleto = boleto.comBanco(banco);
		transforma();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinimumDateForProcessamento() {
		banco = new BancoDoBrasil();
		Datas datas = Datas.novasDatas().comDocumento(4, 5, 2008).comProcessamento(31, 12, 1979)
				.comVencimento(25, 8, 2008);
		boleto.comDatas(datas);
		boleto = boleto.comBanco(banco);
		transforma();
	}

	@Test(expected = NullPointerException.class)
	public void testCriacaoDeBoletoSemDescricoes() {
		boleto.comDescricoes((String[]) null);

		transforma();
	}

	@Test(expected = NullPointerException.class)
	public void testCriacaoDeBoletoSemInstrucoes() {
		boleto.comInstrucoes((String[]) null);

		transforma();
	}

	@Test(expected = NullPointerException.class)
	public void testCriacaoDeBoletoSemLocaisDePagamento() {
		boleto.comLocaisDePagamento((String[]) null);

		transforma();
	}

	public void transforma() {

		class BoletoWriterMock implements BoletoWriter {

			@Override
			public InputStream toInputStream() {
				return null;
			}

			@Override
			public boolean newPage() {
				return false;
			}

			@Override
			public void write(final Boleto boleto) {
				Assert.assertNotNull(boleto);
			}
		}

		BoletoTransformer transformer = new BoletoTransformer(new BoletoWriterMock());
		transformer.transform(boleto);
	}
}
