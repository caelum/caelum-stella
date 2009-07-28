package br.com.caelum.stella.gateway.redecard;

import br.com.caelum.stella.gateway.core.ProblematicTransactionException;

public class RedecardVerificadorRetornoConfirmacaoTransacao {
	private String retorno;

	public RedecardVerificadorRetornoConfirmacaoTransacao(String retorno) {
		this.retorno = retorno;
	}
	
	public RedecardConfirmacaoTransacaoReturn verificaRetorno(){
		if(!"".equals(retorno)){
			String[] params = retorno.split("&");
			int codigoRetorno = Integer.valueOf(params[0].split("=")[1]);
			String mensagemRetorno = params[1].split("=")[1];
			RedecardConfirmacaoTransacaoReturn confirmacaoTransacaoReturn = new RedecardConfirmacaoTransacaoReturn(codigoRetorno,mensagemRetorno);
			if(codigoRetorno!=0){
				throw new ProblematicTransactionException("A transação não pode ser confirmada ("+confirmacaoTransacaoReturn.getMensagemRetorno()+")",confirmacaoTransacaoReturn);
			}
			return confirmacaoTransacaoReturn;
		}
		throw new RedecardConfirmacaoSemDadosException("Os dados de retorno não foram enviados, solicite novamente",new RedecardConfirmacaoTransacaoReturn(-1,"Dados não foram retornados"));		
	}

}