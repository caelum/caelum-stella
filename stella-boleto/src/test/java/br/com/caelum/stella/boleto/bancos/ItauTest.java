package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.assertEquals;
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
		
	    Datas datas = Datas.novasDatas().comDocumento(20, 03, 2013)
	            .comProcessamento(20, 03, 2013).comVencimento(01, 04, 2013);  

		    this.emissor = Emissor.novoEmissor().comCedente("Rodrigo Turini")
	            .comAgencia(167).comCarteira(157).comContaCorrente(45145)
	            .comNossoNumero(21897666l).comDigitoNossoNumero("6");  

		    Sacado sacado = Sacado.novoSacado().comNome("Paulo Silveira");
		    
		    this.boleto = Boleto.novoBoleto().comDatas(datas).comEmissor(emissor)
		    	.comBanco(banco).comSacado(sacado).comValorBoleto(2680.16)
		    	.comNumeroDoDocumento("575");
	}

	@Test
	public void nossoNumeroFormatadoDeveTerOitoDigitos() {
		Emissor emissor = Emissor.novoEmissor().comNossoNumero(9000206);
		String numeroFormatado = this.banco.getNossoNumeroDoEmissorFormatado(emissor);
		assertEquals(8, numeroFormatado.length());
		assertEquals("09000206", numeroFormatado);
	}

	@Test
	public void carteiraFormatadoDeveTerTresDigitos() {
		Emissor emissor = Emissor.novoEmissor().comCarteira(1);
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
		this.boleto = this.boleto.comBanco(this.banco);
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
