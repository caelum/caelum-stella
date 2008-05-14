package br.com.caelum.stella.boleto.bancos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.GregorianCalendar;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.BoletoPadrao;
import br.com.caelum.stella.boleto.DatasPadrao;
import br.com.caelum.stella.boleto.EmissorPadrao;
import br.com.caelum.stella.boleto.SacadoPadrao;
import br.com.caelum.stella.boleto.transformer.BoletoTransformer;
import br.com.caelum.stella.boleto.transformer.PDFBoletoWriter;
import br.com.caelum.stella.boleto.transformer.PNGBoletoWriter;

import com.lowagie.text.DocumentException;

public class Teste {

	public static void main(String[] args) throws NumberFormatException,
			IOException, DocumentException, ParseException {
		DatasPadrao datas = DatasPadrao.newDatas().comDocumento(
				new GregorianCalendar(5, 1, 2008)).comProcessamento(
				new GregorianCalendar(5, 1, 2008)).comVencimento(
				new GregorianCalendar(5, 2, 2008));

		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente(
				"Fulano de Tal").comAgencia("2345").comDvAgencia("6")
				.comContaCorrente("12345").comNumConvenio("1234567")
				.comDvContaCorrete("1").comCarteira("22").comNossoNumero(
						"0009050987");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome(
				"Fulano da Silva").comCpf("111.222.333-12").comEndereco(
				"Av dos testes, 111 apto 333").comBairro("Bairro Teste")
				.comCep("01234-111").comCidade("São Paulo").comUf("SP");

		Banco banco = new BancoDoBrasil();

		Boleto boleto = BoletoPadrao.newBoleto().comBanco(banco)
				.comDatas(datas).comDescricoes("descricao 1", "descricao 2",
						"descricao 3", "descricao 4", "descricao 5")
				.comEmissor(emissor).comSacado(sacado).comValorBoleto("200.00")
				.comNoDocumento("1234").comInstrucoes("instrucao 1",
						"instrucao 2", "instrucao 3", "instrucao 4",
						"instrucao 5").comLocaisDePagamento("local 1",
						"local 2").comNoDocumento("4343");

		geraPDF(boleto);
		geraPNG(boleto);
	}

	public static void geraPDF(Boleto boleto) throws NumberFormatException,
			IOException, DocumentException, ParseException {

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

	public static void geraPNG(Boleto boleto) throws NumberFormatException,
			IOException, DocumentException, ParseException {
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
