package br.com.caelum.stella.boleto.bancos;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class SantanderTest {

	private Santander banco = new Santander();
	private Beneficiario beneficiario;
	private Boleto boleto;
	
	@Rule
	public ExpectedException excecao = ExpectedException.none();

	@Before
	public void setUp() {
		
	    Datas datas = Datas.novasDatas().comDocumento(29, 04, 2013)
            .comProcessamento(29, 04, 2013).comVencimento(8, 05, 2013);  

	    this.beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("PETROBRAS")
            .comAgencia("6790").comDigitoAgencia("0").comCarteira("102")
            .comNumeroConvenio("5260965").comNossoNumero("1056137495014");  

	    Pagador pagador = Pagador.novoPagador().comNome("PAULO SILVEIRA") ; 
	    
	    boleto = Boleto.novoBoleto().comEspecieDocumento("DM")
    		.comBanco(banco).comDatas(datas).comBeneficiario(beneficiario)
    		.comPagador(pagador).comValorBoleto(219.50).comAceite(Boolean.FALSE)
    		.comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4")
    		.comLocaisDePagamento("local 1", "local 2")
    		.comNumeroDoDocumento("105613749501");
	}

	@Test 
	public void testCodigoDeBarraDoBancoSantander() {
		String string = "03392569200000219509526096510561374950140102";
		assertEquals(string, banco.geraCodigoDeBarrasPara(boleto));
	}

	@Test
	public void testGetImage() {
		assertNotNull(banco.getImage());
	}

	@Test
	public void testNossoNumeroDoEmissorFormatado() {
		this.beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("BOTICARIO")
				.comAgencia("6790").comDigitoAgencia("0").comCarteira("102")
				.comCodigoBeneficiario("5260965").comNossoNumero("12").comDigitoNossoNumero("4");

		assertThat(banco.getNossoNumeroFormatado(beneficiario),
				is("0000000000124"));
	}
	
	@Test
	public void testUtilizarNumeroConvenio() throws Exception {
		this.beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("BOTICARIO")
				.comNumeroConvenio("3903125").comCarteira("102")
				.comNossoNumero("382713000472").comDigitoNossoNumero("2");
		boleto.comBeneficiario(beneficiario);
		
		assertThat(banco.geraCodigoDeBarrasPara(boleto),
				is("03391569200000219509390312538271300047220102"));
	}
	
	@Test
	public void testUtilizarDigitoNossoNumero() throws Exception {
		this.beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("BOTICARIO")
				.comNumeroConvenio("3903125").comCarteira("102")
				.comNossoNumero("382713000472").comDigitoNossoNumero("2");
		
		assertThat(banco.getNossoNumeroFormatado(beneficiario), is("3827130004722"));
	}
	
	@Test
	public void naoAparecerNuloEmAgenciaECodigoBeneficiarioFormatado() throws Exception {
		this.banco = new Santander();
		
		beneficiario.comAgencia("12345").comDigitoAgencia(null).comNumeroConvenio("1234567");
		
		assertThat(banco.getAgenciaECodigoBeneficiario(beneficiario), is("12345/1234567"));
	}

}
