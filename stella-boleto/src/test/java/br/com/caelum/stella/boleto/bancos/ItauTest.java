package br.com.caelum.stella.boleto.bancos;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class ItauTest {
	
	private Boleto boleto;
	private Itau banco = new Itau();
	private Emissor emissor;

	@Before
	public void setUp() {
		
	    Datas datas = Datas.newDatas().withDocumento(20, 03, 2013)
	            .withProcessamento(20, 03, 2013).withVencimento(01, 04, 2013);  

		    this.emissor = Emissor.newEmissor().withCedente("Rodrigo Turini")
	            .withAgencia(167).withCarteira(157).withContaCorrente(45145)
	            .withNossoNumero(21897666l).withDigitoNossoNumero("6");  

		    Sacado sacado = Sacado.newSacado().withNome("Paulo Silveira");
		    
		    this.boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor)
		    	.withBanco(banco).withSacado(sacado).withValorBoleto(2680.16)
		    	.withNumeroDoDocumento("575");
	}

	@Test
	public void nossoNumeroFormatadoDeveTerOitoDigitos() {
		Emissor emissor = Emissor.newEmissor().withNossoNumero(9000206);
		String numeroFormatado = this.banco.getNossoNumeroDoEmissorFormatado(emissor);
		assertEquals(8, numeroFormatado.length());
		assertEquals("09000206", numeroFormatado);
	}

	@Test
	public void carteiraFormatadoDeveTerTresDigitos() {
		Emissor emissor = Emissor.newEmissor().withCarteira(1);
		String numeroFormatado = this.banco.getCarteiraDoEmissorFormatado(emissor);
		assertEquals(3, numeroFormatado.length());
		assertEquals("001", numeroFormatado);
	}

	@Test
	public void contaCorrenteFormatadaDeveTerCincoDigitos() {
		String numeroFormatado = this.banco.getContaCorrenteDoEmissorFormatado(this.emissor);
		assertEquals(5, numeroFormatado.length());
		assertEquals("45145", numeroFormatado);
	}

	@Test
	public void testLinhaDoBancoItau() {
		this.boleto = this.boleto.withBanco(this.banco);
		GeradorDeLinhaDigitavel gerador = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);
		String linha = "34191.57213  89766.660164  74514.590004  6  56550000268016";
		assertEquals(linha, gerador.geraLinhaDigitavelPara(codigoDeBarras));
	}

	@Test
	public void testCodigoDeBarraDoBancoItau() {
		String codigoDeBarras = this.banco.geraCodigoDeBarrasPara(this.boleto);
		assertEquals("34196565500002680161572189766660167451459000", codigoDeBarras);
	}

	@Test
	public void testGetImage() {
		assertNotNull(this.banco.getImage());
	}
}
