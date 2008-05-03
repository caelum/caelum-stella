package br.com.caelum.stella.boleto.transformer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Bancos;
import br.com.caelum.stella.boleto.BoletoPadrao;
import br.com.caelum.stella.boleto.DatasPadrao;
import br.com.caelum.stella.boleto.EmissorPadrao;
import br.com.caelum.stella.boleto.SacadoPadrao;

import com.lowagie.text.DocumentException;

public class BoletoTransformerTest {

	private BoletoPadrao boleto;

	@Before
	public void setUp() {
		DatasPadrao datas = DatasPadrao.newDatas().comDataDeDocumento(
				Calendar.getInstance()).comDataDeProcessamento(
				Calendar.getInstance()).comDataDeVencimento(
				Calendar.getInstance());

		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente("Caue")
				.comAgencia("0633").comContaCorrente("4720135")
				.comDvContaCorrete("6").comCarteira("18");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome("Fulano");

		List<String> descricoes = Arrays.asList("descricao 1", "descricao 2",
				"descricao 3", "descricao 4", "descricao 5");

		List<String> locaisDePagamento = Arrays.asList("loca1", "loca2");

		List<String> instrucoes = Arrays.asList("instrucao 1", "instrucao  2",
				"instrucao  3", "instrucao 4", "instrucao 5");

		this.boleto = BoletoPadrao.newBoleto().comBanco(Bancos.BANCO_DO_BRASIL)
				.comDatas(datas).comDescricoes(descricoes).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("2.00")
				.comNoDocumento("4323").comInstrucoes(instrucoes)
				.comLocaisDePagamento(locaisDePagamento);
	}
	
	@Test
	public void testPDFWrite() throws NumberFormatException, IOException, DocumentException, ParseException {
		BufferedImage template = ImageIO.read(BoletoTransformer.class.getResourceAsStream("/br/com/caelum/stella/boleto/img/template.png"));
		
		PDFBoletoWriter writer = new PDFBoletoWriter();
		System.out.println(template.getHeight());
		System.out.println(template.getWidth());
		
		BoletoTransformer transformer = new BoletoTransformer(writer);
		
		InputStream is = transformer.transform(boleto);
		
		File arquivo = new File("arquivo.pdf");
		FileOutputStream fos = new FileOutputStream(arquivo);

		byte[] b = new byte[is.available()];
		is.read(b);

		fos.write(b);
		fos.close();
	}
}
