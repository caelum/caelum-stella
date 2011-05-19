package br.com.caelum.stella.boleto.bancos;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RealTest {
    private Boleto boleto;
    private Banco banco;

    @Before
    public void setUp() {
        Datas datas = Datas.newDatas().withDocumento(28, 9, 2001).withProcessamento(30, 9, 2001).withVencimento(2, 10,
                2001);

        Emissor emissor = Emissor.newEmissor().withCedente("Alberto").withAgencia(501).withContaCorrente(6703255)
                .withNossoNumero(3020).withCarteira(20);

        Sacado sacado = Sacado.newSacado().withNome("Fulano");

        banco = new Real();

        boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor).withSacado(sacado).withValorBoleto("35.00")
                .withNumeroDoDocumento("0000000003020");
    }

    @Test
    public void testLinhaDoBancoReal() {
        boleto = boleto.withBanco(banco);

        assertEquals("35690.50168  70325.510009  00000.030205  9  14560000003500", new LinhaDigitavelGenerator()
                .geraLinhaDigitavelPara(boleto));
    }

    @Test
    public void testCodigoDeBarraDoBancoReal() {
        boleto = boleto.withBanco(banco);
        assertEquals("35699145600000035000501670325510000000003020", banco.geraCodigoDeBarrasPara(boleto));
    }

    @Test
    public void testGetImage() {
        assertNotNull(banco.getImage());
    }

}
