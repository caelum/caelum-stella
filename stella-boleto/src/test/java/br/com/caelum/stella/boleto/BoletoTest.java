package br.com.caelum.stella.boleto;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

public class BoletoTest {

    @Test
    public void novoBoletoDeveTerAlgunsValoresPadrao() {
	Boleto b = Boleto.newBoleto();
	assertEquals("R$", b.getEspecieMoeda());
	assertEquals(9, b.getCodEspecieMoeda());
	assertEquals(false, b.getAceite());
	assertEquals("DV", b.getEspecieDocumento());
    }

    @Test
    public void regraDoFatorVencimentoParaDataDaManha() {
	Boleto b = Boleto.newBoleto();

	Calendar data = Calendar.getInstance();
	data.set(Calendar.DAY_OF_MONTH, 2);
	data.set(Calendar.MONTH, 5 - 1);
	data.set(Calendar.YEAR, 2008);

	data.set(Calendar.HOUR_OF_DAY, 1);

	b.withDatas(Datas.newDatas().withVencimento(data));

	assertEquals("3860", b.getFatorVencimento());
    }

    @Test
    public void regraDoFatorVencimentoParaDataDaNoite() {
	Boleto b = Boleto.newBoleto();

	Calendar data = Calendar.getInstance();
	data.set(Calendar.DAY_OF_MONTH, 2);
	data.set(Calendar.MONTH, 5 - 1);
	data.set(Calendar.YEAR, 2008);

	data.set(Calendar.HOUR_OF_DAY, 23);

	b.withDatas(Datas.newDatas().withVencimento(data));

	assertEquals("3860", b.getFatorVencimento());
    }

    @Test
    public void regraDoFatorVencimentoParaDataDaExtremaNoite() {
	Boleto b = Boleto.newBoleto();

	Calendar data = Calendar.getInstance();
	data.set(Calendar.DAY_OF_MONTH, 2);
	data.set(Calendar.MONTH, 5 - 1);
	data.set(Calendar.YEAR, 2008);

	data.set(Calendar.HOUR_OF_DAY, 23);
	data.set(Calendar.MINUTE, 59);
	data.set(Calendar.SECOND, 59);
	data.set(Calendar.MILLISECOND, 999);

	b.withDatas(Datas.newDatas().withVencimento(data));

	assertEquals("3860", b.getFatorVencimento());
    }

    @Test
    public void regraDoFatorVencimentoParaDataDoExtremaManha() {
	Boleto b = Boleto.newBoleto();

	Calendar data = Calendar.getInstance();
	data.set(Calendar.DAY_OF_MONTH, 2);
	data.set(Calendar.MONTH, 5 - 1);
	data.set(Calendar.YEAR, 2008);

	data.set(Calendar.HOUR_OF_DAY, 0);
	data.set(Calendar.MINUTE, 0);
	data.set(Calendar.SECOND, 0);
	data.set(Calendar.MILLISECOND, 0);

	b.withDatas(Datas.newDatas().withVencimento(data));

	assertEquals("3860", b.getFatorVencimento());
    }

    @Test
    public void valorFormatadoPorStringDeveTerDezDigitos() {
	Boleto b = Boleto.newBoleto();
	b.withValorBoleto("3.00");
	String valorFormatado = b.getValorFormatado();
	assertEquals(10, valorFormatado.length());
	assertEquals("0000000300", valorFormatado);
    }

    @Test
    public void valorFormatadoPorStringSemPontos() {
	Boleto b = Boleto.newBoleto();
	b.withValorBoleto("300");
	assertEquals("0000030000", b.getValorFormatado());
    }

    @Test
    public void valorFormatadoPorDouble() {
	Boleto b = Boleto.newBoleto();
	b.withValorBoleto(3d);
	assertEquals("0000000300", b.getValorFormatado());
    }

    @Test
    public void valorFormatadoPorBigDecimal() {
	Boleto b = Boleto.newBoleto();
	b.withValorBoleto(new BigDecimal(3));
	assertEquals("0000000300", b.getValorFormatado());
    }

    @Test
    public void numeroDoDocumentoFormatadoDeveTerQuatroDigitos() {
	Boleto b = Boleto.newBoleto();
	b.withNoDocumento("232");
	String numeroFormatado = b.getNoDocumentoFormatado();
	assertEquals(4, numeroFormatado.length());
	assertEquals("0232", numeroFormatado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void boletoNaoDeveAceitarMaisDeCincoInstrucoes() {
	Boleto b = Boleto.newBoleto();
	b.withInstrucoes("", "", "", "", "", "");
    }

    @Test
    public void boletoDeveAceitarNoMaximoCincoInstrucoes() {
	Boleto b = Boleto.newBoleto();
	b.withInstrucoes("", "", "", "", "");
	assertEquals(5, b.getInstrucoes().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void boletoNaoDeveAceitarMaisDeCincoDescricoes() {
	Boleto b = Boleto.newBoleto();
	b.withDescricoes("", "", "", "", "", "");
    }

    @Test
    public void boletoDeveAceitarNoMaximoCincoDescricoes() {
	Boleto b = Boleto.newBoleto();
	b.withDescricoes("", "", "", "", "");
	assertEquals(5, b.getDescricoes().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void boletoNaoDeveAceitarMaisDeDoisLocais() {
	Boleto b = Boleto.newBoleto();
	b.withLocaisDePagamento("", "", "");
    }

    @Test
    public void boletoDeveAceitarNoMaximoDoisLocais() {
	Boleto b = Boleto.newBoleto();
	b.withLocaisDePagamento("", "");
	assertEquals(2, b.getLocaisDePagamento().size());
    }

}
