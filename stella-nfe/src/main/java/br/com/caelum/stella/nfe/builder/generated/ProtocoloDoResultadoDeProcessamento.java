package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public interface ProtocoloDoResultadoDeProcessamento<T> extends NFeBuilder<T> {
    public ProtocoloDoResultadoDeProcessamento<T> withDadosDoProtocolo(Protocolo<?> infProt);

    public ProtocoloDoResultadoDeProcessamento<T> withSignature(SignatureType signatureType);

    public ProtocoloDoResultadoDeProcessamento<T> withVersao(String string);
}