package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class SantanderTest {

	private Santander banco = new Santander();
	private Emissor emissor;
	private Boleto boleto;

	@Before
	public void setUp() {
		
	    Datas datas = Datas.newDatas().withDocumento(29, 04, 2013)
            .withProcessamento(29, 04, 2013).withVencimento(8, 05, 2013);  

	    this.emissor = Emissor.newEmissor().withCedente("PETROBRAS")
            .withAgencia(6790).withDigitoAgencia('0').withCarteira(102)
            .withCodigoCliente("5260965").withNossoNumero(1056137495014l);  

	    Sacado sacado = Sacado.newSacado().withNome("PAULO SILVEIRA") ; 
	    
	    boleto = Boleto.newBoleto().withEspecieDocumento("DM")
    		.withBanco(banco).withDatas(datas).withEmissor(emissor)
    		.withSacado(sacado).withValorBoleto(219.50).withAceite(Boolean.FALSE)
    		.withInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4")
    		.withLocaisDePagamento("local 1", "local 2")
    		.withNumeroDoDocumento("105613749501");
	}

	@Test 
	public void testCodigoDeBarraDoBancoSantander() {
		String string = "03392569200000219509526096510561374950140102";
		assertEquals(string, banco.geraCodigoDeBarrasPara(boleto));
	}

	@Test
	public void testGetImage() {
		assertNotNull(banco.getImage());
	}

}
