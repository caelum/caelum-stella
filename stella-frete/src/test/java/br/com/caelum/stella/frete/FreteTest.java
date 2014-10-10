package br.com.caelum.stella.frete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import br.com.caelum.stella.frete.entity.Encomenda;
import br.com.caelum.stella.frete.enums.Servico;
import br.com.caelum.stella.frete.exception.CorreiosException;


public class FreteTest {

	@Test
	public void codigoDeErroDeveSerDiferenteDeZero(){
		int codigoErro = 0;
		try {
			CalculoFreteCorreio.calcularFrete(new Encomenda(), Servico.SEDEX);
		} catch (CorreiosException e) {
			codigoErro = e.getCodigo();
		}
		assertNotEquals(0, codigoErro);
	}

	@Test
	public void valorDeclaradoDeveSerIgual(){
		try {
			Encomenda encomenda = new Encomenda().paraOCep("01310-200").comValorDeclarado(10.2);
			Double resultado = CalculoFreteCorreio.calcularFrete(encomenda, Servico.SEDEX_A_COBRAR).getValorDeclarado();
			assertEquals(new Double("10.2"), resultado);
		} catch (CorreiosException e) {
			e.printStackTrace();
		}
	}
}