package br.com.caelum.stella.boleto.bancos;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class BradescoTest {

    private Boleto boleto;
    private Bradesco banco;
    private Emissor emissor;

    @Before
    public void setUp() {
        Datas datas = Datas.newDatas().withDocumento(31, 5, 2006)
                .withProcessamento(31, 5, 2006).withVencimento(10, 6, 2006);

        this.emissor = Emissor.newEmissor().withCedente("Leonardo Bessa")
                .withAgencia(2949).withDvAgencia('1').withContaCorrente(6580)
                .withNumConvenio(1207113).withDvContaCorrente('3')
                .withCarteira(6).withNossoNumero(3);

        Sacado sacado = Sacado.newSacado().withNome("Fulano");

        this.banco = new Bradesco();

        this.boleto = Boleto.newBoleto().withDatas(datas).withEmissor(
                this.emissor).withSacado(sacado).withValorBoleto("1.00")
                .withNumeroDoDocumento("4323");
    }

    @Test
    public void numeroDoConvenioFormatadoDeveTerSeteDigitos() {
        Emissor emissor = Emissor.newEmissor().withNumConvenio(1234);
        String numeroFormatado = this.banco
                .getNumConvenioDoEmissorFormatado(emissor);
        assertEquals(7, numeroFormatado.length());
        assertEquals("0001234", numeroFormatado);
    }

    @Test
    public void nossoNumeroFormatadoDeveTerOnzeDigitos() {
        Emissor emissor = Emissor.newEmissor().withNossoNumero(9000206);
        String numeroFormatado = this.banco
                .getNossoNumeroDoEmissorFormatado(emissor);
        assertEquals(11, numeroFormatado.length());
        assertEquals("00009000206", numeroFormatado);
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
    public void contaCorrenteFormatadaDeveTerSeteDigitos() {
        String numeroFormatado = this.banco
                .getContaCorrenteDoEmissorFormatado(this.emissor);
        assertEquals(7, numeroFormatado.length());
        assertEquals("0006580", numeroFormatado);
    }

    @Test
    public void testLinhaDoBancoBradesco() {
        this.banco = new Bradesco();
        this.boleto = this.boleto.withBanco(this.banco);
        LinhaDigitavelGenerator linhaDigitavelGenerator = new LinhaDigitavelGenerator();

        assertEquals(
                "23792.94909  60000.000004  03000.658009  6  31680000000100",
                linhaDigitavelGenerator.geraLinhaDigitavelPara(this.boleto));
    }

    @Test
    public void testCodigoDeBarraDoBancoBradesco() {
        this.banco = new Bradesco();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("23796316800000001002949060000000000300065800", this.banco
                .geraCodigoDeBarrasPara(this.boleto));
    }

    @Test
    public void testGetImage() {
        assertNotNull(this.banco.getImage());
    }
}
