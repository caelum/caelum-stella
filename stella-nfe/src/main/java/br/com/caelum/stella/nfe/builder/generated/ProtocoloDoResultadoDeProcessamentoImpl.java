package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class ProtocoloDoResultadoDeProcessamentoImpl<T> implements ProtocoloDoResultadoDeProcessamento<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TProtNFe tProtNFe;
    private final T parent;

    public ProtocoloDoResultadoDeProcessamentoImpl(final T parent) {
        this.parent = parent;
        tProtNFe = new br.com.caelum.stella.nfe.modelo.TProtNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tProtNFe;
    }

    public ProtocoloDoResultadoDeProcessamento<T> withDadosDoProtocolo(final Protocolo<?> infProt) {
        tProtNFe.setInfProt((br.com.caelum.stella.nfe.modelo.InfProt) ((ObjectCreator) infProt).getInstance());
        return this;
    }

    public ProtocoloDoResultadoDeProcessamento<T> withSignature(final SignatureType signatureType) {
        tProtNFe.setSignature(signatureType);
        return this;
    }

    public ProtocoloDoResultadoDeProcessamento<T> withVersao(final String string) {
        tProtNFe.setVersao(string);
        return this;
    }
}