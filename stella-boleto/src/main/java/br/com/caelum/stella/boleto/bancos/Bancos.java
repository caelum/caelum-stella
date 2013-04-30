package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.exception.BancoNaoSuportadoException;

/**
 * Enum que serve como fábrica de Bancos
 * 
 * @author mariofts
 * @author Turini
 * 
 */
public enum Bancos {

	BANCO_DO_BRASIL("001") {
		@Override
		public Banco getBanco() {
			return new BancoDoBrasil();
		}
	},
	BRADESCO("237") {
		@Override
		public Banco getBanco() {
			return new Bradesco();
		}
	},
	CAIXA("104") {
		@Override
		public Banco getBanco() {
			return new Caixa();
		}
	},
	HSBC("399") {
		@Override
		public Banco getBanco() {
			return new HSBC();
		}
	},
	ITAU("341") {
		@Override
		public Banco getBanco() {
			return new Itau();
		}
	},
	SANTANDER("033") {
		@Override
		public Banco getBanco() {
			return new Santander();
		}
	};

	private String numeroDoBanco;

	/**
	 * Obtém o número do banco
	 * 
	 * @return numero do banco
	 */
	public String getNumeroDoBanco() {
		return numeroDoBanco;
	}

	private Bancos(String numeroDoBanco) {
		this.numeroDoBanco = numeroDoBanco;
	}

	/**
	 * Obtém a instancia do banco para ser utilizada na geração dos boletos
	 * 
	 * @return Banco para geração dos boletos
	 */
	public abstract Banco getBanco();

	/**
	 * Obtém o Banco com base no número
	 * 
	 * @param numero
	 *            Número do banco com 3 dígitos.
	 * @return Banco correspondente ao número informado.
	 * @throws BancoNaoSuportadoException
	 *             se o número informado não corresponder a nenhum dos bancos
	 *             suportados.
	 */
	public static Banco getPorNumero(String numero) {
		for (Bancos b : Bancos.values()) {
			if (b.getNumeroDoBanco().equals(numero))
				return b.getBanco();
		}
		throw new BancoNaoSuportadoException(numero);
	}
}