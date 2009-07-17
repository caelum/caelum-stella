package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.UF;

public interface ICMSSobreConsumo<T> extends NFeBuilder<T> {
    public ICMSSobreConsumo<T> withValorDaBaseDeCalculoDoICMSDeSubstituicaoTributariaSobreConsumo(BigDecimal string);

    public ICMSSobreConsumo<T> withValorDoICMSSubstituicaoTributariaSobreConsumo(BigDecimal string);

    public ICMSSobreConsumo<T> withUF(UF tUf);
}