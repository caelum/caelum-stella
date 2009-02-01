package br.com.caelum.stella.nfe.builder.generated;

public final class ArmaImpl implements Arma,
		br.com.caelum.stella.nfe.ObjectCreator {
	private final br.com.caelum.stella.nfe.modelo.Arma arma;

	public ArmaImpl() {
		this.arma = new br.com.caelum.stella.nfe.modelo.Arma();
	}

	public br.com.caelum.stella.nfe.modelo.Arma getInstance() {
		return this.arma;
	}

	public Arma withTpArma(String string) {
		this.arma.setTpArma(string);
		return this;
	}

	public Arma withNSerie(String string) {
		this.arma.setNSerie(string);
		return this;
	}

	public Arma withNCano(String string) {
		this.arma.setNCano(string);
		return this;
	}

	public Arma withDescr(String string) {
		this.arma.setDescr(string);
		return this;
	}
}