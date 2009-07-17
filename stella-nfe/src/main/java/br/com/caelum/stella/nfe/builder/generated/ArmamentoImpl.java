package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeArmamento;

public final class ArmamentoImpl<T> implements Armamento<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Arma arma;
    private final T parent;

    public ArmamentoImpl(final T parent) {
        this.parent = parent;
        this.arma = new br.com.caelum.stella.nfe.modelo.Arma();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.arma;
    }

    public Armamento<T> withTipo(final TipoDeArmamento tipoDeArmamento) {
        this.arma.setTpArma(tipoDeArmamento.getCodigo() + "");
        return this;
    }

    public Armamento<T> withNumeroDeSerie(final Integer numero) {
        this.arma.setNSerie(numero.toString());
        return this;
    }

    public Armamento<T> withNumeroDeSerieDoCano(final Integer numero) {
        this.arma.setNCano(numero.toString());
        return this;
    }

    public Armamento<T> withDescricao(final String string) {
        this.arma.setDescr(string);
        return this;
    }

}