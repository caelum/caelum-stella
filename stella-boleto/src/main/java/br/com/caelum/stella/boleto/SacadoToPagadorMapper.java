package br.com.caelum.stella.boleto;

@SuppressWarnings("deprecation")
public class SacadoToPagadorMapper {

	public Sacado toSacado(Pagador pagador) {
		return Sacado.novoSacado().comBairro(pagador.getEndereco().getBairro())
				.comCep(pagador.getEndereco().getCep())
				.comCidade(pagador.getEndereco().getCidade())
				.comEndereco(pagador.getEndereco().getLogradouro())
				.comUf(pagador.getEndereco().getUf())
				.comCpf(pagador.getDocumento())
				.comNome(pagador.getNome());
	}

	public Pagador toPagador(Sacado sacado) {
		Endereco endereco = new Endereco(sacado.getEndereco(), sacado.getBairro(), sacado.getCep(), sacado.getCidade(), sacado.getUf());
		return Pagador.novoPagador().comDocumento(sacado.getCpf())
				.comEndereco(endereco)
				.comNome(sacado.getNome());
	}
}
