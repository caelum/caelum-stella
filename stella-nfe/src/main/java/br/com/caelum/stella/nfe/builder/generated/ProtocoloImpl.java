package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class ProtocoloImpl<T> implements Protocolo<T>, br.com.caelum.stella.nfe.ObjectCreator {

    private final br.com.caelum.stella.nfe.modelo.InfProt infProt;
    private final T parent;

    public ProtocoloImpl(final T parent) {
        this.parent = parent;
        infProt = new br.com.caelum.stella.nfe.modelo.InfProt();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.infProt;
    }

    public Protocolo<T> withTipoDoAmbiente(final TipoDoAmbiente tipoDoAmbiente) {
        infProt.setTpAmb(tipoDoAmbiente.getCode());
        return this;
    }

    public Protocolo<T> withVersaoDoAplicativo(final String string) {
        infProt.setVerAplic(string);
        return this;
    }

    public Protocolo<T> withChaveDeAcessoDaNFE(final String string) {
        infProt.setChNFe(string);
        return this;
    }

    public Protocolo<T> withDataEHoraDoProcessamento(final Calendar calendar) {
        infProt.setDhRecbto(calendar);
        return this;
    }

    public Protocolo<T> withNumeroDoProtocoloDeStatusDaNFE(final String string) {
        infProt.setNProt(string);
        return this;
    }

    public Protocolo<T> withDigestValue(final byte[] b) {
        infProt.setDigVal(b);
        return this;
    }

    public Protocolo<T> withCodigoDeStatus(final String string) {
        infProt.setCStat(string);
        return this;
    }

    public Protocolo<T> withDescricaoDoMotivo(final String string) {
        infProt.setXMotivo(string);
        return this;
    }

    public Protocolo<T> withId(final String string) {
        infProt.setId(string);
        return this;
    }

}