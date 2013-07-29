package br.com.caelum.stella.boleto.bancos;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;


public class SafraTest {

	private Safra banco;
	private Emissor emissor;
	private Boleto boleto;

	@Before
	public void setup(){
		Datas datas = Datas.novasDatas()
								.comDocumento(25,07,2013)
								.comVencimento(26, 07, 2013)
								.comProcessamento(25, 07, 2013);
		this.emissor = Emissor.novoEmissor()
								.comCedente("Supermercado Pedreira LT")
								.comAgencia(1)
								.comDigitoAgencia('8')
								.comContaCorrente(1245)
								.comDigitoContaCorrente('1')
								.comNossoNumero(4)
								.comDigitoNossoNumero("3");
		
		Sacado sacado = Sacado.novoSacado().comNome("Doutor Cenoura");
		
		banco = new Safra();
		
		this.boleto = Boleto.novoBoleto()
								.comDatas(datas)
								.comEmissor(this.emissor)
								.comSacado(sacado)
								.comValorBoleto(19.80)
								.comNumeroDoDocumento("14048");
	}
	
	@SuppressWarnings("deprecation") @Test
	public void numeroDoBancoDeveTerTresDigitos(){
		assertEquals(banco.getNumeroFormatado().length(),3);
	}
	
	@SuppressWarnings("deprecation") @Test
	public void codigoDeBarrasDeveTerQuarentaEQuatroPosicoes(){
		this.boleto = this.boleto.comBanco(this.banco);
		
		assertEquals(banco.geraCodigoDeBarrasPara(this.boleto).length(), 44, 0);
	}
	
	@SuppressWarnings("deprecation") @Test
	public void contaCorrenteDoEmissorDeveTerNoveDigitos(){
		assertEquals(9, this.banco.getContaCorrenteDoEmissorFormatado(this.emissor).length());
	}
	
	@SuppressWarnings("deprecation") @Test
	public void carteiraFormatadoDeveTerDoisDigitos() {
		Emissor emissor = Emissor.novoEmissor().comCarteira(1);
		String numeroFormatado = this.banco.getCarteiraDoEmissorFormatado(emissor);
		assertEquals(2, numeroFormatado.length());
		assertEquals("01", numeroFormatado);
	}
	
	@SuppressWarnings("deprecation") @Test
	public void nossoNumeroDoEmissorDeveTerNoveDigitos(){
		assertEquals(9, this.banco.getNossoNumeroDoEmissorFormatado(this.emissor).length());
	}

	@SuppressWarnings("deprecation") @Test
	public void numeroComDigitoDeveTerCincoDigitos(){
		String numeroDoBanco = this.banco.getNumeroFormatadoComDigito();
		assertEquals("422-7", numeroDoBanco);
		assertEquals(5, numeroDoBanco.length());
	}
	
	@SuppressWarnings("deprecation") @Test
	public void dadoOsDadosDoBancoEDoEmissorDeveGerarALinhaDoCodigoDeBarras(){
		this.boleto = this.boleto.comBanco(this.banco);
		
		assertEquals("42299577100000019807000010000124510000000482", 
			this.banco.geraCodigoDeBarrasPara(this.boleto));
	}
	
	@SuppressWarnings("deprecation") @Test
	public void dadoOBancoEAMoedaODigitoVerificadorDaPosicaoCincoDeveSerNove(){
		this.boleto = this.boleto.comBanco(this.banco);
		
		String linhaCodigoDeBarras = this.banco.geraCodigoDeBarrasPara(this.boleto);
		
		assertEquals("9", linhaCodigoDeBarras.substring(4,5));
	}
	
	@SuppressWarnings("deprecation") @Test
	public void testGetImage() {
		assertNotNull(this.banco.getImage());
	}
}
