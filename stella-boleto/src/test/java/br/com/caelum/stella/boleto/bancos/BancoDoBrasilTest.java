package br.com.caelum.stella.boleto.bancos;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class BancoDoBrasilTest {

    private Boleto boleto;
    private BancoDoBrasil banco;
    private Emissor emissor;

    @Before
    public void setUp() {
        Datas datas = Datas.newDatas().withDocumento(4, 5, 2008)
                .withProcessamento(4, 5, 2008).withVencimento(2, 5, 2008);

        this.emissor = Emissor.newEmissor().withCedente("Caue").withAgencia(
                1824).withDigitoAgencia('4').withContaCorrente(76000)
                .withNumeroConvenio(1207113).withDigitoContaCorrente('5')
                .withCarteira(18).withNossoNumero(9000206);

        Sacado sacado = Sacado.newSacado().withNome("Fulano");

        this.banco = new BancoDoBrasil();

        this.boleto = Boleto.newBoleto().withDatas(datas).withEmissor(
                this.emissor).withSacado(sacado).withValorBoleto("40.00")
                .withNumeroDoDocumento("4323");
    }

    @Test
    public void numeroDoConvenioFormatadoDeveTerSeisDigitos() {
        Emissor emissor = Emissor.newEmissor().withNumeroConvenio(1234);
        String numeroFormatado = this.banco
                .getNumConvenioDoEmissorFormatado(emissor);
        assertEquals(6, numeroFormatado.length());
        assertEquals("001234", numeroFormatado);
    }

    @Test
    public void nossoNumeroFormatadoDeveTerOnzeDigitos() {
        Emissor emissor = Emissor.newEmissor().withNossoNumero(9000206)
                .withCarteira(11);
        String numeroFormatado = this.banco
                .getNossoNumeroDoEmissorFormatado(emissor);
        assertEquals(11, numeroFormatado.length());
        assertEquals("00009000206", numeroFormatado);
    }

    @Test
    public void nossoNumeroFormatadoDeveTerDezesseteDigitosComCarteira18() {
        Emissor emissor = Emissor.newEmissor().withNossoNumero(9000206)
                .withCarteira(18);
        String numeroFormatado = this.banco
                .getNossoNumeroDoEmissorFormatado(emissor);
        assertEquals(17, numeroFormatado.length());
        assertEquals("00000000009000206", numeroFormatado);
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
    public void contaCorrenteFormatadaDeveTerOitoDigitos() {
        String numeroFormatado = this.banco
                .getContaCorrenteDoEmissorFormatado(this.emissor);
        assertEquals(8, numeroFormatado.length());
        assertEquals("00076000", numeroFormatado);
    }

    @Test
    public void testNumeroFormatadoNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("001", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(0, 3));
    }

    @Test
    public void testCodEspecieMoedaNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("9", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(3, 4));
    }

    @Test
    public void testDigitoVerificadorNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("5", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(4, 5));
    }

    @Test
    public void testFatorVencimentoNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("3860", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(5, 9));
    }

    @Test
    public void testValorNominalNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("0000004000", this.banco.geraCodigoDeBarrasPara(
                this.boleto).substring(9, 19));
    }

    @Test
    public void testCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("0000001207113000900020618", this.banco
                .geraCodigoDeBarrasPara(this.boleto).substring(19, 44));
    }

    @Test
    public void testZerosNoCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("000000", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(19, 25));
    }

    @Test
    public void testNumConvenioFormatadoNoCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("1207113", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(25, 32));
    }

    @Test
    public void testNossoNumeroFormatadoNoCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("0009000206", this.banco.geraCodigoDeBarrasPara(
                this.boleto).substring(32, 42));
    }

    @Test
    public void testCarteiraNoCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("18", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(42, 44));
    }

    @Test
    public void testCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("00195386000000040000000001207113000900020618", this.banco
                .geraCodigoDeBarrasPara(this.boleto));
    }

    @Test
    public void testLinhaDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);
        LinhaDigitavelGenerator linhaDigitavelGenerator = new LinhaDigitavelGenerator();

        assertEquals(
                "00190.00009  01207.113000  09000.206186  5  38600000004000",
                linhaDigitavelGenerator.geraLinhaDigitavelPara(this.boleto));
    }

    @Test
    public void testGetImage() {
        assertNotNull(this.banco.getImage());
    }

}
