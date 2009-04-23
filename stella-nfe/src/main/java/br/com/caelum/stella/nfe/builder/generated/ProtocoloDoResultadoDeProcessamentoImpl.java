package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class ProtocoloDoResultadoDeProcessamentoImpl implements ProtocoloDoResultadoDeProcessamento,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TProtNFe tProtNFe;

    public ProtocoloDoResultadoDeProcessamentoImpl() {
        tProtNFe = new br.com.caelum.stella.nfe.modelo.TProtNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.tProtNFe;
    }

    public ProtocoloDoResultadoDeProcessamento withDadosDoProtocolo(final Protocolo infProt) {
        tProtNFe.setInfProt((br.com.caelum.stella.nfe.modelo.InfProt) ((ObjectCreator) infProt).getInstance());
        return this;
    }

    public ProtocoloDoResultadoDeProcessamento withSignature(final SignatureType signatureType) {
        tProtNFe.setSignature(signatureType);
        return this;
    }

    public ProtocoloDoResultadoDeProcessamento withVersao(final String string) {
        tProtNFe.setVersao(string);
        return this;
    }
}