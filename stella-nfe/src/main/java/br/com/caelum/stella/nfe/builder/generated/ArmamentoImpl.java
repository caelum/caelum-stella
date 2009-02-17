package br.com.caelum.stella.nfe.builder.generated;

public final class ArmamentoImpl implements Armamento, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Arma arma;

    public ArmamentoImpl() {
        this.arma = new br.com.caelum.stella.nfe.modelo.Arma();
    }

    public br.com.caelum.stella.nfe.modelo.Arma getInstance() {
        return this.arma;
    }

    public Armamento withTipo(TipoDeArmamento tipoDeArmamento) {
        this.arma.setTpArma(tipoDeArmamento.getCodigo() + "");
        return this;
    }

    public Armamento withNumeroDeSerie(Integer numero) {
        this.arma.setNSerie(numero.toString());
        return this;
    }

    public Armamento withNumeroDeSerieDoCano(Integer numero) {
        this.arma.setNCano(numero.toString());
        return this;
    }

    public Armamento withDescricao(String string) {
        this.arma.setDescr(string);
        return this;
    }

}