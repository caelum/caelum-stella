package br.com.caelum.stella.boleto;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

public class BoletoTest {

	@Test
	public void novoBoletoDeveTerAlgunsValoresPadrao() {
		Boleto b = Boleto.novoBoleto();
		assertEquals("R$", b.getEspecieMoeda());
		assertEquals(9, b.getCodigoEspecieMoeda());
		assertEquals(false, b.getAceite());
		assertEquals("DM", b.getEspecieDocumento());
	}

	@Test
	public void regraDoFatorVencimentoParaDataDaManha() {
		Boleto b = Boleto.novoBoleto();

		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 2);
		data.set(Calendar.MONTH, 5 - 1);
		data.set(Calendar.YEAR, 2008);

		data.set(Calendar.HOUR_OF_DAY, 1);

		b.comDatas(Datas.novasDatas().comVencimento(data));

		assertEquals("3860", b.getFatorVencimento());
	}

	@Test(expected = IllegalArgumentException.class)
	public void fatorVencimentoComDataMuitoAntiga() {
		Datas.novasDatas().comDocumento(01, 01, 1996).comProcessamento(01, 1, 1996).comVencimento(1, 2, 1996);
	}

	@Test(expected = IllegalArgumentException.class)
	public void fatorVencimentoComDataMaiorQueOPermitido() {
		Datas.novasDatas().comDocumento(01, 01, 2025).comProcessamento(01, 1, 2025).comVencimento(1, 2, 2025);
	}

	public void regraDoFatorVencimentoParaDataDaNoite() {
		Boleto b = Boleto.novoBoleto();

		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 2);
		data.set(Calendar.MONTH, 5 - 1);
		data.set(Calendar.YEAR, 2008);

		data.set(Calendar.HOUR_OF_DAY, 23);

		b.comDatas(Datas.novasDatas().comVencimento(data));

		assertEquals("3860", b.getFatorVencimento());
	}

	@Test
	public void regraDoFatorVencimentoParaDataDaExtremaNoite() {
		Boleto b = Boleto.novoBoleto();

		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 2);
		data.set(Calendar.MONTH, 5 - 1);
		data.set(Calendar.YEAR, 2008);

		data.set(Calendar.HOUR_OF_DAY, 23);
		data.set(Calendar.MINUTE, 59);
		data.set(Calendar.SECOND, 59);
		data.set(Calendar.MILLISECOND, 999);

		b.comDatas(Datas.novasDatas().comVencimento(data));

		assertEquals("3860", b.getFatorVencimento());
	}

	@Test
	public void regraDoFatorVencimentoParaDataDoExtremaManha() {
		Boleto b = Boleto.novoBoleto();

		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 2);
		data.set(Calendar.MONTH, 5 - 1);
		data.set(Calendar.YEAR, 2008);

		data.set(Calendar.HOUR_OF_DAY, 0);
		data.set(Calendar.MINUTE, 0);
		data.set(Calendar.SECOND, 0);
		data.set(Calendar.MILLISECOND, 0);

		b.comDatas(Datas.novasDatas().comVencimento(data));

		assertEquals("3860", b.getFatorVencimento());
	}

	@Test
	public void valorFormatadoPorStringDeveTerDezDigitos() {
		Boleto b = Boleto.novoBoleto();
		b.comValorBoleto("3.00");
		String valorFormatado = b.getValorFormatado();
		assertEquals(10, valorFormatado.length());
		assertEquals("0000000300", valorFormatado);
	}

	@Test
	public void valorFormatadoPorStringSemPontos() {
		Boleto b = Boleto.novoBoleto();
		b.comValorBoleto("300");
		assertEquals("0000030000", b.getValorFormatado());
	}

	@Test
	public void valorFormatadoPorDouble() {
		Boleto b = Boleto.novoBoleto();
		b.comValorBoleto(3d);
		assertEquals("0000000300", b.getValorFormatado());
	}

	@Test
	public void valorFormatadoPorBigDecimal() {
		Boleto b = Boleto.novoBoleto();
		b.comValorBoleto(new BigDecimal(3));
		assertEquals("0000000300", b.getValorFormatado());
	}

	@Test
	public void numeroDoDocumentoFormatadoDeveTerQuatroDigitos() {
		Boleto b = Boleto.novoBoleto();
		b.comNumeroDoDocumento("232");
		String numeroFormatado = b.getNumeroDoDocumentoFormatado();
		assertEquals(4, numeroFormatado.length());
		assertEquals("0232", numeroFormatado);
	}

	@Test(expected = IllegalArgumentException.class)
	public void boletoNaoDeveAceitarMaisDeCincoInstrucoes() {
		Boleto b = Boleto.novoBoleto();
		b.comInstrucoes("", "", "", "", "", "");
	}

	@Test
	public void boletoDeveAceitarNoMaximoCincoInstrucoes() {
		Boleto b = Boleto.novoBoleto();
		b.comInstrucoes("", "", "", "", "");
		assertEquals(5, b.getInstrucoes().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void boletoNaoDeveAceitarMaisDeCincoDescricoes() {
		Boleto b = Boleto.novoBoleto();
		b.comDescricoes("", "", "", "", "", "");
	}

	@Test
	public void boletoDeveAceitarNoMaximoCincoDescricoes() {
		Boleto b = Boleto.novoBoleto();
		b.comDescricoes("", "", "", "", "");
		assertEquals(5, b.getDescricoes().size());
	}

        @Test(expected = IllegalArgumentException.class)
        public void boletoNaoDeveAceitarDescricaoNula() {
            Boleto b = Boleto.novoBoleto();
            b.comDescricao(null);
        }

        @Test(expected = UnsupportedOperationException.class)
        public void boletoNaoDeveAceitarDescricaoQuandoTemCincoDescricoes() {
            Boleto b = Boleto.novoBoleto();
            b.comDescricoes("","","","","");
            b.comDescricao("");
        }

	@Test(expected = IllegalArgumentException.class)
	public void boletoNaoDeveAceitarMaisDeDoisLocais() {
		Boleto b = Boleto.novoBoleto();
		b.comLocaisDePagamento("", "", "");
	}

	@Test
	public void boletoDeveAceitarNoMaximoDoisLocais() {
		Boleto b = Boleto.novoBoleto();
		b.comLocaisDePagamento("", "");
		assertEquals(2, b.getLocaisDePagamento().size());
	}

}
