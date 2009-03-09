package br.com.caelum.stella.nfe.builder.generated;

public enum TipoDeArmamento {
    USO_PERMITIDO("0"), USO_RESTRITO("1");

    private final String codigo;

    private TipoDeArmamento(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
