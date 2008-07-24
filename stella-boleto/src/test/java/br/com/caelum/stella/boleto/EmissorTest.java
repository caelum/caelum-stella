package br.com.caelum.stella.boleto;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Fabio Kung
 */
public class EmissorTest {

    @Test
    public void nossoNumeroFormatadoDeveTerDezDigitos() {
	Emissor emissor = Emissor.newEmissor().withNossoNumero("12345");
	String numeroFormatado = emissor.getNossoNumeroFormatado();
	assertEquals(10, numeroFormatado.length());
	assertEquals("0000012345", numeroFormatado);
    }

    @Test
    public void numeroDoConvenioFormatadoDeveTerSeteDigitos() {
	Emissor emissor = Emissor.newEmissor().withNumConvenio("1234");
	String numeroFormatado = emissor.getNumConvenioFormatado();
	assertEquals(7, numeroFormatado.length());
	assertEquals("0001234", numeroFormatado);
    }

}
