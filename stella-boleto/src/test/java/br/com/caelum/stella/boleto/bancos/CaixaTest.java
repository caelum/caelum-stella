package br.com.caelum.stella.boleto.bancos;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class CaixaTest {
    private Boleto boleto;
    private Caixa banco;
    private Emissor emissor;

    @Before
    public void setUp() {
        Datas datas = Datas.newDatas().withDocumento(31, 5, 2006)
                .withProcessamento(31, 5, 2006).withVencimento(31, 5, 2006);

        this.emissor = Emissor.newEmissor().withCedente("Caue Guerra")
                .withAgencia(2949).withDigitoAgencia('1').withContaCorrente(6580)
                .withNumeroConvenio(1207113).withDigitoContaCorrente('3')
                .withCarteira(9).withNossoNumero(1200200)
                .withCodigoFornecidoPelaAgencia(789).withCodigoOperacao(123);

        Sacado sacado = Sacado.newSacado().withNome("Fulano");

        this.banco = new Caixa();

        this.boleto = Boleto.newBoleto().withDatas(datas).withEmissor(
                this.emissor).withSacado(sacado).withValorBoleto(1.00)
                .withNumeroDoDocumento("4323");
    }

    @Test
    public void codFornecidoPelaAgenciaDeveTerOitoDigitos() {
        Emissor emissor = Emissor.newEmissor().withCodigoFornecidoPelaAgencia(2);
        String numeroFormatado = this.banco
                .getCodigoFornecidoPelaAgenciaFormatado(emissor);
        assertEquals(8, numeroFormatado.length());
        assertEquals("00000002", numeroFormatado);
    }

    @Test
    public void codOperacaoDeveTerTresDigitos() {
        Emissor emissor = Emissor.newEmissor().withCodigoOperacao(2);
        String numeroFormatado = this.banco.getCodigoOperacaoFormatado(emissor);
        assertEquals(3, numeroFormatado.length());
        assertEquals("002", numeroFormatado);
    }

    @Test
    public void carteiraFormatadoDeveTerDoisDigitos() {
        Emissor emissor = Emissor.newEmissor().withCarteira(1);
        String numeroFormatado = this.banco
                .getCarteiraDoEmissorFormatado(emissor);
        assertEquals(2, numeroFormatado.length());
        assertEquals("01", numeroFormatado);
    }

    @Test
    public void contaCorrenteFormatadaDeveTerCincoDigitos() {
        String numeroFormatado = this.banco
                .getContaCorrenteDoEmissorFormatado(this.emissor);
        assertEquals(5, numeroFormatado.length());
        assertEquals("06580", numeroFormatado);
    }

    @Test
    public void testLinhaDoBancoCaixa() {
        this.banco = new Caixa();
        this.boleto = this.boleto.withBanco(this.banco);
        LinhaDigitavelGenerator linhaDigitavelGenerator = new LinhaDigitavelGenerator();

        assertEquals(
                "10499.00127  00200.294916  23000.007890  8  31580000000100",
                linhaDigitavelGenerator.geraLinhaDigitavelPara(this.boleto));
    }

    @Test
    public void testCodigoDeBarraDoBancoCaixa() {
        this.banco = new Caixa();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("10498315800000001009001200200294912300000789", this.banco
                .geraCodigoDeBarrasPara(this.boleto));
    }

    @Test
    public void testGetImage() {
        assertNotNull(this.banco.getImage());
    }
}
