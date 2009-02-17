package br.com.caelum.stella.nfe.builder.generated;

public enum TipoDeArmamento {
    USO_PERMITIDO(0), USO_RESTRITO(1);

    private final int codigo;

    private TipoDeArmamento(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }


}
