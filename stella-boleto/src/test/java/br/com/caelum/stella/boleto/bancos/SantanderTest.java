package br.com.caelum.stella.boleto.bancos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class SantanderTest {

	private Santander banco = new Santander();
	private Emissor emissor;
	private Boleto boleto;
	
	@Rule
	public ExpectedException excecao = ExpectedException.none();

	@Before
	public void setUp() {
		
	    Datas datas = Datas.novasDatas().comDocumento(29, 04, 2013)
            .comProcessamento(29, 04, 2013).comVencimento(8, 05, 2013);  

	    this.emissor = Emissor.novoEmissor().comCedente("PETROBRAS")
            .comAgencia("6790").comDigitoAgencia("0").comCarteira("102")
            .comNumeroConvenio("5260965").comNossoNumero("1056137495014");  

	    Sacado sacado = Sacado.novoSacado().comNome("PAULO SILVEIRA") ; 
	    
	    boleto = Boleto.novoBoleto().comEspecieDocumento("DM")
    		.comBanco(banco).comDatas(datas).comEmissor(emissor)
    		.comSacado(sacado).comValorBoleto(219.50).comAceite(Boolean.FALSE)
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
		this.emissor = Emissor.novoEmissor().comCedente("BOTICARIO")
				.comAgencia("6790").comDigitoAgencia("0").comCarteira("102")
				.comContaCorrente("5260965").comNossoNumero("12").comDigitoNossoNumero("4");

		assertThat(banco.getNossoNumeroDoEmissorFormatado(emissor),
				is("0000000000124"));
	}
	
	@Test
	public void testUtilizarNumeroConvenio() throws Exception {
		this.emissor = Emissor.novoEmissor().comCedente("BOTICARIO")
				.comNumeroConvenio("3903125").comCarteira("102")
				.comNossoNumero("382713000472").comDigitoNossoNumero("2");
		boleto.comEmissor(emissor);
		
		assertThat(banco.geraCodigoDeBarrasPara(boleto),
				is("03391569200000219509390312538271300047220102"));
	}
	
	@Test
	public void testUtilizarDigitoNossoNumero() throws Exception {
		this.emissor = Emissor.novoEmissor().comCedente("BOTICARIO")
				.comNumeroConvenio("3903125").comCarteira("102")
				.comNossoNumero("382713000472").comDigitoNossoNumero("2");
		
		assertThat(banco.getNossoNumeroDoEmissorFormatado(emissor), is("3827130004722"));
	}
	
	@Test	
	public void testRetornarDigitoNossoNumero() throws Exception {
		emissor.comNossoNumero("566612457800");
		String digito = banco.calcularDigitoVerificadorNossoNumero(emissor);
		assertThat(digito, is("2"));
	}
	
	@Test
	public void testLancarExcecaoQuandoNossoNumeroForMaiorQueDoze() throws Exception {
		excecao.expect(IllegalArgumentException.class);
		emissor.comNossoNumero("1056137495014");
		banco.calcularDigitoVerificadorNossoNumero(emissor);
	}
	
	@Test
	public void testLancarExcecaoQuandoNossoNumeroForNulo() throws Exception {
		excecao.expect(IllegalArgumentException.class);
		emissor.comNossoNumero(null);
		banco.calcularDigitoVerificadorNossoNumero(emissor);
	}
	
	@Test
	public void testRetornarDigitoQuandoNossoNumeroForMenorQueDoze() throws Exception {
		emissor.comNossoNumero("1");
		String digito = banco.calcularDigitoVerificadorNossoNumero(emissor);
		assertThat(digito, is("9"));
	}

}
