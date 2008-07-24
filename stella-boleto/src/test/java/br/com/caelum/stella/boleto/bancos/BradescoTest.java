package br.com.caelum.stella.boleto.bancos;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class BradescoTest {

    private Boleto boleto;
    private Banco banco;
    private Emissor emissor;

    @Before
    public void setUp() {
	Datas datas = Datas.newDatas().withDocumento(31, 5, 2006)
		.withProcessamento(31, 5, 2006).withVencimento(10, 6, 2006);

	emissor = Emissor.newEmissor().withCedente("Leonardo Bessa")
		.withAgencia(2949).withDvAgencia("1").withContaCorrente(6580)
		.withNumConvenio(1207113).withDvContaCorrete("3").withCarteira(
			6).withNossoNumero(3);

	Sacado sacado = Sacado.newSacado().withNome("Fulano");

	banco = new Bradesco();

	boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor)
		.withSacado(sacado).withValorBoleto("1.00").withNoDocumento(
			"4323");
    }

    @Test
    public void numeroDoConvenioFormatadoDeveTerSeteDigitos() {
	Emissor emissor = Emissor.newEmissor().withNumConvenio(1234);
	String numeroFormatado = banco
		.getNumConvenioDoEmissorFormatado(emissor);
	assertEquals(7, numeroFormatado.length());
	assertEquals("0001234", numeroFormatado);
    }

    @Test
    public void nossoNumeroFormatadoDeveTerOnzeDigitos() {
	Emissor emissor = Emissor.newEmissor().withNossoNumero(9000206);
	String numeroFormatado = banco
		.getNossoNumeroDoEmissorFormatado(emissor);
	assertEquals(11, numeroFormatado.length());
	assertEquals("00009000206", numeroFormatado);
    }

    @Test
    public void carteiraFormatadoDeveTerDoisDigitos() {
	Emissor emissor = Emissor.newEmissor().withCarteira(1);
	String numeroFormatado = banco.getCarteiraDoEmissorFormatado(emissor);
	assertEquals(2, numeroFormatado.length());
	assertEquals("01", numeroFormatado);
    }

    @Test
    public void contaCorrenteFormatadaDeveTerSeteDigitos() {
	String numeroFormatado = banco
		.getContaCorrenteDoEmissorFormatado(emissor);
	assertEquals(7, numeroFormatado.length());
	assertEquals("0006580", numeroFormatado);
    }

    @Test
    public void testLinhaDoBancoBradesco() {
	banco = new Bradesco();
	boleto = boleto.withBanco(banco);

	assertEquals(
		"23792.94909  60000.000004  03000.658009  6  31680000000100",
		banco.geraLinhaDigitavelPara(boleto));
    }

    @Test
    public void testCodigoDeBarraDoBancoBradesco() {
	banco = new Bradesco();
	boleto = boleto.withBanco(banco);

	assertEquals("23796316800000001002949060000000000300065800", banco
		.geraCodigoDeBarrasPara(boleto));
    }

    @Test
    public void testGetImage() throws IOException {
	assertNotNull(banco.getImage());
    }
}
