package br.com.caelum.stella.boleto.bancos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;

public class HSBCTest {
	
	private Boleto boleto;
	private HSBC banco = new HSBC();

	@Before
	public void setUp() {

		Datas datas = Datas.novasDatas().comDocumento(28,1,2013)
				.comProcessamento(29,1,2013).comVencimento(30,1,2013);

		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("Rodrigo Turini")
			.comCodigoBeneficiario("4146239").comNossoNumero("1476147");

	    Pagador pagador = Pagador.novoPagador().comNome("Paulo Silveira");
		
	    this.boleto = Boleto.novoBoleto().comDatas(datas).comBeneficiario(beneficiario)
	    	.comBanco(this.banco).comPagador(pagador).comValorBoleto(3383.00)
	    	.comNumeroDoDocumento("0789201");
	}

	@Test
	public void testLinhaDoBancoHSBC() {
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);
		assertEquals("39994.14620  39000.000149  76147.030324  5  55940000338300",
			new GeradorDeLinhaDigitavel().geraLinhaDigitavelPara(codigoDeBarras,this.banco));
	}

	@Test
	public void testDataJuliana() {
		Calendar vencimento = boleto.getDatas().getVencimento();
		assertEquals("0303", banco.getDataFormatoJuliano(vencimento, 4));
	}

	@Test
	public void testCodigoDeBarraDoBancoHSBC() {
		this.boleto = this.boleto.comBanco(this.banco);
		String codigoDeBarras = this.banco.geraCodigoDeBarrasPara(this.boleto);
		assertEquals("39995559400003383004146239000000147614703032", codigoDeBarras);
	}
	
	@Test
	public void testDigitosNossoNumeroHSBC(){
		this.boleto = this.boleto.comBanco(this.banco);
		String nossoNumeroCompleto = this.banco.getNossoNumeroECodigoDocumento(boleto);
		assertEquals("0000001476147541", nossoNumeroCompleto);
	}
	
	@Test
	public void testDigitosNossoNumeroHSBCComDadosDoManual(){
		this.boleto = this.boleto.comBanco(this.banco);
		
		this.boleto.getBeneficiario().comNossoNumero("239104761");
		this.boleto.getBeneficiario().comCodigoBeneficiario("8351202");
		this.boleto.getDatas().comVencimento(4, 7, 2008);
		
		String nossoNumeroCompleto = this.banco.getNossoNumeroECodigoDocumento(boleto);
		assertEquals("0000239104761941", nossoNumeroCompleto);
	}

	@Test
	public void testGetImage() throws IOException {
		assertNotNull(this.banco.getImage());
	}
	
	@Test
	public void naoAparecerNuloEmAgenciaECodigoBeneficiarioFormatado() throws Exception {
		this.banco = new HSBC();
		
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comAgencia("1234").comDigitoAgencia(null).comCodigoBeneficiario("1234567").comDigitoCodigoBeneficiario(null);
		
		assertThat(banco.getAgenciaECodigoBeneficiario(beneficiario), is("1234567"));
	}
}