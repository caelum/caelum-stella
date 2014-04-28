package br.com.caelum.stella.boleto.example;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

public class BoletoBancoDoBrasilExample {
    public static void main(String[] args) {
		Datas datas = Datas.novasDatas().comDocumento(1, 5, 2008)
				.comProcessamento(1, 5, 2008).comVencimento(2, 5, 2008);

		Emissor emissor = Emissor.novoEmissor()
		        .comCedente("Fulano de Tal")
		        .comAgencia(1824).comDigitoAgencia('4')
                .comContaCorrente(76000)
                .comNumeroConvenio(1207113)
                .comDigitoContaCorrente('5')
                .comCarteira(18)
                .comNossoNumero(9000206);

		Sacado sacado = Sacado.novoSacado()
		    .comNome("Fulano da Silva")
		    .comCpf("111.222.333-12")
		    .comEndereco("Av dos testes, 111 apto 333")
			.comBairro("Bairro Teste")
			.comCep("01234-111")
			.comCidade("São Paulo")
			.comUf("SP");

		Banco banco = new BancoDoBrasil();

		Boleto boleto = Boleto.novoBoleto()
		    .comBanco(banco)
		    .comDatas(datas)
		    .comDescricoes("descricao 1", "descricao 2", "descricao 3",
						"descricao 4", "descricao 5")
			.comEmissor(emissor)
			.comSacado(sacado)
			.comValorBoleto("200.00")
			.comNumeroDoDocumento("1234")
			.comInstrucoes("instrucao 1", "instrucao 2",
						"instrucao 3", "instrucao 4", "instrucao 5")
			.comLocaisDePagamento("local 1", "local 2")
			.comNumeroDoDocumento("4343");

		GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

		// Para gerar um boleto em PDF
		gerador.geraPDF("/tmp/BancoDoBrasil.pdf");

		// Para gerar um boleto em PNG
		gerador.geraPNG("/tmp/BancoDoBrasil.png");

		// Para gerar um array de bytes a partir de um PDF
		@SuppressWarnings("unused")
		byte[] bPDF = gerador.geraPDF();

		// Para gerar um array de bytes a partir de um PNG
		@SuppressWarnings("unused")
		byte[] bPNG = gerador.geraPNG();
	}
}
