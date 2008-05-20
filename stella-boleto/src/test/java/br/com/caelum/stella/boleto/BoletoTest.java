package br.com.caelum.stella.boleto;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

public class BoletoTest {

    @Test
    public void testNewBoletoSeTemDefaultsCorretos() {
        Boleto b = Boleto.newBoleto();
        assertEquals("R$", b.getEspecieMoeda());
        assertEquals(9, b.getCodEspecieMoeda());
        assertEquals(false, b.getAceite());
        assertEquals("DV", b.getEspecieDocumento());
    }

    @Test
    public void testGetFatorVencimentoParaDataDaManha() {
        Boleto b = Boleto.newBoleto();

        Calendar data = Calendar.getInstance();
        data.set(Calendar.DAY_OF_MONTH, 2);
        data.set(Calendar.MONTH, 5 - 1);
        data.set(Calendar.YEAR, 2008);

        data.set(Calendar.HOUR_OF_DAY, 1);

        b.withDatas(Datas.newDatas().withVencimento(data));

        assertEquals(3860, b.getFatorVencimento());
    }

    @Test
    public void testGetFatorVencimentoParaDataDaNoite() {
        Boleto b = Boleto.newBoleto();

        Calendar data = Calendar.getInstance();
        data.set(Calendar.DAY_OF_MONTH, 2);
        data.set(Calendar.MONTH, 5 - 1);
        data.set(Calendar.YEAR, 2008);

        data.set(Calendar.HOUR_OF_DAY, 23);

        b.withDatas(Datas.newDatas().withVencimento(data));

        assertEquals(3860, b.getFatorVencimento());
    }

    @Test
    public void testGetFatorVencimentoParaDataDaExtremaNoite() {
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

        assertEquals(3860, b.getFatorVencimento());
    }

    @Test
    public void testGetFatorVencimentoParaDataDoExtremaManha() {
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

        assertEquals(3860, b.getFatorVencimento());
    }

    @Test
    public void testGetValorFormatadoPorString() {
        Boleto b = Boleto.newBoleto();
        b.withValorBoleto("3.00");
        assertEquals("0000000300", b.getValorFormatado());
    }

    @Test
    public void testGetValorFormatadoPorStringSemPontos() {
        Boleto b = Boleto.newBoleto();
        b.withValorBoleto("300");
        assertEquals("0000030000", b.getValorFormatado());
    }

    @Test
    public void testGetValorFormatadoPorDouble() {
        Boleto b = Boleto.newBoleto();
        b.withValorBoleto(3d);
        assertEquals("0000000300", b.getValorFormatado());
    }

    @Test
    public void testGetValorFormatadoPorBigDecimal() {
        Boleto b = Boleto.newBoleto();
        b.withValorBoleto(new BigDecimal(3));
        assertEquals("0000000300", b.getValorFormatado());
    }

    @Test
    public void testGetNoDocumentoFormatado() {
        Boleto b = Boleto.newBoleto();
        b.withNoDocumento("232");
        assertEquals("0232", b.getNoDocumentoFormatado());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoletoComMaisDe5Instrucoes() {
        Boleto b = Boleto.newBoleto();
        b.withInstrucoes("", "", "", "", "", "");
    }

    @Test
    public void testBoletoCom5Instrucoes() {
        Boleto b = Boleto.newBoleto();
        b.withInstrucoes("", "", "", "", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoletoComMaisDe5Descricoes() {
        Boleto b = Boleto.newBoleto();
        b.withDescricoes("", "", "", "", "", "");
    }

    @Test
    public void testBoletoCom5Descricoes() {
        Boleto b = Boleto.newBoleto();
        b.withDescricoes("", "", "", "", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoletoComMaisDe2Locais() {
        Boleto b = Boleto.newBoleto();
        b.withLocaisDePagamento("", "", "");
    }

    @Test
    public void testBoletoCom2Locais() {
        Boleto b = Boleto.newBoleto();
        b.withLocaisDePagamento("", "");
    }

}
