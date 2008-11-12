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

public class RealTest {
    private Boleto boleto;
    private Banco banco;

    @Before
    public void setUp() {
        Datas datas = Datas.newDatas().withDocumento(28, 9, 2001)
                .withProcessamento(30, 9, 2001).withVencimento(2, 10, 2001);

        Emissor emissor = Emissor.newEmissor().withCedente("Alberto")
                .withAgencia(501).withContaCorrente(6703255).withNossoNumero(
                        3020).withCarteira(20);

        Sacado sacado = Sacado.newSacado().withNome("Fulano");

        this.banco = new Real();

        this.boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor)
                .withSacado(sacado).withValorBoleto("35.00").withNoDocumento(
                        "0000000003020");
    }

    @Test
    public void testLinhaDoBancoReal() {
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals(
                "35690.50168  70325.510009  00000.030205  9  14560000003500",
                new LinhaDigitavelGenerator()
                        .geraLinhaDigitavelPara(this.boleto));
    }

    @Test
    public void testCodigoDeBarraDoBancoReal() {
        this.boleto = this.boleto.withBanco(this.banco);
        assertEquals("35699145600000035000501670325510000000003020", this.banco
                .geraCodigoDeBarrasPara(this.boleto));
    }

    @Test
    public void testGetImage() throws IOException {
        assertNotNull(this.banco.getImage());
    }

}
