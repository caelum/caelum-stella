package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class HSBCTest {
	
	private Boleto boleto;
	private HSBC banco = new HSBC();

	@Before
	public void setUp() {

		Datas datas = Datas.newDatas().withDocumento(28,1,2013)
				.withProcessamento(29,1,2013).withVencimento(30,1,2013);

		Emissor emissor = Emissor.newEmissor().withCedente("Rodrigo Turini")
			.withCodigoFornecidoPelaAgencia(4146239).withNossoNumero(1476147);

	    Sacado sacado = Sacado.newSacado().withNome("Paulo Silveira");
		
	    this.boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor)
	    	.withBanco(this.banco).withSacado(sacado).withValorBoleto(3383.00)
	    	.withNumeroDoDocumento("0789201");
	}

	@Test
	public void testLinhaDoBancoHSBC() {
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);
		assertEquals("39994.14620  39000.000008  01476.030323  2  55940000338300",
			new GeradorDeLinhaDigitavel().geraLinhaDigitavelPara(codigoDeBarras));
	}

	@Test
	public void testDataJuliana() {
		Calendar vencimento = boleto.getDatas().getVencimento();
		assertEquals("0303", banco.getDataFormatoJuliano(vencimento, 4));
	}

	@Test
	public void testCodigoDeBarraDoBancoHSBC() {
		this.boleto = this.boleto.withBanco(this.banco);
		String codigoDeBarras = this.banco.geraCodigoDeBarrasPara(this.boleto);
		assertEquals("39992559400003383004146239000000000147603032", codigoDeBarras);
	}

	@Test
	public void testGetImage() throws IOException {
		assertNotNull(this.banco.getImage());
	}
}