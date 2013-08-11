package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.*;

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
	public void setup() {
		Datas datas = Datas.novasDatas()
						.comDocumento(25, 07, 2013)
						.comVencimento(26, 07, 2013)
						.comProcessamento(25, 07, 2013);

		this.emissor = Emissor.novoEmissor()
						.comCedente("Supermercado e Comercio XYZ LTDA")
						.comAgencia(1)
						.comDigitoAgencia('8')
						.comContaCorrente(1245)
						.comDigitoContaCorrente('1')
						.comNossoNumero(4)
						.comDigitoNossoNumero("3");

		Sacado sacado = Sacado.novoSacado()
						.comNome("Distribuidora de Alimentos SSH LTDA");

		banco = new Safra();

		this.boleto = Boleto.novoBoleto()
						.comDatas(datas)
						.comEmissor(this.emissor)
						.comSacado(sacado)
						.comValorBoleto(19.80)
						.comNumeroDoDocumento("14048");
	}

	@Test
	public void numeroDoBancoDeveTerTresDigitos() {
		assertEquals(banco.getNumeroFormatado().length(), 3);
	}

	@Test
	public void contaCorrenteDoEmissorDeveTerNoveDigitos() {
		assertEquals(9, this.banco.getContaCorrenteDoEmissorFormatado(this.emissor).length());
	}

	@Test
	public void carteiraFormatadoDeveTerDoisDigitos() {
		Emissor emissor = Emissor.novoEmissor().comCarteira(1);
		String numeroFormatado = this.banco.getCarteiraDoEmissorFormatado(emissor);
		assertEquals(2, numeroFormatado.length());
		assertEquals("01", numeroFormatado);
	}

	@Test
	public void nossoNumeroDoEmissorDeveTerNoveDigitos() {
		assertEquals(9, this.banco.getNossoNumeroDoEmissorFormatado(this.emissor).length());
	}

	@Test
	public void numeroDoBancoComODigitoDeveTerCincoDigitos() {
		String numeroDoBanco = this.banco.getNumeroFormatadoComDigito();
		assertEquals("422-7", numeroDoBanco);
		assertEquals(5, numeroDoBanco.length());
	}

	@Test
	public void dadoOsDadosDoBancoEDoEmissorDeveGerarALinhaDigitavelDoCodigoDeBarras() {
		this.boleto = this.boleto.comBanco(this.banco);

		GeradorDeLinhaDigitavel linhaDigitavelGenerator = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);

		assertEquals("42297.00002  10000.124510  00000.000422  4  57710000001980", linhaDigitavelGenerator.geraLinhaDigitavelPara(codigoDeBarras));
	}

	@Test
	public void dadoOBancoEAMoedaODigitoVerificadorDaPosicaoCincoDeveSerQuatro() {
		this.boleto = this.boleto.comBanco(this.banco);

		String linhaCodigoDeBarras = this.banco.geraCodigoDeBarrasPara(this.boleto);

		assertEquals("4", linhaCodigoDeBarras.substring(4, 5));
	}

	@Test
	public void testGetImage() {
		assertNotNull(this.banco.getImage());
	}
}
