package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public interface Protocolo {
    public Protocolo withTipoDoAmbiente(TipoDoAmbiente tipoDoAmbiente);

    public Protocolo withVersaoDoAplicativo(String string);

    public Protocolo withChaveDeAcessoDaNFE(String string);

    public Protocolo withDataEHoraDoProcessamento(Calendar calendar);

    public Protocolo withNumeroDoProtocoloDeStatusDaNFE(String string);

    public Protocolo withDigestValue(byte[] b);

    public Protocolo withCodigoDeStatus(String string);

    public Protocolo withDescricaoDoMotivo(String string);

    public Protocolo withId(String string);
}