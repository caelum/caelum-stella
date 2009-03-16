package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class ProtocoloImpl implements Protocolo, br.com.caelum.stella.nfe.ObjectCreator {

    private final br.com.caelum.stella.nfe.modelo.InfProt infProt;

    public ProtocoloImpl() {
        infProt = new br.com.caelum.stella.nfe.modelo.InfProt();
    }

    public br.com.caelum.stella.nfe.modelo.InfProt getInstance() {
        return infProt;
    }

    public Protocolo withTipoDoAmbiente(final TipoDoAmbiente tipoDoAmbiente) {
        infProt.setTpAmb(tipoDoAmbiente.getCode());
        return this;
    }

    public Protocolo withVersaoDoAplicativo(final String string) {
        infProt.setVerAplic(string);
        return this;
    }

    public Protocolo withChaveDeAcessoDaNFE(final String string) {
        infProt.setChNFe(string);
        return this;
    }

    public Protocolo withDataEHoraDoProcessamento(final Calendar calendar) {
        infProt.setDhRecbto(calendar);
        return this;
    }

    public Protocolo withNumeroDoProtocoloDeStatusDaNFE(final String string) {
        infProt.setNProt(string);
        return this;
    }

    public Protocolo withDigestValue(final byte[] b) {
        infProt.setDigVal(b);
        return this;
    }

    public Protocolo withCodigoDeStatus(final String string) {
        infProt.setCStat(string);
        return this;
    }

    public Protocolo withDescricaoDoMotivo(final String string) {
        infProt.setXMotivo(string);
        return this;
    }

    public Protocolo withId(final String string) {
        infProt.setId(string);
        return this;
    }

}