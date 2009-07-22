package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.enums.ModalidadeST;
import br.com.caelum.stella.nfe.builder.enums.OrigemICMS;

public interface ICMSOutros extends ICMS {

    public ICMSOutros withOrigem(OrigemICMS origem);

    public ICMSOutros withModalidade(ModalidadeBaseCalculo modalidadeBaseCalculo);

    public ICMSOutros withBaseDeCalculo(BigDecimal baseCalculo);

    public ICMSOutros withPercentualReducaoBaseCalculo(BigDecimal percentual);

    public ICMSOutros withAliquota(BigDecimal aliquota);

    public ICMSOutros withValor(BigDecimal valor);

    public ICMSOutros withModalidadeST(ModalidadeST modalidade);

    public ICMSOutros withPercentualAdicionadoST(BigDecimal percentual);

    public ICMSOutros withValorDaBaseDeCalculoST(BigDecimal valor);

    public ICMSOutros withAliquotaST(BigDecimal aliquota);

    public ICMSOutros withValorST(BigDecimal valor);

    public ICMSOutros withPercentualReducaoBaseCalculoST(BigDecimal percentual);

}
