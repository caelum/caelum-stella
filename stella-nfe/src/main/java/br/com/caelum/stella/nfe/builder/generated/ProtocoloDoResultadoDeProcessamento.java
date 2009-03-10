package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface ProtocoloDoResultadoDeProcessamento {
    public ProtocoloDoResultadoDeProcessamento withDadosDoProtocolo(DadosDoProtocolo infProt);

    public ProtocoloDoResultadoDeProcessamento withSignature(SignatureType signatureType);

    public ProtocoloDoResultadoDeProcessamento withVersao(String string);
}