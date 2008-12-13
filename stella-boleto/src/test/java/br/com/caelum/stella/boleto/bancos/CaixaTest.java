package br.com.caelum.stella.boleto.bancos;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import static junit.framework.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

public class CaixaTest {
    private Boleto boleto;
    private Caixa banco;
    private Emissor emissor;

    @Before
    public void setUp() {
        Datas datas = Datas.newDatas().withDocumento(31, 5, 2006).withProcessamento(31, 5, 2006).withVencimento(31, 5,
                2006);

        emissor = Emissor.newEmissor().withCedente("Caue Guerra").withAgencia(2949).withDvAgencia("1")
                .withContaCorrente(6580).withNumConvenio(1207113).withDvContaCorrente("3").withCarteira(9)
                .withNossoNumero(1200200).withCodFornecidoPelaAgencia(789).withCodOperacao(123);

        Sacado sacado = Sacado.newSacado().withNome("Fulano");

        banco = new Caixa();

        boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor).withSacado(sacado).withValorBoleto(1.00)
                .withNoDocumento("4323");
    }

    @Test
    public void codFornecidoPelaAgenciaDeveTerOitoDigitos() {
        Emissor emissor = Emissor.newEmissor().withCodFornecidoPelaAgencia(2);
        String numeroFormatado = banco.getCodFornecidoPelaAgenciaFormatado(emissor);
        assertEquals(8, numeroFormatado.length());
        assertEquals("00000002", numeroFormatado);
    }

    @Test
    public void codOperacaoDeveTerTresDigitos() {
        Emissor emissor = Emissor.newEmissor().withCodOperacao(2);
        String numeroFormatado = banco.getCodOperacaoFormatado(emissor);
        assertEquals(3, numeroFormatado.length());
        assertEquals("002", numeroFormatado);
    }

    @Test
    public void carteiraFormatadoDeveTerDoisDigitos() {
        Emissor emissor = Emissor.newEmissor().withCarteira(1);
        String numeroFormatado = banco.getCarteiraDoEmissorFormatado(emissor);
        assertEquals(2, numeroFormatado.length());
        assertEquals("01", numeroFormatado);
    }

    @Test
    public void contaCorrenteFormatadaDeveTerCincoDigitos() {
        String numeroFormatado = banco.getContaCorrenteDoEmissorFormatado(emissor);
        assertEquals(5, numeroFormatado.length());
        assertEquals("06580", numeroFormatado);
    }

    @Test
    public void testLinhaDoBancoCaixa() {
        banco = new Caixa();
        boleto = boleto.withBanco(banco);
        LinhaDigitavelGenerator linhaDigitavelGenerator = new LinhaDigitavelGenerator();

        assertEquals("10499.00127  00200.294916  23000.007890  8  31580000000100", linhaDigitavelGenerator
                .geraLinhaDigitavelPara(boleto));
    }

    @Test
    public void testCodigoDeBarraDoBancoCaixa() {
        banco = new Caixa();
        boleto = boleto.withBanco(banco);

        assertEquals("10498315800000001009001200200294912300000789", banco.geraCodigoDeBarrasPara(boleto));
    }

    @Test
    public void testGetImage() {
        assertNotNull(banco.getImage());
    }
}
