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
	
	private Santander banco;
	private Emissor emissor;
	private Boleto boleto;
	
    @Before
    public void setUp() {
		Datas datas = Datas.newDatas()
	            .withDocumento(27, 12, 2012)
	            .withProcessamento(27, 12, 2012)
	            .withVencimento(31, 12, 2012);  

	    emissor = Emissor.newEmissor()  
	            .withCedente("Fulano de Tal")  
	            .withAgencia(4001).withDigitoAgencia('3')  
	            .withContaCorrente(1216)
	            .withDigitoContaCorrente('8')
	            .withNumeroConvenio(1207113)  
	            .withCarteira(102)  
	            .withNossoNumero(4007469108L);  

	    Sacado sacado = Sacado.newSacado()  
	            .withNome("Fulano da Silva")  
	            .withCpf("111.222.333-12")  
	            .withEndereco("Av dos testes, 111 apto 333")  
	            .withBairro("Bairro Teste")  
	            .withCep("01234-111")  
	            .withCidade("São Paulo")  
	            .withUf("SP");  

	    banco = new Santander();  

	    boleto = Boleto.newBoleto()  
	            .withBanco(banco)  
	            .withDatas(datas)  
//	            .withDescricoes("descricao 1", "descricao 2", "descricao 3", "descricao 4", "descricao 5")  
	            .withEmissor(emissor)  
	            .withSacado(sacado)  
	            .withValorBoleto("0.01")  
	            .withInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")  
	            .withLocaisDePagamento("local 1", "local 2")  
	            .withNumeroDoDocumento("2000");

    }

    @Test
    public void testLinhaDoBancoReal() {
        assertEquals("03390.40016  01216.874691  10800.033721  4  55640000000001", new LinhaDigitavelGenerator().geraLinhaDigitavelPara(boleto));
    }

    @Test
    public void testCodigoDeBarraDoBancoSantander() {
        assertEquals("03394556400000000010400101216874691080003372", banco.geraCodigoDeBarrasPara(boleto));
    }

    @Test
    public void testGetImage() {
        assertNotNull(banco.getImage());
    }


}
