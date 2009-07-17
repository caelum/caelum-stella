package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public interface Protocolo<T> extends NFeBuilder<T> {
    public Protocolo<T> withTipoDoAmbiente(TipoDoAmbiente tipoDoAmbiente);

    public Protocolo<T> withVersaoDoAplicativo(String string);

    public Protocolo<T> withChaveDeAcessoDaNFE(String string);

    public Protocolo<T> withDataEHoraDoProcessamento(Calendar calendar);

    public Protocolo<T> withNumeroDoProtocoloDeStatusDaNFE(String string);

    public Protocolo<T> withDigestValue(byte[] b);

    public Protocolo<T> withCodigoDeStatus(String string);

    public Protocolo<T> withDescricaoDoMotivo(String string);

    public Protocolo<T> withId(String string);
}