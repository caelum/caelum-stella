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

public class BradescoTest {

    private Boleto boleto;
    private Banco banco;

    @Before
    public void setUp() {
        Datas datas = Datas.newDatas().withDocumento(31, 5, 2006)
                .withProcessamento(31, 5, 2006).withVencimento(10, 6, 2006);

        Emissor emissor = Emissor.newEmissor().withCedente("Leonardo Bessa").withAgencia(
                "2949").withDvAgencia("1").withContaCorrente("0006580")
                .withNumConvenio("1207113").withDvContaCorrete("3")
                .withCarteira("06").withNossoNumero("00000000003");

        Sacado sacado = Sacado.newSacado().withNome("Fulano");

        this.banco = new Bradesco();

        this.boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor)
                .withSacado(sacado).withValorBoleto("1.00").withNoDocumento(
                        "4323");
    }

    @Test
    public void testLinhaDoBancoBradesco() {
        this.banco = new Bradesco();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("23792.94909  60000.000004  03000.658009  6  31680000000100"
                ,
                this.banco.geraLinhaDigitavelPara(this.boleto));
    }

    @Test
    public void testCodigoDeBarraDoBancoBradesco() {
        this.banco = new Bradesco();
        this.boleto = this.boleto.withBanco(this.banco);

        assertEquals("23796316800000001002949060000000000300065800", this.banco
                .geraCodigoDeBarrasPara(this.boleto));
    }

    @Test
    public void testGetImage() throws IOException {
        assertNotNull(this.banco.getImage());
    }
}
