package br.com.caelum.stella.nfe.builder.generated.enums;

public enum ModalidadeDoFrete {
    PAGO_PELO_EMITENTE("0"), PAGO_PELO_DESTINATARIO("1");

    private final String code;

    private ModalidadeDoFrete(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
