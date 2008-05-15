package br.com.caelum.stella.boleto.example;

import java.io.InputStream;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;
import br.com.caelum.stella.boleto.transformer.BoletoTransformer;
import br.com.caelum.stella.boleto.transformer.BoletoWriter;
import br.com.caelum.stella.boleto.transformer.PDFBoletoWriter;
import br.com.caelum.stella.boleto.transformer.PNGBoletoWriter;

public class BoletoExample {
	public static void main(String[] args) {
		Datas datas = Datas.newDatas().comDocumento(4, 5, 2008)
				.comProcessamento(4, 5, 2008).comVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor().comCedente("Fulano de Tal")
				.comAgencia("2345").comDvAgencia("6").comContaCorrente("12345")
				.comNumConvenio("1234567").comDvContaCorrete("1").comCarteira(
						"22").comNossoNumero("0009050987");

		Sacado sacado = Sacado.newSacado().comNome("Fulano da Silva").comCpf(
				"111.222.333-12").comEndereco("Av dos testes, 111 apto 333")
				.comBairro("Bairro Teste").comCep("01234-111").comCidade(
						"São Paulo").comUf("SP");

		Banco banco = new BancoDoBrasil();

		Boleto boleto = Boleto.newBoleto().comBanco(banco).comDatas(datas)
				.comDescricoes("descricao 1", "descricao 2", "descricao 3",
						"descricao 4", "descricao 5").comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("200.00").comNoDocumento(
						"1234").comInstrucoes("instrucao 1", "instrucao 2",
						"instrucao 3", "instrucao 4", "instrucao 5")
				.comLocaisDePagamento("local 1", "local 2").comNoDocumento(
						"4343");

		BoletoGenerator gerador = new BoletoGenerator(boleto);

		// Para gerar um boleto em PDF
		gerador.toPDF("teste.pdf");

		// Para gerar um boleto em PNG
		gerador.toPNG("teste.png");

		// Para gerar um InputStream a partir de um PDF
		BoletoWriter PDFwriter = new PDFBoletoWriter();
		BoletoTransformer PDFtransformer = new BoletoTransformer(PDFwriter);
		InputStream PDFis = PDFtransformer.transform(boleto);

		// Para gerar um InputStream a partir de um PNG
		BoletoWriter PNGwriter = new PNGBoletoWriter();
		BoletoTransformer PNGtransformer = new BoletoTransformer(PNGwriter);
		InputStream PNGis = PNGtransformer.transform(boleto);
	}
}
