package br.com.caelum.stella.boleto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.stella.boleto.transformer.PDFBoletoTransformer;

import com.lowagie.text.DocumentException;

public class BoletoPadraoTest {

	// TODO: integration test!
	@Test
	public void testNewBoleto() throws NumberFormatException, IOException,
			DocumentException, ParseException {

		DatasPadrao datas = DatasPadrao.newDatas().comDataDeDocumento(
				Calendar.getInstance()).comDataDeProcessamento(
				Calendar.getInstance()).comDataDeVencimento(
				Calendar.getInstance());

		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente("Caue")
				.comAgencia("0633").comContaCorrente("4720135")
				.comDvContaCorrete("6").comCarteira("18").comNossoNumero("12345").comNumConvenio("232323");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome("Fulano");

		String[] descricoes = { "descricao 1", "descricao 2", "descricao 3",
				"descricao 4", "descricao 5" };

		String[] locaisDePagamento = { "local 1", "local 2" };

		String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3",
				"instrucao 4", "instrucao 5" };

		BoletoPadrao boleto = BoletoPadrao.newBoleto().comBanco(
				Bancos.BANCO_DO_BRASIL).comDatas(datas).comDescricoes(
				descricoes).comEmissor(emissor).comSacado(sacado)
				.comValorBoleto("2.00").comNoDocumento("4323").comInstrucoes(
						instrucoes).comLocaisDePagamento(locaisDePagamento);

		PDFBoletoTransformer pdf = new PDFBoletoTransformer();
		InputStream is = pdf.transform(boleto);

		File arquivo = new File("arquivo.pdf");
		FileOutputStream fos = new FileOutputStream(arquivo);

		byte[] b = new byte[is.available()];
		is.read(b);

		fos.write(b);
		fos.close();
	}
}
