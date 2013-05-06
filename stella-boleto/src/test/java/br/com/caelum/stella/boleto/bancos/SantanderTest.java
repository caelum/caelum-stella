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
		
	    Datas datas = Datas.novasDatas().comDocumento(29, 04, 2013)
            .comProcessamento(29, 04, 2013).comVencimento(8, 05, 2013);  

	    this.emissor = Emissor.novoEmissor().comCedente("PETROBRAS")
            .comAgencia(6790).comDigitoAgencia('0').comCarteira(102)
            .comContaCorrente(5260965l).comNossoNumero(1056137495014l);  

	    Sacado sacado = Sacado.novoSacado().comNome("PAULO SILVEIRA") ; 
	    
	    boleto = Boleto.novoBoleto().comEspecieDocumento("DM")
    		.comBanco(banco).comDatas(datas).comEmissor(emissor)
    		.comSacado(sacado).comValorBoleto(219.50).comAceite(Boolean.FALSE)
    		.comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4")
    		.comLocaisDePagamento("local 1", "local 2")
    		.comNumeroDoDocumento("105613749501");
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
