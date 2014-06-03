package br.com.caelum.stella.boleto;

@SuppressWarnings("deprecation")
class EmissorToBeneficiarioMapper {
	
	public Beneficiario toBeneficiario(Emissor emissor){
		
		Endereco endereco = Endereco.novoEndereco().comLogradouro(emissor.getEndereco());

		return Beneficiario.novoBeneficiario()
				.comAgencia(emissor.getAgencia())
				.comCarteira(emissor.getCarteira())
				.comCodigoBeneficiario(emissor.getContaCorrente())
				.comDigitoCodigoBeneficiario(emissor.getDigitoContaCorrente())
				.comDigitoNossoNumero(emissor.getDigitoNossoNumero())
				.comEndereco(endereco)
				.comNomeBeneficiario(emissor.getCedente())
				.comNossoNumero(emissor.getNossoNumero())
				.comNumeroConvenio(emissor.getNumeroConvenio()); //BB
	}
	
	public Emissor toEmissor(Beneficiario beneficiario){
		return Emissor.novoEmissor()
				.comAgencia(beneficiario.getAgencia())
				.comCarteira(beneficiario.getCarteira())
				.comCedente(beneficiario.getNomeBeneficiario())
				
				.comCodigoFornecidoPelaAgencia(beneficiario.getCodigoBeneficiario())
				.comContaCorrente(beneficiario.getCodigoBeneficiario())
				
				.comDigitoAgencia(beneficiario.getDigitoAgencia())
				.comDigitoContaCorrente(beneficiario.getDigitoCodigoBeneficiario())
				.comDigitoNossoNumero(beneficiario.getDigitoNossoNumero())
				.comEndereco(beneficiario.getEndereco().getEnderecoCompleto())
				.comNossoNumero(beneficiario.getNossoNumero())
				.comNumeroConvenio(beneficiario.getNumeroConvenio()); // BB
	}

}
