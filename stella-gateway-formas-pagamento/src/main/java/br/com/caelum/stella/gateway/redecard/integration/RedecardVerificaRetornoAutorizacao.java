package br.com.caelum.stella.gateway.redecard.integration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.core.ProblematicTransactionException;

/**
 * Classe responsável por verificar o retorno da solicitação de autorização da Redecard.
 * @author Alberto Pc
 *
 */
public class RedecardVerificaRetornoAutorizacao implements
		IntegrationHandler<RedecardAutorizacaoReturn> {
	
	private final HttpServletRequest request;
	
	
	public RedecardVerificaRetornoAutorizacao(final HttpServletRequest request) {
		super();
		this.request = request;
	}



	public RedecardAutorizacaoReturn handle() {
		// TODO Auto-generated method stub
		final int codigoRetorno = Integer.valueOf(request.getParameter("CODRET"));
		final String mensagemRetorno = request.getParameter("MSGRET");
		final String numPedido = request.getParameter("NUMPEDIDO");
		final String dataDesformatada = request.getParameter("DATA");
		Calendar dataAutorizacao;
		try {								
			dataAutorizacao = converteDataStringParaCalendar(dataDesformatada);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ProblematicTransactionException("A conversão da data de autorizacao falhou "+dataDesformatada,e,new RedecardAutorizacaoReturn(codigoRetorno,mensagemRetorno,numPedido));
		}		
		RedecardAutorizacaoReturn autorizacaoReturn = new RedecardAutorizacaoReturn(codigoRetorno,mensagemRetorno,dataAutorizacao,numPedido,request.getParameter("NR_CARTAO"),request.getParameter("ORIGEM_BIN"),request.getParameter("NUMAUTOR"),request.getParameter("NUMCV"),request.getParameter("NUMAUTENT"),request.getParameter("NUMSQN"));
		if(autorizacaoReturn.getCodigoRetorno()>49){
			throw new ProblematicTransactionException(autorizacaoReturn.getMensagemRetorno(),autorizacaoReturn);
		}
		return autorizacaoReturn;
	}



	private Calendar converteDataStringParaCalendar(String dataDesformatada) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Calendar dataAutorizacao = Calendar.getInstance();
		dataAutorizacao.setTime(formatter.parse(dataDesformatada));		
		return dataAutorizacao;
	}

}
