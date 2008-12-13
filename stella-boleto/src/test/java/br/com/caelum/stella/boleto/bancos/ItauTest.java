package br.com.caelum.stella.boleto.bancos;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import static junit.framework.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

public class ItauTest {
    private Boleto boleto;
    private Itau banco;
    private Emissor emissor;

    @Before
    public void setUp() {
        Datas datas = Datas.newDatas().withDocumento(31, 5, 2006).withProcessamento(31, 5, 2006).withVencimento(10, 6,
                2006);

        emissor = Emissor.newEmissor().withCedente("Caue Guerra").withAgencia(2949).withDvAgencia("1")
                .withContaCorrente(6580).withNumConvenio(1207113).withDvContaCorrente("3").withCarteira(6)
                .withNossoNumero(3);

        Sacado sacado = Sacado.newSacado().withNome("Fulano");

        banco = new Itau();

        boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor).withSacado(sacado).withValorBoleto("1.00")
                .withNoDocumento("4323");
    }

    @Test
    public void nossoNumeroFormatadoDeveTerOitoDigitos() {
        Emissor emissor = Emissor.newEmissor().withNossoNumero(9000206);
        String numeroFormatado = banco.getNossoNumeroDoEmissorFormatado(emissor);
        assertEquals(8, numeroFormatado.length());
        assertEquals("09000206", numeroFormatado);
    }

    @Test
    public void carteiraFormatadoDeveTerTresDigitos() {
        Emissor emissor = Emissor.newEmissor().withCarteira(1);
        String numeroFormatado = banco.getCarteiraDoEmissorFormatado(emissor);
        assertEquals(3, numeroFormatado.length());
        assertEquals("001", numeroFormatado);
    }

    @Test
    public void contaCorrenteFormatadaDeveTerCincoDigitos() {
        String numeroFormatado = banco.getContaCorrenteDoEmissorFormatado(emissor);
        assertEquals(5, numeroFormatado.length());
        assertEquals("06580", numeroFormatado);
    }

    @Test
    public void testLinhaDoBancoItau() {
        banco = new Itau();
        boleto = boleto.withBanco(banco);
        LinhaDigitavelGenerator linhaDigitavelGenerator = new LinhaDigitavelGenerator();

        assertEquals("34190.06006  00000.332940  90658.090007  9  31680000000100", linhaDigitavelGenerator
                .geraLinhaDigitavelPara(boleto));
    }

    @Test
    public void testCodigoDeBarraDoBancoItau() {
        banco = new Itau();
        boleto = boleto.withBanco(banco);

        assertEquals("34199316800000001000060000000332949065809000", banco.geraCodigoDeBarrasPara(boleto));
    }

    @Test
    public void testGetImage() {
        assertNotNull(banco.getImage());
    }
}
