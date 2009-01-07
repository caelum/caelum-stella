package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.builder.icms.ICMSCobradoAnteriormentePorSubstituicao;
import br.com.caelum.stella.nfe.builder.icms.ICMSComReducaoBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.ICMSComReducaoBaseDeCalculoESubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.ICMSDiferimento;
import br.com.caelum.stella.nfe.builder.icms.ICMSNaoTributado;
import br.com.caelum.stella.nfe.builder.icms.ICMSOutros;
import br.com.caelum.stella.nfe.builder.icms.ICMSTributadoComSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.ICMSTributadoIntegralmente;
import br.com.caelum.stella.nfe.builder.icms.impl.ICMSCobradoAnteriormentePorSubstituicaoImpl;
import br.com.caelum.stella.nfe.builder.icms.impl.ICMSComReducaoBaseCalculoImpl;
import br.com.caelum.stella.nfe.builder.icms.impl.ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl;
import br.com.caelum.stella.nfe.builder.icms.impl.ICMSDiferimentoImpl;
import br.com.caelum.stella.nfe.builder.icms.impl.ICMSNaoTributadoImpl;
import br.com.caelum.stella.nfe.builder.icms.impl.ICMSOutrosImpl;
import br.com.caelum.stella.nfe.builder.icms.impl.ICMSTributadoComSubstituicaoTributariaImpl;
import br.com.caelum.stella.nfe.builder.icms.impl.ICMSTributadoIntegralmenteImpl;

public class ICMSBuilder {

    public ICMSTributadoIntegralmente tributadoIntegralmente() {
        return new ICMSTributadoIntegralmenteImpl();
    }

    public ICMSTributadoComSubstituicaoTributaria tributadoComSubstituicaoTributaria() {
        return new ICMSTributadoComSubstituicaoTributariaImpl();
    }

    public ICMSComReducaoBaseCalculo comReducaoBaseCalculo() {
        return new ICMSComReducaoBaseCalculoImpl();
    }

    public ICMSNaoTributado naoTributado() {
        return new ICMSNaoTributadoImpl();
    }

    public ICMSDiferimento diferimento() {
        return new ICMSDiferimentoImpl();
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria comReducaoBaseDeCalculoESubstituicaoTributaria() {
        return new ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl();
    }

    public ICMSOutros outros() {
        return new ICMSOutrosImpl();
    }

    public ICMSCobradoAnteriormentePorSubstituicao cobradoAnteriormentePorSubstituicao() {
        return new ICMSCobradoAnteriormentePorSubstituicaoImpl();
    }

}
