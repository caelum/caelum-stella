package br.com.caelum.stella.boleto;

import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

public class StellaBBMain {
	
	
	public static void main(String[] args) {  
		
		Double valorAcumulado = 1250.34;
		
	    Datas datas = Datas.novasDatas()
	            .comDocumento(1,1, 2013)
	            .comProcessamento(1,1, 2013)
	            .comVencimento(20,2, 2013);  

	    Emissor emissor = Emissor.novoEmissor()  
	            .comCedente("CERTIMARCA SOLUCOES TECNOLOGICAS LTDA CPF: 04.200.198/0001-08")
		        .comEndereco("RODOVIA SC 401, KM 1 - EDIFÍCIO CELTA, PARQTEC ALFA 88030-000 | FLORIANÓPOLIS")
	            .comAgencia(3544).comDigitoAgencia('0')
	            .comContaCorrente(15456)  
	            .comDigitoContaCorrente('3')  
	            .comNumeroConvenio(2317994)
	            .comCarteira(18)
	            .comNossoNumero(23179940000919601l);  

	    Sacado sacado = Sacado.novoSacado()  
            .comNome("Krystalmix Com e Dist de Produtos e Utensilios Domésticos Ltda")  
            .comCpf("08.248.561/0001-16")  
            .comEndereco("Rua Mar Vermelho, 107")  
            .comBairro("Jardim Regina Alice")  
            .comCep("06412-140")  
            .comCidade("Barueri")  
            .comUf("SP"); 			

	    Banco banco = new BancoDoBrasil();  

	    Boleto boleto = Boleto.novoBoleto().comEspecieDocumento("DM") 
	            .comBanco(banco)  
	            .comDatas(datas)  
	            .comEmissor(emissor)  
	            .comSacado(sacado)
	            .comAceite(Boolean.FALSE)
	            .comValorBoleto(valorAcumulado.toString())
	            .comDescricoes("bla", "bla")
	            .comInstrucoes("Juros de 0,50% ao mês após o vencimento", "Cobrar multa de 2,00% após o vencimento")  
	            .comLocaisDePagamento("Pagar em qualquer banco até o vencimento")  
	            .comNumeroDoDocumento("919601");

	    GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);  

	    // Para gerar um boleto em PDF  
	    gerador.geraPDF("BancoBrasil.pdf");  

	    // Para gerar um boleto em PNG  
	    gerador.geraPNG("BancoDoBrasil.png");  

	    // Para gerar um array de bytes a partir de um PDF  
	   // byte[] bPDF = gerador.toPDF();  

	    // Para gerar um array de bytes a partir de um PNG  
	   // byte[] bPNG = gerador.toPNG();  
	}

}