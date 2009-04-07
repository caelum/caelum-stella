package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.gateway.bb.Situacao;
import br.com.caelum.stella.gateway.bb.TipoTransacao;
import br.com.caelum.stella.gateway.bb.integration.BBFormualrioRetornoReturn;
import br.com.caelum.stella.gateway.bb.integration.BBFormularioInformaReturn;
import br.com.caelum.stella.gateway.bb.integration.BBFormularioSondaReturn;
import br.com.caelum.stella.gateway.bb.integration.BBFormularioSondaReturnBuilder;
import br.com.caelum.stella.gateway.bb.integration.BBVerificacaoFormularioInforma;
import br.com.caelum.stella.gateway.bb.integration.BBVerificacaoFormularioRetorno;


public class BBTestRetornoIntegracao {

	@Test
	public void testRetornoForumalrioSondaString(){
		BBFormularioSondaReturn formularioSondaReturn = BBFormularioSondaReturnBuilder.STRING.buildRetorno("1234567890123456700000000000100012345620102042009");
		assertResultsFormularioSonda(formularioSondaReturn);
	}
	
	@Test
	public void testRetornoFormularioSondaXML() throws URISyntaxException{		
		StringBuilder xml = new StringBuilder("<?xml version='1.0' encoding='ISO-8859-1' standalone='no'?>");
		xml.append("<!DOCTYPE lojavirtual SYSTEM \"lojavirtual.dtd\">");
		xml.append("<FORMULARIO>");
		xml.append("<ENTRADA nome=\"refTran\" valor=\"12345678901234567\" />");
		xml.append("<ENTRADA nome=\"valor\" valor=\"000000000001000\" />");
		xml.append("<ENTRADA nome=\"idConv\" valor=\"123456\" />");
		xml.append("<ENTRADA nome=\"tpPagamento\" valor=\"2\" />");
		xml.append("<ENTRADA nome=\"situacao\" valor=\"01\" />");
		xml.append("<ENTRADA nome=\"dataPagamento\" valor=\"02042009\" />");
		xml.append("</FORMULARIO>");
		BBFormularioSondaReturn formularioSondaReturn = BBFormularioSondaReturnBuilder.XML.buildRetorno(xml.toString());
		assertResultsFormularioSonda(formularioSondaReturn);
		
	}

	private void assertResultsFormularioSonda(BBFormularioSondaReturn formularioSondaReturn) {
		Assert.assertEquals("12345678901234567",formularioSondaReturn.getRefTran());
		Assert.assertEquals(BigDecimal.TEN.setScale(2),formularioSondaReturn.getValor());
		Assert.assertEquals("123456",formularioSondaReturn.getIdConv());
		Assert.assertEquals(TipoTransacao.BLOQUETO_BANCARIO,formularioSondaReturn.getTipoTransacao());
		Assert.assertEquals(Situacao.PAGAMENTO_EFETUADO,formularioSondaReturn.getSituacao());
		Calendar dataPagameto = Calendar.getInstance();
		dataPagameto.set(Calendar.DAY_OF_MONTH,2);
		dataPagameto.set(Calendar.MONTH,Calendar.APRIL);
		dataPagameto.set(Calendar.YEAR,2009);
		Assert.assertEquals(dataPagameto.get(Calendar.DAY_OF_MONTH),formularioSondaReturn.getDataPagamento().get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(dataPagameto.get(Calendar.MONTH),formularioSondaReturn.getDataPagamento().get(Calendar.MONTH));
		Assert.assertEquals(dataPagameto.get(Calendar.YEAR),formularioSondaReturn.getDataPagamento().get(Calendar.YEAR));
	}
	
	@Test
	public void testRetornoFormularioRetorno(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{				
				one(request).getParameter("tpPagamento");will(returnValue("2"));
				one(request).getParameter("idConv");will(returnValue("123456"));
				one(request).getParameter("refTran");will(returnValue("123456789012345"));
			}
		});
		BBFormualrioRetornoReturn formualrioRetornoReturn = new BBVerificacaoFormularioRetorno(request).handle();
		Assert.assertEquals(TipoTransacao.BLOQUETO_BANCARIO,formualrioRetornoReturn.getTipoTransacao());
		Assert.assertEquals("123456",formualrioRetornoReturn.getIdConv());
		Assert.assertEquals("123456789012345",formualrioRetornoReturn.getRefTran());
	}
	
	@Test
	public void testRetornoFormularioInforma(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{				
				one(request).getParameter("valor");will(returnValue("1000"));
				one(request).getParameter("idConv");will(returnValue("123456"));
				one(request).getParameter("refTran");will(returnValue("123456789012345"));
			}
		});
		BBFormularioInformaReturn formularioInformaReturn = new BBVerificacaoFormularioInforma(request).handle();
		Assert.assertEquals(BigDecimal.TEN.setScale(2),formularioInformaReturn.getValor());
		Assert.assertEquals("123456",formularioInformaReturn.getIdConv());
		Assert.assertEquals("123456789012345",formularioInformaReturn.getRefTran());
	}
	
}
