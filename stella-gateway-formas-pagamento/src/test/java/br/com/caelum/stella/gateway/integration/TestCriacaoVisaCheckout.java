package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.BeforeClass;

import br.com.caelum.stella.gateway.visa.CartaoCredito;
import br.com.caelum.stella.gateway.visa.Checkout;
import br.com.caelum.stella.gateway.visa.FormaParcelamento;
import br.com.caelum.stella.gateway.visa.IntegracaoCheckoutViaPost;
import br.com.caelum.stella.gateway.visa.Parcelamento;

public class TestCriacaoVisaCheckout {

	private static Checkout checkout;
	
	@BeforeClass
	public static void before(){
		Calendar dataQueExpira = Calendar.getInstance();
		dataQueExpira.set(Calendar.MONTH,Calendar.DECEMBER+1);
		dataQueExpira.set(Calendar.YEAR,2010);
		checkout = new Checkout("123456","Alberto Souza, Av Juracy Magalhaes,Salvador,Bahia,Brasil","Testando checkout",BigDecimal.ONE,new Parcelamento(FormaParcelamento.CREDITO_A_VISTA,1),new CartaoCredito("4551870000000183",dataQueExpira,"123"));
	}
	
	/**
	 * Configurar o test aqui vai ser uma arte... tem que ter ip fixo e não sei o que lá...
	 */
	public void testComunicacaoTeoricamenteCorretaComComponenteDeCheckout(){
		String telaDeResultadoQueDeveSerApresentadaAoCliente = new IntegracaoCheckoutViaPost(checkout).integra();
		System.out.println(telaDeResultadoQueDeveSerApresentadaAoCliente);
	}
}
