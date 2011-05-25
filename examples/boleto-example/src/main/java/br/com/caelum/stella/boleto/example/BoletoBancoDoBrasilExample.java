package br.com.caelum.stella.boleto.example;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;

public class BoletoBancoDoBrasilExample {
    public static void main(String[] args) {
		Datas datas = Datas.newDatas().withDocumento(1, 5, 2008)
				.withProcessamento(1, 5, 2008).withVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor()
		        .withCedente("Fulano de Tal")
		        .withAgencia(1824).withDigitoAgencia('4')
                .withContaCorrente(76000)
                .withNumeroConvenio(1207113)
                .withDigitoContaCorrente('5')
                .withCarteira(18)
                .withNossoNumero(9000206);

		Sacado sacado = Sacado.newSacado()
		    .withNome("Fulano da Silva")
		    .withCpf("111.222.333-12")
		    .withEndereco("Av dos testes, 111 apto 333")
			.withBairro("Bairro Teste")
			.withCep("01234-111")
			.withCidade("São Paulo")
			.withUf("SP");

		Banco banco = new BancoDoBrasil();

		Boleto boleto = Boleto.newBoleto()
		    .withBanco(banco)
		    .withDatas(datas)
		    .withDescricoes("descricao 1", "descricao 2", "descricao 3",
						"descricao 4", "descricao 5")
			.withEmissor(emissor)
			.withSacado(sacado)
			.withValorBoleto("200.00")
			.withNumeroDoDocumento("1234")
			.withInstrucoes("instrucao 1", "instrucao 2",
						"instrucao 3", "instrucao 4", "instrucao 5")
			.withLocaisDePagamento("local 1", "local 2")
			.withNumeroDoDocumento("4343");

		BoletoGenerator gerador = new BoletoGenerator(boleto);

		// Para gerar um boleto em PDF
		gerador.toPDF("BancoDoBrasil.pdf");

		// Para gerar um boleto em PNG
		gerador.toPNG("BancoDoBrasil.png");

		// Para gerar um array de bytes a partir de um PDF
		@SuppressWarnings("unused")
		byte[] bPDF = gerador.toPDF();

		// Para gerar um array de bytes a partir de um PNG
		@SuppressWarnings("unused")
		byte[] bPNG = gerador.toPNG();
	}
}
