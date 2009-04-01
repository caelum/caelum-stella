package br.com.caelum.stella.gateway.bb.integration;


public class RefTranGenerator {

	/**
	 * 
	 * @param codigoConvenioDeCobranca cadastrado junto ao banco
	 * @param numeroASerAnexadoAoCodigoDeConvenio numero gerado pelo usuario para ser anexado ao codigoDeConvenio
	 * @return
	 */
	public String geraRefTran(String codigoConvenioDeCobranca,
			String numeroASerAnexadoAoCodigoDeConvenio) {
		StringBuilder refTran = new StringBuilder();
		if (codigoConvenioDeCobranca != null) {
			if (codigoConvenioDeCobranca.length() == 7) {
				refTran.append(codigoConvenioDeCobranca);
			}
		}
		refTran.append(numeroASerAnexadoAoCodigoDeConvenio);
		//como não consegui fazer com o String.format, vai assim mesmo.
		if(refTran.length()<17){
			while(refTran.length()<17){
				refTran.append("0");
			}
		}		
		return refTran.toString();
	}


	/**
	 * 
	 * @param numeroASerAnexadoAoCodigoDeConvenio numero gerado pelo usuario para ser anexado ao codigoDeConvenio, neste caso ele é o reftran.
	 * @return
	 */
	public String geraRefTran(String numeroASerAnexadoAoCodigoDeConvenio) {
		return geraRefTran(null, numeroASerAnexadoAoCodigoDeConvenio);
	}
}
