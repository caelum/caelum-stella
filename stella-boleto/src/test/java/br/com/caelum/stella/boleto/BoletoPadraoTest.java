package br.com.caelum.stella.boleto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.stella.boleto.transformer.PDFBoletoTransformer;

import com.lowagie.text.DocumentException;

public class BoletoPadraoTest {

	@Test
	public void testNewBoleto() throws NumberFormatException, IOException, DocumentException, ParseException {
		
		DatasPadrao datas = DatasPadrao.newDatas()
			.comDataDeDocumento(Calendar.getInstance())
			.comDataDeProcessamento(Calendar.getInstance())
			.comDataDeVencimento(Calendar.getInstance());
		
		EmissorPadrao emissor = EmissorPadrao.newEmissor()
			.comCedente("Caue")
			.comAgencia("0633")
			.comContaCorrente("4720135")
			.comDvContaCorrete("6")
			.comCarteira("18");
		
		SacadoPadrao sacado = SacadoPadrao.newSacado()
			.comNome("Fulano");
		
		List<String> descricoes = new ArrayList<String>();
		descricoes.add("descricao1");
		
		List<String> locaisDePagamento = new ArrayList<String>();
		locaisDePagamento.add("local1");
		
		List<String> instrucoes = new ArrayList<String>();
		instrucoes.add("instrucao1");
		
		BoletoPadrao boleto = BoletoPadrao.newBoleto()
			.comBanco(Bancos.BANCO_DO_BRASIL)
			.comDatas(datas)
			.comDescricoes(descricoes)
			.comEmissor(emissor)
			.comSacado(sacado)
			.comValorBoleto("2.00")
			.comNoDocumento("4323")
			.comInstrucoes(instrucoes)
			.comLocaisDePagamento(locaisDePagamento);
		
		
		PDFBoletoTransformer pdf = new PDFBoletoTransformer();
		InputStream is = pdf.transform(boleto);
 
		
		File arquivo = new File("arquivo.pdf");  
        FileOutputStream fos = new FileOutputStream(arquivo);  
        
        fos.write(is.read());
	}
}
