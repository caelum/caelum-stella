package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.enums.OrigemICMS;

public interface ICMSComReducaoBaseCalculo extends ICMS {

    public ICMSComReducaoBaseCalculo withOrigem(OrigemICMS origem);

    public ICMSComReducaoBaseCalculo withModalidade(ModalidadeBaseCalculo modalidade);

    public ICMSComReducaoBaseCalculo withPercentualReducaoBaseCalculo(BigDecimal percentual);

    public ICMSComReducaoBaseCalculo withBaseCalculo(BigDecimal valor);

    public ICMSComReducaoBaseCalculo withAliquota(BigDecimal aliquota);

    public ICMSComReducaoBaseCalculo withValor(BigDecimal valor);

}
