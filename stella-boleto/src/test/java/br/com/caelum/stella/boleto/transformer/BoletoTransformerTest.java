package br.com.caelum.stella.boleto.transformer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.BancoDoBrasil;
import br.com.caelum.stella.boleto.BoletoPadrao;
import br.com.caelum.stella.boleto.DatasPadrao;
import br.com.caelum.stella.boleto.EmissorPadrao;
import br.com.caelum.stella.boleto.SacadoPadrao;

import com.lowagie.text.DocumentException;

// TODO:  isso é um teste de integracao!
public class BoletoTransformerTest {

	private BoletoPadrao boleto;

	@Before
	public void setUp() {
		DatasPadrao datas = DatasPadrao.newDatas().comDocumento(
				Calendar.getInstance()).comProcessamento(
				Calendar.getInstance()).comVencimento(
				Calendar.getInstance());

		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente("Empresa de Teste")
				.comAgencia("1111").comDvAgencia("1").comContaCorrente("2222222")
				.comDvContaCorrete("3").comCarteira("33").comNossoNumero("34512398789");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome("Fulano da Silva")
										  .comCpf("111.222.333-12")
										  .comEndereco("Av dos testes, 111 apto 333")
										  .comBairro("Bairro Teste")
										  .comCep("01234-111")
										  .comCidade("São Paulo")
										  .comUf("SP");

		String[] descricoes = { "descricao 1", "descricao 2", "descricao 3",
				"descricao 4", "descricao 5" };

		String[] locaisDePagamento = { "local 1", "local 2" };

		String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3",
				"instrucao 4", "instrucao 5" };
		
		Banco banco = new BancoDoBrasil();

		this.boleto = BoletoPadrao.newBoleto().comBanco(banco)
				.comDatas(datas).comDescricoes(descricoes).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("2.00")
				.comNoDocumento("4323").comInstrucoes(instrucoes)
				.comLocaisDePagamento(locaisDePagamento);
	}
	
	@Test
	public void testPDFWrite() throws NumberFormatException, IOException, DocumentException, ParseException {	
		PDFBoletoWriter writer = new PDFBoletoWriter();
		
		BoletoTransformer transformer = new BoletoTransformer(writer);
		
		InputStream is = transformer.transform(boleto);
		
		File arquivo = new File("arquivo.pdf");
		FileOutputStream fos = new FileOutputStream(arquivo);

		byte[] b = new byte[is.available()];
		is.read(b);

		fos.write(b);
		fos.close();
	}
	
	
	@Test
	public void testPNGWrite() throws NumberFormatException, IOException, DocumentException, ParseException {
		PNGBoletoWriter writer = new PNGBoletoWriter();
		
		BoletoTransformer transformer = new BoletoTransformer(writer);
		
		InputStream is = transformer.transform(boleto);
		
		File arquivo = new File("arquivo.png");
		FileOutputStream fos = new FileOutputStream(arquivo);

		byte[] b = new byte[is.available()];
		is.read(b);

		fos.write(b);
		fos.close();
	}
}
