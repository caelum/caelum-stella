package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class BancoDoBrasilTest {

    private Boleto boleto;
    private Banco banco;

    @Before
    public void setUp() {
        Datas datas = Datas.newDatas().withDocumento(4, 5, 2008)
                .withProcessamento(4, 5, 2008).withVencimento(2, 5, 2008);

        Emissor emissor = Emissor.newEmissor().withCedente("Caue").withAgencia(
                "1824").withDvAgencia("4").withContaCorrente("76000")
                .withNumConvenio("1207113").withDvContaCorrete("5")
                .withCarteira("18").withNossoNumero("0009000206");

        Sacado sacado = Sacado.newSacado().withNome("Fulano");

        this.banco = new BancoDoBrasil();

        this.boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor)
                .withSacado(sacado).withValorBoleto("40.00").withNoDocumento(
                        "4323");
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

        assertEquals("0000004000", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(9, 19));
    }
    
    @Test
    public void testCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
        this.banco = new BancoDoBrasil();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("0000001207113000900020618", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(19, 44));
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

        assertEquals("0009000206", this.banco.geraCodigoDeBarrasPara(this.boleto)
                .substring(32, 42));
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

        assertEquals(
                "00190.00009  01207.113000  09000.206186  5  38600000004000",
                this.banco.geraLinhaDigitavelPara(this.boleto));
    }

    @Test
    public void testGetImage() throws IOException {
        assertNotNull(this.banco.getImage());
    }
}
