package br.com.caelum.stella.boleto;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author Fabio Kung
 */
public class EmissorTest {
    @Test
    public void contaCorrenteFormatadaDeveTerOitoDigitos() {
        Emissor emissor = Emissor.newEmissor().withContaCorrente(123450);
        String numeroFormatado = emissor.getContaCorrenteFormatado();
        assertEquals(8, numeroFormatado.length());
        assertEquals("00123450", numeroFormatado);
    }

    @Test
    public void testesSimilaresParaOutrosNumerosFormatados() {
        fail("pendente");
    }

}
